package com.cozi.xiaosai.service.sys.Impl;

import com.cozi.xiaosai.common.R;
import com.cozi.xiaosai.controller.sys.DistributionController;
import com.cozi.xiaosai.enums.CueWordsEnum;
import com.cozi.xiaosai.mapper.dataOrigin.sys.DistributionMapper;
import com.cozi.xiaosai.pojo.dataorigin.sys.*;
import com.cozi.xiaosai.pojo.dataorigin.sysParams.LogoIconParams;
import com.cozi.xiaosai.service.sys.DistributionService;
import com.cozi.xiaosai.util.redis.RedisKey;
import com.cozi.xiaosai.util.redis.RedisUtils;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */
@Service
public class DistributionServiceImpl implements DistributionService {

    private final Logger logger = LoggerFactory.getLogger(DistributionServiceImpl.class);

    @Autowired
    private DistributionMapper distributionMapper;

    @Autowired
    private RedisUtils redisUtils;

    private List<MenuInfoPojo> listMenu = new ArrayList<>();

    private List<Integer> idsList = new ArrayList<>();

    @Override
    public R getNavBarInfo() {
        return R.isOk().data(distributionMapper.selectNavigationBar());
    }

    @Override
    public R getSidebarInfo() {
        Gson gson = new Gson();
        //如果缓存中存在，直接从缓存中获取
        List<Map<String, Object>> Listdata = (List<Map<String, Object>>) redisUtils.get(RedisKey.BAR.getKey());
        if (Listdata != null && Listdata.size() > 0) {
            return R.isOk().data(Listdata);
        }
        List<NavigationBarPojo> navigationBarPojos = distributionMapper.selectNavigationBar();
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < navigationBarPojos.size(); i++) {
            Map<String, Object> sideBar = new HashMap<>();
            List<SidebarPojo> sidebarPojo = barConstruction(0, navigationBarPojos.get(i).getId());
            sideBar.put(navigationBarPojos.get(i).getNavigationBarName(), sidebarPojo);
            list.add(sideBar);
        }
        //缓存侧边栏信息
        redisUtils.set(RedisKey.BAR.getKey(), list);

        return R.isOk().data(list);
    }

    @Override
    public R getLogoIcon(HttpServletRequest request) {
        //通过session获取用户信息
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        logger.info("logoIcon获取参数："+user);
        LogoIconPojo logoIconPojo = new LogoIconPojo();
        if(user!=null){
            logoIconPojo = distributionMapper.selectLogoIcon(user.getUserName());
            return R.isOk().data(logoIconPojo);
        }else {
            //设置默认值
            logoIconPojo.setTitle(CueWordsEnum.LOGO_ICON_DEFAULT_TITLE.getValue());
            logoIconPojo.setImage(CueWordsEnum.LOGO_ICON_DEFAULT_IMAGE.getValue());
            logoIconPojo.setHref(CueWordsEnum.LOGO_ICON_DEFAULT_HREF.getValue());
            logoIconPojo.setIsAlter(0);
            return R.isOk().data(logoIconPojo);
        }
    }

    @Override
    public R getLogoIconEcho(HttpServletRequest request) {
        Map<String,Object> map = new HashMap<>();
        //通过session获取用户信息
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user!=null){
            map.put("userName",user.getUserName());
            map.put("pojo",distributionMapper.selectLogoIcon(user.getUserName()));
            map.put("pojos",distributionMapper.selectLogoIconList());
            return R.isOk().data(map);
        }else {
            return R.isFail().msg(CueWordsEnum.LOGO_ICON_FAILED_POJO.getValue());
        }

    }

    @Override
    public R editLogoIconData(LogoIconParams logoIconParams) {
        //TODO:现在只做了普通用户，只有超级用户才能修改logo的主题和href
        if(StringUtils.isEmpty(logoIconParams.getUserName())){
            return R.isFail().msg(CueWordsEnum.LOGO_ICON_FAILED_USERNAME.getValue());
        }
        try {
            distributionMapper.updateLogoIconId(logoIconParams);
            return R.isOk().msg(CueWordsEnum.LOGO_ICON_SUCCESS.getValue());
        } catch (Exception e) {
            e.printStackTrace();
            return R.isFail().msg(CueWordsEnum.LOGO_ICON_FAILED.getValue());
        }
    }

    @Override
    public R getMenuInfo() {
        List<MenuInfoPojo> listCache = (List<MenuInfoPojo>) redisUtils.get(RedisKey.MENU.getKey());
        if (listCache != null && listCache.size() > 0) {
            return R.isOk().data(listCache);
        }

        //每次重新获取，清空集合
        listMenu.clear();
        List<NavigationBarPojo> navigationBarPojos = distributionMapper.selectNavigationBar();
        //获取导航栏
        if (navigationBarPojos != null && navigationBarPojos.size() > 0) {
            List<MenuInfoPojo> menuInfoPojos = distributionMapper.selectMenuInfoList();
            for (NavigationBarPojo navigationBarPojo : navigationBarPojos) {
                menuConstruction(menuInfoPojos, navigationBarPojo.getNavigationBarName(), 0, navigationBarPojo.getId());
            }
            for (int i = 1; i <= listMenu.size(); i++) {
                listMenu.get(i - 1).setAuthorityId(i);
            }
        }

        redisUtils.set(RedisKey.MENU.getKey(), listMenu);

        return R.isOk().data(listMenu).count(listMenu.size());
    }

    @Override
    public MenuInfoPojo getmenuEditData(Integer id) {
        return distributionMapper.selectmenuEditData(id);
    }

    @Override
    public R editMenuData(MenuInfoPojo menuInfoPojo) {
        logger.info("菜单管理编辑参数：" + menuInfoPojo);
        distributionMapper.updatemenuinfo(menuInfoPojo);

        //删除缓存
        redisUtils.del(RedisKey.MENU.getKey());
        redisUtils.del(RedisKey.BAR.getKey());
        return R.isOk().msg(CueWordsEnum.MENU_MANAGE_EDIT_SUCCESS.getValue());
    }

    @Override
    public R addMenuData(MenuInfoPojo menuInfoPojo) {
        if (StringUtils.isEmpty(menuInfoPojo.getNavigationBarName()) || distributionMapper.selectCountByMenuInfoPojo(new MenuInfoPojo(menuInfoPojo.getNavigationBarName()), 1, 2) > 0) {
            if (menuInfoPojo.getNavId().intValue() <= 0 || distributionMapper.selectCountByMenuInfoPojo(new MenuInfoPojo(menuInfoPojo.getNavId(), menuInfoPojo.getNavigationBarName()), 1, 1) <= 0) {
                R.isFail().msg(CueWordsEnum.MENU_MANAGE_NAV_NAVID.getValue());
            }
        }
        if (StringUtils.isEmpty(menuInfoPojo.getTitle()) || distributionMapper.selectCountByMenuInfoPojo(new MenuInfoPojo(menuInfoPojo.getTitle(), menuInfoPojo.getParentId()), 2, 1) > 0) {
            return R.isFail().msg(CueWordsEnum.MENU_MANAGE_SIDEBAR_TITLE.getValue());
        }

        //导航栏已存在
        if (StringUtils.isNotEmpty(menuInfoPojo.getNavigationBarName()) && distributionMapper.selectCountByMenuInfoPojo(new MenuInfoPojo(menuInfoPojo.getNavigationBarName()), 1, 2) > 0) {
            distributionMapper.insertSidebar(menuInfoPojo);
            //导航不存在
        } else {
            menuInfoPojo.setNavigationBarIndex(distributionMapper.selectMixIndex() + 1);
            distributionMapper.insertNavigationBar(menuInfoPojo);
            menuInfoPojo.setNavId(menuInfoPojo.getId());
            distributionMapper.insertSidebar(menuInfoPojo);
        }

        //删除缓存
        redisUtils.del(RedisKey.MENU.getKey());
        redisUtils.del(RedisKey.BAR.getKey());

        return R.isOk();
    }

    @Override
    public R delBarInfo(Integer id) {
        if (id != null && id.intValue() > 0) {
            MenuInfoPojo menuInfoPojo = distributionMapper.selectmenuEditData(id);
            if (menuInfoPojo != null) {
                //如果父级id为0，则删除所有相关数据记录
                if (menuInfoPojo.getParentId().equals(0)) {
                    distributionMapper.deleteBar(menuInfoPojo.getNavId());
                } else {
                    //清空list
                    idsList.clear();
                    //如果不是，则删除本级和下级
                    List<MenuInfoPojo> menuInfoPojos = distributionMapper.selectMenuInfoList();
                    idsList.add(id);
                    List<Integer> ids = searchId(menuInfoPojos, id);
                    String _ids = ids.toString().substring(1, ids.toString().length() - 1);
                    logger.info("下级id：" + _ids);
                    distributionMapper.deleteBarByidAndnavid(_ids);
                }
                //删除缓存
                redisUtils.del(RedisKey.MENU.getKey());
                redisUtils.del(RedisKey.BAR.getKey());
                return R.isOk().msg(CueWordsEnum.MENU_MANAGE_SUCCESS_DELETE.getValue());
            } else {
                return R.isFail().msg(CueWordsEnum.MENU_MANAGE_FAILED_ID.getValue());
            }
        } else {
            return R.isFail().msg(CueWordsEnum.MENU_MANAGE_UNVALID_ID.getValue());
        }
    }


    /**
     * 查找所有下级id-递归
     * @param menuInfoPojos
     * @param id
     * @return
     */
    public List<Integer> searchId(List<MenuInfoPojo> menuInfoPojos, Integer id) {
        for (MenuInfoPojo menuInfoPojo : menuInfoPojos) {
            if (menuInfoPojo.getParentId().equals(id)) {
                searchId(menuInfoPojos, menuInfoPojo.getId());
                idsList.add(menuInfoPojo.getId());
            }
        }
        return idsList;
    }

    /**
     * 构造菜单结构信息-递归
     *
     * @param list              所有数据
     * @param navigationBarName
     * @param parentId
     * @param navId
     * @return
     */
    public List<MenuInfoPojo> menuConstruction(List<MenuInfoPojo> list, String navigationBarName, Integer parentId, Integer navId) {
        for (MenuInfoPojo menuInfoPojo : list) {
            if (navigationBarName.equals(menuInfoPojo.getNavigationBarName()) && parentId.equals(menuInfoPojo.getParentId()) && navId.equals(menuInfoPojo.getNavId())) {
                if (!listMenu.contains(menuInfoPojo)) {
                    listMenu.add(menuInfoPojo);
                }
                menuConstruction(list, menuInfoPojo.getNavigationBarName(), menuInfoPojo.getId(), menuInfoPojo.getNavId());
            }
        }
        return listMenu;
    }

    /**
     * 构造侧边栏信息-递归
     *
     * @param parentId
     * @param navId
     * @return
     */
    public List<SidebarPojo> barConstruction(Integer parentId, Integer navId) {
        List<SidebarPojo> sidebarPojos = distributionMapper.selectSidebar(parentId, navId);
        if (sidebarPojos.size() > 0) {
            for (SidebarPojo sidebarPojo1 : sidebarPojos) {
                List<SidebarPojo> sidebarPojos1 = barConstruction(sidebarPojo1.getId(), navId);
                sidebarPojo1.setChild(sidebarPojos1);
            }
        }
        return sidebarPojos;
    }

}

package com.cozi.xiaosai.service.sys.Impl;

import com.cozi.xiaosai.common.R;
import com.cozi.xiaosai.controller.web.userControl.UserController;
import com.cozi.xiaosai.enums.CueWordsEnum;
import com.cozi.xiaosai.mapper.dataOrigin.sys.UserMapper;
import com.cozi.xiaosai.pojo.dataorigin.sys.User;
import com.cozi.xiaosai.pojo.dataorigin.sysParams.UserEditParams;
import com.cozi.xiaosai.pojo.dataorigin.sysParams.UserParams;
import com.cozi.xiaosai.service.sys.UserService;
import com.cozi.xiaosai.util.aes.AES;
import com.cozi.xiaosai.util.aes.AesKey;
import com.github.pagehelper.Page;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author xiaosai
 * @Date 2019-11-24 15:50
 * @Version 1.0
 */

/**
 * 用户逻辑类
 */
@Service
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(String userId) {
        return userMapper.selectUser(userId);
    }

    @Override
    public int addUser(User user) {
        try {
            return userMapper.insertUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void editUser(User user) {
        try {
            userMapper.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editUserByUserEditParams(UserEditParams userEditParams) throws Exception {
        userMapper.updateUserByUP(userEditParams);
    }

    @Override
    public R userPasswordEdit(User user) {
        if(StringUtils.isEmpty(user.getUserName())||userMapper.userCountByUserName(user.getUserName())<=0){
            return R.isFail().msg(CueWordsEnum.USER_FAILED_INEXISTENCE.getValue());
        }
        if(StringUtils.isEmpty(user.getPassword())||StringUtils.isEmpty(user.getPasswords())){
            return R.isFail().msg(CueWordsEnum.USER_FAILED_OLDANDNEW_PASSWORD.getValue());
        }
        User user1 = userMapper.userByUserName(user.getUserName());
        if(AES.decryptFromBase64(user1.getPassword(), AesKey.AES_KEY).equals(user.getPassword())){
            //执行修改密码
            user1.setPassword(AES.encryptToBase64(user.getPasswords(), AesKey.AES_KEY));
            try {
                userMapper.updatePassword(user1);
                return R.isOk().msg(CueWordsEnum.USER_SUCCESS_EDIT_PASSWORD.getValue());
            } catch (Exception e) {
                e.printStackTrace();
                return R.isFail().msg(CueWordsEnum.USER_FAILED_EDIT_PASSWORD.getValue());
            }
        }else {
            return R.isFail().msg(CueWordsEnum.USER_FAILED_OLD_PASSWORD.getValue());
        }
    }

    @Override
    public void delUser(String userId) {
        try {
            userMapper.deleteUser(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int userCountByUserName(String userName) {
        return userMapper.userCountByUserName(userName);
    }

    @Override
    public User userByUserName(String userName) {
        return userMapper.userByUserName(userName);
    }

    @Override
    public Page<User> userListByUser(UserParams userParams) {
        return userMapper.selectUserListByUser(userParams);
    }

    @Override
    public void batchDelUser(String userIds) {
        try {
            userMapper.delBatchUser(userIds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.cozi.xiaosai.interceptors;

import com.alibaba.fastjson.JSONObject;
import com.cozi.xiaosai.enums.CueWordsEnum;
import com.cozi.xiaosai.pojo.dataorigin.sys.User;
import com.cozi.xiaosai.service.sys.UserService;
import com.cozi.xiaosai.util.redis.RedisKey;
import com.cozi.xiaosai.util.redis.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author xiaosai
 * @Date 2019-12-4 16:17
 * @Version 1.0
 */
@Component
public class XsHandlerInterceptor implements HandlerInterceptor {

    private final Logger logger = LoggerFactory.getLogger(XsHandlerInterceptor.class);

    @Autowired
    private RedisUtils redisUtils;

    public static XsHandlerInterceptor xsHandlerInterceptor;

    @PostConstruct
    public void init(){
        xsHandlerInterceptor = this;
        xsHandlerInterceptor.redisUtils = this.redisUtils;
    }

    /**
     * 不需要拦截的地址
     */
    private static Set<String> uriSet = new HashSet<>();

    static {
        uriSet.add("/");
        uriSet.add("/xiaosai/getLoginQr");
        uriSet.add("/xiaosai/qrCode");
        uriSet.add("/xiaosai/getVerify");
        uriSet.add("/xiaosai/checkVerify");
        uriSet.add("/xiaosai/login");
        uriSet.add("/xiaosai/regis");
        uriSet.add("/xiaosai/addUser");
        uriSet.add("/xiaosai/checkUser");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //logger.info("^-^The system is accessed at the following address:"+request.getRequestURI());
        if(uriSet.contains(request.getRequestURI())){
            return true;
        }
        HttpSession session = request.getSession();
        //手机端接口控制
        if(request.getRequestURI().startsWith(CueWordsEnum.INTERCEPTOR_APP_URL_CONTROLLER.getValue())){
            return true;
        }else {
            //web端接口控制
            User user = (User) session.getAttribute(CueWordsEnum.INTERCEPTOR_SESSION_ATTR_KEY.getValue());
            //session验证
            boolean flag = false;
            if(session!=null&&user!=null){
                Map<Object, Object> map = xsHandlerInterceptor.redisUtils.hmget(RedisKey.SESSION.getKey() + user.getUserName());
                if(map == null){
                    flag = true;
                }else {
                    flag = map.get("sesionId").equals(session.getId())&&System.currentTimeMillis()- Long.parseLong(map.get("validity").toString())<=1000*60*60*30;
                }
            }
            if(flag){
                //设置session有效性
                Map<String,Object> map = new HashMap<>();
                map.put("sesionId",session.getId());
                map.put("validity", System.currentTimeMillis());
                xsHandlerInterceptor.redisUtils.hmset(RedisKey.SESSION.getKey()+user.getUserName(),map);
                return true;
            }else {
                //return sessionExpire(response,"请求session失效，请重新登录！");
                request.getRequestDispatcher(CueWordsEnum.INTERCEPTOR_LOGIN_FORWARD_URL.getValue()).forward(request,response);
                return false;
            }
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    public boolean sessionExpire(HttpServletResponse httpServletResponse, String msg) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("return_code", 416);
        jsonObject.put("return_msg", msg);
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json; charset=utf-8");
        try {
            PrintWriter out = httpServletResponse.getWriter();
            out.append(jsonObject.toJSONString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

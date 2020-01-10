package com.cozi.xiaosai.controller.layuimini;

import com.cozi.xiaosai.annotation.Log1oneAnnotation;
import com.cozi.xiaosai.common.R;
import com.cozi.xiaosai.enums.OperationObjects;
import com.cozi.xiaosai.enums.OperationType;
import com.cozi.xiaosai.pojo.dataorigin.sys.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author xiaosai
 * @Date 2019-12-9 17:21
 * @Version 1.0
 */
@Controller
@RequestMapping("/xiaosai")
public class layuiminiController {

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String getIndex(@RequestParam(value = "userName",defaultValue = "") String userName, Model model,HttpServletRequest request){
        //如果未能取到参数
        if(StringUtils.isEmpty(userName)){
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            if(user!=null){
                userName=user.getUserName();
            }
        }
        model.addAttribute("userName",userName);
        return "layuimini/index";
    }

    @RequestMapping(value = "/userSetting",method = RequestMethod.GET)
    public String getUserSetting(HttpServletRequest request){
        return "layuimini/page/user-setting";
    }

    //@Log1oneAnnotation(operationType = OperationType.UPDATE,operands = OperationObjects.XIAOSAI_USER,uniqueValue = "#{id}")
    @RequestMapping(value = "/userPassword",method = RequestMethod.GET)
    @ResponseBody
    public String getUserPassword(User user){
//        return R.isOk().data("layuimini/page/user-password").msg("修改密码").operands("xiaosai_user");
        System.out.println("方法执行"+user);
        return "";
    }

    @RequestMapping(value = "/welcome",method = RequestMethod.GET)
    public String getWelcome(HttpServletRequest request){
        return "layuimini/page/welcome-1";
    }

    @RequestMapping(value = "/welcome2",method = RequestMethod.GET)
    public String getWelcome2(HttpServletRequest request){
        return "layuimini/page/welcome-2";
    }

    @RequestMapping(value = "/menu",method = RequestMethod.GET)
    public String getMenu(HttpServletRequest request){
        return "layuimini/page/menu";
    }

    @RequestMapping(value = "/setting",method = RequestMethod.GET)
    public String getSetting(HttpServletRequest request){
        return "layuimini/page/setting";
    }

    @RequestMapping(value = "/table",method = RequestMethod.GET)
    public String getTable(HttpServletRequest request){
        return "layuimini/page/table";
    }

    @RequestMapping(value = "/form",method = RequestMethod.GET)
    public String getForm(HttpServletRequest request){
        return "layuimini/page/form";
    }

    @RequestMapping(value = "/formStep",method = RequestMethod.GET)
    public String getFormStep(HttpServletRequest request){
        return "layuimini/page/form-step";
    }

    @RequestMapping(value = "/login1",method = RequestMethod.GET)
    public String getLogin1(HttpServletRequest request){
        return "layuimini/page/login-1";
    }

    @RequestMapping(value = "/login2",method = RequestMethod.GET)
    public String getLogin2(HttpServletRequest request){
        return "layuimini/page/login-2";
    }

    @RequestMapping(value = "/p404",method = RequestMethod.GET)
    public String getP404(HttpServletRequest request){
        return "layuimini/page/404";
    }

    @RequestMapping(value = "/button",method = RequestMethod.GET)
    public String getButton(HttpServletRequest request){
        return "layuimini/page/button";
    }

    @RequestMapping(value = "/layer",method = RequestMethod.GET)
    public String getLayer(HttpServletRequest request){
        return "layuimini/page/layer";
    }

    @RequestMapping(value = "/icon",method = RequestMethod.GET)
    public String getIcon(HttpServletRequest request){
        return "layuimini/page/icon";
    }

    @RequestMapping(value = "/iconPicker",method = RequestMethod.GET)
    public String getIconPicker(HttpServletRequest request){
        return "layuimini/page/icon-picker";
    }

    @RequestMapping(value = "/colorSelect",method = RequestMethod.GET)
    public String getColorSelect(HttpServletRequest request){
        return "layuimini/page/color-select";
    }

    @RequestMapping(value = "/tableSelect",method = RequestMethod.GET)
    public String getTableSelect(HttpServletRequest request){
        return "layuimini/page/table-select";
    }

    @RequestMapping(value = "/upload",method = RequestMethod.GET)
    public String getUpload(HttpServletRequest request){
        return "layuimini/page/upload";
    }

    @RequestMapping(value = "/editor",method = RequestMethod.GET)
    public String getEditor(HttpServletRequest request){
        return "layuimini/page/editor";
    }

    @RequestMapping(value = "/error",method = RequestMethod.GET)
    public String getError(HttpServletRequest request){
        return "layuimini/page/error";
    }

}

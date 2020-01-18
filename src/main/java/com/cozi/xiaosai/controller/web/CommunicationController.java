package com.cozi.xiaosai.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */
@Controller
@RequestMapping("/xiaosai")
public class CommunicationController {


    @RequestMapping("/communicationIndex")
    public String getCommunicationIndexFtl(){
        return "web/communication/CommunicationIndex";
    }

}

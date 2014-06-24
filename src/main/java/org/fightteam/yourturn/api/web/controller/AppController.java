package org.fightteam.yourturn.api.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 介于API没有UI界面,使用全部以json展现
 */
@Controller
public class AppController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, String> index(){
        System.out.println("--------------------");
        Map<String, String> json = new HashMap<>();
        json.put("aa","bbb");
        return json;
    }
}

package org.fightteam.yourturn.api.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by excalibur on 2014/6/23.
 */
@Controller
public class AppController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(){
        System.out.println("--------------------");
        return "index";
    }
}

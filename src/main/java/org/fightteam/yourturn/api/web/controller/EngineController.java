package org.fightteam.yourturn.api.web.controller;

import org.fightteam.yourturn.api.core.vo.EngineVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 介于API没有UI界面,使用全部以json展现
 *
 * 该页面主要是首页引导界面
 */
@Controller
public class EngineController {


    @RequestMapping(value = "", method = RequestMethod.GET)
    public @ResponseBody
    EngineVO index(){
        EngineVO engineVO = new EngineVO();

        return engineVO;
    }
}

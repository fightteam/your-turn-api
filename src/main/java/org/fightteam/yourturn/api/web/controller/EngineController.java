package org.fightteam.yourturn.api.web.controller;

import org.fightteam.yourturn.api.core.vo.EngineVO;
import org.fightteam.yourturn.api.service.EngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * 介于API没有UI界面,使用全部以json展现
 * <p>
 * 该页面主要是首页引导界面
 */
@Controller
public class EngineController {

    @Autowired
    private EngineService engineService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    HttpEntity<Resource<EngineVO>> index() {

        EngineVO engineVO = engineService.loadEngineInfo();

        List<EngineVO> engineVOs = Arrays.asList(engineVO);
        Resource<EngineVO> resources = new Resource<EngineVO>(engineVO);
        return new ResponseEntity<>(resources, HttpStatus.OK);
    }

}

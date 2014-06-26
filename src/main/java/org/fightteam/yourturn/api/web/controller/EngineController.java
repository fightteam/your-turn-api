package org.fightteam.yourturn.api.web.controller;

import org.fightteam.yourturn.api.core.domain.User;
import org.springframework.data.rest.webmvc.RepositoryLinksResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

/**
 * 介于API没有UI界面,使用全部以json展现
 *
 * 该页面主要是首页引导界面
 */
@Controller
public class EngineController implements ResourceProcessor<RepositoryLinksResource>{


    @RequestMapping(value = "/aaa", method = RequestMethod.GET)
    public @ResponseBody
    HttpEntity<Resources<Resource<User>>> index(){
        User user = new User();
        user.setId(1L);
        user.setUsername("ffffff");
        List<User> engineVOList = new ArrayList<>();
        engineVOList.add(user);
        Resources<Resource<User>> resources = Resources.wrap(engineVOList);

        return new ResponseEntity<>(resources, HttpStatus.OK);
    }


    @Override
    public RepositoryLinksResource process(RepositoryLinksResource resource) {

        resource.add(linkTo(methodOn(EngineController.class).index()).withRel("aac"));
//        resource.add();
        return resource;
    }
}

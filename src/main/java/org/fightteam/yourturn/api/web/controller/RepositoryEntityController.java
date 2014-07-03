package org.fightteam.yourturn.api.web.controller;

import org.fightteam.yourturn.api.core.domain.User;
import org.fightteam.yourturn.api.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.Repository;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 通用的工厂生成接口
 */
@Controller
public class RepositoryEntityController {
    private static final String BASE_MAPPING = "/{repository}";

    @Autowired
    private List<Repository> repositories;

    @Autowired
    private UserRepository userRepository;
    
    @ResponseBody
    @RequestMapping(value = BASE_MAPPING, method = RequestMethod.GET)
    public Resources<?> getCollectionResource(@PathVariable String repository, Pageable pageable, Sort sort) {
        // TODO 分页工厂方法
        // 1.根据URI获取对应的repository 这部分需要获取对应的注解比对
        // 注意异常处理

        // 根据 路径获取repository

        // 2.调用repository的对应方法获取对象

        // 3.封装结果

        // 4.返回
        Page<User> users = userRepository.findAll(pageable);

        Resources<?> resources = Resources.wrap(users);

        return resources;
    }

}

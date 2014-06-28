package org.fightteam.yourturn.api.web.controller;

import org.fightteam.yourturn.api.core.domain.User;
import org.fightteam.yourturn.api.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 通用的工厂生成接口
 */
@Controller
public class RepositoryEntityController {
    private static final String BASE_MAPPING = "/{repository}";


    @Autowired
    private UserRepository userRepository;

    @ResponseBody
    @RequestMapping(value = BASE_MAPPING, method = RequestMethod.GET)
    public Resources<?> getCollectionResource(Pageable pageable, Sort sort) {


        Page<User> users = userRepository.findAll(pageable);

        Resources<?> resources = Resources.wrap(users);

        return resources;
    }

}

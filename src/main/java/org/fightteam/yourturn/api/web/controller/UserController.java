//package org.fightteam.yourturn.api.web.controller;
//
//import org.fightteam.yourturn.api.core.domain.User;
//import org.fightteam.yourturn.api.core.vo.EngineVO;
//import org.fightteam.yourturn.api.dao.UserRepository;
//import org.fightteam.yourturn.api.web.common.Router;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.hateoas.Resource;
//import org.springframework.hateoas.Resources;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.Arrays;
//import java.util.List;
//
///**
// * Created by excalibur on 2014/6/28.
// */
//@Controller
//@RequestMapping(value = Router.users)
//public class UserController {
//
//    public Pageable pageable = new PageRequest(0, 20);
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @RequestMapping(method = RequestMethod.GET)
//    @ResponseBody
//    HttpEntity<Resources<Resource<User>>> index() {
//
//        Page<User> users = userRepository.findAll(pageable);
//
//
//       Resources<Resource<User>> resources = Resources.wrap(users);
//
//        return new ResponseEntity<>(resources, HttpStatus.OK);
//    }
//}

package org.fightteam.yourturn.api.web.controller;

import org.fightteam.yourturn.api.core.vo.EngineVO;
import org.fightteam.yourturn.api.service.EngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * 介于API没有UI界面,使用全部以json展现
 * <p>
 * 该页面主要是首页引导界面
 */
@Controller
public class EngineController {

    @Autowired
    private EngineService engineService;

    @Autowired
    private List<Repository> repositories;



    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    HttpEntity<Resource<EngineVO>> index(HttpServletRequest request) {

        EngineVO engineVO = engineService.loadEngineInfo();
        Resource<EngineVO> resources = new Resource<EngineVO>(engineVO);

        String baseUrl = getBaseUrl(request);

        for (Repository tmpRepository : repositories) {
            RepositoryRestResource ann = AnnotationUtils.findAnnotation(tmpRepository.getClass(), RepositoryRestResource.class);

            Link link = new Link(baseUrl+ann.path(),ann.collectionResourceRel());
            resources.add(link);

        }

        return new ResponseEntity<>(resources, HttpStatus.OK);
    }


    private String getBaseUrl(HttpServletRequest request){
        return request.getRequestURL().toString();
    }

}

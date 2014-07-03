package org.fightteam.yourturn.api.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestMethodNotSupportedException;
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
    private List<PagingAndSortingRepository> repositories;

    @Autowired
    private PagedResourcesAssembler pagedResourcesAssembler;

    @ResponseBody
    @RequestMapping(value = BASE_MAPPING, method = RequestMethod.GET)
    public PagedResources<?> getCollectionResource(@PathVariable String repository,
                                                   Pageable pageable) throws ResourceNotFoundException,
            HttpRequestMethodNotSupportedException {

        PagingAndSortingRepository pagingAndSortingRepository = null;

        // 1.根据URI获取对应的repository 这部分需要获取对应的注解比对
        // 注意异常处理

        // 根据 路径获取repository
        for (PagingAndSortingRepository tmpRepository : repositories) {
            RepositoryRestResource ann = AnnotationUtils.findAnnotation(tmpRepository.getClass(), RepositoryRestResource.class);
            if (ann.path().equals(repository)) {
                pagingAndSortingRepository = tmpRepository;
                break;
            }
        }

        // 异常处理
        if (pagingAndSortingRepository == null) {
            throw new ResourceNotFoundException();
        }
        // 2.调用repository的对应方法获取对象
        Page<?> pages = pagingAndSortingRepository.findAll(pageable);

        // 3.封装结果
        PagedResources<?> pagedResources = pagedResourcesAssembler.toResource(pages);

        // TODO 处理每个对象的自身链接

        // 4.返回
        return pagedResources;
    }


    // TODO 处理对象id查询




}

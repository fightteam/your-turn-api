package org.fightteam.yourturn.api.web.controller;

import org.fightteam.yourturn.api.test.SpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.lang.annotation.Annotation;
import java.util.List;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public class RepositoryEntityControllerTest extends SpringTest {

    @Autowired
    private List<Repository> repositories;

    @Test
    public void test01() throws Exception {
        System.out.println(repositories.size());
        PagingAndSortingRepository pagingAndSortingRepository = (PagingAndSortingRepository) repositories.get(0);
        System.out.println(pagingAndSortingRepository);
        System.out.println(pagingAndSortingRepository.getClass());

        Annotation ann = AnnotationUtils.findAnnotation(pagingAndSortingRepository.getClass(), RepositoryRestResource.class);

        System.out.println(ann);
    }
}

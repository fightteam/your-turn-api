package org.fightteam.yourturn.api.web.controller;

import org.fightteam.yourturn.api.core.domain.User;
import org.fightteam.yourturn.api.test.SpringMvcTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.LinkBuilderFactory;
import org.springframework.hateoas.LinkDiscoverer;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.sql.DataSource;


/**
 *  AppController测试类
 */
public class EngineControllerTest extends SpringMvcTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private EntityLinks entityLinks;

    @Test
    public void testIndex() throws Exception {
//        ResultActions ra = this.mockMvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.ALL));
//        MvcResult mr = ra.andReturn();
//        String result = mr.getResponse().getContentAsString();
//        System.out.println(result);
//        Assert.assertEquals("{\"aa\":\"bbb\"}", result);


        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.TEXT_HTML,MediaType.APPLICATION_XHTML_XML, MediaType.APPLICATION_XML)).//
                andDo(MockMvcResultHandlers.print()).//
//                andExpect(linkWithRelIsPresent("22")). //
                andReturn().getResponse();

//        LinkDiscoverer discoverer = links.getLinkDiscovererFor(response.getContentType());
        //Link link = discoverer.findLinkWithRel(ENGINE_REL, response.getContentAsString());

        System.out.println(response.getContentAsString());
    }

    @Test
    public void testDataSource() throws Exception {
        System.out.println(dataSource);

    }

    @Test
    public void test03() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setUsername("111111");
        System.out.println(entityLinks);
        System.out.println(entityLinks.linkFor(User.class, 1L).withRel("111"));

    }
}

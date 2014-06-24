package org.fightteam.yourturn.api.web.controller;

import org.fightteam.yourturn.api.test.SpringMvcTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 *  AppController测试类
 */
public class AppControllerTest extends SpringMvcTest {

    @Test
    public void testIndex() throws Exception {
        ResultActions ra = this.mockMvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.ALL));
        MvcResult mr = ra.andReturn();
        String result = mr.getResponse().getContentAsString();
        Assert.assertEquals("{\"aa\":\"bbb\"}", result);
    }
}

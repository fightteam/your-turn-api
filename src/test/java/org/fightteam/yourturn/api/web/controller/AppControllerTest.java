package org.fightteam.yourturn.api.web.controller;

import org.fightteam.yourturn.api.test.SpringMvcTest;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * Created by excalibur on 2014/6/23.
 */
public class AppControllerTest extends SpringMvcTest {

    @Test
    public void testIndex() throws Exception {
        ResultActions ra = this.mockMvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.ALL));


        MvcResult mr = ra.andReturn();
        System.out.println(mr);
        System.out.println(mr.getModelAndView());
        String result = mr.getResponse().getContentAsString();
        System.out.println(result);
    }
}

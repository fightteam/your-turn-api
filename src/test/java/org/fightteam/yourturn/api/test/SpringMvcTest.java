package org.fightteam.yourturn.api.test;

import org.fightteam.yourturn.api.config.WebSpringConfig;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.LinkDiscoverer;
import org.springframework.hateoas.LinkDiscoverers;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * Created by excalibur on 2014/6/23.
 */
@WebAppConfiguration
@ContextConfiguration(classes = {WebSpringConfig.class})
public abstract class SpringMvcTest extends SpringTest {

    protected MockMvc mockMvc;

//    @Autowired
//    protected LinkDiscoverers links;

    @Autowired
    protected WebApplicationContext wac;

    @Before
    public void setUp() throws Exception {

        mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

//    protected ResultMatcher linkWithRelIsPresent(final String rel) {
//        return new LinkWithRelMatcher(rel, true);
//    }
//
//    protected ResultMatcher linkWithRelIsNotPresent(String rel) {
//        return new LinkWithRelMatcher(rel, false);
//    }

//    protected LinkDiscoverer getDiscovererFor(MockHttpServletResponse response) {
//        return links.getLinkDiscovererFor(response.getContentType());
//    }

//
//    private class LinkWithRelMatcher implements ResultMatcher {
//
//        private final String rel;
//        private final boolean present;
//
//        public LinkWithRelMatcher(String rel, boolean present) {
//            this.rel = rel;
//            this.present = present;
//        }
//
//        /*
//         * (non-Javadoc)
//         * @see org.springframework.test.web.servlet.ResultMatcher#match(org.springframework.test.web.servlet.MvcResult)
//         */
//        @Override
//        public void match(MvcResult result) throws Exception {
//
//            MockHttpServletResponse response = result.getResponse();
//            String content = response.getContentAsString();
//            LinkDiscoverer discoverer = links.getLinkDiscovererFor(response.getContentType());
//
//            assertThat(discoverer.findLinkWithRel(rel, content), is(present ? notNullValue() : nullValue()));
//        }
//    }



}

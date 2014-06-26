package org.fightteam.yourturn.api.web.processor;

import org.fightteam.yourturn.api.core.vo.EngineVO;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;

/**
 * Created by excalibur on 2014/6/26.
 */
public class EngineResourceProcessor implements ResourceProcessor<Resource<EngineVO>> {

    @Override
    public Resource<EngineVO> process(Resource<EngineVO> resource) {
        EngineVO engineVO = resource.getContent();

        System.out.println("EngineResourceProcessor");
        return resource;
    }
}

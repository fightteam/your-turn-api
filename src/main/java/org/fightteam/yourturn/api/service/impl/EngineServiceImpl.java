package org.fightteam.yourturn.api.service.impl;

import org.fightteam.yourturn.api.core.vo.EngineVO;
import org.fightteam.yourturn.api.service.EngineService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 平台接口服务逻辑实现
 *
 * @author faith
 * @since 0.0.1
 */
@Service
public class EngineServiceImpl implements EngineService {

    @Value("${engine.version}")
    private String version;

    @Override
    public EngineVO loadEngineInfo() {
        EngineVO engineVO = new EngineVO();
        engineVO.setVersion(version);
        return engineVO;
    }
}

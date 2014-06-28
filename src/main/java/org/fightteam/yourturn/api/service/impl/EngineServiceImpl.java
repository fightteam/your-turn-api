package org.fightteam.yourturn.api.service.impl;

import org.fightteam.yourturn.api.core.vo.EngineVO;
import org.fightteam.yourturn.api.service.EngineService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 平台接口服务逻辑实现
 *
 * @author faith
 * @since 0.0.1
 */
@Service
@Transactional
public class EngineServiceImpl implements EngineService {

    @Value("${engine.version}")
    private int version;

    @Override
    public EngineVO loadEngineInfo() {
        EngineVO engineVO = new EngineVO();
        engineVO.setVersion(version);
        return engineVO;
    }
}

package org.fightteam.yourturn.api.service;

import org.fightteam.yourturn.api.core.vo.EngineVO;

/**
 * 平台接口服务逻辑
 *
 * @author faith
 * @since 0.0.1
 */
public interface EngineService {

    /**
     * 载入平台信息
     * @return
     */
    EngineVO loadEngineInfo();
}

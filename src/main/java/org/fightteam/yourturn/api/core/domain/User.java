package org.fightteam.yourturn.api.core.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户领域模型
 *
 * @author faith
 * @since 0.0.1
 */
@Getter
@Setter
public class User extends Entity<Long>{
    private String username;
    private String password;
    private String nickname;
}

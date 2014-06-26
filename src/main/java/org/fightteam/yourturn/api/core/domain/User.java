package org.fightteam.yourturn.api.core.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 用户领域模型
 *
 * @author faith
 * @since 0.0.1
 */
@Getter
@Setter
@Entity
@Table(name = "user")
public class User extends AbstractEntity<Long> {
    private String username;
    private String password;
    private String nickname;
}

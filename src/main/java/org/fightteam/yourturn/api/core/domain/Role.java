package org.fightteam.yourturn.api.core.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@Getter
@Setter
public class Role extends AbstractEntity<Long> {
    private String name;
    private String title;

}

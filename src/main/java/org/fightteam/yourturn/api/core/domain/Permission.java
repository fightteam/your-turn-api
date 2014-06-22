package org.fightteam.yourturn.api.core.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by excalibur on 2014/6/23.
 */
@Setter
@Getter
public class Permission extends Entity<Long> {
    private String name;
    private String title;

}

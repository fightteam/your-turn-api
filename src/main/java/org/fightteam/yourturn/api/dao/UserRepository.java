package org.fightteam.yourturn.api.dao;

import org.fightteam.yourturn.api.core.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by excalibur on 2014/6/27.
 */
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
}

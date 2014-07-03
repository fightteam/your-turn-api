package org.fightteam.yourturn.api.dao;

import org.fightteam.yourturn.api.core.domain.Role;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@RepositoryRestResource(collectionResourceRel = "roles", path = "roles")
public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {
}

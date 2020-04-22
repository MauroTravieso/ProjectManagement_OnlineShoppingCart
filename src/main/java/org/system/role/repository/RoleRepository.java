package org.system.role.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.system.role.model.Role;

public interface RoleRepository extends JpaRepository<Role, String> {

}

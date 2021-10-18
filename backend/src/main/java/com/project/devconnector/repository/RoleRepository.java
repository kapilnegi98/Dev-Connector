package com.project.devconnector.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.devconnector.model.Role;
import com.project.devconnector.model.RoleName;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

	

	Optional<Role> getByName(RoleName roleUser);
	
}

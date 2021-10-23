package com.project.devconnector.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.devconnector.model.Follow;
@Repository
public interface FollowRepository extends JpaRepository<Follow, Long>{

	

	@Query("Select f From Follow f where f.userId= :userId")
	List<Follow> findFollowing(@Param("userId")Long userId);
	
	@Query("Select f from Follow f where f.following= :userId")
	List<Follow> findFollowers(@Param("userId") Long userId);
	
	@Query("Select f from Follow f where f.userId= :userId and f.following= :following")
	Follow getByUserdIdAndFollowingIf(Long userId, Long following);
	
}

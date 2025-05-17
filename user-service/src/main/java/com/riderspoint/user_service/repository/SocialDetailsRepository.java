package com.riderspoint.user_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riderspoint.user_service.entity.SocialDetailsEntity;

public interface SocialDetailsRepository extends JpaRepository<SocialDetailsEntity, Long> {
	  Optional<SocialDetailsEntity> findByUserProfileUsername(String username);
}

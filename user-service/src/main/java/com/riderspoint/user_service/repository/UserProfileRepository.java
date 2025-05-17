package com.riderspoint.user_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riderspoint.user_service.entity.UserProfileEntity;

public interface UserProfileRepository extends JpaRepository<UserProfileEntity, Long> {
	Optional<UserProfileEntity> findByUsername(String username);
}

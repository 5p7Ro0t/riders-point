package com.riderspoint.user_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riderspoint.user_service.entity.RidingDetailsEntity;

public interface RidingDetailsRepository extends JpaRepository<RidingDetailsEntity, Long> {
	Optional<RidingDetailsEntity> findByUserProfileUsername(String username);
}

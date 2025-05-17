package com.riderspoint.user_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riderspoint.user_service.entity.BikeDetailsEntity;

public interface BikeDetailsRepository extends JpaRepository<BikeDetailsEntity, Long> {
	Optional<BikeDetailsEntity> findByUserProfileUsername(String username);
}

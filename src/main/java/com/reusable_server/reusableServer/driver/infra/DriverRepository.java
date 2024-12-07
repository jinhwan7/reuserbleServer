package com.reusable_server.reusableServer.driver.infra;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<DriverEntity, Long> {
} 
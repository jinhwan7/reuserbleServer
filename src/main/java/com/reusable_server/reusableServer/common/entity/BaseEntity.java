package com.reusable_server.reusableServer.common.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@Getter
@MappedSuperclass
public class BaseEntity {

	@CreationTimestamp
	@Column(name = "created_date_time", updatable = false)
	private LocalDateTime createdDateTime;

	@UpdateTimestamp
	@Column(name = "updated_date_time")
	private LocalDateTime updatedDateTime;
}

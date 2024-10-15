package com.reusable_server.reusableServer.driver.infrastructure;

import java.time.LocalDateTime;

import com.reusable_server.reusableServer.driver.domain.Driver;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "driver")
@Getter
@Setter
@NoArgsConstructor
public class DriverEntity {
	@Id
	private Long driverId;

	private String state;
	private String email;
	private String name;
	private String password;
	private LocalDateTime createdDateTime;
	private LocalDateTime deletedDateTime;

	// 도메인 모델로 변환하는 메서드
	public Driver toDomain() {
		return Driver.builder()
			.driverId(this.driverId)
			.state(this.state)
			.email(this.email)
			.name(this.name)
			.password(this.password)
			.createdDateTime(this.createdDateTime)
			.deletedDateTime(this.deletedDateTime)
			.build();
	}

	// 도메인 모델로부터 엔티티를 생성하는 정적 메서드
	public static DriverEntity fromDomain(Driver driver) {
		DriverEntity entity = new DriverEntity();
		entity.setDriverId(driver.getDriverId());
		entity.setState(driver.getState());
		entity.setEmail(driver.getEmail());
		entity.setName(driver.getName());
		entity.setPassword(driver.getPassword());
		entity.setCreatedDateTime(driver.getCreatedDateTime());
		entity.setDeletedDateTime(driver.getDeletedDateTime());
		return entity;
	}
}

package com.reusable_server.reusableServer.passenger.infra;

import java.time.LocalDateTime;

import com.reusable_server.reusableServer.driver.domain.Driver;
import com.reusable_server.reusableServer.driver.infra.DriverEntity;
import com.reusable_server.reusableServer.passenger.domain.Passenger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "passenger")
@Getter
@Setter
@NoArgsConstructor
public class PassengerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "driver_id")
	private Long passengerId;

	private String email;
	private String name;
	private String password;

	@Column(name = "created_date_time")
	private LocalDateTime createdDateTime;

	@Column(name = "deleted_date_time")
	private LocalDateTime deletedDateTime;

	// 도메인 모델로 변환하는 메서드
	public Passenger toDomain() {
		return Passenger.builder()
			.passengerId(this.passengerId)
			.email(this.email)
			.name(this.name)
			.password(this.password)
			.createdDateTime(this.createdDateTime)
			.deletedDateTime(this.deletedDateTime)
			.build();
	}

	// 도메인 모델로부터 엔티티를 생성하는 정적 메서드
	public static PassengerEntity fromDomain(Passenger passenger) {
		PassengerEntity entity = new PassengerEntity();
		entity.setPassengerId(passenger.getPassengerId());
		entity.setEmail(passenger.getEmail());
		entity.setName(passenger.getName());
		entity.setPassword(passenger.getPassword());
		entity.setCreatedDateTime(passenger.getCreatedDateTime());
		entity.setDeletedDateTime(passenger.getDeletedDateTime());
		return entity;
	}
}

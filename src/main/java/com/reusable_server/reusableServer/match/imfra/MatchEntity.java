package com.reusable_server.reusableServer.match.imfra;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.reusable_server.reusableServer.driver.infra.DriverEntity;
import com.reusable_server.reusableServer.match.constant.RideState;
import com.reusable_server.reusableServer.match.domain.Location;
import com.reusable_server.reusableServer.match.domain.Match;
import com.reusable_server.reusableServer.passenger.infra.PassengerEntity;
import com.reusable_server.reusableServer.payment.infra.PaymentEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "match")
@Getter
@Setter
@NoArgsConstructor
public class MatchEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	private String rideState;

	@Embedded
	private Location startPoint;

	@Embedded
	private Location endPoint;

	private double estimatedAmount;
	private String paymentMethod;



	@Column(name = "created_date_time")
	@CreationTimestamp
	private LocalDateTime createdDateTime;

	private LocalDateTime completedDateTime;
	private LocalDateTime acceptedDateTime;
	private LocalDateTime deletedDateTime;

	@OneToOne(mappedBy = "match")
	private PaymentEntity payment;

	@ManyToOne
	@JoinColumn(name = "passenger_id")
	private PassengerEntity passenger;

	@ManyToOne
	@JoinColumn(name = "driver_id")
	private DriverEntity driver;


	public static MatchEntity fromDomain(Match match) {
		MatchEntity entity = new MatchEntity();
		entity.setId(match.getId());
		entity.setRideState(match.getRideState().name());
		entity.setStartPoint(match.getStartPoint());
		entity.setEndPoint(match.getEndPoint());
		entity.setEstimatedAmount(match.getEstimatedAmount());
		entity.setPaymentMethod(match.getPaymentMethod());
		entity.setCompletedDateTime(match.getCompletedDateTime());
		entity.setAcceptedDateTime(match.getAcceptedDateTime());
		entity.setCreatedDateTime(match.getCreatedDateTime());
		entity.setDeletedDateTime(match.getDeletedDateTime());

		entity.setPassenger(PassengerEntity.fromDomain(match.getPassenger()));
		entity.setDriver(DriverEntity.fromDomain(match.getDriver()));

		return entity;
	}


	public Match toDomain() {
		return Match.builder()
			.id(this.id)
			.passenger(this.passenger.toDomain())
			.driver(this.driver.toDomain())
			.rideState(RideState.valueOf(this.rideState))
			.startPoint(this.startPoint)
			.endPoint(this.endPoint)
			.estimatedAmount(this.estimatedAmount)
			.paymentMethod(this.paymentMethod)
			.completedDateTime(this.completedDateTime)
			.acceptedDateTime(this.acceptedDateTime)
			.createdDateTime(this.createdDateTime)
			.deletedDateTime(this.deletedDateTime)
			.build();
	}

}

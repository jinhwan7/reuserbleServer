package com.reusable_server.reusableServer.match.domain;

import java.time.LocalDateTime;

import com.reusable_server.reusableServer.driver.domain.Driver;
import com.reusable_server.reusableServer.match.constant.RideState;
import com.reusable_server.reusableServer.passenger.domain.Passenger;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Match {

	private Long matchId;
	private Driver driver;
	private Passenger passenger;
	private RideState rideState;
	private Location startPoint;
	private Location endPoint;
	private double estimatedAmount;

	private String paymentMethod;

	private LocalDateTime completedDateTime;
	private LocalDateTime acceptedDateTime;

	private LocalDateTime createdDateTime;
	private LocalDateTime deletedDateTime;

	@Builder
	public Match(
		Long matchId,
		Driver driver,
		Passenger passenger,
		RideState rideState,
		Location startPoint,
		Location endPoint,
		double estimatedAmount,
		String paymentMethod,
		LocalDateTime completedDateTime,
		LocalDateTime acceptedDateTime,
		LocalDateTime createdDateTime,
		LocalDateTime deletedDateTime) {
		this.matchId = matchId;
		this.driver = driver;
		this.passenger = passenger;
		this.rideState = rideState;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.estimatedAmount = estimatedAmount;
		this.paymentMethod = paymentMethod;
		this.completedDateTime = completedDateTime;
		this.acceptedDateTime = acceptedDateTime;
		this.createdDateTime = createdDateTime;
		this.deletedDateTime = deletedDateTime;
	}
}

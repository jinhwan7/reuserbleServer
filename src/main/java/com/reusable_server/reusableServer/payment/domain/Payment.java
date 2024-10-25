package com.reusable_server.reusableServer.payment.domain;

import java.time.LocalDateTime;

import com.reusable_server.reusableServer.driver.domain.Driver;
import com.reusable_server.reusableServer.match.domain.Match;
import com.reusable_server.reusableServer.passenger.domain.Passenger;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Payment {
	private Long paymentId;
	private Match match;
	private Passenger passenger;
	private Driver driver;
	private double amount;
	private String pgProvider;
	private LocalDateTime createdDateTime;

	@Builder
	public Payment(Long paymentId, Match match, Passenger passenger, Driver driver,
		double amount, String pgProvider, LocalDateTime createdDateTime) {
		this.paymentId = paymentId;
		this.match = match;
		this.passenger = passenger;
		this.driver = driver;
		this.amount = amount;
		this.pgProvider = pgProvider;
		this.createdDateTime = createdDateTime;
	}
}

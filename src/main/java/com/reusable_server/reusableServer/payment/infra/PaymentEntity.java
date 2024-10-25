
package com.reusable_server.reusableServer.payment.infra;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;


import com.reusable_server.reusableServer.common.entity.BaseEntity;
import com.reusable_server.reusableServer.driver.infra.DriverEntity;
import com.reusable_server.reusableServer.match.infra.MatchEntity;
import com.reusable_server.reusableServer.passenger.infra.PassengerEntity;
import com.reusable_server.reusableServer.payment.domain.Payment;

import jakarta.persistence.Column;
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
@Table(name = "payment")
@Getter
@Setter
@NoArgsConstructor
public class PaymentEntity extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;


	@OneToOne
	@JoinColumn(name = "match_id")  // payment 테이블이 match_id를 참조
	private MatchEntity match;

	@ManyToOne
	@JoinColumn(name = "passenger_id")
	private PassengerEntity passenger;

	@ManyToOne
	@JoinColumn(name = "driver_id")
	private DriverEntity driver;

	private double amount;

	private String pgProvider;

	@Column(name = "created_date_time")
	@CreationTimestamp
	private LocalDateTime createdDateTime;

	public Payment toDomain() {
		return Payment.builder()
			.id(this.id)
			.match(this.match.toDomain())
			.passenger(this.passenger.toDomain())
			.driver(this.driver.toDomain())
			.amount(this.amount)
			.pgProvider(this.pgProvider)
			.build();
	}

	public static PaymentEntity fromDomain(Payment payment) {
		PaymentEntity entity = new PaymentEntity();
		entity.setId(payment.getId());
		entity.setMatch(MatchEntity.fromDomain(payment.getMatch()));  // Match 도메인에서 엔티티로 변환
		entity.setPassenger(PassengerEntity.fromDomain(payment.getPassenger()));  // Passenger 도메인에서 엔티티로 변환
		entity.setDriver(DriverEntity.fromDomain(payment.getDriver()));  // Driver 도메인에서 엔티티로 변환
		entity.setAmount(payment.getAmount());
		entity.setPgProvider(payment.getPgProvider());
		return entity;
	}

}

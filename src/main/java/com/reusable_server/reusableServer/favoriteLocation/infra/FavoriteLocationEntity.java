package com.reusable_server.reusableServer.favoriteLocation.infra;

import java.time.LocalDateTime;

import com.reusable_server.reusableServer.favoriteLocation.domain.FavoriteLocation;
import com.reusable_server.reusableServer.passenger.infra.PassengerEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "favorite_location")
@Getter
@Setter
@NoArgsConstructor
public class FavoriteLocationEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "favorite_location_id")
	private Long favoriteLocationId;


	//이 부분 어떻게 해야하는지
	//보통 지우고 아래의 JoinColumn만 쓰는지
	@Column(name = "passenger_id")
	private Long passengerId;

	private String name;
	private String address;
	private double longitude;
	private double latitude;
	private String type;
	private String icon;

	@Column(name = "created_date_time")
	private LocalDateTime createdDateTime;

	@ManyToOne
	@JoinColumn(name = "passenger_id")
	private PassengerEntity passenger;

	// 도메인 모델로 변환하는 메소드
	public FavoriteLocation toDomain() {
		return FavoriteLocation.builder()
			.favoriteLocationId(this.favoriteLocationId)
			.passengerId(this.passengerId)
			.name(this.name)
			.address(this.address)
			.longitude(this.longitude)
			.latitude(this.latitude)
			.type(this.type)
			.icon(this.icon)
			.createdDateTime(this.createdDateTime)
			.build();
	}

	// 도메인 모델로부터 엔티티를 생성하는 정적 메서드
	public static FavoriteLocationEntity fromDomain(FavoriteLocation favoriteLocation) {
		FavoriteLocationEntity entity = new FavoriteLocationEntity();
		entity.setFavoriteLocationId(favoriteLocation.getFavoriteLocationId());
		entity.setPassengerId(favoriteLocation.getPassengerId());
		entity.setName(favoriteLocation.getName());
		entity.setAddress(favoriteLocation.getAddress());
		entity.setLongitude(favoriteLocation.getLongitude());
		entity.setLatitude(favoriteLocation.getLatitude());
		entity.setType(favoriteLocation.getType());
		entity.setIcon(favoriteLocation.getIcon());
		entity.setCreatedDateTime(favoriteLocation.getCreatedDateTime());
		return entity;
	}

}

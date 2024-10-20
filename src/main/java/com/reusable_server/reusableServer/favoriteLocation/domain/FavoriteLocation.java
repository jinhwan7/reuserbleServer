package com.reusable_server.reusableServer.favoriteLocation.domain;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FavoriteLocation {
	private Long favoriteLocationId;
	private Long passengerId;
	private String name;
	private String address;
	private double longitude;
	private double latitude;
	private String type;
	private String icon;
	private LocalDateTime createdDateTime;

	@Builder
	public FavoriteLocation(
		Long favoriteLocationId,
		Long passengerId, String name,
		String address,
		double longitude,
		double latitude,
		String type,
		String icon,
		LocalDateTime createdDateTime
		) {

		this.favoriteLocationId = favoriteLocationId;
		this.passengerId = passengerId;
		this.name = name;
		this.address = address;
		this.longitude = longitude;
		this.latitude = latitude;
		this.type = type;
		this.icon = icon;
		this.createdDateTime = createdDateTime;

	}

}

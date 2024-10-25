package com.reusable_server.reusableServer.match.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Location {
	private double latitude;
	private double longitude;
}

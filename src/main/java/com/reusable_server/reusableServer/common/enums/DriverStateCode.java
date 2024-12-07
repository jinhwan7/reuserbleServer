package com.reusable_server.reusableServer.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DriverStateCode {
	INSERVICE("in_service"),
	IDLE("idle"),
	ONCALL("oncall"),
	OFF("off");

	private String status;
}

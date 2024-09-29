package com.reusable_server.reusableServer.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ReturnCode {
  SUCCESS("200", "Success"),
  NOT_FOUND_ENTITY("400", "Not Found Entity");

  private String returnCode;
  private String returnMessage;

}

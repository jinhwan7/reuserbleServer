package com.reusable_server.reusableServer.common.exception;

import com.reusable_server.reusableServer.common.enums.ReturnCode;

public class ReuserbleException extends RuntimeException {
  private ReturnCode returnCode;
  private String returnMessage;

  public ReuserbleException(ReturnCode returnCode) {
    super(returnCode.getReturnMessage());
    this.returnCode = returnCode;
    this.returnMessage = returnCode.getReturnMessage();
  }

}

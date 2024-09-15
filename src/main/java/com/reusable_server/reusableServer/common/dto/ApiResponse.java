package com.reusable_server.reusableServer.common.dto;

import static com.reusable_server.reusableServer.common.enums.ReturnCode.SUCCESS;

import com.reusable_server.reusableServer.common.enums.ReturnCode;
import lombok.Getter;

@Getter
public class ApiResponse<T> {

  private String returnCode;
  private String returnMessage;
  private T data;

  public static <T> ApiResponse of(T data) {
    ApiResponse<T> response = new ApiResponse<>();
    response.returnCode = SUCCESS.getReturnCode();
    response.returnMessage = SUCCESS.getReturnMessage();
    response.data = data;

    return response;
  }

  public static <T> ApiResponse of(ReturnCode returnCode) {
    ApiResponse<T> response = new ApiResponse<>();
    response.returnCode = returnCode.getReturnCode()
    response.returnMessage = returnCode.getReturnMessage();

    return response;
  }

}

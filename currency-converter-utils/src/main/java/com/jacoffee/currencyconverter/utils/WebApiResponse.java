package com.jacoffee.currencyconverter.utils;

public class WebApiResponse<T> {

  public static final int SUCCESS = 0;
  public static final int ERROR = 1;

  private int code;
  private String errorMsg;
  private T data;

  public void setCode(int code) {
    this.code = code;
  }

  public void setErrorMsg(String errorMsg) {
    this.errorMsg = errorMsg;
  }

  public void setData(T data) {
    this.data = data;
  }

  public int getCode() {
    return code;
  }

  public String getErrorMsg() {
    return errorMsg;
  }

  public T getData() {
    return data;
  }

  public static <T> WebApiResponse<T> success(T data) {
    WebApiResponse<T> response = new WebApiResponse<>();
    response.setCode(SUCCESS);
    response.setData(data);
    return response;
  }

  public static <T> WebApiResponse<T> failed(String errorMsg) {
    WebApiResponse<T> response = new WebApiResponse<>();
    response.setCode(ERROR);
    response.setErrorMsg(errorMsg);
    return response;
  }


}

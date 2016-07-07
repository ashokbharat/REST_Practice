package org.ashok.bharat.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ExceptionMessage {
  private int errorCode;
  private String errorMsg;
  private String errorDocumentation;
  public ExceptionMessage(){
    
  }
  public ExceptionMessage(int errorCode, String errorMsg, String errorDocumentation) {
    super();
    this.errorCode = errorCode;
    this.errorMsg = errorMsg;
    this.errorDocumentation = errorDocumentation;
  }
  public int getErrorCode() {
    return errorCode;
  }
  public void setErrorCode(int errorCode) {
    this.errorCode = errorCode;
  }
  public String getErrorMsg() {
    return errorMsg;
  }
  public void setErrorMsg(String errorMsg) {
    this.errorMsg = errorMsg;
  }
  public String getErrorDocumentation() {
    return errorDocumentation;
  }
  public void setErrorDocumentation(String errorDocumentation) {
    this.errorDocumentation = errorDocumentation;
  }
  
}

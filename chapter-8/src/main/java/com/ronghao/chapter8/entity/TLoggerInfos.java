package com.ronghao.chapter8.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "t_logger_infos")
public class TLoggerInfos implements Serializable{
   private long id;
  private String clientIp;
  private String uri;
  private String type;
  private String method;
  private String paramData;
  private String sessionId;
  private String returmTime;
  private String returnData;
  private String httpStatusCode;
  private Timestamp time;
  private long timeConsuming;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ali_id", nullable = false)
  public long getId() {
    return id;
  }
  public void setId(long aliId) {
    this.id = aliId;
  }

  @Basic
  @Column(name = "ali_client_ip", nullable = true, length = 30)
  public String getClientIp() {
    return clientIp;
  }

  public void setClientIp(String aliClientIp) {
    this.clientIp = aliClientIp;
  }


  @Basic
  @Column(name = "ali_uri", nullable = true, length = 100)
  public String getUri() {
    return uri;
  }

  public void setUri(String aliUri) {
    this.uri = aliUri;
  }


  @Basic
  @Column(name = "ali_type", nullable = true, length = 50)
  public String getType() {
    return type;
  }

  public void setType(String aliType) {
    this.type = aliType;
  }


  @Basic
  @Column(name = "ali_method", nullable = true, length = 10)
  public String getMethod() {
    return method;
  }

  public void setMethod(String aliMethod) {
    this.method = aliMethod;
  }


  @Basic
  @Column(name = "ali_param_data", nullable = true, length = -1)
  public String getParamData() {
    return paramData;
  }

  public void setParamData(String aliParamData) {
    this.paramData = aliParamData;
  }


  @Basic
  @Column(name = "ali_session_id", nullable = true, length = 100)
  public String getSessionId() {
    return sessionId;
  }

  public void setSessionId(String aliSessionId) {
    this.sessionId = aliSessionId;
  }


  @Basic
  @Column(name = "ali_time", nullable = true)
  public Timestamp getTime() {
    return time;
  }

  public void setTime(Timestamp aliTime) {
    this.time = aliTime;
  }


  @Basic
  @Column(name = "ali_returm_time", nullable = true, length = 50)
  public String getReturmTime() {
    return returmTime;
  }

  public void setReturmTime(String aliReturmTime) {
    this.returmTime = aliReturmTime;
  }


  @Basic
  @Column(name = "ali_return_data", nullable = true, length = -1)
  public String getReturnData() {
    return returnData;
  }

  public void setReturnData(String aliReturnData) {
    this.returnData = aliReturnData;
  }


  @Basic
  @Column(name = "ali_http_status_code", nullable = true, length = 10)
  public String getHttpStatusCode() {
    return httpStatusCode;
  }

  public void setHttpStatusCode(String aliHttpStatusCode) {
    this.httpStatusCode = aliHttpStatusCode;
  }


  @Column(name = "ali_time_consuming", nullable = true)
  public long getTimeConsuming() {
    return timeConsuming;
  }
  public void setTimeConsuming(Integer aliTimeConsuming) {
    this.timeConsuming = aliTimeConsuming;
  }



}

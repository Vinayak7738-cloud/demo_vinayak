package com.lexisnexis.companysearch.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="REQ_RES_DATA")
public class RequestResponse implements Serializable {


    @Id
    @Column(name="COMPANY_ID")
    private int id;

    @Column(name="API")
    private String api;

    @Column(name="API_URL")
    private String apiUrl;

    @Column(name="HTTP_METHOD")
    private String httpMethod;

    @Column(name="REQ_TIME")
    private String reqTime;

    @Column(name="STATUS_CODE")
    private int statusCode;

    public int getId() {
        return id;
    }

    public String getApi() {
        return api;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public String getReqTime() {
        return reqTime;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public void setReqTime(String reqTime) {
        this.reqTime = reqTime;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}

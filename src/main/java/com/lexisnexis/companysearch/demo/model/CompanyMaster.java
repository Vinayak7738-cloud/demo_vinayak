package com.lexisnexis.companysearch.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;


@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="COMPANY_MASTER")
public class CompanyMaster implements Serializable {

    @Id
    @Column(name="COMPANY_ID")
    private int compId;

    @Column(name="COMPANY_NUMBER")
    private Long compNumber;

    @Column(name="COMPANY_TYPE")
    private String companyType;

    @Column(name="COMPANY_TITLE")
    private String title;

    @Column(name="COMPANY_STATUS")
    private String companyStatus;

    @Column(name="DATE_OF_CREATION")
    private Date dateOfCreation;

    @OneToMany
    @JoinColumn(name="ADDRESS_ID")
    private Address address;


}

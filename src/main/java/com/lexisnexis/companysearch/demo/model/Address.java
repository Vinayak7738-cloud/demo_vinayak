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
@Table(name="ADDRESS")
public class Address implements Serializable {

    @Id
    @Column(name="ADDRESS_ID")
    private int addressId;

    @Column(name="LOCALITY")
    private String locality;

    @Column(name="POSTAL_CODE")
    private String postalCode;

    @Column(name="PREMISES")
    private String premises;


    @Column(name="ADDRESS_LINE_1")
    private String addressLine;

    @Column(name="country")
    private String country;

}

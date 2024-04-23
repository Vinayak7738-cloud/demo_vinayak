package com.lexisnexis.companysearch.demo.service;

import com.lexisnexis.companysearch.demo.dto.SearchCompanyRequestDTO;
import com.lexisnexis.companysearch.demo.model.CompanyMaster;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SearchService {

    ResponseEntity<String> searchCompany(SearchCompanyRequestDTO searchCompanyRequestDTO);

    List<CompanyMaster> finalAllCompanies();
}

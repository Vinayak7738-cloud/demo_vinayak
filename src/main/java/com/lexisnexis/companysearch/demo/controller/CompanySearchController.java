package com.lexisnexis.companysearch.demo.controller;

import com.lexisnexis.companysearch.demo.dto.SearchCompanyRequestDTO;
import com.lexisnexis.companysearch.demo.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value={"companySearch/api/"})
public class CompanySearchController {

    @Autowired
    private SearchService searchService;
    @PostMapping(value={"/searchCompany"})
    public ResponseEntity<String> searchCompany(@RequestBody SearchCompanyRequestDTO searchCompanyRequestDTO){
        return searchService.searchCompany(searchCompanyRequestDTO);
    }
}

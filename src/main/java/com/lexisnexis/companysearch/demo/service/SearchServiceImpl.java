package com.lexisnexis.companysearch.demo.service;

import com.fasterxml.jackson.core.JsonParser;
import com.lexisnexis.companysearch.demo.dto.SearchCompanyRequestDTO;
import com.lexisnexis.companysearch.demo.model.CompanyMaster;
import com.lexisnexis.companysearch.demo.model.RequestResponse;
import com.lexisnexis.companysearch.demo.model.WebUtility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SearchServiceImpl  implements SearchService {



    @Autowired
    SearchCompanyDao searchCompanyDao;

    @Autowired
    CompanyMasterDao companyMasterDao;
    @Override
    public ResponseEntity<String> searchCompany(SearchCompanyRequestDTO searchCompanyRequestDTO) {
        log.info("Request::::::"+ searchCompanyRequestDTO);

        String url = "https://excersie.trunarative.cloud/TrueProxyApi/rest/Companies/v1/Search?Query={searchCompanyRequestDTO.getCompanyName()}";
        long reqTime = System.currentTimeMillis();

        RequestResponse reqRes = new RequestResponse();
        reqRes.setApi("Company Search");
        reqRes.setApiUrl(url);
        reqRes.setHttpMethod("Post");
        reqRes.setReqTime(Base.getDate(reqTime));
        reqRes.setRequest(searchCompanyRequestDTO.toString());

        ResponseEntity<String> response = null;
        try{
            response = WebUtility.getRestTemplate().postForEntity(url,searchCompanyRequestDTO,String.class);
            reqRes.setStatusCode(response.getStatusCode().value());
            reqRes.setResponse(response.getBody());

            JsonParser parser = new JsonParser();
            JsonObject json = (JsonObject) parser.parse(response.getBody());
            JsonArray companies = jso.getAsJsonArray("companies");
            List<String> compIds = Base.getValuesInArray(companies,"company-id");

            log.info("Response ::::::"+compIds);

        } catch (Exception e){
            reqRes.setStatusCode(900);
            reqRes.setResponse(e.getMessage());
            log.error("Err",e);
            e.printStackTrace();

        } finally {
            long endTime = System.currentTimeMillis();
            long executeTime = endTime - reqTime;
            reqRes.setExecutionTime(executionTime);

        }

        return response;
    }

    @Override
    public List<CompanyMaster> finalAllCompanies() {
        return companyMasterDao.findAll();
    }
}

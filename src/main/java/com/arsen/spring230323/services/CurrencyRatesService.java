package com.arsen.spring230323.services;

import com.arsen.spring230323.dto.CurrencyRatesModel;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class CurrencyRatesService {

    RestTemplate restTemplate;
    XmlMapper xmlMapper;

    public CurrencyRatesService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.xmlMapper = new XmlMapper();
    }

    public CurrencyRatesModel getModelFromApi() throws Exception {
        String xml = restTemplate.getForObject("https://www.nbkr.kg/XML/daily.xml", String.class);
        return xmlMapper.readValue(xml, CurrencyRatesModel.class);
    }

}

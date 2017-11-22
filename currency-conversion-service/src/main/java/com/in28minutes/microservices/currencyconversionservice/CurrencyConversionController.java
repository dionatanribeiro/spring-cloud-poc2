package com.in28minutes.microservices.currencyconversionservice;

import com.in28minutes.microservices.currencyconversionservice.bean.CurrencyConversion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CurrencyExchangeServiceProxy serviceProxy;

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion convertCurrency(@PathVariable String from,
                                              @PathVariable String to,
                                              @PathVariable BigDecimal quantity) {

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);

        ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity(
                "http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                CurrencyConversion.class,
                uriVariables);

        CurrencyConversion response = responseEntity.getBody();

        return new CurrencyConversion(response.getId(), from, to,
                response.getConversionMultiple(),
                quantity,
                quantity.multiply(response.getConversionMultiple()),
                response.getPort());
    }

    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion convertCurrencyFeign(@PathVariable String from,
                                              @PathVariable String to,
                                              @PathVariable BigDecimal quantity) {

        CurrencyConversion response = serviceProxy.retrieveExchangeValue(from, to);

        logger.info("{}", response);

        return new CurrencyConversion(response.getId(), from, to,
                response.getConversionMultiple(),
                quantity,
                quantity.multiply(response.getConversionMultiple()),
                response.getPort());
    }

}

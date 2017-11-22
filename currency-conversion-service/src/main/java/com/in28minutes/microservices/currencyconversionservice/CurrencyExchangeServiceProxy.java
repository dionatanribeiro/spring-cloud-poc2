package com.in28minutes.microservices.currencyconversionservice;

import com.in28minutes.microservices.currencyconversionservice.bean.CurrencyConversion;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
//@FeignClient(name = "currency-exchange-service")

/**
 * Deixa de conectar o Feign ao nome do service e começa a conectar pelo
 * zuul gateway para captura de logs
 */
@FeignClient(name = "netflix-zuul-api-gateway-server")
/**
 * Com o Ribbon não é necessário especificar ao Feign a url da aplicação.
 */
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

    // @GetMapping("/currency-exchange/from/{from}/to/{to}")
    // é necessário apendar o nome do microservice dentro da uri
    // para o request passar pelo zuul gateway
    @GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
    CurrencyConversion retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);

}

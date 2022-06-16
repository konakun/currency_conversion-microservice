package com.konakun.currency_conversionmicroservice.Proxy;

import com.konakun.currency_conversionmicroservice.CurrencyConversionBean.CurrencyConversionBean;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "forex-service")
@LoadBalancerClient(name = "forex-service")
public interface CurrencyExchangeServiceProxy {
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String form,
                                                        @PathVariable("to") String to);
}

package com.jacoffee.currencyconverter.provider;

import com.jacoffee.currencyconverter.api.ConverterService;
import com.alibaba.dubbo.config.annotation.Service;
import com.jacoffee.currencyconverter.utils.HttpUtils;
import com.jacoffee.currencyconverter.utils.JsonUtils;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Service(
    version="1.0.0",
    application="${dubbo.application.id}",
    protocol = "${dubbo.protocol.id}",
    registry = "${dubbo.registry.id}"
)
@Component
public class ConverterServiceImpl implements ConverterService {

  /*
      Get from rest api instead of DAO

      WARNING: this is definitely bad practice, if we can get the result from rest api we can just get it done
      in the client side. Here we just demonstrate the basic skeleton of Spring-boot & dubbo
  */
  @Override
  public double convert(String one, String other) throws Exception {
    String queryUrl = String.format(
      "http://free.currencyconverterapi.com/api/v3/convert?q=%s_%s&compact=ultra",
       one, other
    );
    String jsonKey = String.format("%s_%s", one, other).toUpperCase();
    Optional<String> jsonStrOpt =  HttpUtils.getResponse(queryUrl);

    double rate = JsonUtils.getJsonNode(jsonStrOpt.get()).at("/" + jsonKey).asDouble();
    return rate;
  }

}

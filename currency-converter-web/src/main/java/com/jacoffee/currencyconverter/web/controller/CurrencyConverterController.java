package com.jacoffee.currencyconverter.web.controller;

import com.jacoffee.currencyconverter.api.ConverterService;
import com.jacoffee.currencyconverter.utils.WebApiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.dubbo.config.annotation.Reference;

@Controller
public class CurrencyConverterController {

  @Reference(
      version = "1.0.0",
      timeout = 1000 * 60,
      application = "${dubbo.application.id}"
  )
  private ConverterService converterService;

  /* HttpMessageConverter ---- MappingJackson2HttpMessageConverter */
  @RequestMapping(value = "/api/v3/convert", method = RequestMethod.POST)
  @ResponseBody
  public Object convert(@RequestParam String from, @RequestParam String to) {
    try {
      Double rate = converterService.convert(from, to);
      WebApiResponse<Double> response = WebApiResponse.success(rate);
      return response;
    } catch (Exception ex) {
      WebApiResponse<Double> response = WebApiResponse.failed(ex.getMessage());
      return response;
    }
  }

  /*
        Spring MVC ViewResolver
        + BeanNameViewResolver
        + InternalResourceViewResolver
  */
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index(ModelMap map) {
    map.addAttribute("host", "http://roadtopro.cn");
    return "/index";
  }

}

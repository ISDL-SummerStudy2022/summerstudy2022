package com.example.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.model.Weather;
import com.example.api.service.WeatherService;

@RestController
public class TestController {
    @Autowired
    WeatherService weatherService;

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public String test() {
      return "ok from test.";
    }

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public List<Weather> hello() {
      // 気象データの取得
      List<Weather> weatherDataList = weatherService.findAllWeatherData();
      // model.addAttribute("weatherDataList", weatherDataList);

      return weatherDataList;
    }

    @RequestMapping(path = "/test/json", method = RequestMethod.GET)
    public Example testJson() {
      var examplePOJO = new Example();
      examplePOJO.value1 = "foo";
      examplePOJO.value2 = "bar";
      return examplePOJO;
    }

    public class Example {
      public String value1;
      public String value2;
    }
}


package com.example.api.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;


import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.http.MediaType;
import java.util.List;


// import org.springframework.web.bind.annttation.ResponseBody;

@RestController
@CrossOrigin(origins = "*")
public class TestController {


    @RequestMapping(path = "/test/json", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Testjson> responsejson(
          @RequestBody List<Testjson> testjson) {
            System.out.println("testing2");
            System.out.println(testjson);
            return testjson;
    }

    @RequestMapping(path = "/test/json2", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Testjson responsejson(
          @RequestBody Testjson testjson) {
            System.out.println("testing3");
            return testjson;
    }

    public static class Testjson {
      private String value1;
      private String value2;

      public String getValue1(){
        return value1;
      }
      public String getValue2(){
        return value2;
      }
      public void setValue1(String value1){
        this.value1=value1;
      }
      public void setValue2(String value2){
        this.value2=value2;
      }

    }

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    @ResponseBody
    public Example testJson() {
      var examplePOJO = new Example();
      examplePOJO.value1 = "foo";
      examplePOJO.value2 = "bar";
      System.out.println("testing1");
      return examplePOJO;
    }

    public class Example {
  		public String value1;
	  	public String value2;
	  }
}


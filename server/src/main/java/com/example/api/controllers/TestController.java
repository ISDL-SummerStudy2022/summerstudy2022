package com.example.api.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import java.util.List;

@RestController
public class TestController {
    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public String test() {
      return "ok from test.";
    }

    @RequestMapping(path = "/test/json", method = RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE)
      
      @ResponseBody

      public List<Testjson> responsejson(
          @RequestBody List<Testjson> testjson) {
            System.out.println("testing");
            return testjson;
      }


      @RequestMapping(path = "/test/json2", method = RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE)
      @ResponseBody
      public Testjson responsejson2(
          @RequestBody Testjson testjson) {
            System.out.println("testing");
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
  
    }




package com.example.api.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping(path = "/test/json", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Testjson> responsejson(
          @RequestBody List<Testjson> testjson) {
            System.out.println("testing2");
            System.out.println(testjson);
            return testjson;
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean responsejson(
          @RequestBody Testjson userinfo) {
            System.out.println(userinfo);
            return true;
    }

    public static class userjson {
      private String username;
      private String email;
      private String password;

      public String getUsername(){
        return username;
      }
      public String getEmail(){
        return email;
      }
      public String getPassword(){
        return password;
      }
      public void setUsername(String username){
        this.username=username;
      }
      public void setEmail(String email){
        this.email=email;
      }
      public void setPassword(String password){
        this.password=password;
      }
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


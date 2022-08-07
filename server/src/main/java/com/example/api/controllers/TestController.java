package com.example.api.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.service.TodoService;

@RestController
public class TestController {
    @Autowired
    TodoService todoService;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public String test() {
      return "ok from test.";
    }

    // @RequestMapping(path = "/hello", method = RequestMethod.GET)
    // public List<Todo> hello() {
    //   List<Todo> todoDataList = todoService.findAllTodoData();

    //   return todoDataList;
    // }

    // @RequestMapping(path = "/hello/select", method = RequestMethod.GET)
    // public List<Todo> helloSelect() {
    //   List<Todo> todoDataListSelect = todoService.findTodoDataListByCol1("1111");

    //   return todoDataListSelect;
    // }

    @RequestMapping(path = "/hello/jdbc", method = RequestMethod.GET)
    public String helloJDBC() {
      System.out.println("*** JDBC Start. ***");
      String sql = "select * from items";
      List<Map<String, Object>> sqlResultList = jdbcTemplate.queryForList(sql);
      sqlResultList.forEach(s -> {
          System.out.println(s);
      });
      System.out.println("*** JDBC End. ***");

      return "JDBC";
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


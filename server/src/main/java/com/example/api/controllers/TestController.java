package com.example.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.model.Todo;
import com.example.api.service.TodoService;

@RestController
public class TestController {
    @Autowired
    TodoService todoService;

    @RequestMapping(path = "/todo/insert", method = RequestMethod.GET)
    public String testInsert() {
      return "testInsert";
    }

    @RequestMapping(path = "/todo/update", method = RequestMethod.GET)
    public String testUpdate() {
      return "testUpdate";
    }

    @RequestMapping(path = "/todo/delete", method = RequestMethod.GET)
    public String testDelete() {
      return "testDelete";
    }

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public String test() {
      return "ok from test.";
    }

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public List<Todo> hello() {
      List<Todo> todoDataList = todoService.findAllTodoData();

      return todoDataList;
    }

    @RequestMapping(path = "/hello/select", method = RequestMethod.GET)
    public List<Todo> helloSelect() {
      List<Todo> todoDataListSelect = todoService.findTodoDataListByCol1("1111");

      return todoDataListSelect;
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


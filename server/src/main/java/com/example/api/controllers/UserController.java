package com.example.api.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.model.Todo;
import com.example.api.service.TodoService;

@RestController
public class UserController {
    @Autowired
    TodoService todoService;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(path = "/user/insert", method = RequestMethod.POST)
    public String userInsert() {
      return "userInsert";
    }

    @RequestMapping(path = "/user/update", method = RequestMethod.POST)
    public String userUpdate() {
      return "userUpdate";
    }

    @RequestMapping(path = "/user/delete", method = RequestMethod.POST)
    public String userDelete() {
      return "userDelete";
    }

    @RequestMapping(path = "/user/select", method = RequestMethod.POST)
    public String userSelect() {
      return "userSelect";
    }

    @RequestMapping(path = "/user/selectall", method = RequestMethod.POST)
    public String userSelectall() {
      return "userSelect";
    }
}
package com.example.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.service.TodoService;

@RequestMapping(path="/item")
@RestController
public class ItemController {
    @Autowired
    TodoService todoService;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String itemInsert() {
      return "itemInsert";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String itemUpdate() {
      return "itemUpdate";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String itemDelete() {
      return "itemDelete";
    }

    @RequestMapping(value = "/select", method = RequestMethod.POST)
    public String itemSelect() {
      return "itemSelect";
    }

    @RequestMapping(value = "/selectall", method = RequestMethod.POST)
    public String itemSelectAll() {
      return "itemSelect";
    }
}
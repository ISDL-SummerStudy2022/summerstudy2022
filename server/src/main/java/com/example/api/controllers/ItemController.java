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
public class ItemController {
    @Autowired
    TodoService todoService;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(path = "/item/insert", method = RequestMethod.POST)
    public String itemInsert() {
      return "itemInsert";
    }

    @RequestMapping(path = "/item/update", method = RequestMethod.POST)
    public String itemUpdate() {
      return "itemUpdate";
    }

    @RequestMapping(path = "/item/delete", method = RequestMethod.POST)
    public String itemDelete() {
      return "itemDelete";
    }

    @RequestMapping(path = "/item/select", method = RequestMethod.POST)
    public String itemSelect() {
      return "itemSelect";
    }

    @RequestMapping(path = "/item/selectall", method = RequestMethod.POST)
    public String itemSelectAll() {
      return "itemSelect";
    }
}
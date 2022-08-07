package com.example.api.controllers;

import com.example.api.model.ItemInsert;

import java.util.List;
import java.util.Map;



import org.springframework.dao.DataAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.http.MediaType;
import com.example.api.model.Todo;
import com.example.api.service.TodoService;

@RequestMapping(path = "/item")
@RestController
public class ItemController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public boolean responsejson2(
        @RequestBody ItemInsert item) {
          System.out.println("*** JDBC Start. ***");
          // String sql = "select * from items";

          String sqlText  = "INSERT INTO items (userid,text,genreid,priority,datetime,status) "
                    + "VALUES (?,?,?,?,?,?)";       
          try{
            jdbcTemplate.update(sqlText,item.getuserid(),item.gettext(),item.getgenreid(),item.getpriority(),item.getdatetime(),true);
            return true;
          }
          catch (DataAccessException e)
          {
              System.out.println("DB処理エラー");
              System.out.println(e);
              return false;
          }
          
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
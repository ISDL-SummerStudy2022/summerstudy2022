package com.example.api.controllers;

import com.example.api.model.ItemInsert;

import java.util.List;
import java.util.Map;
import java.util.Date;
import java.util.ArrayList;


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
    public boolean itemUpdate(
      @RequestBody ItemInsert item) {
          System.out.println("*** JDBC Start. ***");
          String sqlText = "UPDATE items SET "+ " userid = ? ,text = ? ,genreid = ? ,priority = ? ,datetime = ? ,status = ? " + "WHERE" + " id = ?;";   
          try{
            jdbcTemplate.update(sqlText,item.getuserid(),item.gettext(),item.getgenreid(),item.getpriority(),item.getdatetime(),item.getstatus(),item.getid());
            return true;
          }
          catch (DataAccessException e)
          {
              System.out.println("DB処理エラー");
              System.out.println(e);
              return false;
          }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public boolean itemDelete(     
      @RequestBody ItemInsert item) {
      System.out.println("*** JDBC Start. ***");
      String sqlText = "DELETE FROM items WHERE id = ?"; 
      try{
        jdbcTemplate.update(sqlText,item.getid());
        return true;
      }
      catch (DataAccessException e)
      {
          System.out.println("DB処理エラー");
          System.out.println(e);
          return false;
      }
    }

    @RequestMapping(value = "/select", method = RequestMethod.POST)
    public List<ItemInsert> itemSelect() {
      String sqlText = ""
      + "SELECT"
          + " *"
      + " FROM"
          + " items";

// queryForListメソッドでSQLを実行し、結果MapのListで受け取る。
  List<Map<String, Object>> items = jdbcTemplate.queryForList(sqlText);
  
  // Userオブジェクト格納用のListを作成する。
  List<ItemInsert> itemList = new ArrayList<ItemInsert>();
  
  // 受け取ったMapのListをfor文で回し、各ユーザの値をUserオブジェクトに格納する。
  for(Map<String, Object> eachItem: items) {
      ItemInsert item = new ItemInsert(
               (int) eachItem.get("id")
              ,(int) eachItem.get("userid")
              ,(String) eachItem.get("text")
              ,(int) eachItem.get("genreid")
              ,(int) eachItem.get("priority")
              ,(Date) eachItem.get("datetime")
              ,(boolean) eachItem.get("status")
              ,(String) eachItem.get("eventid")
       );
      // UserオブジェクトをListに追加する。
      itemList.add(item);
    }

  return itemList;
    }
}
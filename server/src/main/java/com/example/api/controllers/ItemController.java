package com.example.api.controllers;

import com.example.api.model.ItemEntity;

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

@RequestMapping(path = "/item")
@RestController
public class ItemController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public boolean responsejson2(
        @RequestBody ItemEntity item) {
          System.out.println("*** JDBC Start. ***");
          String sqlText  = "INSERT INTO items (userID,text,genreID,priority,datetime,status) "
                    + "VALUES (?,?,?,?,?,?)";       
          try{
            jdbcTemplate.update(sqlText,item.getuserID(),item.gettext(),item.getgenreID(),item.getpriority(),item.getdatetime(),true);
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
      @RequestBody ItemEntity item) {
          System.out.println("*** JDBC Start. ***");
          String sqlText = "UPDATE items SET "+ " userID = ? ,text = ? ,genreID = ? ,priority = ? ,datetime = ? ,status = ? " + "WHERE" + " id = ?;";   
          try{
            jdbcTemplate.update(sqlText,item.getuserID(),item.gettext(),item.getgenreID(),item.getpriority(),item.getdatetime(),item.getstatus(),item.getitemID());
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
      @RequestBody ItemEntity item) {
      System.out.println("*** JDBC Start. ***");
      String sqlText = "DELETE FROM items WHERE id = ?"; 
      try{
        jdbcTemplate.update(sqlText,item.getitemID());
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
    public List<ItemEntity> itemSelect(@RequestBody ItemEntity item) {
      String sqlText = ""
      + "SELECT"
          + " *"
      + " FROM"
          + " items" + " WHERE"
          + " userID = ?";

      System.out.println(item.getitemID());
// queryForListメソッドでSQLを実行し、結果MapのListで受け取る。
  List<Map<String, Object>> items = jdbcTemplate.queryForList(sqlText,item.getuserID());
  
  // Userオブジェクト格納用のListを作成する。
  List<ItemEntity> itemList = new ArrayList<ItemEntity>();
  
  // 受け取ったMapのListをfor文で回し、各ユーザの値をUserオブジェクトに格納する。
  for(Map<String, Object> eachItem: items) {
      ItemEntity DBitem = new ItemEntity(
               (int) eachItem.get("itemID")
              ,(int) eachItem.get("userID")
              ,(String) eachItem.get("text")
              ,(int) eachItem.get("genreID")
              ,(int) eachItem.get("priority")
              ,(Date) eachItem.get("datetime")
              ,(boolean) eachItem.get("status")
              ,(String) eachItem.get("eventid")
       );
      // UserオブジェクトをListに追加する。
      itemList.add(DBitem);
    }

  return itemList;
    }
}
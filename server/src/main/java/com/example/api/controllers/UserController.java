package com.example.api.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.model.Todo;
import com.example.api.model.UserInsert;
import com.example.api.model.UserDelete;
import com.example.api.model.UserSelect;
import com.example.api.service.TodoService;

@RequestMapping(path="/user")
@RestController
public class UserController {
    @Autowired
    TodoService todoService;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Boolean userInsert(
      @RequestBody UserInsert userinsert) {
        System.out.println("*** UserInsert Start ***");
        try {
          System.out.println(userinsert.getName()+", "+userinsert.getEmail());

          String sql = "SELECT * FROM users WHERE email='"+ userinsert.getEmail() +"'";
          List<Map<String, Object>> sqlResultList = jdbcTemplate.queryForList(sql);
          System.out.println(sql+" -> "+sqlResultList);
          if (!(sqlResultList.isEmpty())){
            System.out.println("*** UserInsert Failed ***");
            return false;
          }
          sql = "INSERT INTO users VALUES(DEFAULT,'"+userinsert.getName()+"', '"+userinsert.getEmail()+"', 'password')";
          System.out.println(sql);
          jdbcTemplate.execute(sql);
          System.out.println("*** UserInsert End ***");
          return true;
        }
        catch(Exception e) {
          System.out.println("*** UserInsert ERROR ***");
          System.out.println(e);
          return false;
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String userUpdate() {
      return "userUpdate";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Boolean userDelete(
      @RequestBody UserDelete userdelete) {
        System.out.println("*** UserDelete Start ***");
        try {
          System.out.println(userdelete.getUserID());

          String sql = "SELECT * FROM users WHERE id="+ userdelete.getUserID();
          List<Map<String, Object>> sqlResultList = jdbcTemplate.queryForList(sql);
          System.out.println(sql+" -> "+sqlResultList);
          if (sqlResultList.isEmpty()){
            System.out.println("*** UserDelete Failed ***");
            return false;
          }
          sql = "DELETE FROM items WHERE userid="+ userdelete.getUserID();
          System.out.println(sql);
          jdbcTemplate.execute(sql);
          sql = "DELETE FROM users WHERE id="+ userdelete.getUserID();
          System.out.println(sql);
          jdbcTemplate.execute(sql);
          System.out.println("*** UserDelete End ***");
          return true;
        }
        catch(Exception e) {
          System.out.println("*** UserDelete ERROR ***");
          System.out.println(e);
          return false;
        }
    }

    @RequestMapping(value = "/select", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public returnSelect userSelect(
      @RequestBody UserSelect userselect) {
        System.out.println("*** UserSelect Start ***");
        var returnValue = new returnSelect();
        returnValue.check = false;
        returnValue.userID = 0;
        try {
          System.out.println(userselect.getName()+", "+userselect.getEmail());

          String sql = "SELECT id FROM users WHERE name='"+userselect.getName()+"' AND email='"+ userselect.getEmail() +"'";
          Map<String, Object> userID = jdbcTemplate.queryForMap(sql);
          System.out.println(sql+" -> "+userID);
          // System.out.println((Integer) userID.get("id"));
          returnValue.check = true;
          returnValue.userID = (Integer) userID.get("id");
          System.out.println("*** UserSelect End ***");
          return returnValue;
        }
        catch(Exception e) {
          System.out.println("*** UserSelect ERROR ***");
          System.out.println(e);
          return returnValue;
        }
    }

    public class returnSelect {
      public Boolean check;
      public Integer userID;
    }

    @RequestMapping(value = "/selectall", method = RequestMethod.POST)
    public String userSelectall() {
      return "userSelect";
    }
}
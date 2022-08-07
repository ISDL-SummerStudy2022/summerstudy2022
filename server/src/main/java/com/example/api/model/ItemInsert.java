package com.example.api.model;

import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

// @Entity
public class ItemInsert {
    // @Id
    private int id;
    // @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int userid;
    private String text;
    private int genreid;
    private int priority;
    private Date datetime;
    private boolean status;
    private String eventid;

    public int getid() {
      return id;
    }
    public int getuserid() {
      return userid;
    }
    // public void setCol1(String col1) {
    //   this.col1 = col1;
    // }

    public String gettext() {
      return text;
    }

    public int getgenreid() {
      return genreid;
    }

    public Boolean getstatus(){
      return status;
    }

    public int getpriority() {
        return priority;
      }

    public Date getdatetime() {
    return datetime;
    }

    public boolean status() {
        return status;
    }

    public String eventid(){
        return eventid;
    }

    public ItemInsert() {
    }
    public ItemInsert(
     int id,
     int userid,
     String text,
     int genreid,
     int priority,
     Date datetime,
     boolean status,
     String eventid){
      this.id = id;
      this.userid = userid;
      this.text = text;
      this.genreid = genreid;
      this.priority = priority;
      this.datetime = datetime;
      this.status = status;
      this.eventid = eventid;
    }

}

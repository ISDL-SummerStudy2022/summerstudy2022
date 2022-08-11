package com.example.api.model;
import java.util.Date;


public class ItemEntity {
    private int itemID;
    private int userID;
    private String text;
    private int genreID;
    private int priority;
    private Date datetime;
    private boolean status;
    private String eventid;

    public int getitemID() {
      return itemID;
    }
    public int getuserID() {
      return userID;
    }
    
    public String gettext() {
      return text;
    }

    public int getgenreID() {
      return genreID;
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

    public ItemEntity() {
    }

    public ItemEntity(
     int itemID,
     int userID,
     String text,
     int genreID,
     int priority,
     Date datetime,
     boolean status,
     String eventid){
      this.itemID = itemID;
      this.userID = userID;
      this.text = text;
      this.genreID = genreID;
      this.priority = priority;
      this.datetime = datetime;
      this.status = status;
      this.eventid = eventid;
    }

}

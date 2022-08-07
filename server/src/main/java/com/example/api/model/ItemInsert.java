package com.example.api.model;

import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ItemInsert {
    @Id
    private int id;
    // @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int userid;
    private String text;
    private int genreid;
    private int priority;
    private String datetime;
    private Boolean status;
    private String eventid;

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

    public int getpriority() {
        return priority;
      }

    public String getdatetime() {
    return datetime;
    }

    public boolean status() {
        return status;
    }

    public String eventid(){
        return eventid;
    }

    

}

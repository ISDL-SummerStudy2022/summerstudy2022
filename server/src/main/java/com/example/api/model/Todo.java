package com.example.api.model;

// import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="test")

public class Todo {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String col1;
    private String col2;
    private String col3;

    public String getCol1() {
      return col1;
    }
    public void setCol1(String col1) {
      this.col1 = col1;
    }

    public String getCol2() {
      return col2;
    }
    public void setCol2(String col2) {
      this.col2 = col2;
    }

    public String getCol3() {
      return col3;
    }
    public void setCol3(String col3) {
      this.col3 = col3;
    }
  }
package com.example.api.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.api.model.Todo;
import com.example.api.repository.TodoRepository;

@Service
@Transactional
public class TodoService{
  @Autowired
  TodoRepository todoRepository;
  /**
   * レコードを全件取得する。
   * @return
   */
  public List<Todo> findAllTodoData(){
    return todoRepository.findAll();
  }
  
  /**
   * 指定した都市のレコードを取得する。
   * @param name
   * @return
   */
  public List<Todo> findTodoDataListByCol1(String Col1){
        
    return todoRepository.findByCol1(Col1);
  }
}
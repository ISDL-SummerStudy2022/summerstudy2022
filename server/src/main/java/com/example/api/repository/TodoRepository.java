package com.example.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.api.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
  List<Todo> findByCol1(String Col1);
}
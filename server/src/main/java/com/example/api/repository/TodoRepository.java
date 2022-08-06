package com.example.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.api.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {}
package com.example.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.api.model.Weather;
@Repository
public interface WeatherRepository extends JpaRepository<Weather, Integer> {}
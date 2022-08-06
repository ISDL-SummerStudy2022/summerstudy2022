package com.example.api.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.api.model.Weather;
import com.example.api.repository.WeatherRepository;

@Service
@Transactional
public class WeatherService{
  
  @Autowired
  WeatherRepository weatherRepository;
  
  /**
   * レコードを全件取得する。
   * @return
   */
  public List<Weather> findAllWeatherData(){
    return weatherRepository.findAll();
  }
}
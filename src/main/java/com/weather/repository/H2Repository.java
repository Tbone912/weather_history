package com.weather.repository;


 
import org.springframework.data.repository.CrudRepository;

import com.weather.model.DailyModel;

public interface H2Repository extends CrudRepository<DailyModel, Integer> {}
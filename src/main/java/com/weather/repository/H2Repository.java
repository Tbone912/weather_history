package com.weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weather.entity.DailyEntity;

@Repository
public interface H2Repository extends JpaRepository<DailyEntity, String> {

}

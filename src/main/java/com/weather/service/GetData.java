//This will get send a get Request for historical weather data
//https://open-meteo.com/en/docs/historical-weather-api
package com.weather.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.weather.entity.DailyEntity;
import com.weather.model.WeatherModel;
import com.weather.repository.H2Repository;


@Service
public class GetData {

	@Autowired
	private H2Repository h2Repository;

	public WeatherModel getData() throws IOException {

		RestTemplate restTemplate = new RestTemplate();

		String oikolab = "https://archive-api.open-meteo.com/v1/archive?latitude=33.75&longitude=-84.39&start_date=2022-01-01&end_date=2023-07-01&daily=rain_sum&timezone=auto&precipitation_unit=inch";

		WeatherModel response = restTemplate.getForObject(oikolab, WeatherModel.class);

		return response;
	}
	
	public List<DailyEntity> cacheListData(WeatherModel weatherModel) {

		
		List<DailyEntity> allData = new ArrayList<>();
		
		List<String> time = weatherModel.daily.time;
		List<Double> rain_sum = weatherModel.daily.rain_sum;

		for (int i = 0; i < time.size() && i < rain_sum.size(); i++) {
			String dailyTime = time.get(i);
			Double dailyRain_Sum = rain_sum.get(i);

			DailyEntity dailyObj = new DailyEntity(dailyTime, dailyRain_Sum);
			h2Repository.save(dailyObj);

			allData.add(dailyObj);
		}
		return allData;

	}

	@Cacheable(value="dailyDataCache")
	public DailyEntity singleData(List<DailyEntity> dataList) {
		DailyEntity dailyData = null;
		
		
		for (int i=0; i< dataList.size();i++) {
			return dataList.get(i);
		}

		return dailyData;

	}

}

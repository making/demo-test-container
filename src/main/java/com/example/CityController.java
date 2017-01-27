package com.example;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {
	private final CityRepository cityRepository;

	public CityController(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	@RequestMapping(value = "/cities", method = RequestMethod.GET)
	List<City> getCities() {
		return cityRepository.findAll();
	}

	@RequestMapping(value = "/cities", method = RequestMethod.POST)
	City postCities(@RequestBody City city) {
		return cityRepository.save(city);
	}
}
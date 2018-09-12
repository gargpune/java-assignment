package com.leonardo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leonardo.model.City;
import com.leonardo.service.CityServiceImpl;

/**
 * This is an API class, provide access to City Resource.
 * 
 * @author puneet
 *
 */
@RestController
@RequestMapping("/city")
public class CityResource {

	/** Service to perform operations on Resource. */
	@Autowired
	private CityServiceImpl service;

	/**
	 * Get all cities.
	 * 
	 * @return
	 */
	@GetMapping
	public List<City> getAllCities() {
		return service.getAllCities();
	}

	/**
	 * Get city details by ID.
	 * 
	 * @param cityId
	 * @return
	 */
	@GetMapping("/{id}")
	public City getCity(@PathVariable("id") Integer cityId) {
		return service.getCity(cityId);
	}

	/**
	 * Create new city.
	 * 
	 * @return
	 */
	@PostMapping
	public City createCity(@RequestBody City city) {
		return service.createCity(city);
	}

	/**
	 * Update existing city.
	 * 
	 * @param cityId
	 * @return
	 */
	@PutMapping
	public City updateCity(@RequestBody City city) {
		return service.updateCity(city);
	}

	/**
	 * Delete city by ID.
	 * 
	 * @param cityId
	 * @return
	 */
	@DeleteMapping("{id}")
	public City deleteCity(@PathVariable("id") Integer cityId) {
		return service.deleteCity(cityId);
	}

	/**
	 * Calculate distance between two cities by ID.
	 * 
	 * @param from
	 * @param to
	 */
	@GetMapping("/{from}/distance")
	public String calculateDistance(@PathVariable("from") final Integer from, @RequestParam final Integer to) {
		return service.calculateDistance(from, to);
	}
}

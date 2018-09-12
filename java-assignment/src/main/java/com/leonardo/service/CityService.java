package com.leonardo.service;

import java.util.List;

import com.leonardo.model.City;

/**
 * Service interface to perform operations on City resource.
 * 
 * @author puneet
 *
 */
public interface CityService {

	/**
	 * @return - list of all cities.
	 */
	List<City> getAllCities();

	/**
	 * @param cityId - unique identifier for city.
	 * @return - City if found otherwise null.
	 */
	City getCity(final Integer cityId);

	/**
	 * Create a new city and return new persisted value.
	 * 
	 * @param city - details of new city
	 * @return - return the city with ID if created successfully.
	 */
	City createCity(final City city);

	/**
	 * Delete city by cityId and return deleted value.
	 * 
	 * @param cityId - unique identifier if city
	 * @return - previous state of city with requested cityID
	 */
	City deleteCity(final Integer cityId);

	/**
	 * Update existing value of city with new value and returns new persisted value.
	 * 
	 * @param city - new value to be updated.
	 * @return - persisted value after update.
	 */
	City updateCity(final City city);

	/**
	 * @param from - cityID for source
	 * @param to   - cityID for destination
	 * @return - message stating the distance between two cities.
	 */
	String calculateDistance(final Integer from, final Integer to);
}

package com.leonardo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.leonardo.data.CityDAO;
import com.leonardo.model.City;

/**
 * Test class for CityServiceImpl.java to unit test service layer.
 * 
 * @author puneet
 *
 */
public class CityServiceImplTest {

	private CityServiceImpl cityService;

	/** Setup method to create required object. */
	@Before
	public void setup() {
		cityService = new CityServiceImpl(new CityDAO());
	}

	/** Test method to verify read operation by ID. */
	@Test
	public void testGetCityById() {
		assertEquals(createCity(1, "Tokyo", 35.685, 139.751389), this.cityService.getCity(1));
	}

	/** Test method to verify update operation. */
	@Test
	public void testUpdateCity() {
		assertEquals(createCity(2, "London", 51, -0.093689),
				this.cityService.updateCity(createCity(2, "London", 51, -0.093689)));
	}

	/** Test method to verify delete operation. */
	@Test
	public void testDeleteCity() {
		City deletedCity = this.cityService.getCity(3);
		assertEquals(deletedCity, this.cityService.deleteCity(3));
		assertEquals(null, this.cityService.getCity(3));
	}

	/** Test method to verify create operation. */
	@Test
	public void testCreateCity() {
		assertNotNull(this.cityService.createCity(createCity(1, "Toronto", 35.685, 139)));
	}

	@Test
	public void testCaluclateDistance() {
		assertEquals("Distance between Tokyo and London is 5,969.924 miles.", this.cityService.calculateDistance(1, 2));
	}

	@Test
	public void testCaluclateDistanceNonExistingCity() {
		assertEquals("Distance between 1 and 200 can not be calculated.", this.cityService.calculateDistance(1, 200));
	}

	/**
	 * Utility method to create City object.
	 * 
	 * @param id        - unique id for city
	 * @param name      - city name
	 * @param latitude  - latitude position
	 * @param longitude - longitude position
	 * @return - City object created from input values.
	 */
	private City createCity(Integer id, String name, double latitude, double longitude) {
		City city = new City();
		city.setId(id);
		city.setName(name);
		city.setLatitude(latitude);
		city.setLongitude(longitude);
		return city;
	}

}

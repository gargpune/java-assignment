package com.leonardo.service;

import java.text.MessageFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardo.data.CityDAO;
import com.leonardo.model.City;

/**
 * Implementation of service interface.
 * 
 * @author puneet
 *
 */
@Service
public class CityServiceImpl implements CityService {

	private CityDAO cityDAO;

	/**
	 * Constructor.
	 * 
	 * @param cityDAO
	 */
	@Autowired
	public CityServiceImpl(CityDAO cityDAO) {
		super();
		this.cityDAO = cityDAO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leonardo.service.CityService#getAllCities()
	 */
	@Override
	public List<City> getAllCities() {
		return this.cityDAO.listAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leonardo.service.CityService#getCity(java.lang.Integer)
	 */
	@Override
	public City getCity(Integer cityId) {
		return this.cityDAO.findById(cityId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leonardo.service.CityService#createCity(com.leonardo.model.City)
	 */
	@Override
	public City createCity(final City city) {
		Integer cityID = this.cityDAO.create(city);
		return this.cityDAO.findById(cityID);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leonardo.service.CityService#deleteCity(java.lang.Integer)
	 */
	@Override
	public City deleteCity(Integer cityId) {
		City city = this.cityDAO.findById(cityId);
		this.cityDAO.deleteById(cityId);
		return city;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leonardo.service.CityService#updateCity(com.leonardo.model.City)
	 */
	@Override
	public City updateCity(final City city) {
		this.cityDAO.update(city);
		return cityDAO.findById(city.getId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.leonardo.service.CityService#calculateDistance(java.lang.Integer,
	 * java.lang.Integer)
	 */
	@Override
	public String calculateDistance(Integer from, Integer to) {
		City fromCity = this.cityDAO.findById(from);
		City toCity = this.cityDAO.findById(to);
		String message = null;
		if (fromCity == null || toCity == null) {
			message = MessageFormat.format("Distance between {0} and {1} can not be calculated.", from, to);
		} else {
			double theta = fromCity.getLongitude() - toCity.getLongitude();
			double dist = Math.sin(deg2rad(fromCity.getLatitude())) * Math.sin(deg2rad(toCity.getLatitude()))
					+ Math.cos(deg2rad(fromCity.getLatitude())) * Math.cos(deg2rad(toCity.getLatitude()))
							* Math.cos(deg2rad(theta));
			dist = Math.acos(dist);
			dist = rad2deg(dist);
			dist = dist * 60 * 1.1515;
			message = MessageFormat.format("Distance between {0} and {1} is {2} miles.", fromCity.getName(),
					toCity.getName(), dist);
		}
		return message;
	}

	/**
	 * Convert degree to rad.
	 * 
	 * @param deg
	 * @return
	 */
	private double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	/**
	 * Convert radian to degree.
	 * 
	 * @param rad
	 * @return
	 */
	private double rad2deg(double rad) {
		return (rad * 180.0 / Math.PI);
	}
}

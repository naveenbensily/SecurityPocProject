package demo.service;

import demo.repository.City;

/**
 * Created by Naveen Bensily on 6/20/15.
 */
public interface ICityService {

    City getCity(String name, String country);


}

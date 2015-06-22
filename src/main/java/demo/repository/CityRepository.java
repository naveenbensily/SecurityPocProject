package demo.repository;

import org.springframework.data.repository.Repository;

/**
 * Created by Naveen Bensily on 6/20/15.
 */
public interface CityRepository extends Repository<City, Long> {

    City findByNameAndCountryAllIgnoringCase(String name, String country);

}

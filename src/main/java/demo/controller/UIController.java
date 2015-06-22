package demo.controller;

import demo.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Naveen Bensily on 6/20/15.
 */
@Component
public class UIController {

    private final ICityService cityService;

    @Autowired
    public UIController(ICityService cityService) {
        this.cityService = cityService;
    }

}

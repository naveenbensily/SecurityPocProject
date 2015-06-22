package demo.service;

import demo.repository.User;

/**
 * Created by Naveen Bensily on 6/21/15.
 */
public interface IUserService {

    User findUser(String userName,String password);

}

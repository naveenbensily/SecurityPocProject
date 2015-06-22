package demo.service;

import demo.repository.User;
import demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Naveen Bensily on 6/21/15.
 */
@Component("userService")
@Transactional
public class UserServiceImpl implements IUserService {


    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository =userRepository;
    }

    @Override
    public User findUser(String userName, String password) {
        return userRepository.findByUserNameAndPasswordAllIgnoringCase(userName,password);
    }
}

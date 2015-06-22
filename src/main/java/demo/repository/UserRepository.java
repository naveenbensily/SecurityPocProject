package demo.repository;

import org.springframework.stereotype.Repository;


/**
 * Created by Naveen Bensily on 6/21/15.
 */
@Repository
public interface UserRepository extends org.springframework.data.repository.Repository<User, Long> {


        //Naming convention of methods
        User getUserById(int id);

        //Naming conventions exists in property Names
        User getUserByUserName(String userName);

        User findByUserNameAndPasswordAllIgnoringCase(String userName,String password);



}

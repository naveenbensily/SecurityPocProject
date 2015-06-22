package demo;

import demo.application.UIApplication;
import demo.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = UIApplication.class)
@WebAppConfiguration
public class RepositoryTests {



    @Autowired
    UserRepository userRepository;

	@Test
	public void userServiceTest() {
        assertNotNull(userRepository.getUserById(1));
        assertNotNull(userRepository.getUserByUserName("wphillips0"));
        assertEquals("wphillips0",userRepository.getUserByUserName("wphillips0").getUserName());

        assertNotNull(userRepository.findByUserNameAndPasswordAllIgnoringCase("wphillips0","AdT64hNE"));

       //assertNotNull(userRepository.getUserByUserName("wphillips0", "AdT64hNE"));
	}


}

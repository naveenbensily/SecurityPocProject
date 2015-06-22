package demo.application;

import demo.repository.User;
import demo.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.*;


@Component
@ComponentScan(basePackages="demo")
public class DatabaseAuthenticationProvider implements AuthenticationProvider,
		Serializable {



    @Autowired
    private IUserService userService;


    private static transient HashMap<String, String> acceptedPasswords = new HashMap<String, String>();

    private static final long serialVersionUID = 1258700800324492313L;
    private static final String ROLE_USER = "ROLE_USER";
    private static transient Logger logger = LoggerFactory
            .getLogger(AuthenticationProvider.class);


    static {
        setupAcceptedPasswords();
    }

    private static synchronized void setupAcceptedPasswords() {
        ResourceBundle bundle = ResourceBundle.getBundle("springangular");
        boolean err = false;
        for (int i = 0; i<2; i++) {
            try {
                acceptedPasswords.put(bundle.getString("auth.user." + i),
                        bundle.getString("auth.password." + i));
            } catch (Exception x) {
                logger.debug("setupAcceptedPassords", x);
                err = true;
            }
        }
    }

    public Authentication authenticate(final Authentication authentication)
            throws AuthenticationException {
        Authentication auth;

        try {

            auth = dataBaseAuthenticate(authentication);
           } catch (Exception e) {
            if (e instanceof AuthenticationException) {
                throw (AuthenticationException) e;
            } else {
                throw new BadCredentialsException(e.getMessage(), e);
            }
        }
        return auth;
    }


    private UsernamePasswordAuthenticationToken dataBaseAuthenticate(
            final Authentication authentication) {

        final String userName = authentication.getName();
        String password = authentication.getCredentials().toString();

        User user= userService.findUser(userName,password);
        if(user == null || (!user.getPassword().equals(password))){
            throw new BadCredentialsException("Bad Password");
        }


        final List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        grantedAuthorities.add(new SimpleGrantedAuthority(ROLE_USER));
        UserDetails userInfo = new UserDetails() {


            public Collection<? extends GrantedAuthority> getAuthorities() {
                return grantedAuthorities;
            }

            public String getPassword() {
                return "xxxxxx";
            }

            public String getUsername() {
                return userName;
            }

            public boolean isAccountNonExpired() {
                return true;
            }

            public boolean isAccountNonLocked() {
                return true;
            }

            public boolean isCredentialsNonExpired() {
                return true;
            }

            public boolean isEnabled() {
                return true;
            }
        };
        return new UsernamePasswordAuthenticationToken(userInfo, password,
                grantedAuthorities);
    }


    public boolean supports(Class<?> arg0) {
        return true;
    }

}

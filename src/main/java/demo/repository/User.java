package demo.repository;

import javax.persistence.*;

/**
 * Created by Naveen Bensily on 6/21/15.
 */

@Entity
@Table(name = "USERS")
public class User {

   public User(){

    }


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name="USERNAME")
    private String userName;

    @Column(name="PASSWORD")
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

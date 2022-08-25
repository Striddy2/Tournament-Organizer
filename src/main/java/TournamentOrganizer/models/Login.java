package TournamentOrganizer.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Login extends AbstractEntity {


    @NotBlank
    @Size(min = 3, max = 15, message = "username must be between 3 and 15 characters")
    private String userLogin;

    @NotBlank
    @Size(min = 3, max = 15, message = "username must be between 3 and 15 characters")
    private String userPassword;


    //constructor
        public Login(String userLogin, String userPassword) {
        this.userLogin = userLogin;
        this.userPassword = userPassword;

    }

    //no arg constructor
    public Login(){

    }

    //getters and setters
    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

}

//do I need a 2 string, and override methods??

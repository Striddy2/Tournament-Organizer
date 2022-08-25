package TournamentOrganizer.models;

import TournamentOrganizer.models.AbstractEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
public class Registration extends AbstractEntity {

    @NotBlank
    @Size(min = 3, max = 15, message = "username must be between 3 and 15 characters")
    private String username;


    @Email(message = "Please enter a valid email address")
    @NotBlank
    private String emailAddress;


    @Size(min = 4, max = 15, message = "password must be between 3 and 15 characters")
    @NotBlank
    private String password;


    @NotBlank
    private String verifyPassword;


    //constructor
    public Registration(String username, String emailAddress, String password, String verifyPassword) {

        this.username = username;
        this.emailAddress = emailAddress;
        this.password = password;
        this.verifyPassword = verifyPassword;
    }

    //no arg constructor
    public Registration() {
    }

         //getters and setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword() {
        this.password = password;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }


}
//do I need a 2 string, and override methods??

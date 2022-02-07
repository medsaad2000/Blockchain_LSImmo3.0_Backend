package ma.fstt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import ma.fstt.entities.AppUser;
import ma.fstt.services.AccountService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
//@RequestMapping("/auth")
public class UserController {

    @Autowired
    private AccountService accountService;

    // ------------- Add User ---------------------------------------
    @PostMapping("register")
    public AppUser register(@RequestBody UserForm userForm) {
        return accountService.saveUser(userForm.getUsername(), userForm.getEmail(), userForm.getAdress(),
                userForm.getPassword(), userForm.getConfirmedPassword());
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public AppUser getUser(@PathVariable String id) {
        return accountService.loadUserByUsername(id);
    }
}
@CrossOrigin
class UserForm {
    private String username;
    private String email;
    private String adress;
    //	private String typeUser;
//	private String function;
    private String password;
    private String confirmedPassword;

    public UserForm() {
        super();
    }

    public UserForm(String username, String email, String adress, String password, String confirmedPassword) {
        super();
        this.username = username;
        this.email = email;
        this.adress = adress;
//		this.typeUser = typeUser;
//		this.function = function;
        this.password = password;
        this.confirmedPassword = confirmedPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmedPassword() {
        return confirmedPassword;
    }

    public void setConfirmedPassword(String confirmedPassword) {
        this.confirmedPassword = confirmedPassword;
    }
//	public String getTypeUser() {
//		return typeUser;
//	}
//	public void setTypeUser(String typeUser) {
//		this.typeUser = typeUser;
//	}
//	public String getFunction() {
//		return function;
//	}
//	public void setFunction(String function) {
//		this.function = function;
//	}

}

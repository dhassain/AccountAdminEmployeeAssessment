package com.example.ecommerce.signup.controller;

import com.example.ecommerce.signup.exception.EmailException;
import com.example.ecommerce.signup.exception.IdException;
import com.example.ecommerce.signup.exception.UserException;
import com.example.ecommerce.signup.model.SignUpModel;
import com.example.ecommerce.signup.service.SignUpService;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4000") //Cross Origin lets API work for specific domains.
public class SignUpController {
    @Autowired
    private SignUpService signUpService;

    @RequestMapping("/signup/details")
    public List<SignUpModel> findAll() throws UserException {
        List<SignUpModel> signUpModel = signUpService.findAll();
        if(signUpModel==null){
            throw new UserException("No content.");
        }
        return signUpService.findAll();
    } //Get the details of all users

    @RequestMapping(value = "/signup/save", method = RequestMethod.POST)
    public int save(@RequestBody SignUpModel payload) throws IdException {
        int id = payload.getId();
        if(id == 0){
            throw new IdException("ID is not defined.");
        }
        return signUpService.saveUser(payload);
    } //Save the user

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<SignUpModel> signUpModels(){
        return signUpService.findAll();
    }

//    @GetMapping("/signup/{id}")
//    public SignUpModel findById(@PathVariable("id") int id) throws UserException {
//        SignUpModel signUpModel = signUpService.getUserById(id);
//        if(signUpModel == null)
//            throw new UserException("User doesn't exist.");
//        return signUpModel; //Find the user ID
//    }
//
//    @RequestMapping(value = "/signup/update/{id}", method = RequestMethod.PUT)
//    public SignUpModel updateById(@PathVariable("id") int id, @RequestBody SignUpModel userDetails) throws UserException, EmailException {
//        Optional<SignUpModel> signUpModel = signUpService.getUserById(id);
//        if(signUpModel.isEmpty()) {
//            throw new UserException("Cannot update because user doesn't exist.");
//        }
//        String user = userDetails.getEmailId();
//        if(user.contains("@")) throw new EmailException("Invalid email");
//        return signUpService.updateUser(id,userDetails); //update the user
//    }

}

package com.example.ecommerce.signup.service;

import com.example.ecommerce.signup.model.SignUpModel;
import com.example.ecommerce.signup.repository.SignUpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SignUpService {
    @Autowired
    private SignUpRepository signUpRepository;

//    public SignUpModel getUserById(Integer id){
//        Optional<SignUpModel> checkUser = signUpRepository.findById(id);
//        if(checkUser.isPresent())
//            return checkUser.get();
//        else
//            return null;
//    }

//    public boolean existUser(Integer id){
////        Optional<SignUpModel> checkUser = signUpRepository.findById(id);
////        if(checkUser.isPresent()) return checkUser.get();
////        else return null;
//        return signUpRepository.existsById(id);
//    }

    public int saveUser(SignUpModel user){
        return signUpRepository.saveOrUpdateDetails(user);
    }

    public List<SignUpModel> findAll() {
        return signUpRepository.getAllUsers();
    }

//    public SignUpModel updateUser(Integer id, SignUpModel userDetails){
//        if(!signUpRepository.existsById(id)) {
//            return null;
//        }
//        Optional<SignUpModel> user = signUpRepository.findById(id); //Search for the required user and gets whole row.
//        //Optional is used for rectifying null pointer error
//        SignUpModel newUser = user.get(); //Gets the required user ID from the "database"
//        newUser.setFirstName(userDetails.getFirstName()); //change the first name
//        newUser.setLastName(userDetails.getLastName()); //change the last name
//        return signUpRepository.save(newUser); //save the user
//    }

}

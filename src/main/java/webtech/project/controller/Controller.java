package webtech.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import webtech.project.entity.Account;
import webtech.project.entity.Exercise;
import webtech.project.service.TrainingWithMachineService;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    TrainingWithMachineService service;


    Logger logger = LoggerFactory.getLogger(Controller.class);

    @GetMapping("/allsessions")
    public List<Exercise> gettAll(@RequestHeader String token){
        return service.getAll(token);
    }

    @PutMapping("/addExercise")
    public Account addExerciseToAccount(@RequestHeader String token, @RequestBody Exercise exercise) {
      return service.addExercisetoAccount(exercise, token);
    }

    @PostMapping("/account")
    public Account createAccount(@RequestBody Account account) {return service.createAccount(account);}

    @GetMapping("/training")
    public List<Exercise> getAllMachineTraining(@RequestHeader String token) {
        return service.getAll(token);
    }

    @PostMapping("/training")
    public Exercise createMachineTraining(@RequestBody Exercise training) {
        return service.save(training);
    }
    @PutMapping("/training/{id}")
    public Exercise updateExersice(@PathVariable Long id, @RequestBody Exercise training){
        return service.updateExercise(id, training);
    }
    @PutMapping("/remove/{id}")
    public Exercise removeExercise(@PathVariable Long id, @RequestBody Exercise training){
        return service.removeExercise(id, training);
    }
    @DeleteMapping("/training/{id}")
    public void deleteMachineTraining(@PathVariable Long id){
        service.deleteById(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll(@RequestHeader String auth){
        service.deleteAll(auth);
    }

    @GetMapping("/login")
    public String getToken(@RequestHeader String username, @RequestHeader String password){
        return service.getToken(username, password);
    }

    @PutMapping("/removetoken/{token}")
    public void removeToken(@PathVariable String token){
        service.removeToken(token);
    }


}

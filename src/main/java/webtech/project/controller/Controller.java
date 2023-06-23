package webtech.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import webtech.project.entity.Account;
import webtech.project.entity.Exercise;
import webtech.project.repository.AccountRepo;
import webtech.project.service.TrainingWithMachineService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    TrainingWithMachineService serviceMT;


    Logger logger = LoggerFactory.getLogger(Controller.class);

    @GetMapping("/allsessions")
    public List<Exercise> gettAll(@RequestHeader String token){
        return serviceMT.getAll(token);
    }

    @PutMapping("/addExercise")
    public Account addExerciseToAccount(@RequestHeader String token, @RequestBody Exercise exercise) {
      return serviceMT.addExercisetoAccount(exercise, token);
    }

    @PostMapping("/account")
    public Account createAccount(@RequestBody Account account) {return serviceMT.createAccount(account);}

    @GetMapping("/machinetraining")
    public List<Exercise> getAllMachineTraining(@RequestHeader String token) {
        return serviceMT.getAll(token);
    }

    @PostMapping("/machinetraining")
    public Exercise createMachineTraining(@RequestBody Exercise training) {
        return serviceMT.save(training);
    }
    @PutMapping("/machinetraining/{id}")
    public Exercise updateExersice(@PathVariable Long id, @RequestBody Exercise training){
        return serviceMT.updateExercise(id, training);
    }
    @PutMapping("/remove/{id}")
    public Exercise removeExercise(@PathVariable Long id, @RequestBody Exercise training){
        return serviceMT.removeExercise(id, training);
    }
    @DeleteMapping("/machinetraining/{id}")
    public void deleteMachineTraining(@PathVariable Long id){
        serviceMT.deleteById(id);
    }

    //TODO: Authoriazation needed
    @DeleteMapping("/deleteAll")
    public void deleteAll(){
        serviceMT.deleteAll();
    }

    @GetMapping("/login")
    public String getToken(@RequestHeader String username, @RequestHeader String password){
        return serviceMT.getToken(username, password);
    }


}

package webtech.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import webtech.project.entity.Exercise;
import webtech.project.service.TrainingWithMachineService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    TrainingWithMachineService serviceMT;

    Logger logger = LoggerFactory.getLogger(Controller.class);

    @GetMapping("/allsessions")
    public List<Object> gettAll(){
        List<Exercise> MTSessions = serviceMT.getAll();
        List<Object> merge = new ArrayList<>();

        merge.addAll(MTSessions);
        return merge;
    }

    @GetMapping("/machinetraining")
    public List<Exercise> getAllMachineTraining() {
        return serviceMT.getAll();
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
}

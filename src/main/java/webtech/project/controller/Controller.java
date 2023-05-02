package webtech.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import webtech.project.entity.TrainingSessionMachine;
import webtech.project.entity.TrainingSessionWithoutMachine;
import webtech.project.service.TrainingWithMachineService;
import webtech.project.service.TrainingWithoutMachineService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class Controller {

    @Autowired
    TrainingWithMachineService serviceMT;
    @Autowired
    TrainingWithoutMachineService serviceT;

    Logger logger = LoggerFactory.getLogger(Controller.class);

    @GetMapping("/allsessions")
    public List<Object> gettAll(){
        List<TrainingSessionMachine> MTSessions = serviceMT.getAll();
        List<TrainingSessionWithoutMachine> TSessions = serviceT.getAll();
        List<Object> merge = new ArrayList<>();

        merge.addAll(MTSessions);
        merge.addAll(TSessions);

        return merge;
    }

    @GetMapping("/machinetraining")
    public List<TrainingSessionMachine> getAllMachineTraining() {
        return serviceMT.getAll();
    }

    @PostMapping("/machinetraining")
    public TrainingSessionMachine createMachineTraining(@RequestBody TrainingSessionMachine training) {

        return serviceMT.save(training);
    }

    @GetMapping("/bodytraining")
    public List<TrainingSessionWithoutMachine> getAllBodyTraining(){
        return serviceT.getAll();
    }

    @PostMapping("/bodytraining")
    public TrainingSessionWithoutMachine createBodyTraining(@RequestBody TrainingSessionWithoutMachine training) {
        return serviceT.save(training);
    }

}

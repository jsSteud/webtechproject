package webtech.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webtech.project.entity.TrainingSessionMachine;
import webtech.project.entity.TrainingSessionWithoutMachine;
import webtech.project.repository.TrainingWithoutMachineRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainingWithoutMachineService {

    @Autowired
    TrainingWithoutMachineRepository repo;

    public TrainingSessionWithoutMachine save(TrainingSessionWithoutMachine trainig){

        return repo.save(trainig);
    }

    public TrainingSessionWithoutMachine get (Long id){
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public List<TrainingSessionWithoutMachine> getAll() {
        Iterable<TrainingSessionWithoutMachine> iterator = repo.findAll();
        List<TrainingSessionWithoutMachine> things = new ArrayList<TrainingSessionWithoutMachine>();
        for (TrainingSessionWithoutMachine thing : iterator)  things.add(thing);
        return things;
    }
}

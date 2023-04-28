package webtech.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webtech.project.entity.TrainingSessionMachine;
import webtech.project.repository.TrainingWithMachineRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainingWithMachineService {

    @Autowired
    TrainingWithMachineRepository repo;

    public TrainingSessionMachine save(TrainingSessionMachine trainig){

        return repo.save(trainig);
    }

    public TrainingSessionMachine get (Long id){
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public List<TrainingSessionMachine> getAll() {
        Iterable<TrainingSessionMachine> iterator = repo.findAll();
        List<TrainingSessionMachine> things = new ArrayList<TrainingSessionMachine>();
        for (TrainingSessionMachine thing : iterator)  things.add(thing);
        return things;
    }

}

package webtech.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webtech.project.entity.Exercise;
import webtech.project.repository.TrainingWithMachineRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainingWithMachineService {

    @Autowired
    TrainingWithMachineRepository repo;

    public Exercise save(Exercise trainig){
        return repo.save(trainig);
    }

    public Exercise get (Long id){
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public List<Exercise> getAll() {
        Iterable<Exercise> iterator = repo.findAll();
        List<Exercise> things = new ArrayList<Exercise>();
        for (Exercise thing : iterator)  things.add(thing);
        return things;
    }

    public void deleteById(Long id){
        repo.deleteById(id);
    }


    public Exercise updateExercise(Long id, Exercise training) {
        Exercise existing =  repo.findById(id).get();

//        existing.setComment(training.getComment());
//        existing.setMachineType(training.getMachineType());
//        existing.setName(training.getName());
        existing.setPlaned(training.getPlaned());
//        existing.setReps(training.getReps());
//        existing.setSets(training.getSets());
//        existing.setWeight(training.getWeight());
//
//        existing.setMo(training.isMo());
//        existing.setDi(training.isDi());
//        existing.setMi(training.isMi());
//        existing.setDon(training.isDon());
//        existing.setFr(training.isFr());
//        existing.setSa(training.isSa());
        existing.setSo(training.isSo());
        return repo.save(existing);
    }
}

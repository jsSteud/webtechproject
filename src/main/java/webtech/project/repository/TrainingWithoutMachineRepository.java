package webtech.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import webtech.project.entity.TrainingSessionWithoutMachine;

@Repository
public interface TrainingWithoutMachineRepository extends CrudRepository<TrainingSessionWithoutMachine, Long> { }

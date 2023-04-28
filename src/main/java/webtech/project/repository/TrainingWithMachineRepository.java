package webtech.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import webtech.project.entity.TrainingSessionMachine;

@Repository
public interface TrainingWithMachineRepository extends CrudRepository<TrainingSessionMachine, Long> {}

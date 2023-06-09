package webtech.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import webtech.project.entity.Exercise;

@Repository
public interface TrainingRepo extends CrudRepository<Exercise, Long> {}

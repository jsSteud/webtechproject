package webtech.project;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import webtech.project.entity.Exercise;
import webtech.project.repository.TrainingRepo;
import webtech.project.service.TrainingWithMachineService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


import static org.mockito.Mockito.doReturn;

@SpringBootTest
class ServiceTests {

	@Autowired
	private TrainingWithMachineService service;

	@MockBean
	private TrainingRepo repository;

	@Test
	@DisplayName("should return all exercises")
	void getAllTest() {

		Exercise exercise_1 = new Exercise(3,12,80,"Trizepsmaschine", null, false,false,false,false,false,false,true,true, true);
		Exercise exercise_2 = new Exercise(3,12,80,"Latzug", null, false,false,false,false,false,false,true,true, true);

		exercise_1.setId(1L);
		exercise_2.setId(2L);

		doReturn(List.of(exercise_1, exercise_2)).when(repository).findAll();

		List<Exercise> list = service.getAll("");

		assertEquals(List.of(exercise_1,exercise_2), list);


	}


	@Test
	@DisplayName("should update exercise")
	void updateExercise() {

		Exercise exercise_1 = new Exercise(3,12,80,"Trizepsmaschine", null, false,false,false,false,false,false,true,true, true);
		//sets update to 20
		Exercise newExercise = new Exercise(3,20,80,"Trizepsmaschine", null, false,false,false,false,false,false,true,true, true);
		exercise_1.setId(1L);
		newExercise.setId(2L);

		doReturn(Optional.of(exercise_1)).when(repository).findById(1L);
		doReturn(newExercise).when(repository).save(exercise_1);

		var updatedExercise = service.updateExercise(exercise_1.getId(), newExercise);

		assertEquals(newExercise, updatedExercise);


	}



}

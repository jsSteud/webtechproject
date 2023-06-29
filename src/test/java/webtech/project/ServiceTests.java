package webtech.project;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import webtech.project.entity.Account;
import webtech.project.entity.Exercise;
import webtech.project.repository.AccountRepo;
import webtech.project.repository.TrainingRepo;
import webtech.project.service.TrainingWithMachineService;

import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

@SpringBootTest
class ServiceTests {

	@Autowired
	private TrainingWithMachineService service;

	@MockBean
	private TrainingRepo exerciseRepo;

	@MockBean
	private AccountRepo accountRepo;

	/**
	 * Just exercise_4 is not in account_2
	 */
	Exercise exercise_1 = new Exercise(3,12,80,"Trizepsmaschine", null, false,false,false,false,false,false,true,true, true);
	Exercise exercise_2 = new Exercise(3,12,80,"Latzug", null, false,false,false,false,false,false,true,true, true);
	Exercise exercise_3 = new Exercise(3,12,80,"Bizepsmaschine", null, false,false,false,false,false,false,true,true, true);
	Exercise exercise_4 = new Exercise(3,12,80,"Rudern", null, false,false,false,false,false,false,true,true, true);


	Account account_1 = new Account(BCrypt.hashpw("username_1", BCrypt.gensalt(10)), BCrypt.hashpw("password_1", BCrypt.gensalt(10)),List.of(exercise_1, exercise_2, exercise_3), BCrypt.hashpw("token_1",BCrypt.gensalt(10)));
	Account account_2 = new Account(BCrypt.hashpw("username_2", BCrypt.gensalt(10)), BCrypt.hashpw("password_2", BCrypt.gensalt(10)),List.of(exercise_4), BCrypt.hashpw("token_2", BCrypt.gensalt(10)));

	Account newAccount = new Account("username", "password", null, null);



	@Test
	@DisplayName("should return all exercises of Account_1")
	void getAllTest() {

		exercise_1.setId(1L);
		exercise_2.setId(2L);
		exercise_3.setId(3L);
		exercise_4.setId(4L);

		account_1.setId(1L);
		account_2.setId(2L);

		doReturn(List.of(account_1, account_2)).when(accountRepo).findAll();
		doReturn(Optional.of(account_1)).when(accountRepo).findById(1L);


		List<Exercise> exerciseList = service.getAll("token_1");

		assertEquals(List.of(exercise_1,exercise_2, exercise_3), exerciseList);


	}


	@Test
	@DisplayName("should update exercise")
	void updateExerciseTest() {

		//sets update to 20
		Exercise newExercise = new Exercise(3,20,80,"Trizepsmaschine", null, false,false,false,false,false,false,true,true, true);
		exercise_1.setId(1L);
		newExercise.setId(2L);

		doReturn(Optional.of(exercise_1)).when(exerciseRepo).findById(1L);
		doReturn(newExercise).when(exerciseRepo).save(exercise_1);

		var updatedExercise = service.updateExercise(exercise_1.getId(), newExercise);

		assertEquals(newExercise, updatedExercise);


	}

	@Test
	@DisplayName("Should create an account, where username doesn't exist yet")
	void createAccountTest() {



		doReturn(List.of()).when(accountRepo).findAll();
		doReturn(newAccount).when(accountRepo).save(newAccount);

		Account toSafeAccound = service.createAccount(newAccount);

		// Verify that the account is saved with hashed username and password
		assertNotEquals("username", toSafeAccound.getUsername());
		assertNotEquals("password", toSafeAccound.getPassword());

		// Verify that the hashed username and password are correct
		assertTrue(BCrypt.checkpw("username", toSafeAccound.getUsername()));
		assertTrue(BCrypt.checkpw("password", toSafeAccound.getPassword()));
	}

	@Test
	@DisplayName("Should return null id account username allready exists")
	void createAccountTest_2(){

		//username "username_1" allready exists
		Account newAccountWhereUsernameAlreadyExists = new Account("username_1", "password", null, null);

		doReturn(List.of(account_1, account_2)).when(accountRepo).findAll();

		Account toSafedAccount = service.createAccount(newAccount);

		assertEquals(null, toSafedAccount);
	}


}

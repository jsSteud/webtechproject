package webtech.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webtech.project.entity.Account;
import webtech.project.entity.Exercise;
import webtech.project.repository.AccountRepo;
import webtech.project.repository.TrainingWithMachineRepository;

import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.mindrot.jbcrypt.BCrypt;


@Service
public class TrainingWithMachineService {

    @Autowired
    TrainingWithMachineRepository repo;

    @Autowired
    AccountRepo accountRepo;


    public Exercise save(Exercise trainig){
        return repo.save(trainig);
    }

    public Exercise get (Long id){
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public List<Exercise> getAll(String token) {
        Iterable<Account> accounts = accountRepo.findAll();
        final Long[] accountId = new Long[1];

        accounts.forEach(account -> {
            if (BCrypt.checkpw(token, account.getToken())) accountId[0] = account.getId();
        });

        Account finalAccount = accountRepo.findById(accountId[0]).orElseThrow();

        return finalAccount.getExerciseList();

    }

    /**
     *
     * @param id
     *
     * This method has to remove an exercise from account before being deleted in db, cause of constraint violations
     */
    public void deleteById(Long id){
        Exercise exercise = repo.findById(id).orElseThrow();
        //all accounts
        List<Account> accounts = (List<Account>) accountRepo.findAll();
        //The one account
        final Account[] foundedAccount = new Account[1];
        //the one exercise
        final Exercise[] foundedExercise = new Exercise[1];
        accounts.forEach(account -> {
            account.getExerciseList().forEach(exercise1 -> {
                if (exercise1.getId() == exercise.getId()) {
                    foundedAccount[0] = account;
                    foundedExercise[0] = exercise1;
                }
            });
        });
        //All Exercises for the on account OLD (untill with the, to delete, exercise)
        List<Exercise> foundedExercises = foundedAccount[0].getExerciseList();
        //remove exercise
        foundedExercises.remove(foundedExercise[0]);

        repo.deleteById(id);
    }


    public Exercise updateExercise(Long id, Exercise training) {
        System.out.println(training);
        Exercise existing =  repo.findById(id).get();

        existing.setComment(training.getComment());
        existing.setMachineType(training.getMachineType());
        existing.setName(training.getName());
        existing.setPlaned(training.getPlaned());
        existing.setReps(training.getReps());
        existing.setSets(training.getSets());
        existing.setWeight(training.getWeight());
        existing.setMo(training.isMo());
        existing.setDi(training.isDi());
        existing.setMi(training.isMi());
        existing.setDon(training.isDon());
        existing.setFr(training.isFr());
        existing.setSa(training.isSa());
        existing.setSo(training.isSo());

        return repo.save(existing);
    }

    public Exercise removeExercise(Long id, Exercise training) {
        Exercise existing =  repo.findById(id).get();

        if(!training.isMo()) existing.setMo(false);
        if(!training.isDi()) existing.setDi(false);
        if(!training.isMi()) existing.setMi(false);
        if(!training.isDon()) existing.setDon(false);
        if(!training.isFr()) existing.setFr(false);
        if(!training.isSa()) existing.setSa(false);
        if(!training.isSo()) existing.setSo(false);
        return repo.save(existing);
    }



    public void deleteAll(){
        repo.deleteAll();
    }

    public Account createAccount(Account account) {

        String hashedUsername = BCrypt.hashpw(account.getUsername(), BCrypt.gensalt());
        String hashedPassword = BCrypt.hashpw(account.getPassword(), BCrypt.gensalt());

        account.setUsername(hashedUsername);
        account.setPassword(hashedPassword);

        return accountRepo.save(account);
    }

    public Account addExercisetoAccount(Exercise exercise, String token) {

        Iterable<Account> accounts = accountRepo.findAll();
        final Account[] account = new Account[1];
        accounts.forEach(account1 -> {
            if (BCrypt.checkpw(token, account1.getToken())){
                account[0] = account1;
            }
        });
        List<Exercise> list = account[0].getExerciseList();
        list.add(exercise);
        account[0].setExerciseList(list);
        return accountRepo.save(account[0]);
    }

    public String getToken(String username, String password) {
        Iterable<Account> accounts = accountRepo.findAll();

        for (Account account : accounts) {
            if (BCrypt.checkpw(username, account.getUsername())) {
                if (BCrypt.checkpw(password, account.getPassword())) {
                    return createToken(account.getId());
                }
            }
        }
        return null;
    }

    public String createToken(Long id) {
        /**
         * String plain
         * String hash
         *
         * plain zurück an user
         * hash in db
         */

        String plainToken = generateRandomString();

        String tokenHash = BCrypt.hashpw(plainToken, BCrypt.gensalt(10));

        Account account = accountRepo.findById(id).orElseThrow();
        account.setToken(tokenHash);
        accountRepo.save(account);

        System.out.println(plainToken);

        return plainToken;
    }

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int LENGTH = 10;

    public static String generateRandomString() {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(LENGTH);

        for (int i = 0; i < LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }

}

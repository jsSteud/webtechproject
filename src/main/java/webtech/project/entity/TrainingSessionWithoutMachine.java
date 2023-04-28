package webtech.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TrainingSessionWithoutMachine implements Training{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int reps;
    private int sets;
    private String comment;

    public TrainingSessionWithoutMachine(int reps, int sets, String comment){
        this.reps = reps;
        this.sets = sets;
        this.comment = comment;
    }

    public TrainingSessionWithoutMachine() {}

    @Override
    public int getReps() {
        return reps;
    }

    @Override
    public void setReps(int newReps) {
        this.reps = newReps;
    }

    @Override
    public int getSets() {
        return sets;
    }

    @Override
    public void setSets(int newSets) {
        this.sets = newSets;
    }

    @Override
    public String getComment() {
        return comment;
    }

    @Override
    public void setComment(String newComment) {
        this.comment = newComment;
    }

}

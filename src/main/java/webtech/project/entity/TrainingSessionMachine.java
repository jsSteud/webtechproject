package webtech.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TrainingSessionMachine implements Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int reps;
    private int sets;
    private int weight;
    private String machineName;
    private String comment;

    public TrainingSessionMachine(int reps, int sets, String machineName, int weight, String comment){
    this.reps = reps;
    this.sets = sets;
    this.machineName = machineName;
    this.weight = weight;
    this.comment = comment;
    }

    public TrainingSessionMachine() {}

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

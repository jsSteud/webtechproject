package webtech.project.entity;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Exercise implements Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int reps;
    private int sets;
    private int weight;
    private String name;
    private String comment;
    private boolean mo;
    private boolean di;
    private boolean mi;
    private boolean don;
    private boolean fr;
    private boolean sa;
    private boolean so;
    private boolean planed;
    private boolean isMachineType;

    public void setMachineType(boolean machineType) {
        isMachineType = machineType;
    }

    public boolean getMachineType() {
        return isMachineType;
    }



    public Exercise(int reps, int sets, int weight, String machineName, String comment, boolean mo, boolean di, boolean mi, boolean don, boolean fr, boolean sa, boolean so, boolean planed) {
        this.reps = reps;
        this.sets = sets;
        this.weight = weight;
        this.name = machineName;
        this.comment = comment;
        this.mo = mo;
        this.di = di;
        this.mi = mi;
        this.don = don;
        this.fr = fr;
        this.sa = sa;
        this.so = so;
        this.planed = planed;
    }

    public Exercise() {}

    public void setMo(boolean mo) {
        this.mo = mo;
    }

    public void setDi(boolean di) {
        this.di = di;
    }

    public void setMi(boolean mi) {
        this.mi = mi;
    }

    public void setDon(boolean don) {
        this.don = don;
    }

    public void setFr(boolean fr) {
        this.fr = fr;
    }

    public void setSa(boolean sa) {
        this.sa = sa;
    }

    public void setSo(boolean so) {
        this.so = so;
    }

    public void setPlaned(boolean planed) {
        this.planed = planed;
    }

    public boolean isMo() {
        return mo;
    }

    public boolean isDi() {
        return di;
    }

    public boolean isMi() {
        return mi;
    }

    public boolean isDon() {
        return don;
    }

    public boolean isFr() {
        return fr;
    }

    public boolean isSa() {
        return sa;
    }

    public boolean isSo() {
        return so;
    }

    public boolean getPlaned() {
        return planed;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public boolean isPlaned() {
        return planed;
    }

    public boolean isMachineType() {
        return isMachineType;
    }

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

    @Override
    public boolean getType() {
        return false;
    }



    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int newWeight) {
        this.weight = newWeight;
    }


    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Exercise))
            return false;
        Exercise training = (Exercise) o;
        return Objects.equals(this.id, training.id) && Objects.equals(this.reps, training.reps)
                && Objects.equals(this.sets, training.sets) &&Objects.equals(this.comment, training.comment)
                && Objects.equals(this.name, name) && Objects.equals(this.weight, weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.reps, this.sets, this.comment, this.name, this.weight);
    }

    //not completed
    @Override
    public String toString() {
        return "Employee{" + "id=" + this.id + ", name='" + this.name + '\'' + ", comment='" + this.comment + '\'' + ", weight= " + this.weight + '}';
    }

}

package webtech.project.entity;

public interface Training {

    //getter setter for repetitions
    public int getReps();
    public void setReps(int newReps);

    //getter setter for sets
    public int getSets();
    public void setSets(int newSets);

    public String getComment();
    public void setComment(String newComment);

    public boolean getType();


}

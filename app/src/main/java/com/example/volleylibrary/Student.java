package com.example.volleylibrary;

public class Student {

    private int    id;
    private String first_name;
    private String last_name;
    private String course;
    private int    score;
    private String created_at;
    private String updated_at;

    public String getUpdated_at()                { return updated_at;}

    public void setUpdated_at(String updated_at) { this.updated_at = updated_at;}

    public String getCreated_at()                { return created_at;}

    public void setCreated_at(String created_at) { this.created_at = created_at;}

    public int getScore()                        { return score;}

    public void setScore(int score)              { this.score = score;}

    public String getCourse()                    { return course;}

    public void setCourse(String course)         { this.course = course;}

    public String getLast_name()                 { return last_name;}

    public void setLast_name(String last_name)   { this.last_name = last_name;}

    public String getFirst_name()                { return first_name;}

    public void setFirst_name(String first_name) { this.first_name = first_name;}

    public int getId()                           { return id;}

    public void setId(int id)                    { this.id = id;}
}

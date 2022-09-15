package model;

public class User {

    private int id;
    private String name;
    private String job;

    public User(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }
}

package model;

public class Inheritor {
    private String id;
    private String name;
    private String ethnicity;
    private String gender;
    private String category;
    private String project_name;
    private String project_id;
    private String bio;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public String getGender() {
        return gender;
    }

    public String getProject_name() {
        return project_name;
    }

    public String getCategory() {
        return category;
    }

    public String getProject_id() {
        return project_id;
    }

    public String getBio() {
        return bio;
    }
}
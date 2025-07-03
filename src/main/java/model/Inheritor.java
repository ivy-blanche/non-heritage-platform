package model;

public class Inheritor {
    private String id;
    private String name;
    private String gender;
    private String ethnicity;
    private String category;
    private String projectName;
    private String projectId;
    private String bio;

    // 无参构造器
    public Inheritor() {
    }

    // 全参构造器（方便初始化）
    public Inheritor(String id, String name, String gender, String ethnicity,
                     String category, String projectName, String projectId, String bio) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.ethnicity = ethnicity;
        this.category = category;
        this.projectName = projectName;
        this.projectId = projectId;
        this.bio = bio;
    }

    // getter 和 setter 方法
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}

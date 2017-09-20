package org.scut.mychart.model;

/**
 * Created by linqidi on 2017/9/19.
 */
public class UserStructModel {
    private String id;
    private String name;
    private String sex;
    private String age;
    private String target_job ;
    private String workyear ;
    private String region ;
    private String min_salary ;
    private String educationno;
    private String category;


    public String getId(){
        return  id;
    }
    public void serId(String id ){
        this.id=id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getTarget_job() {
        return target_job;
    }

    public void setTarget_job(String target_job) {
        this.target_job = target_job;
    }
    public String getWorkyear() {
        return workyear;
    }

    public void setWorkyear(String workyear) {
        this.workyear = workyear;
    }
    public String getSalary() {
        return min_salary;
    }

    public void setSalary(String salary) {
        this.min_salary = salary;
    }
    public String getRegion() {
        return region;
    }

    public void setRegion(String area) {
        this.region = area;
    }
    public String getEducation() {
        return educationno;
    }

    public void setEducation(String education) {
        this.educationno = education;
    }
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


}

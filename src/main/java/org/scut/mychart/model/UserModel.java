package org.scut.mychart.model;

/**
 * Created by linqidi on 2017/9/20.
 */
public class UserModel {
    private String name ;
    private String sex ;
    private String age ;
    private String target_job ;
    private String workyear ;
    private String area ;
    private String salary ;
    private String education;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
}

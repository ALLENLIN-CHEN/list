package org.scut.mychart.model;

/**
 * Created by Hao on 2017/7/20.
 */
public class Rating_res {
    public String person_id;

    public String company_id;

    public Double rating;

    public String getPerson_id() {
        return person_id;
    }

    public Double getRating() {
        return rating;
    }

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public void setPerson_id(String person_id) {
        this.person_id = person_id;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}

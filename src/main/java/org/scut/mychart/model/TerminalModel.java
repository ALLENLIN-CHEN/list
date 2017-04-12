package org.scut.mychart.model;

public class TerminalModel {

    private Integer  value;
    private String   category;
    private Integer  year;
    private Integer  errorDays;
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getErrorDays() {
        return errorDays;
    }

    public void setErrorDays(Integer errorDays) {
        this.errorDays = errorDays;
    }
}

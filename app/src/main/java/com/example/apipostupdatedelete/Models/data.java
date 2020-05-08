package com.example.apipostupdatedelete.Models;

import com.google.gson.annotations.SerializedName;

public class data{
    @SerializedName("id")
    String id;

    @SerializedName("employee_name")
    String employee_name;
    @SerializedName("employee_salary")
    String employee_salary;
    @SerializedName("employee_age")
    String employee_age;

    @SerializedName("profile_image")
    String profile_image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(String employee_salary) {
        this.employee_salary = employee_salary;
    }

    public String getEmployee_age() {
        return employee_age;
    }

    public void setEmployee_age(String employee_age) {
        this.employee_age = employee_age;
    }

    public data(String employee_name, String employee_salary, String employee_age, String profile_image) {
        this.employee_name = employee_name;
        this.employee_salary = employee_salary;
        this.employee_age = employee_age;
        this.profile_image = profile_image;
    }

}
package com.example.androidproject.models;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Admin {
    @SerializedName("regNo")
    private long regNo;
    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;
    @SerializedName("fullName")
    private String fullName;
    @SerializedName("university")
    private String university;
    @SerializedName("faculty")
    private String faculty;
    @SerializedName("department")
    private String department;
    @SerializedName("year")
    private long year;
    @SerializedName("totalSubjectsInFirstSem")
    private long totalSubjectsInFirstSem;
    @SerializedName("totalSubjectsInSecondSem")
    private long totalSubjectsInSecondSem;

    public Admin() {
    }

    public Admin(long regNo, String username, String password, String fullName, String university, String faculty, String department, long year, long totalSubjectsInFirstSem, long totalSubjectsInSecondSem) {
        this.regNo = regNo;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.university = university;
        this.faculty = faculty;
        this.department = department;
        this.year = year;
        this.totalSubjectsInFirstSem = totalSubjectsInFirstSem;
        this.totalSubjectsInSecondSem = totalSubjectsInSecondSem;
    }

    public Admin(long regNo, String username, String fullName, String university, String faculty, String department, long year, long totalSubjectsInFirstSem, long totalSubjectsInSecondSem) {
        this.regNo = regNo;
        this.username = username;
        this.fullName = fullName;
        this.university = university;
        this.faculty = faculty;
        this.department = department;
        this.year = year;
        this.totalSubjectsInFirstSem = totalSubjectsInFirstSem;
        this.totalSubjectsInSecondSem = totalSubjectsInSecondSem;
    }

    public long getRegNo() {
        return regNo;
    }

    public void setRegNo(long regNo) {
        this.regNo = regNo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public long getTotalSubjectsInFirstSem() {
        return totalSubjectsInFirstSem;
    }

    public void setTotalSubjectsInFirstSem(long totalSubjectsInFirstSem) {
        this.totalSubjectsInFirstSem = totalSubjectsInFirstSem;
    }

    public long getTotalSubjectsInSecondSem() {
        return totalSubjectsInSecondSem;
    }

    public void setTotalSubjectsInSecondSem(long totalSubjectsInSecondSem) {
        this.totalSubjectsInSecondSem = totalSubjectsInSecondSem;
    }
}



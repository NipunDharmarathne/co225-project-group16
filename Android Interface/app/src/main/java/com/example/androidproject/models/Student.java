package com.example.androidproject.models;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Student {
    @SerializedName("regNo")
    private long regNo;
    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;
    @SerializedName("firstName")
    private String firstName;
    @SerializedName("lastName")
    private String lastName;
    @SerializedName("university")
    private String university;
    @SerializedName("faculty")
    private String faculty;
    @SerializedName("department")
    private String department;

    public Student() {
    }

    public Student(long regNo, String username, String firstName, String lastName, String university, String faculty, String department) {
        this.regNo = regNo;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.university = university;
        this.faculty = faculty;
        this.department = department;
    }

    public Student(long regNo, String username, String password, String firstName, String lastName, String university, String faculty, String department) {
        this.regNo = regNo;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.university = university;
        this.faculty = faculty;
        this.department = department;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
    //    public Student(String username, boolean registered) {
//        this.username = username;
//        this.registered = registered;
//    }
//    protected Student(Parcel in) {
//        regNo = in.readLong();
//        username = in.readString();
//        registered = in.readByte() != 0;
//    }


//    @NonNull
//    @Override
//    public String toString() {
//        return "Student{" +
//                "regNo=" + regNo +
//                ", username='" + username + '\'' +
//                ", registered=" + registered +
//                '}';
//    }

//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeLong(regNo);
//        dest.writeString(username);
//        dest.writeByte((byte) (registered ? 1 : 0));
//    }
//
//    public static final Creator<Student> CREATOR = new Creator<Student>() {
//        @Override
//        public Student createFromParcel(Parcel in) {
//            return new Student(in);
//        }
//
//        @Override
//        public Student[] newArray(int size) {
//            return new Student[size];
//        }
//    };
}
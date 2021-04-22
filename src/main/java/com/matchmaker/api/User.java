package com.matchmaker.api;

import java.util.ArrayList;

public class User {
    String fullName;
    int age;
    String gender;
    String profession;
    String district;
    private ArrayList<String> hobbies;
    String preferredGender;
    private ArrayList<String>  preferredProfessions;
    int preferredAgeRangeFrom;
    int preferredAgeRangeTo;

    public User() {
    }

    public User(String fullName, int age, String gender, String profession, String district, ArrayList<String> hobbiesList, String preferredGender,  ArrayList<String>  preferredProfessions, int preferredAgeRangeFrom, int preferredAgeRangeTo) {
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.profession = profession;
        this.district = district;
        this.hobbies = hobbiesList;
        this.preferredGender = preferredGender;
        this.preferredProfessions = preferredProfessions;
        this.preferredAgeRangeFrom = preferredAgeRangeFrom;
        this.preferredAgeRangeTo = preferredAgeRangeTo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public ArrayList<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(ArrayList<String> hobbies) {
        this.hobbies = hobbies;
    }

    public String getPreferredGender() {
        return preferredGender;
    }

    public void setPreferredGender(String preferredGender) {
        this.preferredGender = preferredGender;
    }

    public ArrayList<String> getPreferredProfessions() {
        return preferredProfessions;
    }

    public void setPreferredProfessions(ArrayList<String> preferredProfessions) {
        this.preferredProfessions = preferredProfessions;
    }

    public int getPreferredAgeRangeFrom() {
        return preferredAgeRangeFrom;
    }

    public void setPreferredAgeRangeFrom(int preferredAgeRangeFrom) {
        this.preferredAgeRangeFrom = preferredAgeRangeFrom;
    }

    public int getPreferredAgeRangeTo() {
        return preferredAgeRangeTo;
    }

    public void setPreferredAgeRangeTo(int preferredAgeRangeTo) {
        this.preferredAgeRangeTo = preferredAgeRangeTo;
    }

    @Override
    public String toString() {
        return "User{" +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", profession='" + profession + '\'' +
                ", district='" + district + '\'' +
                ", hobbies=" + hobbies +
                ", preferredGender='" + preferredGender + '\'' +
                ", preferredProfessions=" + preferredProfessions +
                ", preferredAgeRangeFrom=" + preferredAgeRangeFrom +
                ", preferredAgeRangeTo=" + preferredAgeRangeTo +
                '}';
    }
}

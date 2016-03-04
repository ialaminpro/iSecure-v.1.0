package com.shakil.iCare_Health;

public class Profile {
    private int id;
    private String name;
    private String phone;
    private String gender;

    public  Profile(){};

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    private String bloodGroup;

    public Profile(int id, String name, String phone, String gender, String bloodGroup) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
    }

    public Profile(String name, String phone, String gendeer, String bloodGroup) {

        this.name = name;
        this.phone = phone;
        this.gender = gendeer;
        this.bloodGroup = bloodGroup;
    }


    public Profile(int id, String name, String phone) {

        this.id = id;
        this.name = name;
        this.phone = phone;

    }

    public Profile(String name) {
        this.name = name;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}


package com.shakil.iCare_Health;


public class Doctor {
    private int id;
    private String name;
    private String qualification;
    private String designation;
    private String expertise;
    private String organization;
    private String chamber;

    public Doctor(String name, String qualification, String designation, String expertise, String organization, String chamber, String location, String phone) {
        this.name = name;
        this.qualification = qualification;
        this.designation = designation;
        this.expertise = expertise;
        this.organization = organization;
        this.chamber = chamber;
        this.location = location;
        this.phone = phone;
    }

    public Doctor(int id, String name, String qualification, String designation, String expertise, String organization, String chamber, String location, String phone) {
        this.id = id;
        this.name = name;
        this.qualification = qualification;
        this.designation = designation;
        this.expertise = expertise;
        this.organization = organization;
        this.chamber = chamber;
        this.location = location;

        this.phone = phone;
    }

    private String location;
    private String phone;

    public Doctor() {
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

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getChamber() {
        return chamber;
    }

    public void setChamber(String chamber) {
        this.chamber = chamber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                ", qualification='" + qualification + '\'' +
                ", designation='" + designation + '\'' +
                ", expertise='" + expertise + '\'' +
                ", organization='" + organization + '\'' +
                ", chamber='" + chamber + '\'' +
                ", location='" + location + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

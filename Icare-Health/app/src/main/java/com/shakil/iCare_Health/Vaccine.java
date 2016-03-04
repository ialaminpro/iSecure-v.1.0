package com.shakil.iCare_Health;


public class Vaccine {
    private int id;
    private String profileName;
    private String status;
    private String vaccineName;
    private String date;
    private String nextDate;
    private String description1;
    private String description2;

    public Vaccine() {
    }

    public Vaccine(String profileName, String vaccineName, String date, String description1, String status,  String description2, String nextDate) {

        this.profileName = profileName;
        this.status = status;
        this.vaccineName = vaccineName;
        this.date = date;
        this.nextDate = nextDate;
        this.description1 = description1;
        this.description2 = description2;
    }

    public Vaccine(int id,String profileName, String vaccineName, String date, String description1, String status,  String description2, String nextDate){
        this.id = id;
        this.profileName = profileName;
        this.status = status;
        this.vaccineName = vaccineName;
        this.date = date;
        this.nextDate = nextDate;
        this.description1 = description1;
        this.description2 = description2;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNextDate() {
        return nextDate;
    }

    public void setNextDate(String nextDate) {
        this.nextDate = nextDate;
    }

    public String getDescription1() {
        return description1;
    }

    @Override
    public String toString() {
        return "Vaccine{" +
                "id=" + id +
                ", profileName='" + profileName + '\'' +

                ", vaccineName='" + vaccineName + '\'' +
                ", date='" + date + '\'' +
                ", description1='" + description1 + '\'' +
                ", status='" + status + '\'' +


                ", description2='" + description2 + '\'' +
                ", nextDate='" + nextDate + '\'' +
                '}';
    }

    public void setDescription1(String description1) {
        this.description1 = description1;
    }

    public String getDescription2() {
        return description2;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
    }
}
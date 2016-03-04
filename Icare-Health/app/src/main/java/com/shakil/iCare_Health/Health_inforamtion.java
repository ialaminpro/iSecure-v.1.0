package com.shakil.iCare_Health;

/**
 * Created by spy on 6/30/15.
 */
public class Health_inforamtion {
    private int id;
    private String name;
    private String Blood_pressure;
    private String stoke;
    private String mental_health;
    private String injury;

    public Health_inforamtion() {
    }

    public Health_inforamtion(String name, String blood_pressure, String stoke, String mental_health, String injury) {

        this.name = name;
        this.Blood_pressure = blood_pressure;
        this.stoke = stoke;
        this.mental_health = mental_health;
        this.injury = injury;
    }

    public Health_inforamtion(int id, String name, String blood_pressure, String stoke, String mental_health, String injury) {

        this.id = id;
        this.name = name;
        this.Blood_pressure = blood_pressure;
        this.stoke = stoke;
        this.mental_health = mental_health;
        this.injury = injury;
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

    public String getBlood_pressure() {
        return Blood_pressure;
    }

    public void setBlood_pressure(String blood_pressure) {
        this.Blood_pressure = blood_pressure;
    }

    public String getStoke() {
        return stoke;
    }

    public void setStoke(String stoke) {
        this.stoke = stoke;
    }

    public String getMental_health() {
        return mental_health;
    }

    public void setMental_health(String mental_health) {
        this.mental_health = mental_health;
    }

    public String getInjury() {
        return injury;
    }

    public void setInjury(String injury) {
        this.injury = injury;
    }
}

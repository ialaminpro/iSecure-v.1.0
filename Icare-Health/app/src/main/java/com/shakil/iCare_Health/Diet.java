package com.shakil.iCare_Health;

/**
 * Created by spy on 7/1/15.
 */
public class Diet {
    private int ID;
    private String name;
    private String breakfast_1,breakfast_2,breakfast_3;
    private String lunch_1,lunch_2,lunch_3;
    private String dinner_1,dinner_2,dinner_3;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreakfast_1() {
        return breakfast_1;
    }

    public void setBreakfast_1(String breakfast_1) {
        this.breakfast_1 = breakfast_1;
    }

    public String getBreakfast_2() {
        return breakfast_2;
    }

    public void setBreakfast_2(String breakfast_2) {
        this.breakfast_2 = breakfast_2;
    }

    public String getBreakfast_3() {
        return breakfast_3;
    }

    public void setBreakfast_3(String breakfast_3) {
        this.breakfast_3 = breakfast_3;
    }

    public String getLunch_1() {
        return lunch_1;
    }

    public void setLunch_1(String lunch_1) {
        this.lunch_1 = lunch_1;
    }

    public String getLunch_2() {
        return lunch_2;
    }

    public void setLunch_2(String lunch_2) {
        this.lunch_2 = lunch_2;
    }

    public String getLunch_3() {
        return lunch_3;
    }

    public void setLunch_3(String lunch_3) {
        this.lunch_3 = lunch_3;
    }

    public String getDinner_1() {
        return dinner_1;
    }

    public void setDinner_1(String dinner_1) {
        this.dinner_1 = dinner_1;
    }

    public String getDinner_2() {
        return dinner_2;
    }

    public void setDinner_2(String dinner_2) {
        this.dinner_2 = dinner_2;
    }

    public String getDinner_3() {
        return dinner_3;
    }

    public void setDinner_3(String dinner_3) {
        this.dinner_3 = dinner_3;
    }

    public Diet() {

    }

    public Diet(String name, String breakfast_1, String breakfast_2, String breakfast_3, String lunch_1, String lunch_2, String lunch_3, String dinner_1, String dinner_2, String dinner_3) {

        this.name = name;
        this.breakfast_1 = breakfast_1;
        this.breakfast_2 = breakfast_2;
        this.breakfast_3 = breakfast_3;
        this.lunch_1 = lunch_1;
        this.lunch_2 = lunch_2;
        this.lunch_3 = lunch_3;
        this.dinner_1 = dinner_1;
        this.dinner_2 = dinner_2;
        this.dinner_3 = dinner_3;
    }

    public Diet(int ID, String name, String breakfast_1, String breakfast_2, String breakfast_3, String lunch_1, String lunch_2, String lunch_3, String dinner_1, String dinner_2, String dinner_3) {

        this.ID = ID;
        this.name = name;
        this.breakfast_1 = breakfast_1;
        this.breakfast_2 = breakfast_2;
        this.breakfast_3 = breakfast_3;
        this.lunch_1 = lunch_1;
        this.lunch_2 = lunch_2;
        this.lunch_3 = lunch_3;
        this.dinner_1 = dinner_1;
        this.dinner_2 = dinner_2;
        this.dinner_3 = dinner_3;
    }
}

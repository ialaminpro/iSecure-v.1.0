package com.shakil.iCare_Health;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "db_profile333333";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_PROFILES = "profiles";


    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_PHONE = "phone";
    public static final String KEY_GENDER = "gender";
    public static final String KEY_BLOOD = "blood_group";





    public static final String TABLE_VACCINE = "vaccine";

    DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PROFILES_TABLE = "CREATE TABLE " + TABLE_PROFILES + "(" + KEY_ID + " INTEGER PRIMARY KEY, " +
                KEY_NAME + " TEXT, " + KEY_PHONE + " TEXT, " + KEY_GENDER + " TEXT, " + KEY_BLOOD + " TEXT" + ")";

        db.execSQL(CREATE_PROFILES_TABLE);
        db.execSQL("CREATE TABLE doctors (id INTEGER PRIMARY KEY, name TEXT,qualification TEXT,designation TEXT, expertise TEXT,organization TEXT, chamber TEXT, location TEXT, phone TEXT)");
        db.execSQL("CREATE TABLE health_information (id INTEGER PRIMARY KEY, name TEXT,Blood_Pressure TEXT,Stroke TEXT, injury TEXT,Mental_Health TEXT)");
        db.execSQL("CREATE TABLE Diet (id INTEGER PRIMARY KEY, name TEXT,D_breakfast TEXT,D_Lunch TEXT, D_Dinner TEXT)");
        db.execSQL("CREATE TABLE " + TABLE_VACCINE + "(" + VAC_ID + " INTEGER PRIMARY KEY, " +
                KEY_NAME + " TEXT, " + VAC_NAME + " TEXT, " + VAC_DATE + " TEXT, " + VAC_DESCRIPTION1 + " TEXT, " + VAC_STATUS + " TEXT, " + VAC_DESCRIPTION2 + " TEXT, " + VAC_NEXT_DATE + " TEXT" + ")");

    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void addProfile(Profile profile){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, profile.getName());
        values.put(KEY_PHONE, profile.getPhone());
        values.put(KEY_GENDER, profile.getGender());
        values.put(KEY_BLOOD, profile.getBloodGroup());

        db.insert(TABLE_PROFILES,null,values);
        db.close();
    }


    public List<Profile> getAllProfiles(){
        List<Profile> profileList = new ArrayList<Profile>();
        String select_query= "SELECT * FROM " + TABLE_PROFILES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(select_query,null);

        if(cursor.moveToFirst()){
            do{
                Profile profile = new Profile();
                profile.setId(Integer.parseInt(cursor.getString(0)));
                profile.setName(cursor.getString(1));
                profile.setPhone(cursor.getString(2));
                profile.setGender(cursor.getString(3));
                profile.setBloodGroup(cursor.getString(4));

                profileList.add(profile);

            }while(cursor.moveToNext() && cursor != null);
        }
        return profileList;

    }

    public Profile getProfile(int id){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_PROFILES, new String[]{KEY_ID,
                        KEY_NAME, KEY_PHONE, KEY_GENDER, KEY_BLOOD}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if(cursor != null)
            cursor.moveToFirst();

        Profile profile = new Profile(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
        return profile;
    }


    public Profile getProfile(String name){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_PROFILES, new String[]{KEY_ID,
                        KEY_NAME, KEY_PHONE, KEY_GENDER, KEY_BLOOD}, KEY_NAME + "=?",
                new String[]{name}, null, null, null, null);

        if(cursor != null)
            cursor.moveToFirst();

        Profile profile = new Profile(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
        return profile;
    }


    public void deleteProfile(String id) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_PROFILES, KEY_NAME + " = ?", new String[]{id});

        db.close();

    }

    public void updateProfile(Profile profile){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, profile.getName());
        values.put(KEY_PHONE, profile.getPhone());
        values.put(KEY_GENDER, profile.getGender());
        values.put(KEY_BLOOD, profile.getPhone());


        db.update(TABLE_PROFILES, values, KEY_ID + " = ? ",
                new String[]{Integer.toString(profile.getId())});




    }




    //DOCTOR
///
    ////
    ///
    ///

    ///
    /////
    //
    //
    //
    //
    public static final String TABLE_DOCTORS = "doctors";

    public static final String DOC_ID = "id";
    public static final String DOC_NAME = "name";
    public static final String DOC_QUALIFICATION = "qualification";
    public static final String DOC_DESIGNATION = "designation";
    public static final String DOC_EXPERTISE = "expertise";
    public static final String DOC_ORGANIZATION = "organization";
    public static final String DOC_CHAMBER= "chamber";
    public static final String DOC_LOCATION = "location";
    public static final String DOC_PHONE = "phone";


    public void addDoctor(Doctor doctor){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DOC_NAME, doctor.getName());
        values.put(DOC_QUALIFICATION, doctor.getQualification());
        values.put(DOC_DESIGNATION, doctor.getDesignation());
        values.put(DOC_EXPERTISE, doctor.getExpertise());
        values.put(DOC_ORGANIZATION, doctor.getLocation());
        values.put(DOC_CHAMBER, doctor.getChamber());
        values.put(DOC_LOCATION, doctor.getLocation());
        values.put(DOC_PHONE, doctor.getPhone());

        db.insert(TABLE_DOCTORS,null,values);
        db.close();
    }

    public List<Doctor> getAllDoctors(){
        List<Doctor> doctorsList = new ArrayList<Doctor>();
        String select_query= "SELECT * FROM " + TABLE_DOCTORS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(select_query,null);

        if(cursor.moveToFirst()){
            do{
                Doctor doctor = new Doctor();
                doctor.setId(Integer.parseInt(cursor.getString(0)));
                doctor.setName(cursor.getString(1));
                doctor.setQualification(cursor.getString(2));
                doctor.setDesignation(cursor.getString(3));
                doctor.setExpertise(cursor.getString(4));
                doctor.setOrganization(cursor.getString(5));
                doctor.setChamber(cursor.getString(6));
                doctor.setLocation(cursor.getString(7));
                doctor.setPhone(cursor.getString(8));
                doctorsList.add(doctor);

            }while(cursor.moveToNext() && cursor != null);
        }
        return doctorsList;
    }


    public Doctor getDoctor(int id){

        SQLiteDatabase db = this.getReadableDatabase();

       Cursor cursor =  db.rawQuery("select * from " + TABLE_DOCTORS + "where id = " + id, null);


        int docId = Integer.parseInt(cursor.getString(0));
        String name = cursor.getString(1);
        String qualification = cursor.getString(2);
        String designation = cursor.getString(3);
        String expertise = cursor.getString(4);
        String organization = cursor.getString(5);
        String chamber = cursor.getString(6);
        String location = cursor.getString(7);
        String phone = cursor.getString(8);

        if(cursor != null)
            cursor.moveToFirst();
        Doctor doctor = new Doctor(docId, name, qualification, designation, expertise, organization, chamber, location, phone);

        return doctor;
    }


    public Doctor getDoctor(String name){

        SQLiteDatabase db = this.getReadableDatabase();


       // Cursor cursor =  db.rawQuery("select * from " + TABLE_DOCTORS + " where name = " + name.toString(), null);



        Cursor cursor = db.query(TABLE_DOCTORS, new String[]{DOC_ID, DOC_NAME, DOC_QUALIFICATION, DOC_DESIGNATION, DOC_EXPERTISE, DOC_ORGANIZATION,
                DOC_CHAMBER, DOC_LOCATION, DOC_PHONE}, KEY_NAME + "=?"
                , new String[]{name}, null, null, null, null);

        if(cursor != null)
            cursor.moveToFirst();

        int docId = Integer.parseInt(cursor.getString(0));
        String name2 = cursor.getString(1);
        String qualification = cursor.getString(2);
        String designation = cursor.getString(3);
        String expertise = cursor.getString(4);
        String organization = cursor.getString(5);
        String chamber = cursor.getString(6);
        String location = cursor.getString(7);
        String phone = cursor.getString(8);




        Doctor doctor = new Doctor(docId, name2, qualification, designation, expertise, organization, chamber, location, phone);

        return doctor;
    }


    public void deleteDoctor(String id) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_DOCTORS, DOC_NAME + " = ?", new String[]{id});

        db.close();

    }

    public void updateDoctor(Doctor doctor){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DOC_NAME, doctor.getName());
        values.put(DOC_QUALIFICATION, doctor.getQualification());
        values.put(DOC_DESIGNATION, doctor.getDesignation());
        values.put(DOC_EXPERTISE, doctor.getExpertise());
        values.put(DOC_ORGANIZATION, doctor.getLocation());
        values.put(DOC_CHAMBER, doctor.getChamber());
        values.put(DOC_LOCATION, doctor.getLocation());
        values.put(DOC_PHONE, doctor.getPhone());

        db.update(TABLE_DOCTORS, values, DOC_ID + " = ? ",
                new String[]{Integer.toString(doctor.getId())});


        db.close();
    }



    /****************************** Start Health Information *************************************/



    public static final String TABLE_Health = "health_information";


    public static final String H_ID = "id";

    public static final String H_blood_pressure = "Blood_Pressure";
    public static final String H_stoke = "Stroke";
    public static final String H_injury = "injury";
    public static final String H_mental_health = "Mental_Health";



    public void addhealth_information(Health_inforamtion health){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME,health.getName());
        values.put(H_blood_pressure, health.getBlood_pressure());
        values.put(H_injury, health.getInjury());
        values.put(H_mental_health, health.getMental_health());
        values.put(H_stoke, health.getStoke());


        db.insert(TABLE_Health,null,values);
        db.close();
    }

    public List<Health_inforamtion> getHealth(){
        List<Health_inforamtion> healthList = new ArrayList<Health_inforamtion>();
        String select_query= "SELECT * FROM " + TABLE_Health;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(select_query,null);

        if(cursor.moveToFirst()){
            do{
                Health_inforamtion health = new Health_inforamtion();
                health.setId(Integer.parseInt(cursor.getString(0)));
                health.setBlood_pressure(cursor.getString(1));
                health.setStoke(cursor.getString(2));
                health.setMental_health(cursor.getString(3));
                health.setInjury(cursor.getString(4));
                health.setName(cursor.getString(5));

                healthList.add(health);

            }while(cursor.moveToNext() && cursor != null);
        }
        return healthList;
    }


    public Health_inforamtion getHealth(int id){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor =  db.rawQuery("select * from " + TABLE_Health + "where id = " + id, null);


        int heathId = Integer.parseInt(cursor.getString(0));
        String Blood_Pressure = cursor.getString(1);
        String Stoke = cursor.getString(2);
        String Mental_health = cursor.getString(3);
        String Injury = cursor.getString(4);
        String name = cursor.getString(5);

        if(cursor != null)
            cursor.moveToFirst();
        Health_inforamtion health = new Health_inforamtion(heathId, Blood_Pressure, Stoke, Mental_health, Injury,name);

        return health;
    }


    public Health_inforamtion getHealth(String name){

        SQLiteDatabase db = this.getReadableDatabase();



        Cursor cursor = db.query(TABLE_Health, new String[]{KEY_NAME, H_blood_pressure, H_mental_health, H_injury, H_stoke}, KEY_NAME + "=?"
                , new String[]{name}, null, null, null, null);

        if(cursor != null)
            cursor.moveToFirst();

        //int HealthId = Integer.parseInt(cursor.getString(0));
        String H_name = cursor.getString(0);
        String H_blood_pressure = cursor.getString(1);
        String H_mental_health = cursor.getString(2);
        String H_injury = cursor.getString(3);
        String H_stoke = cursor.getString(4);




        Health_inforamtion health = new Health_inforamtion(H_name, H_blood_pressure, H_stoke,H_mental_health, H_injury) ;

        return health;
    }


    public void deleteHealth(String name) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_Health, KEY_NAME + " = ?", new String[] {name});

        db.close();

    }

    public void updateHealth(String name, Health_inforamtion health){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, health.getName());
        values.put(H_blood_pressure,health.getBlood_pressure());
        values.put(H_stoke, health.getStoke());
        values.put(H_mental_health,health.getMental_health());
        values.put(H_injury, health.getInjury());
        db.update(TABLE_Health, values, KEY_NAME + " = ? ",
                new String[] {name});


        db.close();
    }

    /************************************ END Health Information ***********************************/



    /*********************************** Start Diet and Nutition ***********************************/
    public static final String TABLE_Diet = "diet";


    public static final String D_ID = "id";

    public static final String D_breakfast_1 = "breakfast_1";
    public static final String D_breakfast_2 = "breakfast_2";
    public static final String D_breakfast_3 = "breakfast_3";
    public static final String D_Lunch_1 = "Lunch_1";
    public static final String D_Lunch_2 = "Lunch_2";
    public static final String D_Lunch_3 = "Lunch_3";
    public static final String D_Dinner_1 = "Dinner_1";
    public static final String D_Dinner_2 = "Dinner_2";
    public static final String D_Dinner_3 = "Dinner_3";


    public void adddiet(Diet diet){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME,diet.getName());
        values.put(D_breakfast_1, diet.getBreakfast_1());
        values.put(D_breakfast_2, diet.getBreakfast_2());
        values.put(D_breakfast_3, diet.getBreakfast_3());
        values.put(D_Lunch_1, diet.getLunch_1());
        values.put(D_Lunch_2, diet.getLunch_2());
        values.put(D_Lunch_3, diet.getLunch_3());
        values.put(D_Dinner_1, diet.getDinner_1());
        values.put(D_Dinner_2, diet.getDinner_2());
        values.put(D_Dinner_3, diet.getDinner_3());

        db.insert(TABLE_Diet,null,values);
        db.close();
    }

//    public List<Diet> getDiet(){
//        List<Diet> healthList = new ArrayList<Diet>();
//        String select_query= "SELECT * FROM " + TABLE_Diet;
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(select_query,null);
//
//        if(cursor.moveToFirst()){
//            do{
//                Diet diet = new Diet();
//                diet.setID(Integer.parseInt(cursor.getString(0)));
//                diet.setName(cursor.getString(1));
//                diet.setBreakfast(cursor.getString(2));
//                diet.setLunch(cursor.getString(3));
//                diet.setDinner(cursor.getString(4));
//
//
//                dietList.add(diet);
//
//            }while(cursor.moveToNext() && cursor != null);
//        }
//        return dietList;
//    }


//    public Diet get(int id){
//
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor cursor =  db.rawQuery("select * from " + TABLE_Health + "where id = " + id, null);
//
//
//        int heathId = Integer.parseInt(cursor.getString(0));
//        String Blood_Pressure = cursor.getString(1);
//        String Stoke = cursor.getString(2);
//        String Mental_health = cursor.getString(3);
//        String Injury = cursor.getString(4);
//        String name = cursor.getString(5);
//
//        if(cursor != null)
//            cursor.moveToFirst();
//        Health_inforamtion health = new Health_inforamtion(heathId, Blood_Pressure, Stoke, Mental_health, Injury,name);
//
//        return health;
//    }


    public Diet getdiet(String name){

        SQLiteDatabase db = this.getReadableDatabase();



        Cursor cursor = db.query(TABLE_Diet, new String[]{KEY_NAME, D_breakfast_1,D_breakfast_2,D_breakfast_3, D_Lunch_1,D_Lunch_2,D_Lunch_3, D_Dinner_1,D_Dinner_2,D_Dinner_3}, KEY_NAME + "=?"
                , new String[]{name}, null, null, null);

        if(cursor != null)
            cursor.moveToFirst();

        //int HealthId = Integer.parseInt(cursor.getString(0));
        String D_name = cursor.getString(0);
        String D_breakfast = cursor.getString(1);
        String D_Lunch = cursor.getString(2);
        String D_Dinner = cursor.getString(3);





        Diet diet = new Diet(D_name, D_breakfast_1,D_breakfast_2,D_breakfast_3,D_Lunch_1,D_Lunch_2,D_Lunch_3,D_Dinner_1,D_Dinner_2,D_Dinner_3) ;
        return diet;
    }


    public void deleteDiet(String name) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_Diet, KEY_NAME + " = ?", new String[] {name});

        db.close();

    }

    public void updateDiet(String name, Diet diet){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, diet.getName());
        values.put(D_breakfast_1,diet.getBreakfast_1());
        values.put(D_breakfast_2, diet.getBreakfast_2());
        values.put(D_breakfast_3,diet.getBreakfast_3());

        values.put(D_Lunch_1,diet.getLunch_1());
        values.put(D_Lunch_2, diet.getLunch_2());
        values.put(D_Lunch_3,diet.getLunch_3());

        values.put(D_Dinner_1,diet.getDinner_1());
        values.put(D_Dinner_2, diet.getDinner_2());
        values.put(D_Dinner_3,diet.getDinner_3());

        db.update(TABLE_Diet, values, KEY_NAME + " = ? ",
                new String[] {name});


        db.close();
    }
    /*************************************** END **************************************************/


    /////////////////////////////////////////////////////////////
//    Vaccine


    public static final String VAC_ID = "id";
    public static final String VAC_NAME = "vaccine_name";
    public static final String VAC_DESCRIPTION1 = "description1";
    public static final String VAC_STATUS = "status";
    public static final String VAC_DESCRIPTION2 = "description2";
    public static final String VAC_DATE = "date";

    public static final String VAC_NEXT_DATE = "next_date";




    public void addVaccine(Vaccine vaccine){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, vaccine.getProfileName());
        values.put(VAC_NAME, vaccine.getVaccineName());
        values.put(VAC_DATE, vaccine.getDate());
        values.put(VAC_DESCRIPTION1, vaccine.getDescription1());
        values.put(VAC_STATUS, vaccine.getStatus());
        values.put(VAC_DESCRIPTION2, vaccine.getDescription2());
        values.put(VAC_NEXT_DATE, vaccine.getNextDate());
        db.insert(TABLE_VACCINE,null,values);
        db.close();
    }


    public List<Vaccine> getAllVaccine(String profileName){
        List<Vaccine> vaccineList = new ArrayList<Vaccine>();
        String select_query= "SELECT * FROM " + TABLE_VACCINE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(select_query,null);

        if(cursor.moveToFirst()){
            do{
                Vaccine vaccine = new Vaccine();
                vaccine.setId(Integer.parseInt(cursor.getString(0)));
                vaccine.setProfileName(cursor.getString(1));
                vaccine.setVaccineName(cursor.getString(2));
                vaccine.setDate(cursor.getString(3));
                vaccine.setStatus(cursor.getString(4));
                vaccine.setDescription2(cursor.getString(5));
                vaccine.setNextDate(cursor.getString(6));

                vaccineList.add(vaccine);

            }while(cursor.moveToNext() && cursor != null);
        }
        return vaccineList;

    }

//    public Vaccine getVaccine(int id){
//
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor cursor = db.query(TABLE_VACCINE, new String[]{VAC_ID,
//                        KEY_NAME, VAC_DATE, VAC_DESCRIPTION1, VAC_STATUS, VAC_DESCRIPTION2, VAC_NEXT_DATE}, KEY_ID + "=?",
//                new String[]{String.valueOf(id)}, null, null, null, null);
//
//        if(cursor != null)
//            cursor.moveToFirst();
//
//        Profile profile = new Profile(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
//        return profile;
//    }


    public Vaccine getVaccine(String profileName, String vaccineName){
//
//        SQLiteDatabase db = this.getReadableDatabase();
//
////        Cursor cursor = db.query(TABLE_PROFILES, new String[]{KEY_ID,
////                        KEY_NAME, KEY_PHONE, KEY_GENDER, KEY_BLOOD}, KEY_NAME + "=?",
////                new String[]{name}, null, null, null, null);
//
//        String select_query= "SELECT * FROM " + TABLE_VACCINE + " WHERE " + KEY_NAME + " = " + profileName + " && " + VAC_NAME + " = " + vaccineName;
//
//        Cursor cursor = db.rawQuery(select_query,null);
//
//        if(cursor != null)
//            cursor.moveToFirst();
//
//        Vaccine vaccine = new Vaccine(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7));
//        return vaccine;








        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_VACCINE, new String[]{VAC_ID,
                        KEY_NAME, VAC_NAME, VAC_DATE, VAC_DESCRIPTION1, VAC_STATUS, VAC_DESCRIPTION2, VAC_NEXT_DATE},VAC_NAME + "  = ?" ,
                new String[]{vaccineName}, null, null, null, null);

        if(cursor != null)
            cursor.moveToFirst();
        Vaccine vaccine = new Vaccine(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2), cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7));


        return vaccine;

    }


    public void deleteVaccine(String profileName,String vaccineName) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_VACCINE, KEY_NAME + " = ? AND " + VAC_NAME + " = ? ", new String[]{profileName, vaccineName});


        db.close();

    }

    public void updateVaccine(String profileName, String vaccineName, Vaccine vaccine){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, profileName);
        values.put(VAC_NAME, vaccine.getVaccineName());
        values.put(VAC_DATE, vaccine.getDate());
        values.put(VAC_DESCRIPTION1, vaccine.getDescription1());
        values.put(VAC_STATUS, vaccine.getStatus());
        values.put(VAC_DESCRIPTION2, vaccine.getDescription2());
        values.put(VAC_NEXT_DATE, vaccine.getNextDate());

        db.update(TABLE_VACCINE, values,KEY_NAME + " = ? AND " + VAC_NAME + " = ?" ,
                new String[]{profileName,vaccineName});
        db.close();


    }

}

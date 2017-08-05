package com.example.lameya.maa;


public class Config {

    //Address of our scripts of the CRUD
    public static final String URL_ADD="http://192.168.43.152/por/addEmp.php";
    public static final String URL_GET_ALL = "http://192.168.43.152/por/getAllEmp.php";
    public static final String URL_GET_EMP = "http://192.168.43.152/por/getEmp.php?id=";
    public static final String URL_UPDATE_EMP = "http://192.168.43.152/por/updateEmp.php";
    public static final String URL_DELETE_EMP = "http://192.168.43.152/por/deleteEmp.php?id=";

    //Keys that will be used to send the request to php scripts
    public static final String KEY_EMP_ID = "id";

    public static final String KEY_EMP_NAM = "nam";

    public static final String KEY_EMP_NAME = "name";
    public static final String KEY_EMP_DESG = "desg";
    public static final String KEY_EMP_SAL = "salary";

    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_ID = "id";

    public static final String TAG_NAM  = "nam";

    public static final String TAG_NAME = "name";
    public static final String TAG_DESG = "desg";
    public static final String TAG_SAL = "salary";

    //employee id to pass with intent
    public static final String EMP_ID = "emp_id";




    public static final String LOGIN_URL = "http://192.168.43.152/por/login.php";

    //Keys for email and password as defined in our $_POST['key'] in login.php
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "password";

    //If server response is equal to this that means login is successful
    public static final String LOGIN_SUCCESS = "success";

    //Keys for Sharedpreferences
    //This would be the name of our shared preferences
   // public static final String SHARED_PREF_NAME = "myloginapp";

    //This would be used to store the email of current logged in user
    public static final String EMAIL_SHARED_PREF = "email";



    //Internal
    public static final String URL_GET_HOS= "http://192.168.43.152/por/showHospital.php?h_Id=";
    public static final String URL_GET_ALL_A_HOS= "http://192.168.43.152/por/All_AtoD.php";


    //Keys that will be used to send the request to php scripts
   // public static final String KEY_EMP_ID = "h_id";
   // public static final String KEY_EMP_NAME = "Name";
    public static final String KEY_EMP_AREA = "Area";
    public static final String KEY_EMP_SPC= "Special";
    public static final String KEY_EMP_REV = "Reviews";

    //JSON Tag
    //public static final String TAG_JSON_ARRAY="result";

    //JSON Tags for hospital
  //  public static final String TAG_ID = "Id";
   // public static final String TAG_NAME = "Name";

    //JSON Tags for hospital's details
    public static final String TAG_ADD = "Address";
    public static final String TAG_AREA = "Area";
    public static final String TAG_CONTACT = "Contact";
    public static final String TAG_LONGTITUDE = "Longtitude";
    public static final String TAG_LATITUDE = "Latitude";

    //JSON Tags for Ambulance
    public static final String TAG_AID = "AId";
    public static final String TAG_ANAME = "AName";
    public static final String TAG_ACONTACT = "AContact";
    public static final String TAG_ACALL = "ACall";


    //Keys for email and password as defined in our $_POST['key'] in login.php
    public static final String KEY_LOGIN_NAME = "name";
   // public static final String KEY_PASSWORD = "password";

    //If server response is equal to this that means login is successful
   // public static final String LOGIN_SUCCESS = "success";

    //Keys for Sharedpreferences
    //This would be the name of our shared preferences
    public static final String SHARED_PREF_NAME = "myloginapp";

    //This would be used to store the name of current logged in user
    public static final String NAME_SHARED_PREF = "name";

    //We will use this to store the boolean in sharedpreference to track user is loggedin or not
    public static final String LOGGEDIN_SHARED_PREF = "loggedin";

    //REVIEW
    public static final String TAG_USERNAME = "Name";
    public static final String TAG_REVIEWS= "Reviews";

    //Hospital id to pass with intent
    public static final String HOS_ID = "hos_id";

}
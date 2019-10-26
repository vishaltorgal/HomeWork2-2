package com.example.homework2_2.model;


import java.util.ArrayList;

public class Vehicle {
        protected String mCWID;
        protected String mMake;
        protected String mModel;
        protected String mYear;


        public Vehicle(String CWID, String Make, String Model, String Year) {
            mCWID = CWID;
            mMake = Make;
            mModel = Model;
            mYear = Year;
        }

        public String getMake() {
            return mMake;
        }

        public void setMake(String Make) {
            mMake = Make;
        }

        public String getModel() {
            return mModel;
        }

        public void setModel(String Model) {
            mModel = Model;
        }

        public String getYear() {
            return mYear;
        }

        public void setYear(String Year) {
            mYear = Year;
        }

    }

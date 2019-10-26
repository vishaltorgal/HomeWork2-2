package com.example.homework2_2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import com.example.homework2_2.adapter.Appconstant;
import com.example.homework2_2.adapter.CustomList;
import com.example.homework2_2.model.Student;
import com.example.homework2_2.model.Vehicle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

   // static ArrayList<Student> dataModels;
    CustomList adapter;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView) findViewById(R.id.list);
       // Appconstant.dataModels= new ArrayList<Student>();
        adapter = new CustomList(Appconstant.dataModels,getApplicationContext());
        listview.setAdapter(adapter);


        if(Appconstant.flag){
            new Task().execute();
        }

    }


    private class Task extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @SuppressLint("CommitTransaction")
        protected Void doInBackground(Void... params) {

//         public Course(String CWID, String CourseID, String Grade)
            Student stud = new Student("1","Vishal", "Torgal");

            ArrayList<Vehicle> vehicle = new ArrayList<Vehicle>();
            vehicle.add(new Vehicle("1","Tesla", "Model 3","2019"));
            vehicle.add(new Vehicle("1","Porsche", "Cayenne","2017"));
            stud.setVehicle(vehicle);
            Appconstant.dataModels.add(stud);

            stud = new Student("2","Rohit", "Shah");
            vehicle = new ArrayList<Vehicle>();
            vehicle.add(new Vehicle("2","Toyota", "Camry","2013"));
            vehicle.add(new Vehicle("2","Nissan", "Altima","2015"));
            vehicle.add(new Vehicle("2","Lexus", "GS","2018"));
            stud.setVehicle(vehicle);
            Appconstant.dataModels.add(stud);

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {

            //  Log.d("vt","yahoo 0 "+dataModels.get(0).getCourse().get(0).getCourseID());
            adapter.notifyDataSetChanged();
            Log.d("vt","MAinActivity onPostExecute"+Appconstant.dataModels);

        }

    }

}

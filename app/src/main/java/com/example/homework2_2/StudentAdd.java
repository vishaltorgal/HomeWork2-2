package com.example.homework2_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.homework2_2.adapter.Appconstant;
import com.example.homework2_2.model.Student;
import com.example.homework2_2.model.Vehicle;

import java.util.ArrayList;



public class StudentAdd extends AppCompatActivity {

    ImageView img_add;

    EditText sd_add_fname,sd_add_lname,sd_add_cwid,sd_add_vehicleMake,
            sd_add_vehicleModel,sd_add_vehicleYear;

    ArrayList<Vehicle> vehicle;

    boolean obb=false;

    Student stud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_studentadd);

        img_add = (ImageView) findViewById(R.id.img_add);
        sd_add_fname = (EditText)findViewById(R.id.sd_add_fname);
        sd_add_lname = (EditText)findViewById(R.id.sd_add_lname);
        sd_add_cwid = (EditText)findViewById(R.id.sd_add_cwid);
        sd_add_vehicleMake = (EditText)findViewById(R.id.sd_add_vehicleMake);
        sd_add_vehicleModel = (EditText)findViewById(R.id.sd_add_vehicleModel);
        sd_add_vehicleYear = (EditText)findViewById(R.id.sd_add_vehicleYear);


        img_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(obb==false){
                    createStudentObject();
                }

                vehicle.add(new Vehicle(sd_add_cwid.getText().toString(),
                        sd_add_vehicleMake.getText().toString(),
                        sd_add_vehicleModel.getText().toString(),
                        sd_add_vehicleYear.getText().toString()));

                stud.setVehicle(vehicle);

                sd_add_cwid.setEnabled(false);
                sd_add_fname.setEnabled(false);
                sd_add_lname.setEnabled(false);

                sd_add_vehicleMake.getText().clear();
                sd_add_vehicleModel.getText().clear();
                sd_add_vehicleYear.getText().clear();

            }
        });

    }

    public void saveDate(){

        if(obb==false){
            createStudentObject();
        }

      //   stud = new Student(sd_add_cwid.getText().toString(),
        //        sd_add_fname.getText().toString(),sd_add_lname.getText().toString());

      //  ArrayList<Vehicle> vehicle = new ArrayList<Vehicle>();


        vehicle.add(new Vehicle(sd_add_cwid.getText().toString(),
                sd_add_vehicleMake.getText().toString(),
                sd_add_vehicleModel.getText().toString(),
                sd_add_vehicleYear.getText().toString()));

        stud.setVehicle(vehicle);
        Appconstant.dataModels.add(stud);

      //  Log.d("vt","Student saveDate "+Appconstant.dataModels);

    }

    public void createStudentObject(){

        stud = new Student(sd_add_cwid.getText().toString(),
                sd_add_fname.getText().toString(),sd_add_lname.getText().toString());

        vehicle = new ArrayList<Vehicle>();

        obb=true;

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mymenu, menu);
        menu.findItem(R.id.add).setTitle("Done");
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Handle item selection
        switch (item.getItemId()) {
            case R.id.add:
                //perform any action;

                saveDate();

              //  Log.d("vt","yahoo 0 "+Appconstant.dataModels.get(2).getFirstName());
                Intent i = new Intent(StudentAdd.this,MainActivity.class);
                startActivity(i);
                Appconstant.flag = false;

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
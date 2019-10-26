package com.example.homework2_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.example.homework2_2.adapter.Appconstant;

public class StudentDetails extends AppCompatActivity {

    TextView sd_cwid,sd_vehicleMake,sd_vehicleModel,sd_vehicleYear;
    EditText sd_fname,sd_lname;
    int pos,courselength;
    MainActivity m;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Handle item selection
        switch (item.getItemId()) {
            case R.id.add:
                //perform any action;
                Intent i = new Intent(StudentDetails.this,StudentAdd.class);
                startActivity(i);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_vehicledetails);

        sd_vehicleMake = (TextView)findViewById(R.id.sd_vehicleMake);
        sd_vehicleModel = (TextView)findViewById(R.id.sd_vehicleModel);
        sd_vehicleYear = (TextView)findViewById(R.id.sd_vehicleYear);
        sd_cwid = (TextView)findViewById(R.id.sd_cwid);
        sd_fname = (EditText)findViewById(R.id.sd_fname);
        sd_lname = (EditText)findViewById(R.id.sd_lname);

        sd_fname.setEnabled(false);
        sd_lname.setEnabled(false);

        m = new MainActivity();

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras != null) {

                sd_cwid.setText(extras.getString("cwid"));
                sd_fname.setText(extras.getString("fname"));
                sd_lname.setText(extras.getString("lname"));
                pos = extras.getInt("pos");

                courselength = Appconstant.dataModels.get(pos).getVehicle().size();


                for(int i=0;i<courselength;i++){
                    //  Log.d("vt","yahoo 1-2 "+m.dataModels.get(pos).getCourse().get(i).getCourseID());

                    sd_vehicleMake.append( Appconstant.dataModels.get(pos).getVehicle().get(i).getMake()+ "\n"+"\n");
                    sd_vehicleModel.append( Appconstant.dataModels.get(pos).getVehicle().get(i).getModel()+"\n"+"\n");
                    sd_vehicleYear.append( Appconstant.dataModels.get(pos).getVehicle().get(i).getYear()+ "\n"+"\n");
                }


            }
        }

    }
}

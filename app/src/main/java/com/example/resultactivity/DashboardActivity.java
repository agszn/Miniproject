package com.example.resultactivity;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import android.database.Cursor;
import android.widget.EditText;

public class DashboardActivity extends AppCompatActivity {

    String EmailHolder;
    TextView Email;
    Button LogOUT, homee ;
    EditText name,contact,dob, subjectkannada, subjecthindi, subjectscience, subjectmaths, subjectsocial;
    Button insert, update, delete, view, btnViewunit1results, unittest2result, btnViewSem1results, btnViewSem1gradee, unittest3result,unittest4result, btnViewSem2results, btnViewSem2grade;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        name = findViewById(R.id.name);
        contact = findViewById(R.id.contact);
        dob = findViewById(R.id.dob);
        subjectkannada = findViewById(R.id.subjectkannada);
        subjecthindi = findViewById(R.id.subjecthindi);
        subjectscience = findViewById(R.id.subjectscience);
        subjectmaths = findViewById(R.id.subjectmaths);
        subjectsocial = findViewById(R.id.subjectsocial);

        insert = findViewById(R.id.btnInsert);
        update = findViewById(R.id.btnUpdate);
        delete = findViewById(R.id.btnDelete);
        view = findViewById(R.id.btnView);

        //unit test
        btnViewunit1results = findViewById(R.id.btnViewunit1results);
        unittest2result = findViewById(R.id.btnViewunit2results);
        btnViewSem1results = findViewById(R.id.btnViewSem1results);
        btnViewSem1gradee = findViewById(R.id.btnViewSem1grade);
        unittest3result= findViewById(R.id.btnViewunit3results);
        unittest4result = findViewById(R.id.btnViewunit4results);
        btnViewSem2results = findViewById(R.id.btnViewSem2results);
        btnViewSem2grade = findViewById(R.id.btnViewSem2grade);

        DB = new DBHelper(this);

        Email = (TextView)findViewById(R.id.textView1);
        LogOUT = (Button)findViewById(R.id.button1);
        homee = (Button)findViewById(R.id.home);

        Intent intent = getIntent();

        // Receiving User Email Send By MainActivity.
        EmailHolder = intent.getStringExtra(MainActivity.UserEmail);

        // Setting up received email to TextView.
        Email.setText(Email.getText().toString()+ EmailHolder);

        // Adding click listener to Log Out button.
        LogOUT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Finishing current DashBoard activity on button click.
                finish();

                Toast.makeText(DashboardActivity.this,"Log Out Successful", Toast.LENGTH_LONG).show();

            }
        });


        // Adding click listener to home button.
        homee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Finishing current DashBoard activity on button click.
                Intent intent = new Intent(DashboardActivity.this, home.class);
                startActivity(intent);
            }
        });





        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTxt= name.getText().toString();
                String contactTXT = contact.getText().toString();
                String dobTXT = dob.getText().toString();
                String subjectkannadaTXT = subjectkannada.getText().toString();
                String subjecthindiTXT = subjecthindi.getText().toString();
                String subjectscienceTXT = subjectscience.getText().toString();
                String subjectmathsTXT = subjectmaths.getText().toString();
                String subjectsocialTXT = subjectsocial.getText().toString();

                Boolean checkinsertdata = DB.insertuserdata(nameTxt,contactTXT,dobTXT,subjectkannadaTXT,subjecthindiTXT,subjectscienceTXT ,subjectmathsTXT ,subjectsocialTXT);
                if(checkinsertdata==true)
                    Toast.makeText(DashboardActivity.this,"New Entry Inserted",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(DashboardActivity.this,"New Entry not Inserted",Toast.LENGTH_SHORT).show();
            }
        });




        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTxt= name.getText().toString();
                String contactTXT = contact.getText().toString();
                String dobTXT = dob.getText().toString();
                String subjectkannadaTXT = subjectkannada.getText().toString();
                String subjecthindiTXT = subjecthindi.getText().toString();
                String subjectscienceTXT = subjectscience.getText().toString();
                String subjectmathsTXT = subjectmaths.getText().toString();
                String subjectsocialTXT = subjectsocial.getText().toString();

                Boolean checkupdatedata = DB.updateuserdata(nameTxt,contactTXT,dobTXT,subjectkannadaTXT,subjecthindiTXT,subjectscienceTXT ,subjectmathsTXT ,subjectsocialTXT);
                if(checkupdatedata==true)
                    Toast.makeText(DashboardActivity.this,"Entry Updated",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(DashboardActivity.this,"New Entry not Updated",Toast.LENGTH_SHORT).show();
            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTxt= name.getText().toString();


                Boolean checkdeletedata = DB.deletedata(nameTxt);
                if(checkdeletedata==true)
                    Toast.makeText(DashboardActivity.this,"Entry Deleted",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(DashboardActivity.this,"New Entry not Deleted",Toast.LENGTH_SHORT).show();
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = DB.getdata();
                if (res.getCount()==0) {
                    Toast.makeText(DashboardActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Name :"+res.getString(0)+"\n");
                    buffer.append("Roll no :"+res.getString(1)+"\n");
                    buffer.append("English :"+res.getString(2)+"\n");
                    buffer.append("kannada :"+res.getString(3)+"\n");
                    buffer.append("Hindi :"+res.getString(4)+"\n");
                    buffer.append("Science :"+res.getString(5)+"\n");
                    buffer.append("Maths :"+res.getString(6)+"\n");
                    buffer.append("Social Science :"+res.getString(7)+"\n");
                    //semester1 grade
                    buffer.append("Unit-Test1:"+res.getString(8)+"\n");
                    buffer.append("Unit-Test2:"+res.getString(9)+"\n");
                    buffer.append("Semester1:"+res.getString(10)+"\n");
                    buffer.append("Semester1-Total:"+res.getString(11)+"\n");
                    //semestre2 grade
                    buffer.append("Unit-Test3:"+res.getString(12)+"\n");
                    buffer.append("Unit-Test4:"+res.getString(13)+"\n");
                    buffer.append("Semester2:"+res.getString(14)+"\n");
                    buffer.append("Semester2-Total:"+res.getString(15)+"\n\n\n");
                    //buffer.append("Total:"+res.getString(16)+"\n\n");

                }
                AlertDialog.Builder builder = new AlertDialog.Builder(DashboardActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Student Details Entered");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });


        //unit test 1
        btnViewunit1results.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = DB.unittest1result();
                if (res.getCount()==0) {
                    Toast.makeText(DashboardActivity.this, "Unit Test 1 Calculated", Toast.LENGTH_SHORT).show();
                    return;
                }

            }
        });

        //unit test 2
        unittest2result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = DB.unittest2result();
                if (res.getCount()==0) {
                    Toast.makeText(DashboardActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

        //unit test 3
        unittest3result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = DB.unittest3result();
                if (res.getCount()==0) {
                    Toast.makeText(DashboardActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });



        //unit test 4
        unittest4result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = DB.unittest4result();
                if (res.getCount()==0) {
                    Toast.makeText(DashboardActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });


        //Semester 1
        btnViewSem1results.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = DB.semmesterresult1();
                if (res.getCount()==0) {
                    Toast.makeText(DashboardActivity.this, "Semester Marks Calculated", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

        //Semester 1 grade
        btnViewSem1gradee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = DB.semmestergrade1();
                if (res.getCount()==0) {
                    Toast.makeText(DashboardActivity.this, "Total Semester Marks Calculated", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

        //Semester 2
        btnViewSem1results.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = DB.semmesterresult2();
                if (res.getCount()==0) {
                    Toast.makeText(DashboardActivity.this, "Semester Marks Calculated", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

        //Semester 2 total
        btnViewSem1gradee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = DB.semmestergrade2();
                if (res.getCount()==0) {
                    Toast.makeText(DashboardActivity.this, "Total Semester Marks Calculated", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

    }
}

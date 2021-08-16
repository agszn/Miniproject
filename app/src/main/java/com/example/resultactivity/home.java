package com.example.resultactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ajts.androidmads.library.ExcelToSQLite;
import com.ajts.androidmads.library.SQLiteToExcel;

import java.io.File;

public class home extends AppCompatActivity {

    Button logouT, chatboT, calculatE,prinT;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        DB = new DBHelper(this);

        logouT = (Button)findViewById(R.id.logout);
        chatboT = (Button)findViewById(R.id.chatbot);
        calculatE = (Button)findViewById(R.id.calculate);
        prinT = (Button)findViewById(R.id.print);

        // Adding click listener to Log Out button.
        logouT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Finishing current DashBoard activity on button click.
                Intent intent = new Intent(home.this, MainActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(home.this,"Log Out Successful", Toast.LENGTH_LONG).show();

            }
        });

        // back to calculate
        calculatE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Finishing current DashBoard activity on button click.
                Intent intent = new Intent(home.this, DashboardActivity.class);
                startActivity(intent);
            }
        });

        // Video
        prinT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Finishing current DashBoard activity on button click.
                Intent intent = new Intent(home.this, MainActivity3.class);
                startActivity(intent);
            }
        });

        // Formulas
        chatboT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Finishing current DashBoard activity on button click.
                Intent intent = new Intent(home.this, calculate.class);
                startActivity(intent);
            }
        });

    }


}

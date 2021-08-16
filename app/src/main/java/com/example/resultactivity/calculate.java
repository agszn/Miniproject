package com.example.resultactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class calculate extends AppCompatActivity {

    Button logouT, calculatE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        logouT = (Button)findViewById(R.id.logout);
        calculatE = (Button)findViewById(R.id.calculate);

        // Adding click listener to Log Out button.
        logouT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Finishing current DashBoard activity on button click.
                Intent intent = new Intent(calculate.this, MainActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(calculate.this,"Log Out Successful", Toast.LENGTH_LONG).show();

            }
        });

        // back to calculate
        calculatE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Finishing current DashBoard activity on button click.
                Intent intent = new Intent(calculate.this, DashboardActivity.class);
                startActivity(intent);
            }
        });

    }
}
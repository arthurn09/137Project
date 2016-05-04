package com.example.arthurnguyen.cmpe137project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Trade extends AppCompatActivity {

    Button bSend, bReceive;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trade);

        bSend = (Button) findViewById(R.id.bSend);
        bReceive = (Button) findViewById(R.id.bReceive);

//        Send data
        bSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });

//        Receive data
        bReceive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}

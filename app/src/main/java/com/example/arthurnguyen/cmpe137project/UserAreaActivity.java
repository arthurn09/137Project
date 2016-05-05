package com.example.arthurnguyen.cmpe137project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;


public class UserAreaActivity extends AppCompatActivity{

    Button bCollection, bSync, bTrade, bChat, bPurchase;
    Toolbar mToolbar;
    Boolean design1, design2, design3;
    int currentDesign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        //Bundle extras = getIntent().getExtras();
        //String name = getIntent().getExtras().getString("name");
        //String name = extras.getString("name");
        //String username = extras.getString("username");
        //int age = extras.getInt("age", -1);

        TextView tvWelcomeMsg = (TextView) findViewById(R.id.tvWelcomeMsg);
        EditText etUsername = (EditText) findViewById(R.id.etUsername);
        EditText etAge = (EditText) findViewById(R.id.etAge);

        setTitle("eKandi");
//        Buttons
        bCollection = (Button) findViewById(R.id.bCollection);
        bSync = (Button) findViewById(R.id.bSync);
        bTrade = (Button) findViewById(R.id.bTrade);
        bChat = (Button) findViewById(R.id.bChat);
        bPurchase = (Button) findViewById(R.id.bPurchase);

//        Listeners
//        Collection button
        bCollection.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent1 = new Intent(UserAreaActivity.this, Collection.class);
                intent1.putExtra("design1", design1);
                intent1.putExtra("currentDesign", currentDesign);
                intent1.putExtra("design2", design2);
                intent1.putExtra("design3", design3);
                startActivity(intent1);
            }
        });
//        Purchase Button
        bPurchase.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent1 = new Intent(UserAreaActivity.this, Purchase.class);
                intent1.putExtra("currentDesign", currentDesign);
                intent1.putExtra("design1", design1);
                intent1.putExtra("design2", design2);
                intent1.putExtra("design3", design3);
                startActivity(intent1);
            }
        });
        //        Chat Button
        bChat.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent1 = new Intent(UserAreaActivity.this, Chat.class);
                startActivity(intent1);
            }
        });
        //        Sync Button
        bSync.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent1 = new Intent(UserAreaActivity.this, Sync.class);
                intent1.putExtra("currentDesign", currentDesign);
                startActivity(intent1);
            }
        });
        //        Trade Button
        bTrade.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent1 = new Intent(UserAreaActivity.this, Trade.class);
                startActivity(intent1);
            }
        });

        // Display user details
        //String message = name + " welcome to your user area";
        //tvWelcomeMsg.setText(message);
        //etUsername.setText(username);
        //etAge.setText(age + "");

        // Accept data
        Bundle extras = getIntent().getExtras();
        if(extras == null){
            return;
        }
        design1 = getIntent().getExtras().getBoolean("design1");
        design2 = getIntent().getExtras().getBoolean("design2");
        design3 = getIntent().getExtras().getBoolean("design3");
        currentDesign = extras.getInt("currentDesign", 1);
        if(currentDesign == 1){
            Toast.makeText(UserAreaActivity.this, "Current design: Squirtle", Toast.LENGTH_SHORT).show();
        }
        if(currentDesign == 2){
            Toast.makeText(UserAreaActivity.this, "Current design: Bulbasaur", Toast.LENGTH_SHORT).show();
        }
        if(currentDesign == 3){
            Toast.makeText(UserAreaActivity.this, "Current deisgn: Charmander", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_user_area, menu);
        return super.onCreateOptionsMenu(menu);
    }


}


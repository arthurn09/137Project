package com.example.arthurnguyen.cmpe137project;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Collection extends AppCompatActivity{

    //    Initializations
    boolean design1, design2, design3;
    ImageButton bDesign1, bDesign2, bDesign3;
    int currentDesign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);

        bDesign1 = (ImageButton) findViewById(R.id.bDesign1);
        bDesign2 = (ImageButton) findViewById(R.id.bDesign2);
        bDesign3 = (ImageButton) findViewById(R.id.bDesign3);
        setTitle("Collection");


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
            bDesign1.setColorFilter(Color.argb(0, 0, 0, 0));
        }
        else{
            if(!design1){
                bDesign1.setColorFilter(Color.argb(247, 247, 247, 247));
            }
            else{
                bDesign1.setColorFilter(Color.argb(150, 150, 150, 150));
            }
        }

        if(currentDesign == 2){
            bDesign2.setColorFilter(Color.argb(0, 0, 0, 0));
        }
        else{
            if(!design2){
                bDesign2.setColorFilter(Color.argb(247, 247, 247, 247));
            }
            else{
                bDesign2.setColorFilter(Color.argb(150, 150, 150, 150));
            }
        }

        if(currentDesign == 3){
            bDesign3.setColorFilter(Color.argb(0, 0, 0, 0));
        }
        else{
            if(!design3){
                bDesign3.setColorFilter(Color.argb(247, 247, 247, 247));
            }
            else{
                bDesign3.setColorFilter(Color.argb(150, 150, 150, 150));
            }
        }
        bDesign1.setOnClickListener(new View.OnClickListener(){
            @Override
        public void onClick(View view){
              if(design1 == true){
                  bDesign1.setColorFilter(Color.argb(0, 0, 0, 0));
                  if(!design2){
                      bDesign2.setColorFilter(Color.argb(247, 247, 247, 247));
                  }
                  else{
                      bDesign2.setColorFilter(Color.argb(150, 150, 150, 150));
                  }
                  if(!design3){
                      bDesign3.setColorFilter(Color.argb(247, 247, 247, 247));
                  }
                  else{
                      bDesign3.setColorFilter(Color.argb(150, 150, 150, 150));
                  }
                  Toast.makeText(Collection.this,"Current design set to Squirtle",Toast.LENGTH_SHORT).show();
                  currentDesign = 1;
              }
            }
        });
        bDesign2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(design2 == true){
                    bDesign2.setColorFilter(Color.argb(0, 0, 0, 0));
                    if(!design1){
                        bDesign1.setColorFilter(Color.argb(247, 247, 247, 247));
                    }
                    else{
                        bDesign1.setColorFilter(Color.argb(150, 150, 150, 150));
                    }
                    if(!design3){
                        bDesign3.setColorFilter(Color.argb(247, 247, 247, 247));
                    }
                    else{
                        bDesign3.setColorFilter(Color.argb(150, 150, 150, 150));
                    }
                    Toast.makeText(Collection.this,"Current design set to Bulbasaur",Toast.LENGTH_SHORT).show();
                    currentDesign = 2;
                }
            }
        });
        bDesign3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(design3 == true){
                    bDesign3.setColorFilter(Color.argb(247, 247, 247, 247));
                    if(!design1){
                        bDesign1.setColorFilter(Color.argb(247, 247, 247, 247));
                    }
                    else{
                        bDesign1.setColorFilter(Color.argb(150, 150, 150, 150));
                    }
                    if(!design3){
                        bDesign3.setColorFilter(Color.argb(247, 247, 247, 247));
                    }
                    else{
                        bDesign3.setColorFilter(Color.argb(150, 150, 150, 150));
                    }
                    Toast.makeText(Collection.this,"Current design set to Charmander",Toast.LENGTH_SHORT).show();
                    currentDesign = 3;
                }
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_user_area, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.home_id:

//                    Start activity
                Intent intent = new Intent(this, UserAreaActivity.class);
//                    Pass values
                intent.putExtra("design1", design1);
                intent.putExtra("design2", design2);
                intent.putExtra("design3", design3);
                intent.putExtra("currentDesign", currentDesign);
                startActivity(intent);

        }
        return true;
    }

    @Override
    public void onBackPressed() {
        //                    Start activity
        Intent intent = new Intent(this, UserAreaActivity.class);
//                    Pass values
        intent.putExtra("design1", design1);
        intent.putExtra("design2", design2);
        intent.putExtra("design3", design3);
        intent.putExtra("currentDesign", currentDesign);
        startActivity(intent);
        super.onBackPressed();
    }

}

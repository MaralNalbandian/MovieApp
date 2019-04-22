package com.example.tanmay.bingeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class GenreSelect extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_genres);
        Button showFilmsButton = (Button) findViewById(R.id.showFilmsButton);
        showFilmsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openFilms();
            }
        });
    }

    public void openFilms(){
        Intent openFilmView = new Intent(GenreSelect.this, MovieScreen.class);
        startActivity(openFilmView);
    }
}

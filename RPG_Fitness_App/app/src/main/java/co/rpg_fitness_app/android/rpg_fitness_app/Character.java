package co.rpg_fitness_app.android.rpg_fitness_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Character extends AppCompatActivity {


    private String name;
    private Species mySpecies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);
    }



}

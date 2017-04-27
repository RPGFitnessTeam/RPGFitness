package co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

import co.rpg_fitness_app.android.rpg_fitness_app.R;
import co.rpg_fitness_app.android.rpg_fitness_app.character_Package.CharacterActivity;
import co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package.DataSource;
import co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package.KingdomActivity;
import co.rpg_fitness_app.android.rpg_fitness_app.quest_Package.QuestActivity;


public class FitnessLogActivity extends AppCompatActivity {

    DataSource mDatasource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__fitness_log);

        //Add new LogEntry
        ((Button) findViewById(R.id.button_add_activity)).setOnClickListener(
                new Button.OnClickListener()
                {
                    @Override
                    public void onClick(View v) {

                        android.app.FragmentManager fm = getFragmentManager();
                        AddLogTypeDialogFragment dF = new AddLogTypeDialogFragment();
                        dF.show(fm, "idgoal");
                    }
                }

        );

        configureToolBarButtons();
    }

    private void configureToolBarButtons() {
        ImageButton b;
        b = (ImageButton) findViewById(R.id.questFooterButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FitnessLogActivity.this, QuestActivity.class);
                startActivity(i);
                finish();
            }
        });
        b = (ImageButton) findViewById(R.id.fitnessLogFooterButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FitnessLogActivity.this, FitnessLogActivity.class);
                startActivity(i);
                finish();
            }
        });
        b = (ImageButton) findViewById(R.id.tipsFooterButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FitnessLogActivity.this, TipMaster.class);
                startActivity(i);
                finish();
            }
        });
        b = (ImageButton) findViewById(R.id.kingdomFooterButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FitnessLogActivity.this, KingdomActivity.class);
                startActivity(i);
                finish();
            }
        });
        b = (ImageButton) findViewById(R.id.goalsFooterButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FitnessLogActivity.this, GoalActive.class);
                startActivity(i);
                finish();
            }
        });
        b = (ImageButton) findViewById(R.id.characterFooterButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FitnessLogActivity.this, CharacterActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

}




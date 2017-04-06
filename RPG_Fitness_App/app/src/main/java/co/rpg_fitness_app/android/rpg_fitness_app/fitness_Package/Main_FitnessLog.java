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
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

import co.rpg_fitness_app.android.rpg_fitness_app.R;



public class Main_FitnessLog extends AppCompatActivity {

    FitnessLog duya = new FitnessLog();
    //Todo: create List view from fitnessLog

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_create_goal_main);
        setContentView(R.layout.activity_main__fitness_log);


        //FitnessLog fitnessLog = new FitnessLog();

        //Add new LogEntry
        ((Button) findViewById(R.id.button_add_activity)).setOnClickListener(
                new Button.OnClickListener()
                {
                    @Override
                    public void onClick(View v) {

                        android.app.FragmentManager fm = getFragmentManager();
                        AddLogTypeDialogFragment dF = new AddLogTypeDialogFragment();
                       // AddGoalLogType dF = new AddGoalLogType();
                        dF.show(fm, "idgoal");
                    }
                }

        );

    }

}




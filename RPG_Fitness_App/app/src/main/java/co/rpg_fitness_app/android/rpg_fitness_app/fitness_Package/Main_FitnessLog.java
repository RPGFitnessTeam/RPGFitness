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
import co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package.DataSource;


public class Main_FitnessLog extends AppCompatActivity {

    DataSource mDatasource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__fitness_log);
        mDatasource = new DataSource(this);
        mDatasource.upgrade();

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

    }

}




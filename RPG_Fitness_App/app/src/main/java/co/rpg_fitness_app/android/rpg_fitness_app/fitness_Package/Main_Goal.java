package co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import co.rpg_fitness_app.android.rpg_fitness_app.R;

/**
 * Created by duya on 4/4/17.
 */

public class Main_Goal extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__fitness_log);

        FitnessLog fitnessLog = new FitnessLog();

        //Add new LogEntry
        ((Button) findViewById(R.id.button_add_activity)).setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        android.app.FragmentManager fm = getFragmentManager();
                        AddLogTypeDialogFragment dF = new AddLogTypeDialogFragment();
                        dF.show(fm, "Duya");

                    }
                }
        );


    }
}
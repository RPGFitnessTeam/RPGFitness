package co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package;

import co.rpg_fitness_app.android.rpg_fitness_app.R;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

public class MainActivityFitness extends AppCompatActivity {

    private TextView list_days;
    private TextView temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__fitness_log);

        list_days = (TextView) findViewById(R.id.days);

        FitnessLog fitness_log = new FitnessLog();

        List<LogEntry> logged_entries = fitness_log.retrieveLogEntries();

        int num_entry = logged_entries.size();

    }
    private void add_log()
    {
        Button add = (Button) findViewById(R.id.button);
        add.setOnClickListener(new View.OnClickListener(){
          public void onClick (View v)
          {
            // Show Activity Options
          }
        }
        );
        Button Nutrition = (Button) findViewById(R.id.add_nutrition);
        add.setOnClickListener(new View.OnClickListener(){
                                   public void onClick (View v)
                                   {
                                       // Show SubActivity Option
                                   }
                               }
        );
        Button Sleep = (Button) findViewById(R.id.add_sleep);
        add.setOnClickListener(new View.OnClickListener(){
                                   public void onClick (View v)
                                   {
                                       // Show SubActivity Options
                                   }
                               }
        );
        Button Fitness = (Button) findViewById(R.id.add_fitness);
        add.setOnClickListener(new View.OnClickListener(){
                                   public void onClick (View v)
                                   {
                                       // Show SubActivity Options
                                   }
                               }
        );
        Button Weight = (Button) findViewById(R.id.add_weight);
        add.setOnClickListener(new View.OnClickListener(){
                                   public void onClick (View v)
                                   {
                                       // Show SubActivity Options
                                   }
                               }
        );


    }
}

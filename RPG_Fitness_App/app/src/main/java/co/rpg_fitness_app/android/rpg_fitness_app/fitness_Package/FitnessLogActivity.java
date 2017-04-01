package co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.HashMap;
import java.util.List;

import co.rpg_fitness_app.android.rpg_fitness_app.R;

public class FitnessLogActivity extends AppCompatActivity {

    ExpandableListView expandableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FitnessLog fitness_log = new FitnessLog();
        List<LogEntry> logEntries = fitness_log.retrieveLogEntries();

        expandableListView = (ExpandableListView) findViewById(R.id.expand_list);
        List<String> dates = null; // set to date string

        HashMap<String, List<LogEntry>> logentryList = new HashMap<String, List<LogEntry>>(30);

        // set up the Hash Map here

        FitnessLogAdapter adapt = new FitnessLogAdapter(dates, logentryList, this);
        expandableListView.setAdapter(adapt);
    }

}

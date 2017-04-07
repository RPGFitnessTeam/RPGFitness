package co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.rpg_fitness_app.android.rpg_fitness_app.R;

public class GoalActive extends AppCompatActivity {

    List<Goal> goalList = new ArrayList<Goal>();
    private ImageButton editButton;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goal_main);
        // Setting toolbar for displaying "My Goals"
        Toolbar mToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        mToolbar.setTitle("My Goals");
        setSupportActionBar(mToolbar);
        // Example Data. Will be data from database eventually
        LogEntry lg0 = new LogEntry(UUID.randomUUID().toString(), 2);
        LogEntry lg1 = new LogEntry(UUID.randomUUID().toString(), 4);
        LogEntry lg2 = new LogEntry(UUID.randomUUID().toString(), 4);
        LogEntry lg3 = new LogEntry(UUID.randomUUID().toString(), 1);
        LogEntry lg4 = new LogEntry(UUID.randomUUID().toString(), 3);
        Goal goal = new Goal(lg0, UUID.randomUUID().toString(), 0, 3, 6, false, false, false);
        goalList.add(goal);
        Goal goal1 = new Goal(lg1, UUID.randomUUID().toString(), 0, 1, 4, false, false, false);
        goalList.add(goal1);
        Goal goal2 = new Goal(lg2, UUID.randomUUID().toString(), 0, 0, 5, false, false, false);
        goalList.add(goal2);
        Goal goal3 = new Goal(lg3, UUID.randomUUID().toString(), 0, 3, 9, false, false, false);
        goalList.add(goal3);
        Goal goal4 = new Goal(lg4, UUID.randomUUID().toString(), 0, 7, 8, false, false, false);
        goalList.add(goal4);
        // Setting up the custom adapter for the list of goals
        GoalAdapter glAdapt = new GoalAdapter(goalList, this, false);
        ListView listView = (ListView)findViewById(R.id.goal_listview);
        listView.setAdapter(glAdapt);

        editButton = (ImageButton)findViewById(R.id.edit_button);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GoalActive.this, Edit_Goal_Main.class);
                startActivity(intent);
            }
        });
    }

}

        //Add new LogEntry
        ((Button) findViewById(R.id.button_create_goal)).setOnClickListener(
                new Button.OnClickListener()
                {
                    @Override
                    public void onClick(View v) {

                        android.app.FragmentManager fm = getFragmentManager();
                        AddGoalLogType dF = new AddGoalLogType();
                        dF.show(fm, "idgoal");
                    }
                }

        );

    }
}


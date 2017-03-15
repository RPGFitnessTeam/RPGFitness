package co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import co.rpg_fitness_app.android.rpg_fitness_app.R;

public class GoalActive extends AppCompatActivity {

        List<Goal> goalList = new ArrayList<Goal>();
        ProgressBar prg;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout parent = (LinearLayout) inflater.inflate(R.layout.goal_main,
                null);

//        Goal goal1 = new Goal("Swim 4 times this fortnight", 0, 1, 4, false, false);
//        goalList.add(goal1);
//        Goal goal = new Goal("Run 6 miles this week", 0, 3, 6, false, false);
//        goalList.add(goal);
        for (int i = 0; i < goalList.size(); i++) {
            View custom = (View) inflater.inflate(R.layout.all_goals, null);
            int progress = (int) (100 * ((double) goalList.get(i).getCurrentValue() / (double) goalList.get(i).getEndValue()));
            ProgressBar prg = (ProgressBar)custom.findViewById(R.id.goalProgress);
            prg.setProgress(progress);
            TextView textView = (TextView)custom.findViewById(R.id.goalText);
            textView.setText(goalList.get(i).getGoalId());
            parent.addView(custom);
        }
        setContentView(parent);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        mToolbar.setTitle("My Goals");
        setSupportActionBar(mToolbar);

    }
}

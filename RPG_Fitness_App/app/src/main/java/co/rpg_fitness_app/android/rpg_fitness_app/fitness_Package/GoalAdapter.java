package co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import co.rpg_fitness_app.android.rpg_fitness_app.MainActivity;
import co.rpg_fitness_app.android.rpg_fitness_app.R;
import co.rpg_fitness_app.android.rpg_fitness_app.character_Package.CharacterActivity;

/**
 * Created by Arthur Clark on 3/15/2017.
 */

//Custom Adapter class for displaying goals in a ListView
public class GoalAdapter extends BaseAdapter{
    private Context ctx;
    private List<Goal> goalList;
    private boolean isEditGoal;
    private Goal currGoal;
    private int currPosition;

    public GoalAdapter(List<Goal> goalList, Context ctx, boolean isEditGoal) {
        this.ctx = ctx;
        this.goalList = goalList;
        this.isEditGoal = isEditGoal;
    }
    @Override
    public int getCount() {

        return goalList.size();
    }

    @Override
    public Object getItem(int position) {

        return goalList.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater layoutInflate = (LayoutInflater)this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (!isEditGoal) {
                v = layoutInflate.inflate(R.layout.all_goals, null);
            }
            else {
                v = layoutInflate.inflate(R.layout.edit_goal_list, null);
            }
        }

        currGoal = goalList.get(position);

        if (currGoal != null) {
            // Integer displays percentage of goal completed
            int progress = (int) (100 * ((double) currGoal.getCurrentValue() / (double) currGoal.getEndValue()));
            if (!isEditGoal) {
                ProgressBar prg = (ProgressBar) v.findViewById(R.id.goalProgress);
                TextView textView = (TextView) v.findViewById(R.id.goalText);
                textView.setText(currGoal.getGoalActivity().getTypeName()
                        + ": " + (double) currGoal.getCurrentValue() + "/" + (double) currGoal.getEndValue());
                prg.setProgress(progress);
            }
            else {
                ProgressBar prg = (ProgressBar) v.findViewById(R.id.editGoalProgress);
                Button button = (Button) v.findViewById(R.id.edit_goal_buttons);
                button.setText(currGoal.getGoalActivity().getTypeName()
                        + ": " + (double) currGoal.getCurrentValue() + "/" + (double) currGoal.getEndValue());
                prg.setProgress(progress);
                final Goal goal = currGoal;
                button.setOnClickListener(new View.OnClickListener()
                {
                @Override

                    public void onClick(View view) {
                        Intent startIntent = new Intent(ctx, Edit_Goal_Pop_Up.class);
                //        currGoal = goalList.get(position);
                        startIntent.putExtra("goal", goal);
                        ctx.startActivity(startIntent);
                    }
                });
            }
        }

        return v;
    }
}

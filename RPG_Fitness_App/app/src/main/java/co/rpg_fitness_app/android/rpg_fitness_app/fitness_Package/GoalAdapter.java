package co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import co.rpg_fitness_app.android.rpg_fitness_app.R;

/**
 * Created by Arthur Clark on 3/15/2017.
 */

//Custom Adapter class for displaying goals in a ListView
public class GoalAdapter extends BaseAdapter{
    private Context ctx;
    private List<Goal> goalList;

    public GoalAdapter(List<Goal> goalList, Context ctx) {
        this.ctx = ctx;
        this.goalList = goalList;
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
            v = layoutInflate.inflate(R.layout.all_goals, null);
        }

        Goal goal = goalList.get(position);

        if (goal != null) {
            // Integer displays percentage of goal completed
            int progress = (int) (100 * ((double)goal.getCurrentValue() / (double)goal.getEndValue()));
            ProgressBar prg = (ProgressBar)v.findViewById(R.id.goalProgress);
            TextView textView = (TextView)v.findViewById(R.id.goalText);
            textView.setText(goal.getGoalActivity().getTypeName()
                    + ": " + (double)goal.getCurrentValue() + "/" + (double)goal.getEndValue());
            prg.setProgress(progress);
        }

        return v;
    }
}

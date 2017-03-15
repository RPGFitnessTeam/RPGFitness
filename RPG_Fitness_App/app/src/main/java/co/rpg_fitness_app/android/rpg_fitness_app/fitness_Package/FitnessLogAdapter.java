package co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import co.rpg_fitness_app.android.rpg_fitness_app.R;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by duya on 3/14/17.
 */

public class FitnessLogAdapter extends BaseExpandableListAdapter {
    private List<String> Dates;
    private HashMap<String, List<LogEntry>> logEntryMap;
    private Context ctx;

    public FitnessLogAdapter(List<String> Dates, HashMap<String, List<LogEntry>> logEntryMap, Context ctx)
    {
        this.ctx = ctx;
        this.Dates = Dates;
        this.logEntryMap = logEntryMap;
    }

    @Override
    //First List Count -- Dates
    public int getGroupCount() {
        return this.Dates.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return logEntryMap.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return Dates.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return logEntryMap.get(Dates.get(groupPosition));
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        String date = (String) this.getGroup(groupPosition);

        if(convertView == null)
        {
            LayoutInflater layoutInflate = (LayoutInflater) this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflate.inflate(R.layout.date_list, null);
        }

        TextView txtView = (TextView) convertView.findViewById(R.id.days);
        txtView.setText(date);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        LogEntry entry = (LogEntry) this.getChild(groupPosition, childPosition);

        if(convertView == null)
        {
            LayoutInflater layoutInflate = (LayoutInflater) this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflate.inflate(R.layout.logs, null);
        }

        TextView txtView = (TextView) convertView.findViewById(R.id.logs);
        txtView.setText("Set the date name here");
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}

package co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by duya on 4/6/17.
 */

public class ExpandableListAdapterFitness extends BaseExpandableListAdapter {
    private final LayoutInflater inflater;
    private ArrayList<String> groups;
    private ArrayList<ArrayList<LogEntry>> children;
    private Activity activity;

    public ExpandableListAdapterFitness(Activity activity, ArrayList<String> groups, ArrayList<ArrayList<LogEntry>>children)
    {
        this.groups = groups;
        this.children = children;
        this.activity = activity;
        inflater = activity.getLayoutInflater();
    }

    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return children.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groups.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return children.get(groupPosition).get(childPosition);
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
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        if(convertView == null)
        {
            convertView = inflater.inflate(R.layout.fragment_date, parent, false);
            TextView activity_date = (TextView) convertView.findViewById(R.id.logEntryDate);
            activity_date.setText(getGroup(groupPosition).toString());
        }
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        if(convertView == null)
        {
            convertView = inflater.inflate(R.layout.activity_date, parent, false);

            LogEntry child = (LogEntry) getChild(groupPosition, childPosition);

            TextView activityView = (TextView) convertView.findViewById(R.id.activity_date);
            activityView.setText(child.getActivity());

            if(!child.getSubType().equals("")) {
                TextView subTypeView = new TextView(inflater.getContext());
                subTypeView.setText(child.getSubType());
                ((LinearLayout) convertView).addView(subTypeView);
            }

            if(!child.getFirstDropdown().equals("")) {
                TextView firstView = new TextView(inflater.getContext());
                firstView.setText(child.getFirstDropdown());
                ((LinearLayout) convertView).addView(firstView);
            }

            if(!child.getSecondDrop().equals("")) {
                TextView secondView = new TextView(inflater.getContext());
                secondView.setText(child.getSecondDrop());
                ((LinearLayout) convertView).addView(secondView);
            }

            if(!child.getThirdDrop().equals("")) {
                TextView thirdView = new TextView(inflater.getContext());
                thirdView.setText(child.getThirdDrop());
                ((LinearLayout) convertView).addView(thirdView);
            }
        }

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}



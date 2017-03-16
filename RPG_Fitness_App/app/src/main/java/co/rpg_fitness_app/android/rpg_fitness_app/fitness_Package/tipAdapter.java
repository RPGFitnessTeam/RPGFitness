package co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package;

import android.content.Context;
import android.graphics.Typeface;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;


import java.util.HashMap;
import java.util.List;

import co.rpg_fitness_app.android.rpg_fitness_app.R;

/**
 * Created by Arthur Clark on 3/12/2017.
 */

// Custom adapter class for ExpandableListView for displaying tips
public class tipAdapter extends BaseExpandableListAdapter {
    private List<String> fitnessCategories;
    private HashMap<String,List<Tips>> tipMap;
    private Context ctx;
    public tipAdapter(Context ctx, List<String> fitnessCategories, HashMap<String,List<Tips>> tipMap)
    {
        this.ctx = ctx;
        this.fitnessCategories = fitnessCategories;
        this.tipMap = tipMap;
    }
    @Override
    public int getGroupCount() {
        return fitnessCategories.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {

        return tipMap.get(fitnessCategories.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return fitnessCategories.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return tipMap.get(fitnessCategories.get(groupPosition)).get(childPosition).getMessage();
    }

    @Override
    public long getGroupId(int i) {
        return i;
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
    public View getGroupView(int groupPosition, boolean b, View view, ViewGroup viewGroup) {
        String title = (String)this.getGroup(groupPosition);
        if (view == null) {
            LayoutInflater layoutInflate = (LayoutInflater)this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflate.inflate(R.layout.parent_layout, null);
        }

        TextView textView = (TextView)view.findViewById(R.id.heading_item);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setText(title);
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean b, View view, ViewGroup viewGroup) {
        int title = (int)this.getChild(groupPosition, childPosition);
        if (view == null) {
            LayoutInflater layoutInflate = (LayoutInflater) this.ctx.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflate.inflate(R.layout.child_layout, null);
        }
        if (childPosition == tipMap.get(fitnessCategories.get(groupPosition)).size() - 1) {
            view.setPadding(0, 0, 0, 0);
        } else
            view.setPadding(0, 0, 0, 20);

        TextView textView = (TextView)view.findViewById(R.id.child_item);
        textView.setText(title);
        textView.setMovementMethod(LinkMovementMethod.getInstance());


        return view;

    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}

package fitnessrpg.fitnessrpg;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by duya on 4/4/17.
 */

public class FragmentListDaysExpandable extends Fragment
{
    View parentView;
    ExpandableListView listView;
    private ArrayList<String> list_days;
    private ArrayList<ArrayList<LogEntry>> activities;

    public FragmentListDaysExpandable()
    {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    private int organize()
    {
        list_days = new ArrayList<String>();
        activities = new ArrayList<ArrayList<LogEntry>>();

        ArrayList<LogEntry> activity_list = FitnessLog.retrieveLogEntries();
        if(activity_list == null)
            return -1;

        //Todo: discuss initial capacity
        HashMap<String, ArrayList<LogEntry>> hashMap = new HashMap<String, ArrayList<LogEntry>>(60);


        //Todo: compare with 30 days
        //Create Hash Map first
        Iterator<LogEntry> itr = activity_list.iterator();
        while(itr.hasNext())
        {
            LogEntry temp = itr.next();
            String date = temp.getDate();

            //same date exists
            if(hashMap.containsKey(date))
            {
                hashMap.get(date).add(temp);
            }

            //new date
            else
            {
                ArrayList<LogEntry> newValue = new ArrayList<LogEntry>();
                newValue.add(temp);
                hashMap.put(date, newValue);
            }
        }

        //Create parent and children
        Iterator iterator = hashMap.entrySet().iterator();

        while(iterator.hasNext())
        {
            HashMap.Entry temp2 = (HashMap.Entry)iterator.next();
           list_days.add((String) temp2.getKey());
            ArrayList<LogEntry> tempVal = (ArrayList<LogEntry>) temp2.getValue();

            Iterator<LogEntry> itemVal = tempVal.iterator();
            ArrayList<LogEntry> itemPost = new ArrayList<LogEntry>();

            //Todo: deside what is the child view
            while(itemVal.hasNext())
            {
                LogEntry item = itemVal.next();
                //String childItem = "Duya";
                itemPost.add(item);
            }
            activities.add(itemPost);
        }

        return 0;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

       return parentView = inflater.inflate(R.layout.fragment_list_days, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(organize() == 0) ;//success;

        listView = (ExpandableListView) view.findViewById(R.id.list_days);
        listView.setAdapter(new ExpandableListAdapter(list_days, activities));

    }
    //Todo: Reload the view

    public class ExpandableListAdapter extends BaseExpandableListAdapter
    {
        private final LayoutInflater inflater;
        private ArrayList<String> groups;
        private ArrayList<ArrayList<LogEntry>> children;

        public ExpandableListAdapter(ArrayList<String> groups, ArrayList<ArrayList<LogEntry>>children)
        {
            this.groups = groups;
            this.children = children;
            inflater = LayoutInflater.from(getActivity());
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
                    TextView subTypeView = new TextView(getActivity());
                    subTypeView.setText(child.getSubType());
                    ((RelativeLayout) convertView).addView(subTypeView);
                }

                if(!child.getFirstDropdown().equals("")) {
                    TextView firstView = new TextView(getActivity());
                    firstView.setText(child.getFirstDropdown());
                    ((RelativeLayout) convertView).addView(firstView);
                }

                if(!child.getSecondDrop().equals("")) {
                    TextView secondView = new TextView(getActivity());
                    secondView.setText(child.getSecondDrop());
                    ((RelativeLayout) convertView).addView(secondView);
                }

                if(!child.getThirdDrop().equals("")) {
                    TextView thirdView = new TextView(getActivity());
                    thirdView.setText(child.getThirdDrop());
                    ((RelativeLayout) convertView).addView(thirdView);
                }
            }

            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
    }

}

package co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
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
import co.rpg_fitness_app.android.rpg_fitness_app.R;
/**
 * Created by duya on 4/4/17.
 */

public class FragmentListDaysExpandable extends Fragment
{
    private View parentView;
    private static ExpandableListView listView;
    private static ArrayList<String> list_days;
    private static ArrayList<ArrayList<LogEntry>> activities;
    private static Activity activityThis;
    public FragmentListDaysExpandable()
    {

    }


    public static ExpandableListView getListView()
    {
        return listView;
    }
    public static Activity getActivityUpdate()
    {
        return activityThis;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    public static ArrayList<String> getList_days()
    {
        return list_days;
    }

    public static ArrayList<ArrayList<LogEntry>> getActivities()
    {
        return activities;
    }

    public static int organize()
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
        activityThis = getActivity();
        if(organize() == 0) ;//success;
        listView = (ExpandableListView) view.findViewById(R.id.list_days);
        listView.setAdapter(new ExpandableListAdapterFitness(getActivity(), list_days, activities));

    }

}

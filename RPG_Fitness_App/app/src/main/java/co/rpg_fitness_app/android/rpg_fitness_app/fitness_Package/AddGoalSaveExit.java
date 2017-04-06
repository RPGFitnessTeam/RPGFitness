package co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package;

/**
 * Created by duya on 4/4/17.
 */



import android.app.Activity;
import android.app.DialogFragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

import co.rpg_fitness_app.android.rpg_fitness_app.R;

/**
 * Created by duya on 4/4/17.
 */

public class AddGoalSaveExit extends DialogFragment {

    private int activity;
    private int subType;
    private int thirdType;
    private int secondType;
    private String firstType;
    private int initialValue;
    private int finalValue;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.firstType = getArguments().getString("firstType");
        this.activity = getArguments().getInt("activity");
        this.subType = getArguments().getInt("subType");
        this.secondType = getArguments().getInt("secondType");
        this.thirdType = getArguments().getInt("thirdType");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rV = inflater.inflate(R.layout.add_activity, container, false);

        createInitial(rV);
        createFinal(rV);
        save_exit(rV);

        return rV;
    }


    private void save_exit(View rV)
    {
        final Button save = (Button) new Button(getActivity());
        save.setText("Save");
        save.setTypeface(null, Typeface.BOLD);
        ((LinearLayout) rV).addView(save);
        Button exit = (Button) new Button(getActivity());
        exit.setText("Exit");
        exit.setTypeface(null, Typeface.BOLD);
        ((LinearLayout) rV).addView(exit);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LogEntry new_log = new LogEntry("ID", activity);

                if(activity == 0 || activity == 1) new_log.setSubtype(subType);


                if(activity == 0) {
                    new_log.setFirstDropdownValues(firstType);
                }

                new_log.setSecondDropdownValues(secondType);

                if((activity == 0 && (subType == 0 || subType == 2)) || activity == 2 )
                {
                    new_log.setThirdDropdownValues(thirdType);
                }

                new_log.setDate(Calendar.getInstance().getTimeInMillis());

                //Todo: goalID uunknown, currentVal = 0?
                String goalId = "to be decided";
                int currentValue = 0;
                Goal newGoal = new Goal(new_log, goalId, initialValue, currentValue, finalValue, false, false, false );

                //Todo: save to goal data base

                dismiss();


            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // do nothing
                dismiss();
            }
        });

    }

    private void createInitial(View rV)
    {
        TextView typeInitial = new TextView(getActivity());
        typeInitial.setText("Enter Initial Value");

        typeInitial.setTypeface(null, Typeface.BOLD);

        ((LinearLayout) rV).addView(typeInitial);

        String[] initialVal = {"0","10", "20", "30", "40", "50"};
        Spinner initialSpin = new Spinner(getActivity());
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, initialVal);
        initialSpin.setAdapter(adapter);
        ((LinearLayout) rV).addView(initialSpin);

        initialSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> parent, View v, int pos, long id)
            {
                Object item = parent.getItemAtPosition(pos);
                initialValue = Integer.parseInt(item.toString().replaceAll("[^0-9]", ""));
            }
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });
    }
    private void createFinal(View rV)
    {
        TextView typeInitial = new TextView(getActivity());
        typeInitial.setText("Enter Final Value");

        typeInitial.setTypeface(null, Typeface.BOLD);

        ((LinearLayout) rV).addView(typeInitial);

        String[] finalVal = {"0","10", "20", "30", "40", "50"};
        Spinner finalSpin = new Spinner(getActivity());
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, finalVal);
        finalSpin.setAdapter(adapter);
        ((LinearLayout) rV).addView(finalSpin);

        finalSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> parent, View v, int pos, long id)
            {
                Object item = parent.getItemAtPosition(pos);
                finalValue = Integer.parseInt(item.toString().replaceAll("[^0-9]", ""));
            }
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });
    }
}

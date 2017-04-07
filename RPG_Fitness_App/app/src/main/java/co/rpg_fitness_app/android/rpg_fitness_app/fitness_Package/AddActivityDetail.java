package co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package;


import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Typeface;
import android.hardware.input.InputManager;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

import co.rpg_fitness_app.android.rpg_fitness_app.R;
import co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package.DataSource;

/**
 * Created by duya on 4/6/17.
 */

public class AddActivityDetail extends DialogFragment {
    private int activity;
    private int subType = 0;
    private int thirdType = 0;
    private int secondType = 0;
    private String firstType = null;
    private EditText editView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.activity = getArguments().getInt("activity");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rV = inflater.inflate(R.layout.add_activity, container, false);

        TextView activityTypeView = new TextView(getActivity());
        switch (activity)
        {
            case 0:
                activityTypeView.setText("Fitness");
                break;
            case 1:
                activityTypeView.setText("Nutrition\n");
                break;
            case 2:
                activityTypeView.setText("Sleep\n");
                break;
            case 3:
                activityTypeView.setText("Weight\n");
                break;
        }
        activityTypeView.setTypeface(null, Typeface.BOLD);
        activityTypeView.setTextAppearance(getActivity(), android.R.style.TextAppearance_Medium);
        ((LinearLayout) rV).addView(activityTypeView);

        if(activity == 0 || activity == 1) {
            createSubTypeView(rV);
        }
        else if(activity == 2)
        {
            createSecondDropView(rV);
            createThirdDropView(rV);
            save_exit(rV);
        }
        else
        {
            createSecondDropView(rV);
            save_exit(rV);
        }



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

                LogEntry new_log = new LogEntry(UUID.randomUUID().toString(), activity);

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

                DataSource mDatasource = new DataSource(getActivity());
                mDatasource.open();
              //  System.out.println(new_log.getSubTypeInt() + new_log.getFirstDropdown() + new_log.getDate() + new_log.getDate() +"");
                mDatasource.insertLogEntry(new_log);
                FitnessLog.update(mDatasource.getAllLogEntries());
                dismiss();

                //Update the ListView
                ExpandableListView ref = FragmentListDaysExpandable.getListView();
                Activity act = FragmentListDaysExpandable.getActivityUpdate();
                FragmentListDaysExpandable.organize(mDatasource.getAllLogEntries());
                ref.setAdapter(new ExpandableListAdapterFitness
                        (act, FragmentListDaysExpandable.getList_days(),
                                FragmentListDaysExpandable.getActivities() ));


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
    private void createSubTypeView(View rV)
    {

        TextView type = new TextView(getActivity());
        type.setText("Select Type");
        type.setTypeface(null, Typeface.BOLD);
        ((LinearLayout) rV).addView(type);

        String[] subTypes = LogEntry.getSubtypes(this.activity);
        for(int i = 0; i < subTypes.length; i++)
        {
            CheckBox box = new CheckBox(getActivity());
            box.setId(i);
            box.setText(subTypes[i]);
            box.setOnClickListener(onSubType(box, rV));
            ( (LinearLayout) rV).addView(box);

        }
    }
    View.OnClickListener onSubType(final Button button, final View rV) {

        return new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                subType = button.getId();
                switch (activity)
                {
                    case 0:
                        createFirstDropView(rV);
                        createSecondDropView(rV);
                        if(subType == 0 || subType == 2)
                        {
                            createThirdDropView(rV);
                        }
                        save_exit(rV);
                        break;

                    case 1:
                        createSecondDropView(rV);
                        save_exit(rV);
                        break;

                    default:break;
                }
            }
        };
    }
    private void createFirstDropView(View rV)
    {
        TextView type = new TextView(getActivity());
        switch(this.subType)
        {
            case 0:  type.setText("Type of Recreation");
                break;
            case 1:  type.setText("Type of Calisthenics");
                break;
            case 2:  type.setText("Type of Aerobics");
                break;
            case 3:  type.setText("Body Part targeted during lifting");
                break;
            default:break;
        }
        type.setTypeface(null, Typeface.BOLD);

        ((LinearLayout) rV).addView(type);
        editView = new EditText(getActivity());
        ((LinearLayout) rV).addView(editView);

        editView.setInputType(0);

        editView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                firstType = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
    private void createSecondDropView(View rV)
    {
        TextView type = new TextView(getActivity());
        switch(this.activity)
        {
            case 0 :
            {
                switch(this.subType) {
                    case 0:
                        type.setText("Enter Duration");
                        break;
                    case 1:
                        type.setText("Enter Duration/Count");
                        break;
                    case 2:
                        type.setText("Enter Distance");
                        break;
                    case 3:
                        type.setText("Enter Intensity");
                        break;
                    default: break;
                }
                break;
            }
            case 1 :
            {
                switch(this.subType)
                {
                    case 0:
                        type.setText("Enter Servings");
                        break;
                    case 1:
                        type.setText("Enter Glasses");
                        break;
                    case 2:
                        type.setText("Enter Servings");
                        break;
                    default: break;
                }
                break;
            }
            case 2 :
            {
                type.setText("Enter Quality of Sleep");
                break;
            }
            case 3 : {
                type.setText("Enter Current Weight");
                break;
            }
            default : break;
        }
        type.setTypeface(null, Typeface.BOLD);
        ((LinearLayout) rV).addView(type);
        String[] secondDrop = LogEntry.getSecondDropdownValues(this.activity, this.subType);
        Spinner secondSpin = new Spinner(getActivity());
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, secondDrop);
        secondSpin.setAdapter(adapter);
        ((LinearLayout) rV).addView(secondSpin);

        secondSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> parent, View v, int pos, long id)
            {
                Object item = parent.getItemAtPosition(pos);
                secondType = Integer.parseInt(item.toString().replaceAll("[^0-9]", ""));
            }
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });
    }

    private void createThirdDropView(View rV)
    {

        TextView type = new TextView(getActivity());
        switch(this.activity)
        {
            case 0 :
            {
                switch(this.subType) {
                    case 0:
                        type.setText("Enter Intensity");
                        break;
                    case 2:
                        type.setText("Enter Duration");
                        break;
                    default: break;
                }
                break;
            }
            case 2 :
            {
                type.setText("Enter Duration");
                break;
            }
            default: break;
        }
        type.setTypeface(null, Typeface.BOLD);

        ((LinearLayout) rV).addView(type);

        String[] thirdDrop = LogEntry.getThirdDropdownValues(this.activity, this.subType);
        Spinner thirdSpin = new Spinner(getActivity());
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, thirdDrop);
        thirdSpin.setAdapter(adapter);
        ((LinearLayout) rV).addView(thirdSpin);
        thirdSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> parent, View v, int pos, long id)
            {
                Object item = parent.getItemAtPosition(pos);
                thirdType = Integer.parseInt(item.toString().replaceAll("[^0-9]", ""));
            }
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });
    }
}

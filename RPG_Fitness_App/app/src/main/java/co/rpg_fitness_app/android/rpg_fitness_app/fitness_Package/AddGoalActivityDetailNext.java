package co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package;


import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Typeface;
import android.hardware.input.InputManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
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
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import co.rpg_fitness_app.android.rpg_fitness_app.R;

import co.rpg_fitness_app.android.rpg_fitness_app.R;

/**
 * Created by duya on 4/6/17.
 */

public class AddGoalActivityDetailNext extends DialogFragment {
    private int activity;
    private int subType = 0;
    private int thirdType = 0;
    private int secondType = 0;
    private String firstType = null;
    private int finalValue = 0;
    private int initialValue = 0;
    private EditText editView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.activity = getArguments().getInt("activity");
        this.subType = getArguments().getInt("subType");
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
            createNext(rV);
        }
        else
        {
            createSecondDropView(rV);
            createNext(rV);
        }



        return rV;

    }
    private void createNext(View rV)
    {

        Button next = new Button(getActivity());
        next.setText("Next");
        next.setTypeface(null, Typeface.BOLD);
        ((LinearLayout) rV).addView(next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                android.app.FragmentManager fm = getFragmentManager();

                DialogFragment dF = new AddGoalSaveExit();
                Bundle argument = new Bundle();
                argument.putInt("thirdType", thirdType);
                argument.putInt("secondType",secondType );
                argument.putString("firstType", firstType);
                argument.putInt("subType", subType);
                argument.putInt("activity", activity );
                dF.setArguments(argument);
                dF.show(fm, "saveexit");
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

        CheckBox box = new CheckBox(getActivity());
        box.setId(subType);
        box.setText(subTypes[subType]);
        box.setChecked(true);
        box.setClickable(false);

        ( (LinearLayout) rV).addView(box);
        switch(activity)
        {
            case 0:
                createFirstDropView(rV);
                createSecondDropView(rV);
                if(subType == 0 || subType == 2)
                {
                    createThirdDropView(rV);

                }
                createNext(rV);
                break;

            case 1:
                createSecondDropView(rV);
                createNext(rV);
                break;

            default: break;
        }

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

        int secondDropMax = LogEntry.getSecondDropdownMax(this.activity, this.subType);
        SeekBar seekBar = new SeekBar(getActivity());
        seekBar.setMax(secondDropMax);

        ((LinearLayout) rV).addView(seekBar);

        final TextView secondText = new TextView(getActivity());
        final String secondDropUnit = LogEntry.getSecondDropdownUnit(this.activity, this.subType);
        secondText.setText(secondDropUnit);
        secondText.setGravity(Gravity.CENTER);
        ((LinearLayout) rV).addView(secondText);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                secondType = progress;

                if(activity == 0 && subType == 3)
                {
                    secondText.setText(LogEntry.convertIntensity(progress));
                }
                else if(activity == 2)
                {
                    secondText.setText(LogEntry.convertQuality(progress));
                }
                else {
                    secondText.setText(progress + " " + secondDropUnit);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

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

        int thirdDropMax = LogEntry.getThirdDropdownMax(this.activity, this.subType);
        SeekBar seekBar = new SeekBar(getActivity());
        seekBar.setMax(thirdDropMax);

        ((LinearLayout) rV).addView(seekBar);

        final TextView thirdText = new TextView(getActivity());
        final String thirdDropUnit = LogEntry.getThirdDropdownUnit(this.activity, this.subType);
        thirdText.setText(thirdDropUnit);
        thirdText.setGravity(Gravity.CENTER);
        ((LinearLayout) rV).addView(thirdText);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                thirdType = progress;

                if(activity == 0 && subType == 0){
                    thirdText.setText(LogEntry.convertIntensity(progress));
                }
                else {
                    thirdText.setText(progress + " " + thirdDropUnit);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}

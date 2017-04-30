package co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package;

/**
 * Created by duya on 4/4/17.
 */



import android.app.Activity;
import android.app.DialogFragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import co.rpg_fitness_app.android.rpg_fitness_app.R;

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

                int currentValue = 0;
                Goal newGoal = new Goal(new_log, UUID.randomUUID().toString(), initialValue, currentValue, finalValue, false, false, false );

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

        final int initialMax = 60;

        SeekBar seekBar = new SeekBar(getActivity());
        seekBar.setMax(initialMax);

        ((LinearLayout) rV).addView(seekBar);

        final TextView initialText = new TextView(getActivity());
        initialText.setGravity(Gravity.CENTER);
        ((LinearLayout) rV).addView(initialText);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                initialValue = progress;
                initialText.setText(progress + "");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
    private void createFinal(View rV) {
        TextView typeInitial = new TextView(getActivity());
        typeInitial.setText("Enter Final Value");

        typeInitial.setTypeface(null, Typeface.BOLD);

        ((LinearLayout) rV).addView(typeInitial);

        final int finalMax = 100;

        SeekBar seekBar = new SeekBar(getActivity());
        seekBar.setMax(finalMax);

        ((LinearLayout) rV).addView(seekBar);

        final TextView finalText = new TextView(getActivity());
        finalText.setGravity(Gravity.CENTER);
        ((LinearLayout) rV).addView(finalText);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                finalValue = progress;
                finalText.setText(progress + "");

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

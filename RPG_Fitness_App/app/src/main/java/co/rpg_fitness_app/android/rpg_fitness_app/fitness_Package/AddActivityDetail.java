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
        switch (activity) {
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

        createSubTypeView(rV);

        return rV;
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

                android.app.FragmentManager fm = getFragmentManager();
                DialogFragment dF = new AddActivityDetailNext();

                Bundle arguments = new Bundle();
                arguments.putInt("activity", activity);
                arguments.putInt("subType", subType);
                dF.setArguments(arguments);
                dF.show(fm, "id2");
                dismiss();
            }
        };
    }

}

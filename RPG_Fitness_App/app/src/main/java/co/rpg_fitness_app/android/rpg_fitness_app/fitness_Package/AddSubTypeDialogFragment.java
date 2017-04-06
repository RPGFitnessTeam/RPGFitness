package co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import co.rpg_fitness_app.android.rpg_fitness_app.R;

/**
 * Created by duya on 4/4/17.
 */

public class AddSubTypeDialogFragment extends DialogFragment {

    private int activity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.activity = getArguments().getInt("activity");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rV = inflater.inflate(R.layout.add_activity, container, false);

        TextView type = new TextView(getActivity());
        type.setText("Select Type");
        ((LinearLayout) rV).addView(type);

        String[] subTypes = LogEntry.getSubtypes(this.activity);
        for(int i = 0; i < subTypes.length; i++)
        {
            CheckBox box = new CheckBox(getActivity());
            box.setId(i);
            box.setText(subTypes[i]);
            box.setOnClickListener(nextOnClick(box, this.activity));
            ( (LinearLayout) rV).addView(box);

        }

        return rV;
    }

     View.OnClickListener nextOnClick(final Button button, final int activity) {

        return new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                dismiss();
                android.app.FragmentManager fm = getFragmentManager();
                DialogFragment dF;

                //Only Exercise Activity needs firstDropDownValue
                if(activity == 0)
                {
                    dF = new AddFirstDropDialogFragment();
                }
                else
                {
                    dF = new AddSecondDropDialogFragment();
                }

                Bundle argument = new Bundle();
                argument.putInt("firstDrop", 1); //exception
                argument.putInt("subType", button.getId());
                argument.putInt("activity", activity );
                dF.setArguments(argument);
                dF.show(fm, "Duya");


            }
        };
    }
}

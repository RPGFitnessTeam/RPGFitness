package co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package;

import android.app.DialogFragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import co.rpg_fitness_app.android.rpg_fitness_app.R;

/**
 * Created by duya on 4/4/17.
 */

public class AddFirstDropDialogFragment extends DialogFragment {

    private int activity;
    private int subType;

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

        
        String[] firstDrop = LogEntry.getFirstDropdownValues(this.activity, this.subType);
        for(int i = 0; i < firstDrop.length; i++)
        {
            CheckBox box = new CheckBox(getActivity());
            box.setId(i);
            box.setText(firstDrop[i]);
            box.setOnClickListener(nextOnClick(box, this.activity, this.subType));
            ( (LinearLayout) rV).addView(box);

        }


        return rV;
    }

    View.OnClickListener nextOnClick(final Button button, final int activity, final int subType) {

        return new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                dismiss();
                android.app.FragmentManager fm = getFragmentManager();

                DialogFragment dF = new AddSecondDropDialogFragment();

                Bundle argument = new Bundle();
                argument.putInt("firstDrop", button.getId());
                argument.putInt("subType", subType);
                argument.putInt("activity", activity );
                dF.setArguments(argument);
                dF.show(fm, "Duya");


            }
        };
    }
}

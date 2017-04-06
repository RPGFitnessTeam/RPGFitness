package fitness.goal;

/**
 * Created by duya on 4/4/17.
 */



import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import java.util.Calendar;
import java.util.Date;

import fitnessrpg.fitnessrpg.LogEntry;
import fitnessrpg.fitnessrpg.R;

/**
 * Created by duya on 4/4/17.
 */

public class AddGoalSecondDrop extends DialogFragment {

    private int firstDrop;
    private int activity;
    private int subType;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.firstDrop = getArguments().getInt("firstDrop");
        this.activity = getArguments().getInt("activity");
        this.subType = getArguments().getInt("subType");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rV = inflater.inflate(R.layout.add_activity, container, false);

        int[] secondDrop = LogEntry.getSecondDropdownValues(this.activity, this.subType);
        for(int i = 0; i < secondDrop.length; i++)
        {
            CheckBox box = new CheckBox(getActivity());
            box.setId(i);
            box.setText(secondDrop[i] + "");
            box.setOnClickListener(nextOnClick(box, this.activity, this.subType, this.firstDrop));
            ( (LinearLayout) rV).addView(box);

        }

        return rV;
    }

    View.OnClickListener nextOnClick(final Button button, final int activity, final int subType, final int firstDrop) {

        return new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                dismiss();
                android.app.FragmentManager fm = getFragmentManager();

                DialogFragment dF = new AddGoalThirdDrop();

                //Only Excercise(Recreation, Aerobics) and Sleep has third dropdown value
                if((activity == 0 && (subType == 0 || subType == 2)) || activity == 2 )
                {
                    Bundle argument = new Bundle();
                    argument.putInt("secondDrop", button.getId());
                    argument.putInt("firstDrop", firstDrop);
                    argument.putInt("subType", subType);
                    argument.putInt("activity", activity );
                    dF.setArguments(argument);
                    dF.show(fm, "Duya");

                }
                else
                {
                    LogEntry new_log = new LogEntry("ID", activity);
                    new_log.setSubtype(subType);
                    new_log.setSecondDropdownValues(button.getId());
                    new_log.setDate(Calendar.getInstance().getTimeInMillis());
                    //Todo: instansiate wit actual Goal class
                   // Goal.addNewLogEntry(new_log); //add new entry


                }


            }
        };
    }
}

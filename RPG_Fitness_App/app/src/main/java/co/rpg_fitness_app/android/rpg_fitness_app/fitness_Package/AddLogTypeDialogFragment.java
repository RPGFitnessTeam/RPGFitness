package co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package;


import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import co.rpg_fitness_app.android.rpg_fitness_app.R;

/**
 * Created by duya on 4/4/17.
 */

public class AddLogTypeDialogFragment  extends DialogFragment{


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rV = inflater.inflate(R.layout.add_log_entry1, container, false);
        getDialog().setTitle("Check");
        ((Button) rV.findViewById(R.id.delete_add_log1)).setOnClickListener(
                new Button.OnClickListener()
                {
                    @Override
                    public void onClick(View v) {
                        dismiss();
                    }
                }

        );

        ((TextView) rV.findViewById(R.id.add_fitness)).setOnClickListener(
                  new TextView.OnClickListener() {
                      public void onClick(View v) {
                          onClickHandler(0);


                      }
                  }
                );
        ((TextView) rV.findViewById(R.id.add_nutrition)).setOnClickListener(
                new TextView.OnClickListener() {
                    public void onClick(View v) {
                        onClickHandler(1);


                    }
                }
        );
        ((TextView) rV.findViewById(R.id.add_sleep)).setOnClickListener(
                new TextView.OnClickListener() {
                    public void onClick(View v) {
                        onClickHandler(2);

                    }
                }
        );
        ((TextView) rV.findViewById(R.id.add_weight)).setOnClickListener(
                new TextView.OnClickListener() {
                    public void onClick(View v) {
                       onClickHandler(3);

                    }
                }
        );

        ArrayList<LogEntry> testArray = FitnessLog.retrieveLogEntries();
        TextView test = new TextView(getActivity());
       
        ((RelativeLayout) rV).addView(test);

        return rV;
    }
    private void onClickHandler(int activity)
    {
        dismiss();
        android.app.FragmentManager fm = getFragmentManager();
        DialogFragment dF = new AddActivityDetail();
        Bundle arguments = new Bundle();
        arguments.putInt("activity", activity);
        dF.setArguments(arguments);
        dF.show(fm, "id2");
    }

}

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

import fitnessrpg.fitnessrpg.LogEntry;
import fitnessrpg.fitnessrpg.R;

/**
 * Created by duya on 4/4/17.
 */

public class AddGoalFirstDrop extends DialogFragment {

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

                DialogFragment dF = new AddGoalSecondDrop();

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

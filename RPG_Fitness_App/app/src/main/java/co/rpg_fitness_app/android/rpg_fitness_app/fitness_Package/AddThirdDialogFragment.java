package fitnessrpg.fitnessrpg;

import android.app.DialogFragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by duya on 4/4/17.
 */

public class AddThirdDialogFragment extends DialogFragment {
    private int secondDrop;
    private int  firstDrop;
    private int activity;
    private int subType;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.secondDrop = getArguments().getInt("secondDrop");
        this.firstDrop = getArguments().getInt("firstDrop");
        this.activity = getArguments().getInt("activity");
        this.subType = getArguments().getInt("subType");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rV = inflater.inflate(R.layout.add_activity, container, false);

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

        int[] thirdDrop = LogEntry.getThirdDropdownValues(this.activity, this.subType);
        for(int i = 0; i < thirdDrop.length; i++)
        {
            CheckBox box = new CheckBox(getActivity());
            box.setId(i);
            box.setText(thirdDrop[i] + "");
            box.setOnClickListener(nextOnClick(box, this.activity, this.subType, this.firstDrop, this.secondDrop));
            ( (LinearLayout) rV).addView(box);

        }

        return rV;
    }

    View.OnClickListener nextOnClick(final Button button, final int activity, final int subType, final int firstDrop, final int secondDrop) {

        return new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                dismiss();

                LogEntry new_log = new LogEntry("ID", activity);
                new_log.setSubtype(subType);
                if(activity == 0) {
                    new_log.setFirstDropdownValues(LogEntry.getFirstDropdownValues(activity, subType)[firstDrop]);
                }
                new_log.setSecondDropdownValues(button.getId());
                new_log.setThirdDropdownValues(button.getId());
                new_log.setDate(Calendar.getInstance().getTimeInMillis());
                FitnessLog.addNewLogEntry(new_log); //add new entry


            }
        };
    }
}

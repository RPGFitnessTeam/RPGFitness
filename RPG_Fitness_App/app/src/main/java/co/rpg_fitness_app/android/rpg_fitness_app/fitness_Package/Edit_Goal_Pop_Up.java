package co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import co.rpg_fitness_app.android.rpg_fitness_app.R;

/**
 * Created by Arthur on 4/1/2017.
 */

public class Edit_Goal_Pop_Up extends AppCompatActivity{
    private String[] fitCategories;
    private String[] exerciseSub;
    private String[] nutrSub;
    private String[] sleepSub;
    private String[] weightSub;
    private Spinner fitDropDown;
    private Spinner subTypes;
    private ArrayAdapter<String> exAdapter;
    private ArrayAdapter<String> nutrAdapter;
    private ArrayAdapter<String> sleepAdapter;
    private ArrayAdapter<String> weightAdapter;
    private EditText currVal;
    private EditText goalVal;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_goal_pop_up);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        Goal goal = (Goal)this.getIntent().getSerializableExtra("goal");
        Integer activity = goal.getGoalActivity().getActivity();
        final Integer currValue = goal.getCurrentValue();
        Integer goalValue = goal.getEndValue();

        String[] fitCategories = getResources().getStringArray(R.array.Fitness_Categories);
        String[] exerciseSub = getResources().getStringArray(R.array.Fitness_Subtypes);
        String[] nutrSub = getResources().getStringArray(R.array.Nutrition_Subtypes);
        String[] sleepSub = getResources().getStringArray(R.array.Sleep_Subtypes);
        String[] weightSub = getResources().getStringArray(R.array.Weight_Subtypes);
        Spinner fitDropDown = (Spinner) findViewById(R.id.fitCategoriesSpin);
        subTypes = (Spinner) findViewById(R.id.editSubSpinner);
        exAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, exerciseSub);
        nutrAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, nutrSub);
        sleepAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, sleepSub);
        weightAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, weightSub);




        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, fitCategories);

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fitDropDown.setAdapter(myAdapter);
        fitDropDown.setSelection(activity - 1);


        currVal = (EditText)findViewById(R.id.currentValueEdit);
        goalVal = (EditText)findViewById(R.id.goalValueEdit);
        currVal.setText(currValue.toString());
        goalVal.setText(goalValue.toString());
        currVal.requestFocus();


        switch(activity) {
            case 1:
                subTypes.setAdapter(exAdapter);
                break;
            case 2:
                subTypes.setAdapter(nutrAdapter);
                break;
            case 3:
                subTypes.setAdapter(sleepAdapter);
                break;
            case 4:
                subTypes.setAdapter(weightAdapter);
                break;
        }


        getWindow().setLayout((int) (width * 0.75), (int) (height * 0.75));
        configureExitButton();
        configureSaveButton();



        fitDropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String selectedItem = parent.getItemAtPosition(position).toString();
                switch(selectedItem) {

                    case "Exercise":
                        subTypes.setAdapter(exAdapter);
                        currVal.setText("");
                        goalVal.setText("");
                        currVal.setHint("Enter your current exercise value");
                        goalVal.setHint("Enter your goal exercise value");
                        break;
                    case "Nutrition":
                        subTypes.setAdapter(nutrAdapter);
                        currVal.setText("");
                        goalVal.setText("");
                        currVal.setHint("Enter your current nutrition value");
                        goalVal.setHint("Enter your goal nutrition value");
                        break;
                    case "Sleep":
                        subTypes.setAdapter(sleepAdapter);
                        currVal.setText("");
                        goalVal.setText("");
                        currVal.setHint("Enter your current sleep value");
                        goalVal.setHint("Enter your goal sleep value");
                        break;
                    case "Weight":
                        subTypes.setAdapter(weightAdapter);
                        currVal.setText("");
                        goalVal.setText("");
                        currVal.setHint("Enter your current weight");
                        goalVal.setHint("Enter your goal weight");
                        break;
                }
            } // to close the onItemSelected
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });
    }
    private void configureExitButton() {
        Button exitEdit = (Button) findViewById(R.id.exitEditPopUp);
        exitEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void configureSaveButton() {
        Button saveEdit = (Button) findViewById(R.id.saveEditBtn);
        saveEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}

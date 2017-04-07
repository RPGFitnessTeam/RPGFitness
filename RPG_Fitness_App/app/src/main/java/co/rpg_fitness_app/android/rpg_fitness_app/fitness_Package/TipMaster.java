package co.rpg_fitness_app.android.rpg_fitness_app.fitness_Package;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ExpandableListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import co.rpg_fitness_app.android.rpg_fitness_app.R;


// Activity Class for displaying tips
public class TipMaster extends AppCompatActivity {
    private List<Tips> tipList = new ArrayList<Tips>();
    private List<Tips> exerciseTipList = new ArrayList<Tips>();
    private List<Tips> nutritionTipList = new ArrayList<Tips>();
    private List<Tips> weightTipList = new ArrayList<Tips>();
    private List<Tips> sleepTipList = new ArrayList<Tips>();

        ExpandableListView expandableListView;
        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.tip_main);
            // Sets toolbar text to Tips and Tricks
            Toolbar mToolbar = (Toolbar) findViewById(R.id.my_toolbar);
            mToolbar.setTitle("Tips and Tricks");
            setSupportActionBar(mToolbar);
            fillExerciseTipList();
            fillNutritionTipList();
            fillSleepTipList();
            fillWeightTipList();

            expandableListView = (ExpandableListView) findViewById(R.id.exp_listview);
            List<String> fitCategories = new ArrayList<String>();
            HashMap<String, List<Tips>> childList = new HashMap<String, List<Tips>>();
            String parentTips[] = getResources().getStringArray(R.array.Fitness_Categories);
            for (String category : parentTips) {
                fitCategories.add(category);
            }
            childList.put(fitCategories.get(0), exerciseTipList);
            childList.put(fitCategories.get(1), nutritionTipList);
            childList.put(fitCategories.get(2), sleepTipList);
            childList.put(fitCategories.get(3), weightTipList);
            tipAdapter adapt = new tipAdapter(this, fitCategories, childList);
            expandableListView.setAdapter(adapt);

        }
        public boolean addTip(int message, String ID, String type, boolean thumbsUp, boolean thumbsDown) {
            switch (type) {
                case "exercise":
                    Tips eType = new Tips(message, ID, type, false, thumbsUp, thumbsDown, null);
                    tipList.add(eType);
                    exerciseTipList.add(eType);
                    return true;
                case "nutrition":
                    Tips nType = new Tips(message, ID, type, false, thumbsUp, thumbsDown, null);
                    tipList.add(nType);
                    nutritionTipList.add(nType);
                    return true;
                case "weight":
                    Tips wType = new Tips(message, ID, type, false, thumbsUp, thumbsDown, null);
                    tipList.add(wType);
                    weightTipList.add(wType);
                    return true;
                case "sleep":
                    Tips sType = new Tips(message, ID, type, false, thumbsUp, thumbsDown, null);
                    tipList.add(sType);
                    sleepTipList.add(sType);
                    return true;
                }
                return false;
            }

            // Methods for populating ListView, will be done in the database when it is ready
            public void fillNutritionTipList() {
                this.addTip(R.string.n0, UUID.randomUUID().toString(), "nutrition", false, false);
                this.addTip(R.string.n1, UUID.randomUUID().toString(), "nutrition", false, false);
                this.addTip(R.string.n2, UUID.randomUUID().toString(), "nutrition", false, false);
                this.addTip(R.string.n3, UUID.randomUUID().toString(), "nutrition", false, false);
            }
            public void fillExerciseTipList() {
                this.addTip(R.string.e0, UUID.randomUUID().toString(), "exercise", false, false);
                this.addTip(R.string.e1, UUID.randomUUID().toString(), "exercise", false, false);
                this.addTip(R.string.e2, UUID.randomUUID().toString(), "exercise", false, false);
                this.addTip(R.string.e3, UUID.randomUUID().toString(), "exercise", false, false);
            }
            public void fillSleepTipList() {
                this.addTip(R.string.s0, UUID.randomUUID().toString(), "sleep", false, false);
                this.addTip(R.string.s1, UUID.randomUUID().toString(), "sleep", false, false);
                this.addTip(R.string.s2, UUID.randomUUID().toString(), "sleep", false, false);
                this.addTip(R.string.s3, UUID.randomUUID().toString(), "sleep", false, false);

            }
            public void fillWeightTipList() {
                this.addTip(R.string.w0, UUID.randomUUID().toString(), "weight", false, false);
                this.addTip(R.string.w1, UUID.randomUUID().toString(), "weight", false, false);
                this.addTip(R.string.w2, UUID.randomUUID().toString(), "weight", false, false);
                this.addTip(R.string.w3, UUID.randomUUID().toString(), "weight", false, false);
             }
    }






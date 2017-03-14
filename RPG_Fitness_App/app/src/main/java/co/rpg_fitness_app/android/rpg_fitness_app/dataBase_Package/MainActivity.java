package co.rpg_fitness_app.android.rpg_fitness_app.dataBase_Package;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import co.rpg_fitness_app.android.rpg_fitness_app.R;

public class MainActivity extends AppCompatActivity {
    DataSource mDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO: set content to proper activity
        setContentView(R.layout.activity_main);

        mDataSource = new DataSource(this);
        mDataSource.open();
        mDataSource.seedDatabase();
    }
}



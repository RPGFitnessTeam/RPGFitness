package co.rpg_fitness_app.android.rpg_fitness_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import javax.sql.DataSource;

import co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package.Kingdom;
import co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package.KingdomActivity;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private Kingdom kingdom;
    private DataSource mDataSource;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //TODO: uncomment once DB is implemented
        /*mDataSource = new DataSource(this);
        mDataSource.open();
        mDataSource.seedDatabase();*/

        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);


        //kingdom code
        getKingdom();
    }

    private void getKingdom() {
        //this.kingdom = mDataSource.getAllKingdoms();
        if (this.kingdom == null) {
            this.kingdom = new Kingdom();
        }
    }


}

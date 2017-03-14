package co.rpg_fitness_app.android.rpg_fitness_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package.Kingdom;
import co.rpg_fitness_app.android.rpg_fitness_app.kingdom_Package.KingdomActivity;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private Kingdom kingdom;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //kingdom code
        getKingdom();
        configureKingdomButton();
        configureNavKingdomButton();
    }

    private void getKingdom() {
        this.kingdom = db.getKingdom;
        if (this.kingdom == null) {
            this.kingdom = new Kingdom();
        }
    }

    private void configureNavKingdomButton(){
        Button navKingdomButton = (Button) findViewById(R.id.navKingdomButton);
        navKingdomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, KingdomActivity.class);
                intent.putExtra("kingdom", kingdom);
                startActivity(intent);
            }
        });
    }

    private void configureKingdomButton(){
        Button kingdomButton = (Button) findViewById(R.id.kingdomButton);
        kingdomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, KingdomActivity.class);
                intent.putExtra("kingdom", kingdom);
                startActivity(intent);
            }
        });
    }

}

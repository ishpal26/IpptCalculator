package ishpal.ipptcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class FemaleDataEntry extends AppCompatActivity {
    int givenAge = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_female_data_entry);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intentExtras = getIntent();
        Bundle extraBundle = intentExtras.getExtras();

        if (extraBundle.isEmpty() == true){

        } else {
            givenAge = extraBundle.getInt("age");
            //just to check
            Toast.makeText(this,"age is: "+givenAge, Toast.LENGTH_SHORT).show();
        }
    }

}

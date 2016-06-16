package ishpal.ipptcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class ResultPage extends AppCompatActivity {
    int points, runpts,pushpts,sitpts;
    String award;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intentExtras = getIntent();
        Bundle extraBundle = intentExtras.getExtras();

        if (extraBundle.isEmpty() == true){
            // throw error
        } else {
            points = extraBundle.getInt("score");
            award = extraBundle.getString("award");
            runpts = extraBundle.getInt("runscore");
            sitpts = extraBundle.getInt("sitscore");
            pushpts = extraBundle.getInt("pushscore");

            //just to check
            Toast.makeText(this,"score: "+points +", \n"+award +"\n pushScore: "+pushpts +"\n sitscore: "+sitpts +"\n runscore: "+runpts,
                    Toast.LENGTH_LONG).show();
        }


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}

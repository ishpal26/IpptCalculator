package ishpal.ipptcalculator;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
import android.view.View;
//import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MaleDataEntry extends AppCompatActivity implements View.OnClickListener {
    private Spinner spin;
    EditText minutes,seconds,pushUps,sitUps;
    //Button calculate;
    int givenAge = 0;
    //ArrayAdapter<CharSequence> adapter;
    TextView t2, t3, t4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_male_data_entry);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        Intent intentExtras = getIntent();
        Bundle extraBundle = intentExtras.getExtras();

        t2 =  (TextView) findViewById(R.id.textView2);
        Typeface myCustomFont2 = Typeface.createFromAsset(getAssets(), "Fonts/Roboto-Thin.ttf");
        t2.setTypeface(myCustomFont2);

        t3 =  (TextView) findViewById(R.id.textView3);
        Typeface myCustomFont3 = Typeface.createFromAsset(getAssets(), "Fonts/Roboto-Thin.ttf");
        t3.setTypeface(myCustomFont3);

        t4 =  (TextView) findViewById(R.id.textView4);
        Typeface myCustomFont4 = Typeface.createFromAsset(getAssets(), "Fonts/Roboto-Thin.ttf");
        t4.setTypeface(myCustomFont4);

        if (extraBundle.isEmpty() == true){
        } else {
            givenAge = extraBundle.getInt("age");
            //just to check
            Toast.makeText(this,"Age: "+givenAge, Toast.LENGTH_SHORT).show();
        }

        /*calculate = (Button) findViewById(R.id.calButton);
        calculate.setOnClickListener(this);*/
        minutes = (EditText) findViewById(R.id.mins);
        seconds = (EditText) findViewById(R.id.secs);
        pushUps = (EditText) findViewById(R.id.pushUpReps);
        sitUps = (EditText) findViewById(R.id.sitUpReps);

        /*spin = (Spinner)findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.minutes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),parent.getItemIdAtPosition(position)+"is selected", Toast.LENGTH_LONG);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        }); */

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.fab:
                int runMin = Integer.parseInt(minutes.getText().toString().trim());
                int runSec = Integer.parseInt(seconds.getText().toString().trim());
                int pushReps = Integer.parseInt(pushUps.getText().toString().trim());
                int sitReps = Integer.parseInt(sitUps.getText().toString().trim());
                MaleCalculator toCheckScore = new MaleCalculator(givenAge, runMin, runSec, pushReps, sitReps);
                toCheckScore.calculate();
                int score = toCheckScore.getPoints();
                String award = toCheckScore.getAward();

                if(award.contains("error")){
                    Toast.makeText(this,"Error with data, please input your data correctly", Toast.LENGTH_LONG).show();
                } else {
                    Intent intentBundle = new Intent(this, ResultPage.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("score", score);
                    bundle.putString("award", award);
                    intentBundle.putExtras(bundle);
                    startActivity(intentBundle); // we now launch the male data entry page
                }
        }
    }
}

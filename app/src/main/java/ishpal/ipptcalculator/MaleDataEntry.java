package ishpal.ipptcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MaleDataEntry extends AppCompatActivity implements View.OnClickListener {
    private Spinner spin;
    EditText minutes,seconds,pushUps,sitUps;
    Button calculate;
    int givenAge = 0;
    ArrayAdapter<CharSequence> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_male_data_entry);
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

        calculate = (Button) findViewById(R.id.calButton);
        calculate.setOnClickListener(this);
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
        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.calButton:
                String[] arrMin = minutes.getText().toString().split("min");
                String[] arrSec = seconds.getText().toString().split("sec");
                String[] arrPush = pushUps.getText().toString().split("reps");
                String[] arrSit = sitUps.getText().toString().split("reps");
                int runMin = Integer.parseInt(arrMin[0]);
                int runSec = Integer.parseInt(arrSec[0]);
                int pushReps = Integer.parseInt(arrPush[0]);
                int sitReps = Integer.parseInt(arrSit[0]);



                Intent intentBundle = new Intent(this, ResultPage.class);
                Bundle bundle = new Bundle();
                bundle.putInt("age", givenAge);
                bundle.putInt("runMin", runMin);
                bundle.putInt("runSec", runSec);
                bundle.putInt("pushReps", pushReps);
                bundle.putInt("sitReps", sitReps);
                intentBundle.putExtras(bundle);
                startActivity(intentBundle); // we now launch the male data entry page
        }
    }
}

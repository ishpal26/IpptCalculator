package ishpal.ipptcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Switch;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {    // add in the on click listener to this class
    private Switch mySwitch;
    private String gender;
    private NumberPicker numPicker;
    private Button cont;
    @Override
    // basically what this method does is to initialize everything when this page is has been created
    // it will only be created by the previous "splash" screen, after its 2 second timeout
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);         // this is to select which xml file will be rendered and displayed to the user
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        cont = (Button) findViewById(R.id.continueButton);
        cont.setOnClickListener(this);
        mySwitch = (Switch)findViewById(R.id.mySwitch);
        numPicker = (NumberPicker) findViewById(R.id.numberPicker);
        numPicker.setMaxValue(60);
        numPicker.setMinValue(17);
        numPicker.setWrapSelectorWheel(false);

        //set the switch to off
        mySwitch.setChecked(false);
        //attach a listener to check for changes in state
        mySwitch.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {

                if(isChecked){
                    gender = "female";
                }else{
                    gender = "male";
                }

            }
        });

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @Override                       // for now can ignore this
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override                       // for now can ignore this
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.continueButton:
            if(gender == "male") {
                int age = numPicker.getValue();
                startActivity(new Intent(this, MaleDataEntry.class)); // we now launch the female data entry page
            } else {
                int age = numPicker.getValue();
                startActivity(new Intent(this, FemaleDataEntry.class)); // we now launch the female data entry page
            }
        }
    }
}

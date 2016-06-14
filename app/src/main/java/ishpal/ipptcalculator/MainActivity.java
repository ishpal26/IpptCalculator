package ishpal.ipptcalculator;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {    // add in the on click listener to this class
    private Switch mySwitch;
    private String gender = "male";
    private NumberPicker numPicker;
    private Button cont;
    private static SeekBar seek_bar;
    private static TextView g, a, c, cP, aP;
    @Override
    // basically what this method does is to initialize everything when this page is has been created
    // it will only be created by the previous "splash" screen, after its 2 second timeout
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);         // this is to select which xml file will be rendered and displayed to the user
        seekbar();
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        //This is to make the fonts nice
        g =  (TextView) findViewById(R.id.ageText);
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(), "Fonts/Roboto-Light.ttf");
        g.setTypeface(myCustomFont);

        a =  (TextView) findViewById(R.id.genderText);
        Typeface myCustomFont1 = Typeface.createFromAsset(getAssets(), "Fonts/Roboto-Light.ttf");
        a.setTypeface(myCustomFont1);

        c =  (TextView) findViewById(R.id.categoryText);
        Typeface myCustomFont2 = Typeface.createFromAsset(getAssets(), "Fonts/Roboto-Light.ttf");
        c.setTypeface(myCustomFont2);

        cP =  (TextView) findViewById(R.id.categoryProgress);
        Typeface myCustomFont3 = Typeface.createFromAsset(getAssets(), "Fonts/Roboto-Light.ttf");
        cP.setTypeface(myCustomFont3);

        aP =  (TextView) findViewById(R.id.ageProgress);
        Typeface myCustomFont4 = Typeface.createFromAsset(getAssets(), "Fonts/Roboto-Light.ttf");
        aP.setTypeface(myCustomFont4);

        //This is for the button
        cont = (Button) findViewById(R.id.continueButton);
        cont.setOnClickListener(this);

        //This is for the gender switch
        mySwitch = (Switch)findViewById(R.id.mySwitch);
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

        //This is for the number picker
        /*
        numPicker = (NumberPicker) findViewById(R.id.numberPicker);
        numPicker.setMaxValue(60);
        numPicker.setMinValue(17);
        numPicker.setWrapSelectorWheel(false);*/


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
            if(gender.equals("male")) {
                int age = Integer.parseInt("" + aP.getText());

                // to pass the age to the next activity
                Intent intentBundle = new Intent(this, MaleDataEntry.class);
                Bundle bundle = new Bundle();
                bundle.putInt("age", age);
                intentBundle.putExtras(bundle);
                startActivity(intentBundle); // we now launch the male data entry page
            } else {
                int age = Integer.parseInt("" + aP.getText());

                // to pass the age to the next activity
                Intent intentBundle = new Intent(this, FemaleDataEntry.class);
                Bundle bundle = new Bundle();
                bundle.putInt("age", age);
                intentBundle.putExtras(bundle);
                startActivity(intentBundle); // we now launch the female data entry page
            }
        }
    }

    public void seekbar() {
        seek_bar = (SeekBar)findViewById(R.id.ageSeekBar);
        aP = (TextView)findViewById(R.id.ageProgress);
        aP.setText("17");


        seek_bar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    public int ageFromSeekBar;

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        ageFromSeekBar = progress;
                        aP.setText("" + progress);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        aP.setText("" + ageFromSeekBar);
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        aP.setText("" + ageFromSeekBar);
                    }
                }
        );
    }
}

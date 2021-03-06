package ishpal.ipptcalculator;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
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

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {    // add in the on click listener to this class
    private Switch mySwitch, catSwitch;
    private String gender = "male", cat = "Active";
    private FloatingActionButton cont;
    private static SeekBar seek_bar;
    private static TextView g, a, c, cP, aP, genderText;
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
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(), "Fonts/Roboto-Thin.ttf");
        g.setTypeface(myCustomFont);

        a =  (TextView) findViewById(R.id.genderText);
        Typeface myCustomFont1 = Typeface.createFromAsset(getAssets(), "Fonts/Roboto-Thin.ttf");
        a.setTypeface(myCustomFont1);

        c =  (TextView) findViewById(R.id.categoryText);
        Typeface myCustomFont2 = Typeface.createFromAsset(getAssets(), "Fonts/Roboto-Thin.ttf");
        c.setTypeface(myCustomFont2);

        cP =  (TextView) findViewById(R.id.categoryProgress);
        Typeface myCustomFont3 = Typeface.createFromAsset(getAssets(), "Fonts/Roboto-Thin.ttf");
        cP.setTypeface(myCustomFont3);
        cP.setText("Active");

        aP =  (TextView) findViewById(R.id.ageProgress);
        Typeface myCustomFont4 = Typeface.createFromAsset(getAssets(), "Fonts/Roboto-Thin.ttf");
        aP.setTypeface(myCustomFont4);

        genderText =  (TextView) findViewById(R.id.textView);
        Typeface myCustomFont5 = Typeface.createFromAsset(getAssets(), "Fonts/Roboto-Thin.ttf");
        genderText.setTypeface(myCustomFont5);
        genderText.setText("Male");

        //This is for the button
        cont = (FloatingActionButton) findViewById(R.id.nextFab);
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
                    genderText.setText("Female");
                    cat = "Active";
                    catSwitch.setChecked(false);
                    cP.setText("" + "Active");

                }else{
                    gender = "male";
                    genderText.setText("Male");
                }

            }
        });

        //This is for the gender switch
        catSwitch = (Switch)findViewById(R.id.catSwitch);
        //set the switch to off
        catSwitch.setChecked(false);
        //attach a listener to check for changes in state
        catSwitch.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked && gender == "male") {
                        cat = "NSman";
                        cP.setText("" + "NSman");
                } else if(isChecked && gender == "female"){
                        cat = "Active";
                        catSwitch.setChecked(false);
                        cP.setText("" + "Active");
                } else {
                        cat = "Active";
                        cP.setText("" + "Active");
                }
            }
        });
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
            case R.id.nextFab:
            if(gender.equals("male")) {
                int age = Integer.parseInt("" + aP.getText());

                // to pass the age to the next activity
                Intent intentBundle = new Intent(this, MaleDataEntry.class);
                Bundle bundle = new Bundle();
                bundle.putInt("age", age);
                bundle.putString("cat",cat);
                intentBundle.putExtras(bundle);
                startActivity(intentBundle); // we now launch the male data entry page
            } else {
                int age = Integer.parseInt("" + aP.getText());

                // to pass the age to the next activity
                Intent intentBundle = new Intent(this, FemaleDataEntry.class);
                Bundle bundle = new Bundle();
                bundle.putInt("age", age);
                bundle.putString("cat",cat);
                intentBundle.putExtras(bundle);
                startActivity(intentBundle); // we now launch the female data entry page
            }
        }
    }

    public void seekbar() {
        seek_bar = (SeekBar)findViewById(R.id.ageSeekBar);
        aP = (TextView)findViewById(R.id.ageProgress);
        aP.setText("17");
        final int max = 60;
        seek_bar.setMax(max);

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

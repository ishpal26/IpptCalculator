package ishpal.ipptcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{    // add in the on click listener to this class
    private Button male, female;        // create 2 button objects

    @Override
    // basically what this method does is to initialize everything when this page is has been created
    // it will only be created by the previous "splash" screen, after its 2 second timeout
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);         // this is to select which xml file will be rendered and displayed to the user
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        male = (Button) findViewById(R.id.maleButton);      // initialize male button object to maleButton in XML file and set on click listener
        male.setOnClickListener(this);
        female = (Button) findViewById(R.id.femaleButton);
        female.setOnClickListener(this);
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
    /*  this method kicks in when a click is being made, each button in the XML has alrd been assigned to a
        button object in this java file. When the user taps a button the 'View' will identify where the user
        has tapped, using its getId method. This method will return either maleButton or femaleButton, according
        to the id we state in the XML file.
     */

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.maleButton:          // if the male button has been tapped
                startActivity(new Intent(this, MaleDataEntry.class)); // create a new page for the user to key in the data, this page will now be inactive
                break;
            case R.id.femaleButton:        // female button tapped
                startActivity(new Intent(this, FemaleDataEntry.class)); // we now launch the female data entry page
                break;
            default:        // do nothing
        }
    }
}

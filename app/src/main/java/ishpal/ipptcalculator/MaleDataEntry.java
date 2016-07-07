package ishpal.ipptcalculator;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
//import android.widget.AdapterView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MaleDataEntry extends AppCompatActivity implements View.OnClickListener {
    int givenAge = 0;
    String category = "";
    TextView t2, t3, t4, minText, secText, sitText, pushText;
    SeekBar minBar, secBar, pushBar, sitBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_male_data_entry);

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

        minText =  (TextView) findViewById(R.id.minText);
        Typeface myCustomFont5 = Typeface.createFromAsset(getAssets(), "Fonts/Roboto-Thin.ttf");
        minText.setTypeface(myCustomFont5);

        secText =  (TextView) findViewById(R.id.secText);
        Typeface myCustomFont6 = Typeface.createFromAsset(getAssets(), "Fonts/Roboto-Thin.ttf");
        secText.setTypeface(myCustomFont6);

        pushText =  (TextView) findViewById(R.id.pushText);
        Typeface myCustomFont7 = Typeface.createFromAsset(getAssets(), "Fonts/Roboto-Thin.ttf");
        pushText.setTypeface(myCustomFont7);

        sitText =  (TextView) findViewById(R.id.sitText);
        Typeface myCustomFont8 = Typeface.createFromAsset(getAssets(), "Fonts/Roboto-Thin.ttf");
        sitText.setTypeface(myCustomFont8);

        seekbar();

        //This changes the color of the floating action button for future reference
        FloatingActionButton test = (FloatingActionButton) findViewById(R.id.fab);
        test.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#D32F2F")));

        if (extraBundle.isEmpty() == true){
        } else {
            givenAge = extraBundle.getInt("age");
            category = extraBundle.getString("cat");
            //just to check
            //Toast.makeText(this,"Age: "+givenAge, Toast.LENGTH_SHORT).show();
        }


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.fab:
                String[] minArr = minText.getText().toString().trim().split(" ");
                String[] secArr = secText.getText().toString().trim().split(" ");


                int runMin = Integer.parseInt(minArr[0]);
                int runSec = Integer.parseInt(secArr[0]);
                int pushReps = Integer.parseInt(pushText.getText().toString());
                int sitReps = Integer.parseInt(sitText.getText().toString());

                MaleCalculator toCheckScore = new MaleCalculator(givenAge, runMin, runSec, pushReps, sitReps, category);
                toCheckScore.calculate();
                int score = toCheckScore.getPoints();
                if(category.equals("Active")) {
                    Toast toast = Toast.makeText(this, "Your Points: " + score + "\nCommando Gold (≥90 points)\nGold (≥85 points)\nSilver (≥75 points)\nPass (≥61 points)", Toast.LENGTH_SHORT);
                    TextView toastText = (TextView) toast.getView().findViewById(android.R.id.message);
                    if( toastText != null) toastText.setGravity(Gravity.CENTER);
                    toast.setGravity(Gravity.TOP,0,0);
                    toast.show();

                    //FOR TESTING DONT REMOVE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                    Toast test = Toast.makeText(this,""+toCheckScore.getAgeGroup()+"\n"+toCheckScore.getRunPoints()+"\n"+toCheckScore.getSitUpPoints()+"\n"+toCheckScore.getPushUpPoints(),Toast.LENGTH_LONG);
                    //test.show();
                } else {
                    Toast toast = Toast.makeText(this, "Your Points: " + score + "\nGold (≥85 points)\nSilver (≥75 points)\nPass with Incentive (≥61 points)\nPass (≥51 points)\n", Toast.LENGTH_LONG);
                    TextView toastText = (TextView) toast.getView().findViewById(android.R.id.message);
                    if( toastText != null) toastText.setGravity(Gravity.CENTER);
                    toast.setGravity(Gravity.TOP,0,0);
                    toast.show();
                    //FOR TESTING DONT REMOVE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                    Toast test = Toast.makeText(this,""+toCheckScore.getAgeGroup()+"\n"+ toCheckScore.getRunPoints()+"\n"+toCheckScore.getSitUpPoints()+"\n"+toCheckScore.getPushUpPoints(),Toast.LENGTH_LONG);
                    //test.show();
                }

                /*String award = toCheckScore.getAward();

                if(award.contains("error")){
                    Toast.makeText(this,"Error with data, please input your data correctly", Toast.LENGTH_LONG).show();
                } else {
                    Intent intentBundle = new Intent(this, ResultPage.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("score", score);
                    bundle.putString("award", award);
                    // for checking
                    bundle.putInt("pushscore", toCheckScore.getPushUpPoints());
                    bundle.putInt("sitscore", toCheckScore.getSitUpPoints());
                    bundle.putInt("runscore", toCheckScore.getRunPoints());
                    intentBundle.putExtras(bundle);
                    startActivity(intentBundle); // we now launch the male data entry page
                }*/
        }
    }

    public void seekbar() {
        minBar = (SeekBar)findViewById(R.id.minBar);
        minBar.setMax(20);
        minText.setText("12" +" m");
        final TextView awardTextView = (TextView) findViewById(R.id.awardText);
        Typeface myCustomFont8 = Typeface.createFromAsset(getAssets(), "Fonts/Roboto-Thin.ttf");
        awardTextView.setTypeface(myCustomFont8);

        minBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    public int valFromBar;

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        valFromBar = progress;
                        minText.setText(valFromBar+ " m");

                        //For real time feedback
                        String[] minArr = minText.getText().toString().trim().split(" ");
                        String[] secArr = secText.getText().toString().trim().split(" ");


                        int runMin = Integer.parseInt(minArr[0]);
                        int runSec = Integer.parseInt(secArr[0]);
                        int pushReps = Integer.parseInt(pushText.getText().toString());
                        int sitReps = Integer.parseInt(sitText.getText().toString());


                        MaleCalculator toCheckScore = new MaleCalculator(givenAge, runMin, runSec, pushReps, sitReps, category);
                        toCheckScore.calculate();
                        String award = toCheckScore.getAward();
                        awardTextView.setText(award);
                        setColor(award);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        minText.setText(valFromBar + " m");

                        //For real time feedback
                        String[] minArr = minText.getText().toString().trim().split(" ");
                        String[] secArr = secText.getText().toString().trim().split(" ");


                        int runMin = Integer.parseInt(minArr[0]);
                        int runSec = Integer.parseInt(secArr[0]);
                        int pushReps = Integer.parseInt(pushText.getText().toString());
                        int sitReps = Integer.parseInt(sitText.getText().toString());


                        MaleCalculator toCheckScore = new MaleCalculator(givenAge, runMin, runSec, pushReps, sitReps, category);
                        toCheckScore.calculate();
                        String award = toCheckScore.getAward();
                        awardTextView.setText(award);
                        setColor(award);
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        minText.setText(valFromBar + " m");

                        //For real time feedback
                        String[] minArr = minText.getText().toString().trim().split(" ");
                        String[] secArr = secText.getText().toString().trim().split(" ");


                        int runMin = Integer.parseInt(minArr[0]);
                        int runSec = Integer.parseInt(secArr[0]);
                        int pushReps = Integer.parseInt(pushText.getText().toString());
                        int sitReps = Integer.parseInt(sitText.getText().toString());


                        MaleCalculator toCheckScore = new MaleCalculator(givenAge, runMin, runSec, pushReps, sitReps,category);
                        toCheckScore.calculate();
                        String award = toCheckScore.getAward();
                        awardTextView.setText(award);
                        setColor(award);
                    }
                }
        );

        secBar = (SeekBar)findViewById(R.id.secBar);
        secBar.setMax(59);
        secText.setText("0" +" s");

        secBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    public int valFromBar;

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        valFromBar = progress;
                        secText.setText(valFromBar+ " s");

                        //For real time feedback
                        String[] minArr = minText.getText().toString().trim().split(" ");
                        String[] secArr = secText.getText().toString().trim().split(" ");


                        int runMin = Integer.parseInt(minArr[0]);
                        int runSec = Integer.parseInt(secArr[0]);
                        int pushReps = Integer.parseInt(pushText.getText().toString());
                        int sitReps = Integer.parseInt(sitText.getText().toString());


                        MaleCalculator toCheckScore = new MaleCalculator(givenAge, runMin, runSec, pushReps, sitReps, category);
                        toCheckScore.calculate();
                        String award = toCheckScore.getAward();
                        awardTextView.setText(award);
                        setColor(award);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        secText.setText(valFromBar + " s");

                        //For real time feedback
                        String[] minArr = minText.getText().toString().trim().split(" ");
                        String[] secArr = secText.getText().toString().trim().split(" ");


                        int runMin = Integer.parseInt(minArr[0]);
                        int runSec = Integer.parseInt(secArr[0]);
                        int pushReps = Integer.parseInt(pushText.getText().toString());
                        int sitReps = Integer.parseInt(sitText.getText().toString());


                        MaleCalculator toCheckScore = new MaleCalculator(givenAge, runMin, runSec, pushReps, sitReps,category);
                        toCheckScore.calculate();
                        String award = toCheckScore.getAward();
                        awardTextView.setText(award);
                        setColor(award);
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        secText.setText(valFromBar + " s");

                        //For real time feedback
                        String[] minArr = minText.getText().toString().trim().split(" ");
                        String[] secArr = secText.getText().toString().trim().split(" ");


                        int runMin = Integer.parseInt(minArr[0]);
                        int runSec = Integer.parseInt(secArr[0]);
                        int pushReps = Integer.parseInt(pushText.getText().toString());
                        int sitReps = Integer.parseInt(sitText.getText().toString());


                        MaleCalculator toCheckScore = new MaleCalculator(givenAge, runMin, runSec, pushReps, sitReps, category);
                        toCheckScore.calculate();
                        String award = toCheckScore.getAward();
                        awardTextView.setText(award);
                        setColor(award);
                    }
                }
        );

        pushBar = (SeekBar)findViewById(R.id.pushBar);
        pushBar.setMax(70);
        pushText.setText("30");

        pushBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    public int valFromBar =0;

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        valFromBar = progress;
                        pushText.setText(""+valFromBar);

                        //For real time feedback
                        String[] minArr = minText.getText().toString().trim().split(" ");
                        String[] secArr = secText.getText().toString().trim().split(" ");


                        int runMin = Integer.parseInt(minArr[0]);
                        int runSec = Integer.parseInt(secArr[0]);
                        int pushReps = Integer.parseInt(pushText.getText().toString());
                        int sitReps = Integer.parseInt(sitText.getText().toString());


                        MaleCalculator toCheckScore = new MaleCalculator(givenAge, runMin, runSec, pushReps, sitReps, category);
                        toCheckScore.calculate();
                        String award = toCheckScore.getAward();
                        awardTextView.setText(award);
                        setColor(award);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        pushText.setText(""+valFromBar);

                        //For real time feedback
                        String[] minArr = minText.getText().toString().trim().split(" ");
                        String[] secArr = secText.getText().toString().trim().split(" ");


                        int runMin = Integer.parseInt(minArr[0]);
                        int runSec = Integer.parseInt(secArr[0]);
                        int pushReps = Integer.parseInt(pushText.getText().toString());
                        int sitReps = Integer.parseInt(sitText.getText().toString());


                        MaleCalculator toCheckScore = new MaleCalculator(givenAge, runMin, runSec, pushReps, sitReps, category);
                        toCheckScore.calculate();
                        String award = toCheckScore.getAward();
                        awardTextView.setText(award);
                        setColor(award);
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        pushText.setText(""+valFromBar);

                        //For real time feedback
                        String[] minArr = minText.getText().toString().trim().split(" ");
                        String[] secArr = secText.getText().toString().trim().split(" ");


                        int runMin = Integer.parseInt(minArr[0]);
                        int runSec = Integer.parseInt(secArr[0]);
                        int pushReps = Integer.parseInt(pushText.getText().toString());
                        int sitReps = Integer.parseInt(sitText.getText().toString());


                        MaleCalculator toCheckScore = new MaleCalculator(givenAge, runMin, runSec, pushReps, sitReps, category);
                        toCheckScore.calculate();
                        String award = toCheckScore.getAward();
                        awardTextView.setText(award);
                        setColor(award);
                    }
                }
        );

        sitBar = (SeekBar)findViewById(R.id.sitBar);
        sitBar.setMax(70);
        sitText.setText("30");

        sitBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    public int valFromBar =0;

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        valFromBar = progress;
                        sitText.setText(""+valFromBar);

                        //For real time feedback
                        String[] minArr = minText.getText().toString().trim().split(" ");
                        String[] secArr = secText.getText().toString().trim().split(" ");


                        int runMin = Integer.parseInt(minArr[0]);
                        int runSec = Integer.parseInt(secArr[0]);
                        int pushReps = Integer.parseInt(pushText.getText().toString());
                        int sitReps = Integer.parseInt(sitText.getText().toString());


                        MaleCalculator toCheckScore = new MaleCalculator(givenAge, runMin, runSec, pushReps, sitReps, category);
                        toCheckScore.calculate();
                        String award = toCheckScore.getAward();
                        awardTextView.setText(award);
                        setColor(award);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        sitText.setText(""+valFromBar);

                        //For real time feedback
                        String[] minArr = minText.getText().toString().trim().split(" ");
                        String[] secArr = secText.getText().toString().trim().split(" ");


                        int runMin = Integer.parseInt(minArr[0]);
                        int runSec = Integer.parseInt(secArr[0]);
                        int pushReps = Integer.parseInt(pushText.getText().toString());
                        int sitReps = Integer.parseInt(sitText.getText().toString());


                        MaleCalculator toCheckScore = new MaleCalculator(givenAge, runMin, runSec, pushReps, sitReps, category);
                        toCheckScore.calculate();
                        String award = toCheckScore.getAward();
                        awardTextView.setText(award);
                        setColor(award);
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        sitText.setText(""+valFromBar);

                        //For real time feedback
                        String[] minArr = minText.getText().toString().trim().split(" ");
                        String[] secArr = secText.getText().toString().trim().split(" ");


                        int runMin = Integer.parseInt(minArr[0]);
                        int runSec = Integer.parseInt(secArr[0]);
                        int pushReps = Integer.parseInt(pushText.getText().toString());
                        int sitReps = Integer.parseInt(sitText.getText().toString());


                        MaleCalculator toCheckScore = new MaleCalculator(givenAge, runMin, runSec, pushReps, sitReps, category);
                        toCheckScore.calculate();
                        String award = toCheckScore.getAward();
                        awardTextView.setText(award);
                        setColor(award);
                    }
                }
        );

    }

    public void setColor(String currentAward) {

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        switch(currentAward) {

            case "Gold":                                            fab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFD600")));
                                                                    break;
            case "Commando Gold":                                   fab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFD600")));
                                                                    break;
            case "Silver":                                          fab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#BDBDBD")));
                                                                    break;
            case "Fail":                                            fab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#424242")));
                                                                    break;
            case "Pass":                                            fab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#8BC34A")));
                                                                    break;
            case "Pass with Incentive":                             fab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#8BC34A")));
                                                                    break;
            default:                                                fab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FEEBEE")));
                                                                    break;
        }
    }
}

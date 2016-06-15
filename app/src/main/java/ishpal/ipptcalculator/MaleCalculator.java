package ishpal.ipptcalculator;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Ishpal on 13/6/2016.
 */
public class MaleCalculator {
    int ageGroup, personAge, runMinutes, runSeconds, pushReps, sitReps, totalPoints =0;
    boolean commandoOrGuards=false;
    String award;
    //TODO check cdo/gds


    public MaleCalculator(int age, int runM, int runS, int pRep, int sRep){
        personAge = age;
        runMinutes = runM;
        runSeconds = runS;
        pushReps = pRep;
        sitReps = sRep;
        award = "none";
    }

    public void calculate(){
        if (personAge < 22) {
            ageGroup=1;
        } else if (22 <= personAge && personAge <= 24){
            ageGroup=2;
        } else if (25 <= personAge && personAge <= 27){
            ageGroup=3;
        } else if (28 <= personAge && personAge <= 30){
            ageGroup=4;
        } else if (31 <= personAge && personAge <= 33){
            ageGroup=5;
        } else if (34 <= personAge && personAge <= 36){
            ageGroup=6;
        } else if (37 <= personAge && personAge <= 39){
            ageGroup=7;
        } else if (40 <= personAge && personAge <= 42){
            ageGroup=8;
        } else if (43 <= personAge && personAge <= 45){
            ageGroup=9;
        } else if (46 <= personAge && personAge <= 48){
            ageGroup=10;
        } else if (49 <= personAge && personAge <= 51){
            ageGroup=11;
        } else if (52 <= personAge && personAge <= 54){
            ageGroup=12;
        } else if (55 <= personAge && personAge <= 57){
            ageGroup=13;
        } else {
            ageGroup=14;
        }
        totalPoints=getScore(ageGroup);
    }

    public int getScore(int group) {
        int inSeconds = getSeconds(runMinutes, runSeconds);
        int colToRetrieve = group + 1;
        int totalScore = 0;

        Scores scores = new Scores();

        for (int i = 0; i < scores.pushUpScores.size(); i++) {
            if (pushReps == (scores.pushUpScores.get(i).get(0))) {
                totalScore += scores.pushUpScores.get(i).get(colToRetrieve);
            }
        }
        for (int i = 0; i < scores.sitUpScores.size(); i++) {
            if (pushReps == (scores.sitUpScores.get(i).get(0))) {
                totalScore += scores.sitUpScores.get(i).get(colToRetrieve);
            }
        }
        //TODO running scores

        return totalScore;
    }


    private int getSeconds(int minutes, int seconds) {
        return minutes*60 + seconds;
    }





    public int getPoints(){
        return totalPoints;
    }
    public String getAward(){
        return award;
    }

}

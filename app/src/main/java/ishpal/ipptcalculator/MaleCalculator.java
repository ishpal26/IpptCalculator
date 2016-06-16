package ishpal.ipptcalculator;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Ishpal on 13/6/2016.
 */
public class MaleCalculator {
    int ageGroup, personAge, runMinutes, runSeconds, pushReps, sitReps, totalPoints =0, pushPoints, runPoints, sitPoints;
    String award;

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
        totalPoints=calculateScore(ageGroup);
        award= determineAward();
    }

    private int calculateScore(int group) {
        int inSeconds = getSeconds(runMinutes, runSeconds);
        int colToRetrieve = group + 1;
        int userTime= getSeconds(runMinutes,runSeconds);
        int totalScore = 0;

        MaleScores scores = new MaleScores();

        for (int i = 0; i < scores.pushUpScores.size(); i++) {
            if (pushReps == (scores.pushUpScores.get(i).get(0))) {
                totalScore += scores.pushUpScores.get(i).get(colToRetrieve);
                pushPoints = scores.pushUpScores.get(i).get(colToRetrieve);
                break;
            }
        }
        for (int i = 0; i < scores.sitUpScores.size(); i++) {
            if (sitReps == (scores.sitUpScores.get(i).get(0))) {
                totalScore += scores.sitUpScores.get(i).get(colToRetrieve);
                sitPoints = scores.sitUpScores.get(i).get(colToRetrieve);
                break;
            }
        }
        if(userTime <= scores.runningScores.get(0).get(0)) {
            totalScore += scores.runningScores.get(0).get(1);
            runPoints = scores.runningScores.get(0).get(1);
            return totalScore;
        }

        for(int i=1; i< scores.runningScores.size()-1 ; i++) {

            if(scores.runningScores.get(i).get(0)+1<=userTime && userTime<scores.runningScores.get(i+1).get(0)){
                totalScore+=scores.runningScores.get(i).get(colToRetrieve);
                runPoints = scores.runningScores.get(i).get(colToRetrieve);
            }
        }
        return totalScore;
    }
    private String determineAward() {
        if(totalPoints>100) {
            return "ERROR";
        } else if(totalPoints >=90) {
            return "GOLD(COMMANDO/GUARDS/DIVERS)";
        }else if(totalPoints<90 && totalPoints>=85) {
            return "GOLD";
        }else if(totalPoints<85 && totalPoints>=75) {
            return "SILVER";
        } else if (totalPoints<75 && totalPoints>= 61) {
            return "PASS WITH INCENTIVE(NSMEN)" + '\n' + "PASS(NSF/ACTIVE)";
        }else if (totalPoints<61 && totalPoints>=51){
            return "PASS(NSMEN)" + '\n' + "FAIL(NSF/ACTIVE)";
        } else {
            return "FAIL";
        }
    }

    private int getSeconds(int minutes, int seconds) {
        return minutes*60 + seconds;
    }

    public int getPoints(){
        return totalPoints;
    }
    public int getSitUpPoints(){return sitPoints;}
    public int getRunPoints(){return runPoints;}
    public int getPushUpPoints(){return pushPoints;}
    public String getAward(){return award;}

}

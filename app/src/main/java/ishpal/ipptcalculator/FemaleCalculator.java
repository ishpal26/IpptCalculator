package ishpal.ipptcalculator;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by freez_000 on 13/6/2016.
 */
public class FemaleCalculator {
    int ageGroup, personAge, runMinutes, runSeconds, pushReps, sitReps, totalPoints = 0, pushPoints, runPoints, sitPoints;
    String award, cat;

    public FemaleCalculator(int age, int runM, int runS, int pRep, int sRep, String category) {
        personAge = age;
        runMinutes = runM;
        runSeconds = runS;
        pushReps = pRep;
        sitReps = sRep;
        award = "none";
        cat = category;
    }

    public void calculate() {
        if (personAge < 22) {
            ageGroup = 1;
        } else if (22 <= personAge && personAge <= 24) {
            ageGroup = 2;
        } else if (25 <= personAge && personAge <= 27) {
            ageGroup = 3;
        } else if (28 <= personAge && personAge <= 30) {
            ageGroup = 4;
        } else if (31 <= personAge && personAge <= 33) {
            ageGroup = 5;
        } else if (34 <= personAge && personAge <= 36) {
            ageGroup = 6;
        } else if (37 <= personAge && personAge <= 39) {
            ageGroup = 7;
        } else if (40 <= personAge && personAge <= 42) {
            ageGroup = 8;
        } else if (43 <= personAge && personAge <= 45) {
            ageGroup = 9;
        } else if (46 <= personAge && personAge <= 48) {
            ageGroup = 10;
        } else if (49 <= personAge && personAge <= 51) {
            ageGroup = 11;
        } else if (52 <= personAge && personAge <= 54) {
            ageGroup = 12;
        } else if (55 <= personAge && personAge <= 57) {
            ageGroup = 13;
        } else {
            ageGroup = 14;
        }
        totalPoints = calculateScore(ageGroup);
        award = determineAward();
    }

    private int calculateScore(int group) {
        int colToRetrieve = group;
        int userTime = getSeconds(runMinutes, runSeconds);
        int totalScore = 0;
        int pushCheck=0;
        int sitCheck=0;

        MaleScores scores = new MaleScores();

        for (int i = 0; i < scores.pushUpScores.size(); i++) {
            if (pushReps == (scores.pushUpScores.get(i).get(0))) {
                totalScore += scores.pushUpScores.get(i).get(colToRetrieve);
                pushPoints = scores.pushUpScores.get(i).get(colToRetrieve);
                pushCheck=1;
                break;
            }
        }
        if(pushReps>60 && pushCheck==0) {
            pushPoints=25;
            totalScore+=25;
        }

        for (int i = 0; i < scores.sitUpScores.size(); i++) {
            if (sitReps == (scores.sitUpScores.get(i).get(0))) {
                totalScore += scores.sitUpScores.get(i).get(colToRetrieve);
                sitPoints = scores.sitUpScores.get(i).get(colToRetrieve);
                sitCheck=1;
                break;
            }
        }
        if(sitReps>60 && sitCheck==0) {
            sitPoints=25;
            totalScore+=25;
        }
        //Check if below the CDO GOLD
        if (userTime <= scores.runningScores.get(0).get(0)) {
            totalScore += scores.runningScores.get(0).get(1);
            runPoints = scores.runningScores.get(0).get(1);
            return totalScore;
        }
        //Not better than CDO GOLD so check the table for points
        for (int i = 1; i < scores.runningScores.size() - 1; i++) {
            if (scores.runningScores.get(i).get(0) <= userTime && userTime < scores.runningScores.get(i + 1).get(0)) {
                totalScore += scores.runningScores.get(i).get(colToRetrieve);
                runPoints = scores.runningScores.get(i).get(colToRetrieve);
                break;
            }
        }
        return totalScore;
    }

    private String determineAward() {
        if(pushPoints == 0 || sitPoints == 0 || runPoints ==0){
            return "Fail";
        }

        if (totalPoints > 100) {
            return "Error";
        } else if (totalPoints >= 90) {
            return "Commando Gold";
        } else if (totalPoints < 90 && totalPoints >= 85) {
            return "Gold";
        } else if (totalPoints < 85 && totalPoints >= 75) {
            return "Silver";
        } else if (totalPoints < 75 && totalPoints >= 51) {
            return "Pass";
        } else {
            return "Fail";
        }
    }

    private int getSeconds(int minutes, int seconds) {
        return minutes * 60 + seconds;
    }

    public int getPoints() {
        return totalPoints;
    }

    public int getSitUpPoints() {
        return sitPoints;
    }

    public int getRunPoints() {
        return runPoints;
    }

    public int getPushUpPoints() {
        return pushPoints;
    }

    public int getAgeGroup(){ return ageGroup;}

    public String getAward() {
        return award;
    }

}

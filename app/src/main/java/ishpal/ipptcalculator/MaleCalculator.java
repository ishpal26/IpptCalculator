package ishpal.ipptcalculator;

/**
 * Created by Ishpal on 13/6/2016.
 */
public class MaleCalculator {
    int personAge, runMinutes, runSeconds, pushReps, sitReps, totalPoints =0;
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
            totalPoints = getGroup1Score();
        } else if (22 <= personAge && personAge <= 24){
            totalPoints = getGroup2Score();
        } else if (25 <= personAge && personAge <= 27){
            totalPoints = getGroup3Score();
        } else if (28 <= personAge && personAge <= 30){
            totalPoints = getGroup4Score();
        } else if (31 <= personAge && personAge <= 33){
            totalPoints = getGroup5Score();
        } else if (34 <= personAge && personAge <= 36){
            totalPoints = getGroup6Score();
        } else if (37 <= personAge && personAge <= 39){
            totalPoints = getGroup7Score();
        } else if (40 <= personAge && personAge <= 42){
            totalPoints = getGroup8Score();
        } else if (43 <= personAge && personAge <= 45){
            totalPoints = getGroup9Score();
        } else if (46 <= personAge && personAge <= 48){
            totalPoints = getGroup10Score();
        } else if (49 <= personAge && personAge <= 51){
            totalPoints = getGroup11Score();
        } else if (52 <= personAge && personAge <= 54){
            totalPoints = getGroup12Score();
        } else if (55 <= personAge && personAge <= 57){
            totalPoints = getGroup13Score();
        } else {
            totalPoints = getGroup14Score();
        }

    }
    public int getPoints(){
        return totalPoints;
    }
    public String getAward(){
        return award;
    }

    public int getGroup1Score(){

        return 0;
    }
    public int getGroup2Score(){
        return 0;
    }
    public int getGroup3Score(){
        return 0;
    }
    public int getGroup4Score(){
        return 0;
    }
    public int getGroup5Score(){
        return 0;
    }
    public int getGroup6Score(){
        return 0;
    }
    public int getGroup7Score(){
        return 0;
    }
    public int getGroup8Score(){
        return 0;
    }
    public int getGroup9Score(){
        return 0;
    }
    public int getGroup10Score(){
        return 0;
    }
    public int getGroup11Score(){
        return 0;
    }
    public int getGroup12Score(){
        return 0;
    }
    public int getGroup13Score(){
        return 0;
    }
    public int getGroup14Score(){
        return 0;
    }
}

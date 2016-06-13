package ishpal.ipptcalculator;

/**
 * Created by Ishpal on 13/6/2016.
 */
public class MaleCalculator {
    int personAge, runMinutes, runSeconds, pushReps, sitReps, totalPoints;
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

    }
    public int getPoints(){
        return totalPoints;
    }
    public String getAward(){
        return award;
    }
}

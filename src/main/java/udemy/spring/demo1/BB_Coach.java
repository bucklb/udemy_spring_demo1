package udemy.spring.demo1;

public class BB_Coach implements Coach{


    // A dependency to play with.  Give it a setter we can use
    private Motivation motivation;
    public void setMotivation(Motivation motivation) {
        this.motivation = motivation;
    }

    // Allow two approaches to construction. One allows the dependency to be passed in
    public BB_Coach(Motivation theMotivation){
        motivation=theMotivation;
    }
    public BB_Coach(){

    }

    @Override
    public String getDailyWorkout(){
        return "swing it big boy!";
    }

    @Override
    public String getMotivation(){
        if (motivation!=null) {
            return motivation.getMotivation();
        } else {
            return "your fate is in your own hands";
        }

    }

}

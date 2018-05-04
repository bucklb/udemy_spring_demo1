package udemy.spring.demo1;

public class BB_Coach implements Coach{


    private Motivation motivation;
    public BB_Coach(Motivation theMotivation){
//        System.out.println("Constructor called " + theMotivation.getMotivation());
        motivation=theMotivation;
    }

    @Override
    public String getDailyWorkout(){
        return "swing it big boy!";
    }

    @Override
    public String getMotivation() {
        return motivation.getMotivation();
    }

}

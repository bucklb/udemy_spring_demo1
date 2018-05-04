package udemy.spring.demo1;

public class TrackCoach implements Coach {
    @Override
    public String getDailyWorkout(){
        return "run 4 it!";
    }
    @Override
    public String getMotivation() {
        return null;
    }

}

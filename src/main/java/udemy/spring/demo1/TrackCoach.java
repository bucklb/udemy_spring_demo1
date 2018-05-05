package udemy.spring.demo1;

public class TrackCoach implements Coach {
    // A dependency to play with.  Give it a setter we can use
    private Motivation motivation;
    public void setMotivation(Motivation motivation) {
        this.motivation = motivation;
    }

    @Override
    public String getDailyWorkout(){
        return "run 4 it!";
    }
    @Override
    public String getMotivation() {
        if (motivation!=null) {
            return motivation.getMotivation();
        } else {
            return "your fate is in your own hands";
        }
    }

}

package udemy.spring.demo1;

public class RugbyCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Odd shaped balls!";
    }
    @Override
    public String getMotivation() {
        return null;
    }
}

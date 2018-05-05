package udemy.spring.demo1;

public class RugbyCoach implements Coach {

    // A dependency to play with.  Give it a setter we can use
    private Motivation motivation;
    public void setMotivation(Motivation motivation) {
        this.motivation = motivation;
    }

    // Allow two approaches to construction. One allows the dependency to be passed in
    public RugbyCoach(Motivation theMotivation){
        motivation=theMotivation;
    }
    public RugbyCoach(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    private String country;

    public void onInit(){
        System.out.println("What is this place?");
    }
    public void onQuit(){
        System.out.println("Fun whilst it lasted!");
    }



    @Override
    public String getDailyWorkout() {
        return "Odd shaped balls!";
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

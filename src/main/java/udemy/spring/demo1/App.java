package udemy.spring.demo1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Intellij project to go with the Udemy couse (Spring & Hibernate).  Basically working from appContext.xml
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        // Tell Spring that we have context stuff in a file and to go access it in readiness
        // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Put a bit of space between us and the Spring blurb
        System.out.println( "=== It begins =========================================================================" );

        // conventional approach.  Instance a Coach directly
        Motivation motivation=new CarrotMotivation();
        Coach coach=new BB_Coach(motivation);
//        Coach coach=new BB_Coach();
        System.out.println("hard  wired:" +"\t"+ coach.getDailyWorkout() + "\t" + coach.getMotivation());

        Motivation m=context.getBean("myMotivation",Motivation.class);
//        System.out.println(m.getMotivation());


        // get a bean defined in the appCtx xml file with CONSTRUCTOR
        Coach constructorCoach=context.getBean("myConstructorBasedCoach",Coach.class);
        System.out.println("constructor:" +"\t"+ constructorCoach.getDailyWorkout()+ "\t" + constructorCoach.getMotivation());

        // get a bean defined in the appCtx xml file using CONSTRUCTOR.
        // If we want coach specific functionality, cast generic coach to specific one
        Coach setterCoach=context.getBean("mySetterBasedCoach",Coach.class);
        System.out.println("setter     :" +"\t"+ setterCoach.getDailyWorkout()+ "\t" + setterCoach.getMotivation() +
                "\t love: " +((RugbyCoach)setterCoach).getName()+",\t" +((RugbyCoach)setterCoach).getCountry());

        // Prototype allows multiple different coaches (rather than singletons)
        Coach stickCoach =context.getBean("myMultiScopeCoach",Coach.class);
        ((TrackCoach)stickCoach).setMotivation(new StickMotivation());
        Coach carrotCoach=context.getBean("myMultiScopeCoach",Coach.class);
        ((TrackCoach)carrotCoach).setMotivation(new CarrotMotivation());

        System.out.println("stick Track:" +"\t"+ stickCoach.getDailyWorkout()+ "\t" + stickCoach.getMotivation());
        System.out.println("carrotTrack:" +"\t"+ carrotCoach.getDailyWorkout()+ "\t" + carrotCoach.getMotivation());

        // Look at initialise and destroy methods. (for RugbyCoach and RUCoach)
        Coach c =context.getBean("myMethodsCoach",Coach.class);
        RugbyUnionCoach ruc=(RugbyUnionCoach)c;
        System.out.println("method Test:" +"\t"+ ruc.getDailyWorkout()+ "\t" + ruc.getMotivation());



        System.out.println( "=== This too did pass =================================================================" );
        // Close the factor
        context.close();

    }
}

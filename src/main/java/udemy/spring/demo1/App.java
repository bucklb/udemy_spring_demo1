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
        // Tell Spring that we have context stuff in a file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Put a bit of space between us and the Spring blurb
        System.out.println( "=== It begins =========================================================================" );

        // conventional approach.  Instance a Coach directly
        Motivation motivation=new CarrotMotivation();
        Coach coach=new BB_Coach(motivation);
        System.out.println("hard wired:" +"\t"+ coach.getDailyWorkout() + "\t" + coach.getMotivation());

        Motivation m=context.getBean("myMotivation",Motivation.class);
        System.out.println(m.getMotivation());


        // get a bean defined in the appCtx xml file
        Coach resourceCoach=context.getBean("myCoach",Coach.class);
        System.out.println("via file:" +"\t"+ resourceCoach.getDailyWorkout()+ "\t" + resourceCoach.getMotivation());


        System.out.println( "=== This too did pass =================================================================" );
        // Close the factor
//        context.close();

    }
}

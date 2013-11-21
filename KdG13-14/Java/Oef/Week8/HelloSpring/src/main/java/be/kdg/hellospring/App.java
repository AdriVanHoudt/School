package be.kdg.hellospring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("be/kdg/spring/app-context.xml");
        HelloSpring hello = (HelloSpring) context.getBean("hello");
        
        hello.print("Hello World");
    }
}

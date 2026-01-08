import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class MainApp {
    public static void main(String[] args) {

        System.out.println("--- Starting ApplicationContext (Eager Loading) ---");
        // 1. Implementation using ApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // Retrieve the bean by the ID defined in your XML
        UserBean appBean = (UserBean) context.getBean("myUserBean");
        appBean.display();


        System.out.println("\n--- Starting BeanFactory (Lazy Loading) ---");
        // 2. Implementation using BeanFactory (the core engine)
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);

        // Load the definitions from the same XML file
        reader.loadBeanDefinitions(new ClassPathResource("beans.xml"));

        // The bean is created ONLY when getBean is called
        UserBean factoryBean = (UserBean) factory.getBean("myUserBean");
        factoryBean.display();
    }
}
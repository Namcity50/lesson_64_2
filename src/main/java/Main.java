import controller.AuthController;
import db.DataBase;
import db.InitDataBase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        DataBase.initTable();

        InitDataBase.adminInit();
        InitDataBase.addCompanyCard();

//        AuthController authController = new AuthController();
//        authController.start();
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        AuthController authController = (AuthController) context.getBean("authController");
        authController.start();
    }
}

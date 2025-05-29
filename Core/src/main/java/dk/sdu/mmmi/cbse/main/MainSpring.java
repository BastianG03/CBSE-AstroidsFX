package dk.sdu.mmmi.cbse.main;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainSpring extends Application{
    public static void main(String[] args) {
        launch(MainSpring.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ModuleConfiguration.class);
        for (String name : context.getBeanDefinitionNames()) {
            System.out.println(name);
        }
        Game game = context.getBean(Game.class);
        game.start(new Stage());
        game.render();
    }
}

package edu.mum.main;

import java.io.IOException;
import java.net.URL;

import org.springframework.context.ApplicationContext;

import javafx.fxml.FXMLLoader;

public class SpringFXMLLoader {

    private ApplicationContext context;
    
    public SpringFXMLLoader(ApplicationContext context)
    {
        this.context = context;
    }

     // Spring needs to manage FX controller in order to do DI
    public Object load(URL url) {   //, String resources
        FXMLLoader loader = new FXMLLoader(url);
        // Ths is telling the loader that we want to get classes via getBean  in Spring context
        // SPRING is the controller factory...
        loader.setControllerFactory(clazz -> context.getBean(clazz));

        try {
            return loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
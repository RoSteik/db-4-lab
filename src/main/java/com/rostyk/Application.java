/**
 * @author RoSteik (Telegram: @RoSteik)
 * Project: db-4
 * Package: com.rostyk
 * Class: Application
 */

package com.rostyk;

import com.rostyk.view.MyView;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private final MyView view;

    public Application(MyView view) {
        this.view = view;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        view.show();
    }
}

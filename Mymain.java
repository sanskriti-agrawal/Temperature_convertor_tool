package com.intershala.javaFX;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class Mymain extends Application{

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("start");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
        VBox rootNode = loader.load();
        MenuBar menubar = createMenu();
        rootNode.getChildren().add(0,menubar);


        Scene scene = new Scene(rootNode );

        primaryStage.setScene(scene);
        primaryStage.setTitle("Temperature Convertor Tool");
        primaryStage.show();
    }

        private MenuBar createMenu() {
            Menu filemenu=new Menu("File");
            MenuItem newmenuitem=new MenuItem("New");

            newmenuitem.setOnAction(event -> System.out.println("New menu item clicked"));

            SeparatorMenuItem seprator=new SeparatorMenuItem();

            MenuItem quitmenuitem=new MenuItem("Quit");
            quitmenuitem.setOnAction(event -> {
                Platform.exit();
                System.exit(0);
            });

            filemenu.getItems().addAll(newmenuitem,seprator,quitmenuitem);


            Menu helpmenu=new Menu("help");
            MenuItem aboutapp=new MenuItem("About");
            aboutapp.setOnAction(event -> aboutapp());

            helpmenu.getItems().addAll(aboutapp);

            MenuBar menubar=new MenuBar();
            menubar.getMenus().addAll(filemenu,helpmenu);
            return menubar;
    }

    private void aboutapp() {

        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("My first Desktop App");
        alert.setHeaderText("Learning javafx"); //subtitle
        alert.setContentText("i am just a beginner,because every pro was once just a beginner");

        ButtonType button=new ButtonType("YES");
        ButtonType nobutton=new ButtonType("NO");

        alert.getButtonTypes().setAll(button,nobutton);


        Optional<ButtonType> clickedbutton=alert.showAndWait() ;

        if(clickedbutton.isPresent() && clickedbutton.get()==button)
        {
            System.out.println("YES button clicked");
        }
       else
        {
            System.out.println("NO button is clicked");
        }

    }

    @Override
    public void stop() throws Exception{

    }
}

package ui;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class mainInterface {
    public void show(Stage stage){
        Menu fileMenu=new Menu("File");
        Menu editMenu= new Menu("Edit");
        Menu viewMenu =new Menu("View");
        MenuBar menuBar=new MenuBar(fileMenu,editMenu,viewMenu);
        TextArea area=new TextArea();
        BorderPane borderPane=new BorderPane();
        borderPane.setTop(menuBar);
        borderPane.setCenter(area);
        stage.setScene(new Scene(borderPane,600,500));
        stage.setTitle("Notepad");
        stage.show();


    }
}

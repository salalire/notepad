package ui;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class mainInterface {
    public void show(Stage stage){
        Menu fileMenu=new Menu("File");
        Menu editMenu= new Menu("Edit");
        Menu viewMenu =new Menu("View");
        fileMenu.getItems().addAll(
                new MenuItem("New Tab"),
                new MenuItem("New Window"),
                new MenuItem("Open"),
                new MenuItem("recent"),
                new MenuItem("save"),
                new MenuItem("save as"),
                new MenuItem("save all"),
                new MenuItem("close tab"),
                new MenuItem("close window"),
                new MenuItem("exit")
        );

        editMenu.getItems().addAll(
                new MenuItem("Undo"),
                new MenuItem("Copy"),
                new MenuItem("Cut"),
                new MenuItem("Paste"),
                new MenuItem("Delete"),
                new MenuItem("Find"),
                new MenuItem("Find next"),
                new MenuItem("Find previous"),
                new MenuItem("Replace"),
                new MenuItem("Go to"),
                new MenuItem("Select all"),
                new MenuItem("Time/date"),
                new MenuItem("Font")
        );
        viewMenu.getItems().addAll(
                new MenuItem("Zoom"),
                new MenuItem("Status Bar"),
                new MenuItem("Word wrap")

        );
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

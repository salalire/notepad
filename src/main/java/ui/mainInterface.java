package ui;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import logic.FileOperation;

public class mainInterface {
    FileOperation fileOperation=new FileOperation();
    public void show(Stage stage){
        Menu fileMenu=new Menu("File");
        Menu editMenu= new Menu("Edit");
        Menu viewMenu =new Menu("View");
        MenuItem newFile=new MenuItem("New");
        MenuItem open=new MenuItem("open");
        MenuItem newWindow=new MenuItem("New Window");
        MenuItem recent = new MenuItem("recent");
        MenuItem save = new MenuItem("Save");
        MenuItem saveAs = new MenuItem("Save as");
        MenuItem saveAll = new MenuItem("Save All");
        MenuItem closeTab = new MenuItem("Close Tab");
        MenuItem closeWindow = new MenuItem("Close Window");
        MenuItem exit = new MenuItem("Exit");
        fileMenu.getItems().addAll(
                newFile,open, newWindow, recent, save, saveAs,saveAll,closeTab,closeWindow,exit
        );
       MenuItem undo=new MenuItem("Undo");
        MenuItem copy=new MenuItem("Copy");
        MenuItem cut=new MenuItem("Cut");
        MenuItem paste=new MenuItem("Paste");
        MenuItem delete=new MenuItem("Delete");
        MenuItem find=new MenuItem("Find");
        MenuItem findNext=new MenuItem("Find Next");
        MenuItem findPrevious=new MenuItem("Find Previous");
        MenuItem replace=new MenuItem("Replace");
        MenuItem goTo=new MenuItem("Go To");
        MenuItem selectAll=new MenuItem("Select All");
        MenuItem time=new MenuItem("Time/Date");
        MenuItem font=new MenuItem("Font");
        editMenu.getItems().addAll(
                undo,copy,cut,paste,delete,find,findNext,findPrevious,replace,goTo,selectAll,time,font
        );
        MenuItem zoom=new MenuItem("Zoom");
        MenuItem statusBar=new MenuItem("Status Bar");
        MenuItem wordWrap=new MenuItem("Word Wrap");

        viewMenu.getItems().addAll(
                zoom,statusBar,wordWrap
        );
        MenuBar menuBar=new MenuBar(fileMenu,editMenu,viewMenu);
        TextArea area=new TextArea();
        newFile.setOnAction(e->{
            fileOperation.handleNew(area,stage);
        });
        open.setOnAction(e1->{
            fileOperation.handleOpen(area,stage);
        });

        BorderPane borderPane=new BorderPane();
        borderPane.setTop(menuBar);
        borderPane.setCenter(area);
        stage.setScene(new Scene(borderPane,600,500));
        stage.setTitle("Notepad");
        stage.show();


    }
}

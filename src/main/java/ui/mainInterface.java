package ui;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import logic.FileOperation;

import java.io.File;

public class mainInterface {
    FileOperation fileOperation=new FileOperation();
    TabPane tabPane=new TabPane();
    private Tab createNewTab() {
        TextArea area = new TextArea();
        Tab tab = new Tab("Untitled");
        tab.setContent(area);
        tab.setUserData(null);
        return tab;
    }

    private TextArea getCurrentTextArea(TabPane tabPane) {
        Tab selectedTab = tabPane.getSelectionModel().getSelectedItem();
        return (TextArea) selectedTab.getContent();
    }

    private File getCurrentFile(TabPane tabPane){
        Tab selectedTab=tabPane.getSelectionModel().getSelectedItem();
        return (File) selectedTab.getUserData();
    }

    private void SetCurrentFile(TabPane tabPane,File file){
        Tab selectedTab=tabPane.getSelectionModel().getSelectedItem();
        selectedTab.setUserData(file);
        selectedTab.setText(file.getName());
    }

    public void show(Stage stage){
        Menu fileMenu=new Menu("File");
        Menu editMenu= new Menu("Edit");
        Menu viewMenu =new Menu("View");
        MenuItem newFile=new MenuItem("New");
        MenuItem open=new MenuItem("open");
        MenuItem newWindow=new MenuItem("New Window");
        MenuItem newTab=new MenuItem("New Tab");
        MenuItem recent = new MenuItem("recent");
        MenuItem save = new MenuItem("Save");
        MenuItem saveAs = new MenuItem("Save as");
        MenuItem saveAll = new MenuItem("Save All");
        MenuItem closeTab = new MenuItem("Close Tab");
        MenuItem closeWindow = new MenuItem("Close Window");
        MenuItem exit = new MenuItem("Exit");
        fileMenu.getItems().addAll(
                newFile,open, newWindow, newTab,recent, save, saveAs,saveAll,closeTab,closeWindow,exit
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

        newFile.setOnAction(e->{
            TextArea currentArea = getCurrentTextArea(tabPane);
            fileOperation.handleNew(currentArea,stage);
        });
        open.setOnAction(e1->{
            TextArea currentArea = getCurrentTextArea(tabPane);
            File currentFile=fileOperation.handleOpen(currentArea,stage);
            if (currentFile!=null){
                SetCurrentFile(tabPane,currentFile);

            }

        });
        save.setOnAction(e->{
            TextArea currentArea = getCurrentTextArea(tabPane);
            File file =getCurrentFile(tabPane);
            File saved=fileOperation.handleSave(currentArea,stage,file);
            if(saved!=null){
                SetCurrentFile(tabPane,saved);
            }

        });
        saveAs.setOnAction(e->{
            TextArea currentArea = getCurrentTextArea(tabPane);
            fileOperation.handleSaveAs(currentArea,stage);
        });
        newWindow.setOnAction(e->{
            Stage newStage=new Stage();
            new mainInterface().show(newStage);
        });

        Tab firstTab = createNewTab();
        tabPane.getTabs().add(firstTab);
        newTab.setOnAction(e -> {
            Tab newTab1 = createNewTab();
            tabPane.getTabs().add(newTab1);
            tabPane.getSelectionModel().select(newTab1);
        });


        BorderPane borderPane=new BorderPane();
        borderPane.setTop(menuBar);
        borderPane.setCenter(tabPane);
        stage.setScene(new Scene(borderPane,600,500));
        stage.setTitle("Notepad");
        stage.show();


    }
}

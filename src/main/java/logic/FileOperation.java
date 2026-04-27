package logic;

import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import java.io.IOException;
import java.io.File;
import java.nio.file.Files;


public class FileOperation {
    public void handleNew(TextArea textArea,Stage stage){
        textArea.clear();
    }

    public void handleOpen(TextArea textArea,Stage stage ){
     FileChooser fileChooser=new FileChooser();
     fileChooser.setTitle("Open File");
     File file=fileChooser.showOpenDialog(stage);
     if(file!=null){
         try {
             String fileContent=Files.readString(file.toPath());
             textArea.setText(fileContent);
         }
         catch (IOException e){
             e.printStackTrace();

         }
     }

    }

    public void handleSave(TextArea textArea,Stage stage){

    }
}

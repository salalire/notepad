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

    public File handleOpen(TextArea textArea,Stage stage ){
     FileChooser fileChooser=new FileChooser();
     fileChooser.setTitle("Open File");
     File file=fileChooser.showOpenDialog(stage);
     if(file!=null){
         try {
             String fileContent=Files.readString(file.toPath());
             textArea.setText(fileContent);
             return file;
         }
         catch (IOException e){
             e.printStackTrace();

         }
     }
     return null;

    }

    public File handleSave(TextArea textArea,Stage stage, File currentFile){
        if (currentFile==null){
            return handleSaveAs(textArea,stage);
        }
            try {
                Files.writeString(currentFile.toPath(),textArea.getText());
                return currentFile;
            }
            catch (IOException e){
              e.printStackTrace();
            }

            return null;

    }

    public File handleSaveAs(TextArea textArea,Stage stage){
        FileChooser fileChooser=new FileChooser();
        fileChooser.setTitle("Save File");
        File file=fileChooser.showSaveDialog(stage);
        if (file !=null){
           try {
               Files.writeString(file.toPath(),textArea.getText());
               return file;

           }
           catch (IOException e){
               e.printStackTrace();
           }
        }
        return null;
    }
}

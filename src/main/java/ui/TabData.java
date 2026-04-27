package ui;

import java.io.File;

public class TabData {
    private File file;
    private boolean modified;

    public TabData(File file) {
        this.file = file;
        this.modified = false;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public boolean isModified() {
        return modified;
    }

    public void setModified(boolean modified) {
        this.modified = modified;
    }
}
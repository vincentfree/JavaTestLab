package io;

import java.awt.*;
import java.io.File;
import java.util.Date;

class FileInfo {

    public static void main(String args[]) {
        new FileInfo();
    }

    public FileInfo() {
        initDialog();
        System.exit(0);
    }

    public void initDialog() {
        Frame scherm = new Frame("File Dialog");
        final FileDialog fd = new FileDialog(scherm);
        fd.setVisible(true);
        File gekozenBestand = new File(fd.getDirectory(), fd.getFile());
        toonInfo(gekozenBestand);
    }

    public void toonInfo(File f) {
        System.out.println("exists():       " + f.exists());
        System.out.println("getName():      " + f.getName());
        System.out.println("lastModified(): " + new Date(f.lastModified()));
        System.out.println("getParent():    " + f.getParent());
        System.out.println("getPath():      " + f.getPath());
    }
}
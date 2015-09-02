package io;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

class Editor {

    private TextArea area;

    public Editor() {
        Frame frame = new Frame("Editor");                              // Frame aanmaken
        area = new TextArea(30, 100);                                    // Textarea instellen en toevoegen
        area.setEditable(true);
        area.setFont(new Font("MonoSpaced", Font.PLAIN, 12));
        frame.add(area);
        MenuBar bar = new MenuBar();                                    // Menu aanmaken en toevoegen
        bar.add(getMenu());
        frame.setMenuBar(bar);
        frame.addWindowListener(new WindowAdapter() {                    // Frame afsluitbaar maken
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        frame.pack();
        frame.setVisible(true);                                         // Frame tonen
    }


    public static void main(String args[]) {
        new Editor();
    }


    private Menu getMenu() {                                          // Menu aanmaken
        Menu menu = new Menu("File");
        MenuItem open = new MenuItem("Open");
        open.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                openFile();
            }
        });
        menu.add(open);
        MenuItem save = new MenuItem("Save");
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                saveFile();
            }
        });
        menu.add(save);
        MenuItem exit = new MenuItem("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(exit);
        return menu;
    }

    private void openFile() {                                         // File openen
        final String nieuweRegel = "\r\n";
        try {
            FileDialog fd = new FileDialog(new Frame(), "Open een tekstbestand...", FileDialog.LOAD);
            fd.setVisible(true);
            File gekozenBestand = new File(fd.getDirectory(), fd.getFile());

            Reader reader = new FileReader(gekozenBestand);               // Reader aanmaken op basis van File
            BufferedReader bufferedReader = new BufferedReader(reader);
            String tekst = bufferedReader.readLine();

            while (tekst != null) {                                         // regels tekst inlezen
                area.append(tekst + nieuweRegel);                          // en toevoegen aan TextArea
                tekst = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private void saveFile() {
        try {                                                           // File bewaren
            FileDialog fd = new FileDialog(new Frame(), "Bewaar het tekstbestand...", FileDialog.SAVE);
            fd.setVisible(true);
            File gekozenBestand = new File(fd.getDirectory(), fd.getFile());

            Writer writer = new FileWriter(gekozenBestand);// maak de methode hieronder af
            StringReader reader = new StringReader(area.getText());
            char[] buffer = new char[1024];
            int gelezen = 0;

            do {
                gelezen = reader.read(buffer);
                if (gelezen > -1) {
                    writer.write(buffer, 0, gelezen);
                }
            } while (gelezen > -1);
            reader.close();
            writer.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
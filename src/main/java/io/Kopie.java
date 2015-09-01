import java.awt.FileDialog;
import java.awt.Frame;
import java.io.*;

class Kopie {

	public static void main(String args[]) {
		new Kopie();
	}

	public Kopie() {
		initDialog();
		System.exit(0);
	}

	public void initDialog() {
		FileDialog fb = new FileDialog(new Frame(), "Kies bronbestand",
				FileDialog.LOAD);
		fb.setVisible(true);
		FileDialog fd = new FileDialog(new Frame(), "Kies doelbestand",
				FileDialog.SAVE);
		fd.setVisible(true);
		File bronBestand = new File(fb.getDirectory(), fb.getFile());
		File doelBestand = new File(fd.getDirectory(), fd.getFile());
		try {
			kopieer(bronBestand, doelBestand);
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}

	public void kopieer(File bron, File doel) throws IOException {

	}
}

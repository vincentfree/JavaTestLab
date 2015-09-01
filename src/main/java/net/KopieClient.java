import java.awt.FileDialog;
import java.awt.Frame;
import java.io.*;
import java.net.*;

class KopieClient{

  private static String SERVER;
  private int POORT=1234;

	public static void main(String args[]) {
		SERVER=args[0];
		new KopieClient();
	}

	public KopieClient() {
		initDialog();
		System.exit(0);
	}

	public void initDialog() {
		final FileDialog fb = new FileDialog(new Frame(), "Kies bestand",
				FileDialog.LOAD);
		fb.setVisible(true);
		File bronBestand = new File(fb.getDirectory(), fb.getFile());
		try {
			kopieer(bronBestand);
		} catch (UnknownHostException uhe) {
		  System.err.println("Onbekend IP adres");
		} catch (IOException ie) {
			System.err.println("Bronbestand niet gevonden");
		} 
	}

	public void kopieer(File bron) throws IOException, UnknownHostException {
	
	  // maak de server socket en een DataOutputStream aan;


    // en schrijf de lengte van de bestandsnaam, 
    // en de bestandsnaam zelf naar de output stream
    
	  
		byte[] buffer = new byte[1024];             // buffer aanmaken voor lezen en schrijven in delen
		InputStream input = new FileInputStream(bron);
    int gelezen=0;
    do {
      gelezen = input.read(buffer);
      if(gelezen>0) {
        output.write(buffer,0,gelezen);
      }
    } while (gelezen != -1);
    
   // sluit de input stream, de output stream en de server socket.

    System.out.println("Bestand staat op de server.");
	}
}

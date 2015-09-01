import java.io.*;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

public class WerknemersKantoren 
{   
  // een dubbele backslash om niet aan te geven dat er een escape karakter gebruikt moet worden
  static String lokatie = "H:\\java\\io\\opdrachten\\";
  static File f = new File(lokatie+"werknemers_kantoren.txt");

  public static void main(String[] args)
  {
    maakObjecten();
    leesObjecten();
  }
  
  static void maakObjecten()
  {
    try
    {
      FileReader in = new FileReader(f);
      LineNumberReader lineIn = new LineNumberReader(in);

      boolean end = false;
      while (!end)
      {
        try
        {
          Werknemer werkn = new Werknemer();
          // eigenschappen werknemer inlezen

          Kantoor kant = new Kantoor();
          // eigenschappen kantoor inlezen en kantoor aan werknemer koppelen
          
          // de achtste regel is de scheidingsregel naar de volgende werknemer
          // als deze niet bestaat is het einde van de file bereikt.
          if (lineIn.readLine() == null)
          {
            end = true;
          }

          // Schrijf de werknemer weg als object:
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }
      }
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace(); 
    }
  }
  
  static void leesObjecten()
  {
    Collection<Werknemer> werknemers = new Vector<Werknemer>();
    File dir = new File(lokatie);
    String[] listing = dir.list();
    for (int i=0; i<listing.length; i++)
    {
      if (listing[i].indexOf(".obj") != -1 )
      {
        try
        {
          // lees werknemer in en voeg toe aan vector werknemers
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }
      }
    }
    if (werknemers != null)
    {
      File f = new File(lokatie+"werknemers_tabel.csv");
      try
      {
         // doorloop de werknemers vector
         // en schrijf elke werknemer als regel weg in werknemers_tabel.csv
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    
    
  }
}

import java.util.*;

class KaartSpel extends ArrayList<KaartSpel.Kaart> {
	
  public static void main(String[] args) {
    KaartSpel kaartSpel = new KaartSpel();
		
    for (Waarden waarde: Waarden.values()) {
      for (Kleuren kleur: Kleuren.values()) {
        Kaart kaart = kaartSpel.new Kaart(waarde, kleur);
        kaartSpel.add(kaart);
      }
    }
    kaartSpel.add(kaartSpel.new Kaart(Waarden.TWEE, Kleuren.HARTEN));

    for (KaartSpel.Kaart kaart : kaartSpel) {
      System.out.println(kaart);
    }
		
    Collections.shuffle(kaartSpel, new Random());

    System.out.println("################## NA HET SCHUDDEN ###################");
		
    for (KaartSpel.Kaart kaart : kaartSpel) {
      System.out.println(kaart);
    }
}
			
  enum Kleuren {
    HARTEN, RUITEN , SCHOPPEN, KLAVER
  }

  enum Waarden {
    TWEE, DRIE, VIER, VIJF, ZES, ZEVEN , ACHT, NEGEN, TIEN, BOER, VROUW, HEER, AAS;
  }
	
  class Kaart {
    Waarden waarde;
    Kleuren kleur;
	
    Kaart(Waarden waarde, Kleuren kleur) {
      this.waarde = waarde;
      this.kleur = kleur;
    }
		
    public String toString(){
      return "Kaart met waarde: " + waarde + ", en kleur: " + kleur;
    }
  }
}
public class Werknemer
{
  private int persnr;
  private String naam;
  private String functie;
  private int sal;
  private Kantoor kantoor;

  public Werknemer()
  {
  }

  public int getPersnr()
  {
    return persnr;
  }

  public void setPersnr(int persnr)
  {
    this.persnr = persnr;
  }

  public String getNaam()
  {
    return naam;
  }

  public void setNaam(String naam)
  {
    this.naam = naam;
  }

  public String getFunctie()
  {
    return functie;
  }

  public void setFunctie(String functie)
  {
    this.functie = functie;
  }

  public int getSal()
  {
    return sal;
  }

  public void setSal(int sal)
  {
    this.sal = sal;
  }

  public Kantoor getKantoor()
  {
    return kantoor;
  }

  public void setKantoor(Kantoor kantoor)
  {
    this.kantoor = kantoor;
  }
 

}

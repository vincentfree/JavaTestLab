import java.io.*;
import java.util.*;

class Moment implements Serializable {
  
  private Date tijd=null; 
  
  public void setTijd() {
    Calendar c = Calendar.getInstance();
    tijd = c.getTime();
  }
  
  public Date getTijd() {
    return tijd;
  }

}
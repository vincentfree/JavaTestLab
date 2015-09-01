import java.text.NumberFormat;
import java.text.DecimalFormat;
import java.util.Locale;

class NumberFormatApp {
   
   public static void main (String args[]) {
     NumberFormat nf = NumberFormat.getCurrencyInstance();
     nf.setMaximumFractionDigits(nf.getCurrency().getDefaultFractionDigits());
     for(int i=0;i<10;i++) {
       System.out.println(nf.format(5000 - Math.random()*10000));
     }     
  }
}
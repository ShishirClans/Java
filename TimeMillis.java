import java.util.Scanner;
public class TimeMillis{
    public static void main(String[] args){
        long tms = System.currentTimeMillis();
        long ts = tms / 1000;
        long cs = ts % 60;    // current second , total second   ////
        long tm = ts/ 60;     // total minute
       // long th = tm /60;        // total hour  ?????? 
        long cm = tm%60;     // current minute    ///
        long th = tm / 60;
        long ch= th % 24;     ///  mm
        System.out.println((ch-12)+":"+cm+":"+cs+"GMT");   // -12 for the 12 hr format
     }
}
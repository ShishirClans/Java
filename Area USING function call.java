import java.util.Scanner;
public class TakeInput{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Radius:");
        double radius = input.next.Double();
        double area;
        final float PI = 3.142f;
        area= computeAreaOfCircle(radius, PI);
        // area= radius*radius* PI;
        System.out.println("Area of Circle is:"+area);
    }
    
    double computeAreaofCircle(double radius, float PI){
        return radius*radius*PI;
    }


   
}
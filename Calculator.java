import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Choose your operation");
        System.out.println("1 For Addition");
        System.out.println("2 for Substraction ");
        System.out.println("3 for Multiplication");
        System.out.println("4 for Division");

        int choose = sc.nextInt();


        System.out.println(" Enter 2 numbers");
        int x = sc.nextInt();
        int y = sc.nextInt();

        if( choose ==1 ) {
            System.out.println(" Addition is "+ Add(x,y));

        }
        else if ( choose ==2 ){
            System.out.println((" Substration is "+ Sub(x,y)));

        }
        else if(choose==3){
            System.out.println("Multiplication is "+ Mul(x,y));
        }

        else if(choose== 4){
            System.out.println("Division is "+ Div(x,y));


        }
        else
        System.out.println("Out of Range");
        }

    public static int Add(int x, int y){
        int n;
        n=x+y;
        return n;
    }
    public static int Sub(int x, int y){
        int n;
        n=x-y;
        return n;
    }
    public static int Mul(int x, int y){
        int n;
        n=x*y;
        return n;
    }
    public static double Div(int x, int y){
        double n = 0;
        if(y!=0){
           n=x/y;
        }
        return n;
    }

}


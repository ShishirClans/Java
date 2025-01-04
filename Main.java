import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int count=0;
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        for(int i=1; i<=n ; i++) {
            if (n % i == 0) {
                count++;
                i++;
                System.out.println(n);
            }
        }
        if(count==2)
            System.out.println(+n+" Is a Prime number");
        else
            System.out.println("Try again");
    }
}
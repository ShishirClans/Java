
class Pen     // We define Blueprints for pen now.. like the properties of a pen
{
    String color;
    String type; // ballpoint; gel pen, etc...

    //We can define methods in a class
    public void write(){
        System.out.println("Writing Something....");
    }

    public void printColor(){
        System.out.println(this.color);   // this is a keyword that tells, which object called this function.
    }
}


public class OOPS {
    public static void main(String[] args) {

        //Creating object here

        Pen pen1 = new Pen();
        //defining the color and its type
        pen1.color = "red";  // we used that DOT to access the property from the class we created above
        pen1.type = "gel";
        pen1.write();

        Pen pen2 = new Pen();
        pen2.color = "Pen 2 color is black";
        pen2.type = "ballpoint";

        pen1.printColor();
        pen2.printColor();
    }
}



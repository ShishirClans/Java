class Pen {    // Blue print defining for pen
    String color; 
    String type; //Ball or gelpen
    //and This class has a function as well 
    public void write() {
        System.out.println(" Writing Something");
    }

    public void printColor(){
        System.out.println(this.color);
    }
}

//Inside main function we make Objects for classes(Eg. Pen) inside the Main function

public class OOPS{ 
    public static void main(String[] args){

        Pen pen1= new Pen();
        //All properties of Pen (like color, type). To use them, we use dot ( eg: pen1.color) 
        pen1.color = "blue";
        pen1.type = "Gel";
        //Let's say we want to write something, so we gotta call the write function 
        //pen1.write();

        //Let's create pen2
        Pen pen2 = new Pen();
        pen2.color = "black";
        pen2.type = "Ball pen";

        //pen1 and pen2 are calling the 
        pen1.printColor();
        pen2.printColor();
    
    }
    

}
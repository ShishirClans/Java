public class TestOctagon {
    public static void main(String[] args) {
        // Create an Octagon object with a side length of 5.0
        Octagon oct1 = new Octagon(5.0);

        // Initialize oct2 to null
        Octagon oct2 = null;

        try {
            // Clone oct1 to create oct2
            oct2 = oct1.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning is not supported.");
        }

        // Display the properties of oct1 and oct2
        System.out.println("Properties of oct1: " + oct1);
        System.out.println("Properties of oct2: " + oct2);

        // Compare oct1 and oct2 using the compareTo method
        System.out.println("Comparison result (oct1.compareTo(oct2)): " + oct1.compareTo(oct2));

        // Change the side length of oct1 to 5.2
        oct1 = new Octagon(5.2);

        // Display the updated properties of oct1 and the previous properties of oct2
        System.out.println("Updated properties of oct1: " + oct1);
        System.out.println("Previous properties of oct2: " + oct2);

        // Compare oct1 and the previous oct2 using the compareTo method again
        System.out.println("Comparison result (oct1.compareTo(oct2)): " + oct1.compareTo(oct2));
    }
}

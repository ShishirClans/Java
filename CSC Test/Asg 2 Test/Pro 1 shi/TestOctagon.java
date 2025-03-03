/* Name- Shishir Ghorashainee
   Course - CSC 360
   Professor Yangyang Tao
 */


public class TestOctagon {
    public static void main(String[] args) {
        Octagon oct1 = new Octagon(5.0);
        Octagon oct2 = null;

        try {
            oct2 = (Octagon) oct1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println("oct1: " + oct1);
        System.out.println("oct2: " + oct2);
        System.out.println("oct1.compareTo(oct2): " + oct1.compareTo(oct2));

        oct1.setSide(5.2);

        System.out.println("oct1: " + oct1);
        System.out.println("oct2: " + oct2);
        System.out.println("oct1.compareTo(oct2): " + oct1.compareTo(oct2));
    }
}

/* Name- Shishir Ghorashainee
   Course - CSC 360
   Professor Yangyang Tao
 */

public class Octagon extends GeometricObject implements Comparable<Octagon>, Cloneable {
    private double side;
    private boolean isClone;

    public Octagon(double side) {
        this.side = side;
        this.isClone = false;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getPerimeter() {
        return 8 * side;
    }

    public double getArea() {
        return (2 + 4 / Math.sqrt(2)) * side * side;
    }

    public boolean isClone() {
        return isClone;
    }

    public void setClone(boolean isClone) {
        this.isClone = isClone;
    }

    @Override
    public String toString() {
        return "Octagon with side = " + side + " perimeter = " + getPerimeter() + " area = " + getArea() +
                " isClone = " + isClone();
    }

    @Override
    public int compareTo(Octagon o) {
        if (this.side < o.side) {
            return -1;
        } else if (this.side > o.side) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Octagon clone = (Octagon) super.clone();
        clone.setClone(true);
        return clone;
    }
}

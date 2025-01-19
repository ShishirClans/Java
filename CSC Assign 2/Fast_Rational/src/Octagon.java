

class Octagon extends GeometricObject implements Comparable<Octagon>, Cloneable {
    private double side;
    private boolean isClone;

    public Octagon(double side) {
        this.side = side;
        this.isClone = false;
    }

    public double getSide() {
        return side;
    }

    public double getPerimeter() {
        return 8 * side;
    }

    public double getArea() {
        return (2 + 4 / Math.sqrt(2)) * side * side;
    }

    @Override
    public String toString() {
        return String.format("Octagon with side = %.1f perimeter = %.1f area = %.2f isClone = %s",
                side, getPerimeter(), getArea(), isClone);
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
    public Octagon clone() throws CloneNotSupportedException {
        Octagon clone = (Octagon) super.clone();
        clone.isClone = true;
        return clone;
    }
}

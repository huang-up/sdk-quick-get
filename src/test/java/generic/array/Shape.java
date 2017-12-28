package generic.array;

/**
 * Created by h on 2017/11/2.
 */
public abstract class Shape implements Comparable<Shape> {
    protected float radius;
    @Override
    public int compareTo(Shape o) {
        int result = 0;
        if (o != null ) {
            Shape instance = (Shape) o;
            if (instance.radius > this.radius) {
                result = 1;
            }
        }
        return result;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + " " + this.radius;
    }
}

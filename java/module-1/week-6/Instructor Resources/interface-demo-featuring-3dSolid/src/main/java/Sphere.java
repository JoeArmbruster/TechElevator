public class Sphere implements ThreeDimensionalSolid {

   private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getVolume() {
        double volume = 4.0 / 3 * Math.PI * Math.pow(radius, 3); // radius ^ 3
        return volume;
    }

    @Override
    public double getSurfaceArea() {
        double surfaceArea = 4 * Math.PI * radius * radius;
        return surfaceArea;
    }

    @Override
    public String getDimensions() {
        String s = "Radius: " + radius;
        s += "\nVolume: " + getVolume();
        s+= "\nSurface Area: " + getSurfaceArea();
        return s;
    }

    @Override
    public String toString() {
        String s = "\nSPHERE ";
        s += "\n" + getDimensions();
        return s;
    }
}

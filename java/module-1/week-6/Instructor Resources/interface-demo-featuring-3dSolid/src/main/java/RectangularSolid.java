public class RectangularSolid implements ThreeDimensionalSolid{
    private int length;
    private int width;
    private int height;

    // Constructor(s)
    public RectangularSolid (int length, int width, int height){
        this.length = length;
        this.width = width;
        this.height = height;
    }

    // Getters

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    // from the Interface

    @Override
    public double getVolume() {
        int volume = length * width * height;
        return volume;
    }

    @Override
    public double getSurfaceArea() {
        double surfaceArea = 2 * ((length * width) + (width * height) + (length * height));
        return surfaceArea;
    }

    @Override
    public String getDimensions() {
        String s = "Length: " + length + ", Width: " + width + ", Height: " + height;
        s += "\nVolume: " + getVolume();
        s+= "\nSurface Area: " + getSurfaceArea();
        return s;
    }

    @Override
    public String toString(){
        String s = "\nRECTANGULAR SOLID: ";
        s += "\n" + getDimensions();
        return s;
    }
}

import java.util.ArrayList;
import java.util.List;

public class ThreeDimensionalSolidDemo {
    public static void main(String[] args) {
        List<ThreeDimensionalSolid> solids = new ArrayList<>();

        solids.add (new RectangularSolid(2, 2, 3));
        solids.add (new Sphere(3.0));

        for (ThreeDimensionalSolid solid : solids){
            System.out.println(solid);
        }


    }
}

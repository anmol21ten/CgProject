import org.apache.commons.math3.linear.RealMatrix;

public interface CoordinateGenerator {
    public RealMatrix generateCoordinates(double[][] inputMatrix, double m, double c);
}

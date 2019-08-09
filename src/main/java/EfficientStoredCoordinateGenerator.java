import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;

public class EfficientStoredCoordinateGenerator implements CoordinateGenerator {
    @Override
    public RealMatrix generateCoordinates(double[][] inputMatrix, double m, double c) {
        double angle = Math.toRadians(Math.toDegrees(Math.atan(m)));
        RealMatrix rInputMatrix = new Array2DRowRealMatrix(inputMatrix);

        double cos2Angle = Math.cos(2*angle);
        double sin2Angle = Math.sin(2*angle);

        double[][] transformMatrix =   {{cos2Angle,sin2Angle,0},
                                        {sin2Angle,-cos2Angle,0},
                                        {-c*sin2Angle,c*cos2Angle+c,1}};
        RealMatrix rTransformMatrix= new Array2DRowRealMatrix(transformMatrix);

        rInputMatrix = rInputMatrix.multiply(rTransformMatrix);

        return rInputMatrix;
    }
}

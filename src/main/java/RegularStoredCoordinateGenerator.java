import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;

public class RegularStoredCoordinateGenerator implements CoordinateGenerator {
    @Override
    public RealMatrix generateCoordinates(double[][] inputMatrix, double m, double c) {
        double angle = Math.toRadians(Math.toDegrees(Math.atan(m)));
        RealMatrix rInputMatrix = new Array2DRowRealMatrix(inputMatrix);

        double cosAngle = Math.cos(angle);
        double sinAngle = Math.sin(angle);

        double[][] transformMatrix =   {{(cosAngle*cosAngle)-(sinAngle*sinAngle),2*sinAngle*cosAngle,0},
                                        {2*sinAngle*cosAngle,(sinAngle*sinAngle)-(cosAngle*cosAngle),0},
                                        {-2*c*sinAngle*cosAngle,c*(cosAngle*cosAngle)-c*(sinAngle*sinAngle)+c,1}};
        RealMatrix rTransformMatrix= new Array2DRowRealMatrix(transformMatrix);

        rInputMatrix = rInputMatrix.multiply(rTransformMatrix);

        return rInputMatrix;
    }
}

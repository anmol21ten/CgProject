import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;

public class EfficientCoordinateGenerator implements CoordinateGenerator {
    @Override
    public RealMatrix generateCoordinates(double[][] inputMatrix, double m, double c) {
        double angle = Math.toRadians(Math.toDegrees(Math.atan(m)));
        RealMatrix rInputMatrix = new Array2DRowRealMatrix(inputMatrix);

        double[][] transformMatrix1 =   {{1,0,0},
                                         {0,-1,0},
                                         {0,0,1}};
        RealMatrix rTransformMatrix1= new Array2DRowRealMatrix(transformMatrix1);

        rInputMatrix = rInputMatrix.multiply(rTransformMatrix1);
        double cos2Angle = Math.cos(2*angle);
        double sin2Angle = Math.sin(2*angle);

        double[][] transformMatrix2 =   {{cos2Angle,sin2Angle,0},
                                         {-sin2Angle,cos2Angle,0},
                                         {0,0,1}};
        RealMatrix rTransformMatrix2= new Array2DRowRealMatrix(transformMatrix2);

        rInputMatrix = rInputMatrix.multiply(rTransformMatrix2);

        double[][] transformMatrix3 =   {{1,0,0},
                                         {0,1,0},
                                         {-c*sin2Angle,c*cos2Angle+c,1}};
        RealMatrix rTransformMatrix3= new Array2DRowRealMatrix(transformMatrix3);

        rInputMatrix = rInputMatrix.multiply(rTransformMatrix3);

        return rInputMatrix;

    }
}

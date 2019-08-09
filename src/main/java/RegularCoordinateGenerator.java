import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import java.math.*;

public class RegularCoordinateGenerator implements CoordinateGenerator {
    @Override
    public RealMatrix generateCoordinates(double[][] inputMatrix, double m, double c) {
        double angle = Math.toRadians(Math.toDegrees(Math.atan(m)));
        RealMatrix rInputMatrix = new Array2DRowRealMatrix(inputMatrix);

        double[][] transformMatrix1 =   {{1,0,0},
                                         {0,1,0},
                                         {0,-c,1}};
        RealMatrix rTransformMatrix1= new Array2DRowRealMatrix(transformMatrix1);

        rInputMatrix = rInputMatrix.multiply(rTransformMatrix1);
        double cosAngle = Math.cos(angle);
        double sinAngle = Math.sin(angle);

        double[][] transformMatrix2 =   {{cosAngle,-sinAngle,0},
                                        {sinAngle,cosAngle,0},
                                        {0,0,1}};
        RealMatrix rTransformMatrix2= new Array2DRowRealMatrix(transformMatrix2);

        rInputMatrix = rInputMatrix.multiply(rTransformMatrix2);

        double[][] transformMatrix3 =   {{1,0,0},
                                        {0,-1,0},
                                        {0,0,1}};
        RealMatrix rTransformMatrix3= new Array2DRowRealMatrix(transformMatrix3);

        rInputMatrix = rInputMatrix.multiply(rTransformMatrix3);

        double[][] transformMatrix4 =   {{cosAngle,sinAngle,0},
                                         {-sinAngle,cosAngle,0},
                                         {0,0,1}};
        RealMatrix rTransformMatrix4= new Array2DRowRealMatrix(transformMatrix4);

        rInputMatrix = rInputMatrix.multiply(rTransformMatrix4);

        double[][] transformMatrix5 =   {{1,0,0},
                                         {0,1,0},
                                         {0,-c,1}};
        RealMatrix rTransformMatrix5= new Array2DRowRealMatrix(transformMatrix5);

        rInputMatrix = rInputMatrix.multiply(rTransformMatrix5);

        return rInputMatrix;

    }
}

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;

public class ReflectionApplication {

    public static void main(String[] args) {
        double[][] inputMatrix = {{53.3,343.3,11.1},
                                 {4.5,6.4,133.1},
                                 {2.2,6.5,1}};

        double m = 0.4;
        double c = 7.5;
        long startTime1 = System.nanoTime();
        RealMatrix resultMatrix1 = new RegularCoordinateGenerator().generateCoordinates(inputMatrix,m,c);
        long endTime1 = System.nanoTime();

        System.out.println("Time for Regular Method is:"+(endTime1-startTime1));
        System.out.println("ResultMatrix 1 is "+resultMatrix1.toString());

        long startTime3 = System.nanoTime();
        RealMatrix resultMatrix3 = new EfficientCoordinateGenerator().generateCoordinates(inputMatrix,m,c);
        long endTime3 = System.nanoTime();

        System.out.println("Time for Effective Method is:"+(endTime3-startTime3));
        System.out.println("ResultMatrix 3 is "+resultMatrix3.toString());

        long startTime4 = System.nanoTime();
        RealMatrix resultMatrix4 = new EfficientStoredCoordinateGenerator().generateCoordinates(inputMatrix,m,c);
        long endTime4 = System.nanoTime();

        System.out.println("Time for Effective Stored Method is:"+(endTime4-startTime4));
        System.out.println("ResultMatrix 4 is "+resultMatrix4.toString());

        long startTime2 = System.nanoTime();
        RealMatrix resultMatrix2 = new RegularStoredCoordinateGenerator().generateCoordinates(inputMatrix,m,c);
        long endTime2 = System.nanoTime();

        System.out.println("Time for Regular Stored Method is:"+(endTime2-startTime2));
        System.out.println("ResultMatrix 2 is "+resultMatrix2.toString());


    }
}

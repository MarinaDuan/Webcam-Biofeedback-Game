package Tester;
import org.opencv.core.*;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;

public class DisplayTester {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        String filePath = "src/CoffeeMeme.jpg";
        Mat originalImage = Imgcodecs.imread(filePath);
        if (originalImage.dataAddr() == 0) {
            System.out.println("Couldn't open the file " + filePath);
        } else {
            HighGui.namedWindow("Original Image");
            HighGui.imshow("Original Image", originalImage);
            HighGui.waitKey();
        }

    }

}
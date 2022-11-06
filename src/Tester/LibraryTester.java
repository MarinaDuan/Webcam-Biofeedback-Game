package Tester;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

public class LibraryTester {
    // unit test whether the openCv is added or not
    public static void main(String[] args) {
        // import the library
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        // identify the matrix
        Mat mat = Mat.eye(3, 3, CvType.CV_8UC(1));
        // plus more concatenate to display the matrix
        System.out.println("mat = " + mat.dump());
    }
}
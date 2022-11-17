package Tester;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

public class CaptureTester {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        VideoCapture capture = new VideoCapture(0);
        capture.set(Videoio.CAP_PROP_FRAME_WIDTH, 800);
        capture.set(Videoio.CAP_PROP_FRAME_HEIGHT, 600);
        // exception handling
        if(!capture.isOpened()) {
            System.out.println("Unable to open the camera.");
            capture.release();
        }

        HighGui.namedWindow("Webcam Video Capture");
        Mat frame = new Mat();
        // Only works if the webcam is idle. If the webcam resource is used by other application, it will get the error.
        while (true) {
            capture.read(frame);
            if(frame.empty()) {
                System.out.println("Empty framework.\nPlease make sure your webcam is idle.");
                break;
            }
            HighGui.imshow("Webcam Video Capture", frame);
            // exit if user press the esc key
            if (HighGui.waitKey(10) == 27) {
                break;
            }
        }
        HighGui.destroyAllWindows();
        capture.release();
        System.exit(0);
    }
}

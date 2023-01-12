package Components;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

class ImageFrameWindow extends JFrame{
    JLabel imageLabel;
    public ImageFrameWindow(String title) {
        super(title);
        imageLabel = new JLabel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(imageLabel);
        setVisible(true);
    }

    // accept matrix from openCV
    private BufferedImage MatToBufferedImage(Mat matrix) {
        int type = BufferedImage.TYPE_BYTE_GRAY;
        if (matrix.channels() > 1) {
            type = BufferedImage.TYPE_3BYTE_BGR;
        }

        int bufferSize = matrix.channels() * matrix.cols() * matrix.rows();
        byte[] buffer = new byte[bufferSize];
        // get all the pixels
        matrix.get(0, 0, buffer);
        BufferedImage image = new BufferedImage(matrix.cols(), matrix.rows(), type);
        final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        System.arraycopy(buffer, 0, targetPixels, 0, buffer.length);
        return image;
    }

    public void setImage(Mat matImage) {
        Image image = MatToBufferedImage(matImage);
        ImageIcon imgIcon = new ImageIcon(image);
        setSize(matImage.cols(), matImage.rows());
        imageLabel.setIcon(imgIcon);
        imageLabel.repaint();
    }
}

public class StillImageWindow {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        String filePath = "src/coffeeMeme.jpg";
        // for openCV 2.5 highgui Mat img = Highgui.imread(filePath);
        Mat img = Imgcodecs.imread(filePath);

        ImageFrameWindow frameWindow = new ImageFrameWindow("Still Image");
        frameWindow.setImage(img);
    }
}

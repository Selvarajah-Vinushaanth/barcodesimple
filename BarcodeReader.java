import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BarcodeReader {
    public static void main(String[] args) {
        String filePath = "C://Users//Vinushaanth//Desktop//ss//barcode.png"; // Path to the barcode image file
        try {
            String barcodeText = readBarcode(filePath);
            System.out.println("Barcode text: " + barcodeText);
        } catch (IOException | NotFoundException e) {
            System.err.println("Could not read barcode, " + e.getMessage());
        }
    }

    private static String readBarcode(String filePath) throws IOException, NotFoundException {
        BufferedImage bufferedImage = ImageIO.read(new File(filePath));
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(bufferedImage)));
        Result result = new MultiFormatReader().decode(binaryBitmap);
        return result.getText();
    }
}

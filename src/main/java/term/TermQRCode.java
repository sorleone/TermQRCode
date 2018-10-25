package term;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class TermQRCode {

  private static final String LINE_SEPARATOR = System.lineSeparator();
  private final StringBuilder stringBuilder = new StringBuilder();
  private final QRCodeWriter qrCodeWriter = new QRCodeWriter();
  private String set = "  ";
  private String unset = new String(new char[2]).replace('\0', Character.toChars(9608)[0]);
  private int padding = 3;

  /**
  * Generates a QR Code with the given content.
  *
  * @param content The content to be encoded in the QR Code.
  * @return A String containing the generated QR Code.
  * @throws WriterException if content cannot be encoded legally in a format.
  */
  public String generate(String content) throws WriterException {
    final BitMatrix bitMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, 0, 0);
    final int height = bitMatrix.getHeight() - padding;
    final int width = bitMatrix.getWidth() - padding;
    stringBuilder.setLength(0);

    for (int y = padding; y < height; y++) {
      for (int x = padding; x < width; x++) {
        stringBuilder.append(bitMatrix.get(x, y) ? set : unset);
      }
      stringBuilder.append(LINE_SEPARATOR);
    }

    return stringBuilder.toString().trim();
  }

  /**
  * Sets the padding that will be used to generate the QR Code.
  *
  * @param padding the value of the padding to add.
  * @return this
  */
  public TermQRCode setPadding(int padding) {
    if(padding >= 0 && padding <= 4) {
      this.padding = 4 - padding;
    } else {
      throw new IllegalArgumentException("Padding value must be between 1 and 4.");
    }
    return this;
  }

  /**
  * Inverts the colors of the QR Code so that it can be adapted to different terminal colors.
  *
  * @return this
  */
  public TermQRCode invertColors() {
    String tmp = set;
    set = unset;
    unset = tmp;
    return this;
  }
}

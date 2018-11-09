import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class enc {
  public static void main(String[] args) throws IOException {
    if (args[0].equals("enc")) {
      encrypt(args);
    }
    if (args[0].equals("dec")) {
      decrypt(args);
    }
  }

  public static void encrypt(String[] args) throws IOException {
    File rfile = new File(args[1]);
    byte[] bytesArray = new byte[(int) rfile.length()];
    FileInputStream fis = new FileInputStream(rfile);

    fis.read(bytesArray); // read file into bytes[]
    fis.close();
    System.out.println(bytesArray.length + " Total Bytes");
    for (int x = 0; x < bytesArray.length; x++) {
      bytesArray[x] = mutateByte(bytesArray[x]);
      System.out.println(bytesArray[x]);
    }
    File wfile = new File(args[1]);
    FileOutputStream fos = new FileOutputStream(wfile);

    fos.write(bytesArray);
    return;
  }

  public static void decrypt(String[] args) throws IOException {
    File rfile = new File(args[1]);
    byte[] bytesArray = new byte[(int) rfile.length()];
    FileInputStream fis = new FileInputStream(rfile);

    fis.read(bytesArray); // read file into bytes[]
    fis.close();
    System.out.println(bytesArray.length + " Total Bytes");
    for (int x = 0; x < bytesArray.length; x++) {
      bytesArray[x] = fixByte(bytesArray[x]);
      System.out.println(bytesArray[x]);
    }
    File wfile = new File(args[1]);
    FileOutputStream fos = new FileOutputStream(wfile);

    fos.write(bytesArray);
    return;
  }

  public static byte mutateByte(byte oldbyte) {
    byte newbyte;
    newbyte = (byte) (((int) oldbyte) - 2);

    return newbyte;
  }

  public static byte fixByte(byte oldbyte) {
    byte newbyte;
    newbyte = (byte) (((int) oldbyte) + 2);
    return newbyte;
  }
}
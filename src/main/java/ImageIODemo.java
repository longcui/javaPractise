import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;

/**
 * Created by long on 27.02.2017.
 * http://stackoverflow.com/questions/1143293/how-to-convert-array-of-bytes-into-image-in-java-se
 * jAI: http://www.oracle.com/technetwork/java/javasebusiness/downloads/java-archive-downloads-java-client-419417.html#jaiio-1.0_01-oth-JPR
 * http://www.oracle.com/technetwork/java/install-jai-imageio-1-0-01-139659.html#Manual
 */
public class ImageIODemo {
    public static void main(String[] args){
        try {
            long l = System.currentTimeMillis();
            File file = new File("C:\\linqfiles\\files\\270000035.jpg");        //5mb
            BufferedImage bufferedImage = ImageIO.read(file);
            System.out.println(bufferedImage.getMinX());
            long l1 = System.currentTimeMillis();
            long l2 = l1 - l;
            System.out.println("time for reading from file: " + l2 + "ms");     //3338ms

//            l = System.currentTimeMillis();
//            byte[] bytes = Files.readAllBytes(Paths.get("C:\\linqfiles\\files\\270000035.idf"));
//            bufferedImage = ImageIO.bufferedImage(new ByteArrayInputStream(bytes));
//            System.out.println(bufferedImage.getMinX());
//            l1 = System.currentTimeMillis();
//            l2 = l1 - l;
//            System.out.println("time for reading from bytes: " + l2 + "ms");
//            System.out.println(bytes.length);

            l = System.currentTimeMillis();
            File tempFile = File.createTempFile("bufferedImage", "tmp");
            FileOutputStream fileOutputStream = new FileOutputStream(tempFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            WritableRaster raster = bufferedImage.getRaster();
            byte[] pixels = ((DataBufferByte) raster.getDataBuffer()).getData();
            System.out.println("pixels.length:" + pixels.length);
            objectOutputStream.writeObject(pixels);
            objectOutputStream.flush();

            int width = raster.getWidth();
            int height = raster.getHeight();
            l1 = System.currentTimeMillis();
            l2 = l1 - l;
            System.out.println("time for write bytes to disk: " + l2 + "ms");

            l = System.currentTimeMillis();
            FileInputStream fileInputStream = new FileInputStream(tempFile);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            byte[] bytes = (byte[]) objectInputStream.readObject();
            System.out.println(bytes.length);

//            BufferedImage bufferedImage1 = new BufferedImage(
//                    new DirectColorModel(24,
//                    0x00ff0000,   // Red
//                    0x0000ff00,   // Green
//                    0x000000ff,   // Blue
//                    0x0           // Alpha
//            ));
//            System.out.println(read.getMinX());
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
            DataBuffer buffer = new DataBufferByte(bytes, bytes.length);

            //The most difficult part of awt api for me to learn
            SampleModel sampleModel = new ComponentSampleModel(DataBuffer.TYPE_BYTE, width, height, 3, width*3, new int[]{2,1,0});

            Raster rasterNew = Raster.createRaster(sampleModel, buffer, null);
            image.setData(rasterNew);
            l1 = System.currentTimeMillis();
            l2 = l1 - l;
            System.out.println("time for getting bytes from disk and create image: " + l2 + "ms");

            JFrame window = new JFrame();
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setBounds(30, 30, 3000, 3000);

            MyCanvas myCanvas = new MyCanvas();
            myCanvas.setImage(image);
            window.getContentPane().add(myCanvas);
            window.setVisible(true);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static class MyCanvas extends JComponent {
        private Image image;

        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;

            g2.drawImage(image, 10, 10, this);
            g2.finalize();
        }

        public void setImage(Image image) {
            this.image = image;
        }
    }
}

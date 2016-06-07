import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ImageDownloader {
    public static String I_URL = "http://fcontheweb.com/articles/percentage_preloader/earth.jpg";
    public static String FILE_WAY = "Z:\\MyWorkSpase\\ValentynTests\\SecondTest\\Test_image.jpg";
    public static File IMAGE = new File("Z:\\MyWorkSpase\\ValentynTests\\Test_image.jpg");

    public File saveImage(String url1, String fileWAy) throws IOException {
        URL url = new URL(url1);
        try (InputStream in = url.openStream();
             OutputStream out = new FileOutputStream(fileWAy)) {
            byte[] b = new byte[2048];
            int i;
            while ((i = in.read(b)) != -1) {
                out.write(b, 0, i);
            }
            return (new File(fileWAy));
        }
    }

    private List<Integer> readFiles(BufferedReader fileReader) throws IOException {
        List<Integer> fileBytes = new ArrayList<>();
        int b;
        while ((b = fileReader.read()) != -1) {
            fileBytes.add(b);
        }
        return fileBytes;
    }

    public boolean compareFiles(File fileA, File fileB) {
        try (BufferedReader br1 = new BufferedReader(new FileReader(fileA));
             BufferedReader br2 = new BufferedReader(new FileReader(fileB))) {
            return readFiles(br1).equals(readFiles(br2));
        } catch (IOException e) {
            throw new RuntimeException("Files are not equal");
        }
    }
}




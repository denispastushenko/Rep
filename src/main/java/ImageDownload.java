import org.apache.commons.io.FilenameUtils;

import java.io.*;
import java.net.URL;

public class ImageDownload {
    public static final String FILE_WAY = "Z:/MyWorkSpase/ValentynTests/InstagramTest(4)/kyliejenner/Test_Image.jpg";

    public File saver( String url1,String destination) throws IOException {
        URL url = new URL(url1);
        String filename = FilenameUtils.getName(url1);
        try (InputStream input = url.openStream();
             OutputStream output = new FileOutputStream(FILE_WAY + filename)) {
            byte[] b = new byte[1024];
            int lenght;
            while ((lenght = input.read(b)) != -1) {
                output.write(b, 0, lenght);
            }
            return (new File(destination));
        }
    }
}


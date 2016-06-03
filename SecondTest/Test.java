/**
 * Created by Denys on 6/2/2016.
 */
import java.io.*;
import java.net.URL;

public class Test {
    public static void main(String[] args)throws IOException{
        String iUrl = "http://fcontheweb.com/articles/percentage_preloader/earth.jpg";
        String fileWay = "Z:\\MyWorkSpase\\ValentynTests\\SecondTest\\Test_image.jpg";
        saveImage(iUrl, fileWay) ;
    }

    private static void saveImage(String iUrl , String fileWay) throws IOException{
        URL url = new URL(iUrl);
        InputStream in = url.openStream();
        OutputStream out = new FileOutputStream(fileWay);
        byte [] b = new byte[2048];
        int i;       // Длинна(размер);
        while ((i = in.read(b)) != -1) {
            out.write(b,0,i);
        }
        in.close();
        out.close();
    }

}





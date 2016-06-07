import com.ImageDownloader;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import static com.ImageDownloader.*;

public class ImageDownloadTest {
    private File file = null;

    @Test
    public void imageDownloadTest() throws IOException {
        ImageDownloader iD = new ImageDownloader();
        file = iD.saveImage(I_URL, FILE_WAY);
        Assert.assertTrue(iD.compareFiles(file, IMAGE));
    }

    @After
    public void endJob() {

        file.delete();
    }
}

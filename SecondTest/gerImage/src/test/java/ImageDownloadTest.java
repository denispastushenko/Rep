import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by Denys on 6/5/2016.
 */
public class ImageDownloadTest {
    File file = null;

    @Test
    public void imaageDownloadTest() throws IOException {
        ImageDownloader iD = new ImageDownloader();
        file = iD.saveImage(iD.I_URL, iD.FILE_WAY);
        Assert.assertTrue(iD.compareFiles(file, iD.IMAGE));
    }

    @After
    public void endJob() {

        file.delete();
    }
}

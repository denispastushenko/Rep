import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Billy on 5/24/2016.
 */
public class Tests {
    private static void createFolder(int a, int b, int c) {
        String homeDirectory = "Z:\\My_test\\Folder";
        String homeSubDirectory = "SubFolder";
        String filename = "File";
        boolean bool = false;
        File folder = null;
        Random random = new Random();
        for (int y = 0; y < a; y++) {
            try {
                folder = new File(homeDirectory.concat(String.valueOf(y + 1)));
                bool = folder.mkdirs();
                System.out.println(bool);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            System.out.println(y + " " + homeDirectory);
            for (int i = 0; i < random.nextInt(b); i++) {
                File subfolder = new File(folder, homeSubDirectory.concat(String.valueOf(i + 1)));
                subfolder.mkdirs();
                for (int i3 = 0; i3 < random.nextInt(c) + 1; i3++) {
                    try {
                        FileWriter writer = new FileWriter(new File(subfolder, filename.concat(String.valueOf(i3++)).concat(".txt")));
                        String string = "";
                        for (int i4 = 65, i5 = 0; i5 < random.nextInt(a) * random.nextInt(b) * c + 1024; i5++) {
                            string = string.concat(String.valueOf((char) i4++));
                        }
                        writer.write(string);
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        createFolder(4, 7, 10);

    }
}
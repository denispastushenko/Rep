/**
 * Created by Denys on 6/7/2016.
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Refactoring1 {
    public static final String HOME_SUB_DIRECTORY = "SubFolder";
    public static final String FILENAME = "File";
    public static File FOLDER = null;
    public static Random RANDOM = new Random();

    public static void main(String[] args)throws IOException {
        for (int y = 0; y < Integer.parseInt(args[0]); y++) {
            FOLDER = folderCreatorPro(args[3].concat(String.valueOf(y + 1)));
            System.out.println(y + " " + args[3]);
            for (int i = 0; i < RANDOM.nextInt(Integer.parseInt(args[1])); i++) {
                File subfolder = folderCreatorPro(FOLDER, HOME_SUB_DIRECTORY.concat(String.valueOf(i + 1)));
                for (int i3 = 0; i3 < RANDOM.nextInt(Integer.parseInt(args[2])) + 1; i3++) {
                    try (FileWriter writer = new FileWriter(new File(subfolder, FILENAME.concat(String.valueOf(i3++)).concat(".txt")))) {
                        String string = "";
                        for (int i4 = 65, i5 = 0; i5 < countMethod(args[0], args[1], args[2]); i5++) {
                            string = string.concat(String.valueOf((char) i4++));
                        }
                        insteadOfTry(writer, string);
                    }
                }

            }
        }
    }

    public static File folderCreatorPro(String pathToSubFolder) {
        return folderCreatorPro(new File(pathToSubFolder), "");
    }

    public static File folderCreatorPro(File folder, String pathToFolder) {
        File file = new File(folder, pathToFolder);
        file.mkdirs();
        return file;
    }
    public static Integer countMethod(String arg1,String arg2, String arg3) {
        return( RANDOM.nextInt(Integer.parseInt(arg1)) * RANDOM.nextInt(Integer.parseInt(arg2)) * Integer.parseInt(arg3) + 2048);

    }
    public static void insteadOfTry(FileWriter writer, String string)throws  IOException {
        try {
            writer.write(string);
        }catch (IOException e){
            throw new RuntimeException("Try again");
        }

    }
}

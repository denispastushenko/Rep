import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Copy {
    private static final String HOME_SUB_DIRECTORY = "SubFolder";
    private static final String FILENAME = "File";
    private static File FOLDER = null;
    private static Random RANDOM = new Random();

    public static void main(String[] args) throws IOException {

        for (int y = 0; y < Integer.parseInt(args[0]); y++) {
            FOLDER = folderCreator(args[3].concat(String.valueOf(y + 1)));
            System.out.println(y + " " + args[3]);
            for (int i = 0; i < RANDOM.nextInt(Integer.parseInt(args[1])); i++) {
                File subfolder = folderCreator(FOLDER, HOME_SUB_DIRECTORY.concat(String.valueOf(i + 1)));
                for (int i3 = 0; i3 < RANDOM.nextInt(Integer.parseInt(args[2])) + 1; i3++) {
                    FileWriter writer = myFileWriter(subfolder, FILENAME.concat(String.valueOf(i3++)).concat(".txt"));
                    String string = "";
                    for (int i4 = 65, i5 = 0; i5 < mChange(args[0],args[1],args[2]) ; i5++) {
                        string = string.concat(String.valueOf((char) i4++));
                    }
                      second(writer,string);
                }

            }

        }

    }

    public static File folderCreator(String pathToSubFolder) {
        return folderCreator(new File(pathToSubFolder), "");
    }

    public static File folderCreator(File folder, String pathToFolder) {
        File file = new File(folder, pathToFolder);
        file.mkdirs();
        return file;
    }

    public static FileWriter myFileWriter(File subfolder , String destination) throws IOException {

        try (FileWriter writer = new FileWriter(folderCreator(subfolder,destination))) {
            return writer;
        }
    }

    public static void second(FileWriter writer, String string)throws  IOException {
        try {
            writer.write(string);
        }catch (IOException e){
            throw new RuntimeException("Try again");
        }

    }

    public static Integer mChange(String arg1,String arg2, String arg3) {
       return( RANDOM.nextInt(Integer.parseInt(arg1)) * RANDOM.nextInt(Integer.parseInt(arg2)) * Integer.parseInt(arg3) + 2048);

    }
}
import java.io.File;
import java.io.FileWriter;

public class CreateANewFile {

    public static void main(String[] args) {
        // File file = new File("hi.txt");
        // if (!file.isFile()) {
        //     try {
        //         file.createNewFile();
        //     } catch (Exception e) {
        //         e.printStackTrace();
        //     }
        // }
        FileWriter writer;
        try {
            writer = new FileWriter("hi.txt");
            writer.write("null");
            writer.close();
            System.out.println("done!! check if the file has created or not.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
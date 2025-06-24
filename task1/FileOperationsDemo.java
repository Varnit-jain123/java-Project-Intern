package task1;
import java.io.*;

public class FileOperationsDemo {

    static final String FILE_PATH = "sample.txt";

    public static void main(String[] args) {
        try {
            String originalText = "This is the original file.\nThis file will be modified.";
            writeTextToFile(originalText);

            System.out.println("Original File Content:");
            printFileContent();

            updateFileContent("original", "modified");

            System.out.println("\nModified File Content:");
            printFileContent();

        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    public static void writeTextToFile(String text) throws IOException {
        FileWriter writer = new FileWriter(FILE_PATH);
        writer.write(text);
        writer.close();
    }

    public static void printFileContent() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

    public static void updateFileContent(String find, String replaceWith) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
        StringBuilder updatedContent = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            updatedContent.append(line.replace(find, replaceWith)).append("\n");
        }
        reader.close();

        FileWriter writer = new FileWriter(FILE_PATH);
        writer.write(updatedContent.toString());
        writer.close();
    }
}

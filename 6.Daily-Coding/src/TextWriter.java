import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TextWriter {

    private File file;
    private FileWriter fileWriter;
    private PrintWriter printWriter;

    public TextWriter() throws IOException {
        file = new File("out.txt");
        fileWriter = new FileWriter(file);
        printWriter = new PrintWriter(fileWriter);
    }

    public int getRandomNumberInRange(int lower, int upper) {
        return (int) (Math.random() * upper + lower);
    }

    public void print(String toPrint) {
        printWriter.println(toPrint);
    }

    public void closeWriter() {
        this.printWriter.close();
    }
}

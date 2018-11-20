package util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TextWriter {

    private File fileOut;
    private FileWriter fileWriterOut;
    private PrintWriter printWriterOut;

    private File fileIn;
    private FileWriter fileWriterIn;
    private PrintWriter printWriterIn;


    public TextWriter() throws IOException {
        fileOut = new File("out.txt");
        fileWriterOut = new FileWriter(fileOut);
        printWriterOut = new PrintWriter(fileWriterOut);


        fileIn = new File("in.txt");
        fileWriterIn = new FileWriter(fileIn);
        printWriterIn = new PrintWriter(fileWriterIn);

    }

    static public int getRandomNumberInRange(int lower, int upper) {
        return (int) (Math.random() * ((upper - lower) + 1)) + lower;
    }

    public void printOut(String toPrint) {
        printWriterOut.print(toPrint);
    }

    public void printIn(String toPrint) {
        printWriterIn.print(toPrint);
    }

    public void closeWriter() {
        this.printWriterOut.close();
        this.printWriterIn.close();
    }
}

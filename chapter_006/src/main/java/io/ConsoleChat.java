package io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.SplittableRandom;

/**
 * This class represents a console chat. A user may write a phrase and a programme must return
 * a random phrase taken from a .txt file. If the user writes the "Stop" word, the programme starts returning nothing,
 * but the user still may write something. If the user writes the "Continue" word, the programme starts to return
 * a random phrase again. The programme stop working when the "End" word is received from the user.
 * Such a dialog must be saved in .txt file including the "Stop", "Continue" and "End" words.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 23.06.2019
 */
public class ConsoleChat {

    private final static String END = "End";
    private final static String STOP = "Stop";
    private final static String CONTINUE = "Continue";


    /**
     * A console chat.
     */
    public void chat() {
        Path path = Paths.get(System.getProperty("java.io.tmpdir"), "log.txt");
        File file = new File(Paths.get("chapter_006\\RandomPhrases.txt").toString());
        long j = file.length();
        try (RandomAccessFile randomPhrases = new RandomAccessFile(file, "r");
             Scanner in = new Scanner(System.in);
             BufferedWriter writer = new BufferedWriter(new FileWriter(path.toString()))) {
            System.out.println("Write your message, please.");
            String input = "";
            String params = "";
            while (!input.equals(END)) {
                randomPhrases.seek(new SplittableRandom().nextLong(0, file.length()));
                if (in.hasNext()) {
                    input = in.nextLine();
                }
                if (input.equals(STOP)) {
                    params = STOP;
                } else if (input.equals(CONTINUE)) {
                    params = CONTINUE;
                } else if (input.equals(END)) {
                    input = END;
                    params = END;
                    writer.write(END);
                }
                if (params.equals("") || params.equals(CONTINUE)) {
                    String output = "System message: " + randomPhrases.readLine();
                    System.out.println(output);
                    writer.write(input + System.lineSeparator());
                    writer.write(output + System.lineSeparator());
                } else if (params.equals(STOP)) {
                    writer.write(input);
                    writer.write(System.lineSeparator());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
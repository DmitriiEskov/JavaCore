package io;

import java.io.*;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class for converting a file with info about working hours of a server into
 * a file containing only non-working hours of a server.
 */
public class Analysis {

    /**
     * Regex for discovering if a server message reports that the server is up or down.
     */
    private final static String REGEX = "[4-5]00\\s([0-2][0-9]:[0-5][0-9]:[0-5][0-9])"
            + "|[2-3]00\\s([0-2][0-9]:[0-5][0-9]:[0-5][0-9])";

    /**
     * Returns time ranges of a server when it was down.
     * @param source - a file containing data about working hours of a server
     * @param target - a file where non-activity hours of a server are supposed to be written into
     */
    public void unavailable(String source, String target) {
        StringBuilder buffer = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String str = reader.readLine();
            while (str != null) {
                buffer.append(str);
                str = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(target))) {
            Pattern pattern = Pattern.compile(REGEX);
            Matcher matcher = pattern.matcher(buffer);
            StringJoiner joiner = new StringJoiner("; ");
            int i = 0;
            while (matcher.find()) {
                String down = matcher.group(1);
                String up = matcher.group(2);
                if (down != null) {
                    if (i == 0) {
                        joiner.add(down);
                        i++;
                    }
                } else {
                    if (i != 0) {
                        joiner.add(up);
                        i = 0;
                    }
                }
            }
            writer.write(joiner.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
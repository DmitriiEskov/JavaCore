package io;

import org.junit.Test;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Tests for the Analysis class.
 */
public class AnalysisTest {

    @Test
    public void whenReadFromFileThenSuccess() {
        Path source  = Paths.get("server.txt");
        Path target  = Paths.get("target.txt");
        new Analysis().unavailable(source.toString(), target.toString());
        String expect = "10:58:01; 10:59:01; 11:01:02; 11:02:02; 00:18:45; 03:15:09; 07:00:09; 10:00:00";
        String result = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(target.toString()))) {
            StringBuilder builder = new StringBuilder();
            String str = reader.readLine();
            while (str != null) {
                builder.append(str);
                str = reader.readLine();
            }
            result = builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(result, is(expect));
    }
}
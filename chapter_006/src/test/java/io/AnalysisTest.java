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
        var source  = getClass().getClassLoader().getResource("server.txt");
        var target  = getClass().getClassLoader().getResource("target.txt");
        new Analysis().unavailable(source.getFile(), target.getFile());
        String expect = "10:58:01; 10:59:01; 11:01:02; 11:02:02; 00:18:45; 03:15:09; 07:00:09; 10:00:00";
        String result = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(target.getFile()))) {
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
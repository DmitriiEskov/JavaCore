package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Config {

    /**
     * Path to a file.
     */
    private final String path;

    /**
     * A Map to keep read data from a file (this.path).
     */
    private final Map<String, String> values = new HashMap<String, String>();

    /**
     * Constructs a Config obj with a specified path to a file.
     * @param path
     */
    public Config(final String path) {
        this.path = path;
    }

    /**
     * Fills in a Map (this.values) with specified keys and values read from a specified file (this.path).
     */
    public void load() {
        StringBuilder out = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(this.path))) {
            String str = reader.readLine();
            while (str != null) {
                out.append(str);
                str = reader.readLine();
                out.append(System.lineSeparator());
            }
            String patternString = "([a-zA-Z0-9]+\\s=\\s[a-zA-Z0-9]+)";
            Pattern pattern = Pattern.compile(patternString);
            Matcher matcher = pattern.matcher(out);
            while (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();
                String strSec = out.substring(start, end);
                String[] array = strSec.split("\\s=\\s");
                if (array.length == 2) {
                    this.values.put(array[0], array[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns a value associated with the specified key.
     * @param key - specified key
     * @return value
     */
    public String value(String key) {
        return this.values.get(key);
    }

    /**
     * Overrides Object's toString().
     */
    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    /**
     * Returns this.values;
     * @return a HashMap filled in with sorted keys and values
     */
    public Map<String, String> getResultMap() {
        return this.values;
    }
}
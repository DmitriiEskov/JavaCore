package io;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The main purpose of this class is scanning a file system.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 18.06.2019
 */
public class Search {

    /**
     * Scans a file system for files with a specified type and returns a list of such files.
     * @param parent - a directory to start scanning for files with a specified type
     * @param exts - a list of file types to to look for
     * @return a list containing all files with a specified type
     */
    List<File> files(String parent, List<String> exts) {
        if (parent == null || exts == null) {
            return new LinkedList<File>();
        }
        List<File> result = new LinkedList<>();
        String regex = this.getRegex(exts);
        Pattern pattern = Pattern.compile(regex);
        File root = new File(parent);
        File[] listRoot = root.listFiles();
        Queue<File> queue = new LinkedList<>();
        for (File file : listRoot) {
            queue.offer(file);
        }
        while (!queue.isEmpty()) {
            File file = queue.poll();
            if (file.isDirectory()) {
                listRoot = file.listFiles();
                for (File value : listRoot) {
                    queue.offer(value);
                }
            } else {
                String fileName = file.getName();
                Matcher matcher = pattern.matcher(fileName);
                if (matcher.find()) {
                    result.add(file);
                }
            }
        }
        return result;
    }

    /**
     * Returns a regular expression.
     */
    private String getRegex(List<String> exts) {
        String regex = null;
        StringJoiner joiner = new StringJoiner("|");
        int i = 0;
        while (i < exts.size()) {
            regex = "\\." + exts.get(i);
            joiner.add(regex);
            i++;
        }
        regex = joiner.toString();
        return regex;
    }
}
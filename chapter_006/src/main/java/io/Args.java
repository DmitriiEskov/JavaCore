package io;

import org.apache.commons.cli.*;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Class for testing the Zip class.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 21.06.2019
 */
public class Args {

    /**
     * Retrieves a list of files of a project, which are supposed to be archived.
     * @param source a name of a project's path
     * @return a list of project files, which are supposed to be archived.
     */
    public List<File> directory(String source) {
        List<File> result = new LinkedList<>();
        File root = new File(source);
        File[] listRoot = root.listFiles();
        Queue<File> queue = new LinkedList<>();
        for (File file : listRoot) {
            queue.offer(file);
        }
        while (!queue.isEmpty()) {
            File file = queue.poll();
            if (file.isDirectory() && file.list().length != 0) {
                listRoot = file.listFiles();
                for (File value : listRoot) {
                    queue.offer(value);
                }
            } else {
                result.add(file);
            }
        }
        return result;
    }


    /**
     * Retrieves a list of project files, which are not supposed to be archived.
     * @param source - source of a project
     * @param exclude - name of a file type not to include into an archive
     * @return files, which are not supposed to be archived
     */
    public List<File> exclude(String source, String exclude) {
        return new Zip().seekBy(source, exclude);
    }

    /**
     * Retrieves a file into which an archive will be created
     * @param output path of a file
     * @return a file into which an archive will be created
     */
    public File output(String output) {
        return new File(output);
    }

    public static void main(String[] args) {
        try {
            Options options = new Options();
            options.addOption("d", true, "a directory, which is supposed to be zipped");
            options.addOption("e", true, "files to be excluded from .zip");
            options.addOption("o", true, "a path where a zip is supposed to be placed");
            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options, args);
            File source = null;
            File target = null;
            List<File> files = null;
            List<File> toBeExcluded = null;
            if (cmd.hasOption("d")) {
                String directorySource = cmd.getOptionValue("d");
                if (directorySource != null) {
                    source = new File(directorySource);
                    files = new Args().directory(source.getPath());
                }
            }
            if (cmd.hasOption("e")) {
                String excl = cmd.getOptionValue("e");
                if (excl != null && source != null) {
                    toBeExcluded = new Args().exclude(source.getPath(), excl);
                }
            }
            if (cmd.hasOption("o")) {
                String directoryTarget = cmd.getOptionValue("o");
                if (directoryTarget != null) {
                    target = new File(directoryTarget);
                    if (toBeExcluded != null && files != null) {
                        files.removeAll(toBeExcluded);
                        new Zip().pack(files, target);
                    } else if (files != null) {
                        new Zip().pack(files, target);
                    }
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
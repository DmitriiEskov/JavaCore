package io;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

/**
 * This class is for searching a file with criteria.
 * e.g. java -jar find.jar -d c:/ -n *.txt -m -o log.txt
 *
 * -d a directory to start searching in
 *
 * -n a file's full name, a mask or a regular expression
 *
 * -m searches a file by a mask
 * -f searches a file by its full name
 * -r searches a file by a regular expression
 *
 * -o a file to write a searching result (a name of the found file) in
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 11.07.2019
 */
public class FilesSearch extends SimpleFileVisitor<Path> {

    private Matcher matcher;
    private Pattern pattern;
    private Path dest;
    private String mode;

    /**
     * @param pat - pattern to search with
     * @param des - path to place a file with searching results
     * @param mode - indicates a mask or a file's full name or a regex
     */
    public FilesSearch(Pattern pat, Path des, String mode) {
        this.pattern = pat;
        this.dest = des;
        this.mode = mode;
    }

    /**
     * Invoked for a file in a directory.
     *
     * <p> Unless overridden, this method returns {@link FileVisitResult#CONTINUE
     * CONTINUE}.
     */
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        this.find(file);
        return FileVisitResult.CONTINUE;
    }

    /**
     * Compares the pattern against the file.
     * @param file - a file to compare with
     */
    private void find(Path file) {
        Path name = file.getFileName();
        if (name != null) {
            String fileName = name.toString();
            matcher = pattern.matcher(fileName);
            if (mode.equals("-f")) {
                if (matcher.matches()) {
                    try (OutputStream out = new BufferedOutputStream(
                            Files.newOutputStream(this.dest, CREATE, APPEND))) {
                        out.write(String.format("%s%n", fileName).getBytes());
                    } catch (IOException x) {
                        System.err.println(x);
                    }
                }
            } else {
                if (matcher.find()) {
                    try (OutputStream out = new BufferedOutputStream(
                            Files.newOutputStream(this.dest, CREATE, APPEND))) {
                        out.write(String.format("%s%n", fileName).getBytes());
                    } catch (IOException x) {
                        System.err.println(x);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        if (args.length < 7) {
            System.out.println("Please, provide 4 keys with specified values.");
            System.out.println("-d a directory to start searching in");
            System.out.println("-n a file's full name, a mask or a regular expression");
            System.out.println("-m searches a file by a mask");
            System.out.println("-f searches a file by its full name");
            System.out.println("-r searches a file by a regular expression");
            System.out.println("-o a file to write a searching result (a name of the found file) in");
            return;
        }
        Path dir = Paths.get(args[1]);
        String params = args[3];
        String mode = args[4];
        Path dest = Paths.get(args[6]);
        Pattern pattern;
        if (mode.equals("-m")) {
            String[] str = params.split("\\*");
            String reg = str[1];
            pattern = Pattern.compile(reg);
        } else {
            pattern = Pattern.compile(params);
        }
        try {
            Files.walkFileTree(dir, new FilesSearch(pattern, dest, mode));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
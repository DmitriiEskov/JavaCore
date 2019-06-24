package io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Class for archiving a project.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @version 1.0
 * @since 21.06.2019
 */
public class Zip {

    /**
     * Transforms a source file into a zip or a jar file.
     * @param source - file to be archived
     * @param target - name of the archived file
     */
    public void pack(File source, File target) {
        if (source == null || target == null) {
            return;
        }
        List<File> result = new LinkedList<>();
        File root = new File(source.toString());
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
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            Iterator<File> iter = result.iterator();
            while (iter.hasNext()) {
                File sourceFile = iter.next();
                Path file = Paths.get(source.getParent()).relativize(sourceFile.toPath());
                if (!sourceFile.isDirectory()) {
                    zip.putNextEntry(new ZipEntry(file.toString()));
                    try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(sourceFile))) {
                        zip.write(out.readAllBytes());
                    }
                } else {
                    String specialPath = file.toString() + System.getProperty("file.separator");
                    zip.putNextEntry(new ZipEntry(specialPath));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Transforms a source file into a zip or a jar file and excludes specified files.
     * @param source - file to be archived
     * @param target - name of the archived file
     * @param exc - files to be excluded
     */
    public void pack(File source, File target, List<File> exc) {
        if (source == null || target == null || exc == null) {
            return;
        }
        List<File> result = new LinkedList<>();
        File root = new File(source.toString());
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
        result.removeAll(exc);
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            Iterator<File> iter = result.iterator();
            while (iter.hasNext()) {
                File sourceFile = iter.next();
                Path file = Paths.get(source.getParent()).relativize(sourceFile.toPath());
                if (!sourceFile.isDirectory()) {
                    zip.putNextEntry(new ZipEntry(file.toString()));
                    try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(sourceFile))) {
                        zip.write(out.readAllBytes());
                    }
                } else {
                    String specialPath = file.toString() + System.getProperty("file.separator");
                    zip.putNextEntry(new ZipEntry(specialPath));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves a list of project files with a specified type.
     * @param root - source of a project
     * @param ext - name of a specified type
     * @return a list of files with specified type of a project
     */
    List<File> seekBy(String root, String ext) {
        List<String> params = Collections.singletonList(ext);
        return new Search().files(root, params);
    }
}
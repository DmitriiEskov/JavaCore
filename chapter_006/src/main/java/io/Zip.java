package io;

import java.io.*;
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
    public void pack(List<File> source, File target) {
        if (source == null || target == null) {
            return;
        }
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            Iterator<File> iter = source.iterator();
            while (iter.hasNext()) {
                File sourceFile = iter.next();
                if (!sourceFile.isDirectory()) {
                    zip.putNextEntry(new ZipEntry(sourceFile.getPath()));
                    try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(sourceFile))) {
                        zip.write(out.readAllBytes());
                    }
                } else {
                    String specialPath = sourceFile.getPath() + System.getProperty("file.separator");
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
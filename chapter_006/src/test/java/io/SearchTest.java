package io;

import org.junit.Before;
import org.junit.Test;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * This class tests the Search class.
 */
public class SearchTest {

    private Path parent = null;
    private File file1;
    private File file2;
    private File file3;
    private File file4;
    private File file5;
    private File file6;
    private File file7;
    private File file8;
    private File file9;
    private File file10;
    private File file11;
    private File file12;

    @Before
    public void setFileStructure() {
        try {
            Path root = Files.createTempDirectory("Parent");
            Path folder1 = Files.createDirectory(Paths.get(root.toString(), "Folder1"));
            Path folder2 = Files.createDirectory(Paths.get(root.toString(), "Folder1", "Folder2"));
            Path folder3 = Files.createDirectory(Paths.get(root.toString(), "Folder1", "Folder2", "Folder3"));
            Path folder4 = Files.createDirectory(Paths.get(root.toString(), "Folder4"));
            Path folder5 = Files.createDirectory(Paths.get(root.toString(), "Folder4", "Folder5"));
            Path folder6 = Files.createDirectory(Paths.get(root.toString(), "Folder6"));
            File first = new File(Paths.get(root.toString(), "Root.xml").toString());
            File second = new File(Paths.get(root.toString(), "text.txt").toString());
            File third = new File(Paths.get(root.toString(), "image.jpeg").toString());
            File fourth = new File(Paths.get(folder1.toString(), "SomeText.txt").toString());
            File fifth = new File(Paths.get(folder1.toString(), "NewImage.jpeg").toString());
            File sixth = new File(Paths.get(folder1.toString(), "NewXML.xml").toString());
            File seventh = new File(Paths.get(folder2.toString(), "type.txt").toString());
            File eighth = new File(Paths.get(folder3.toString(), "TypeType.txt").toString());
            File ninth = new File(Paths.get(folder3.toString(), "numbers.xml").toString());
            File tenth = new File(Paths.get(folder5.toString(), "words.txt").toString());
            File eleventh = new File(Paths.get(folder5.toString(), "SomeOtherNumbers.xml").toString());
            File twelfth = new File(Paths.get(folder5.toString(), "photo.jpeg").toString());
            first.createNewFile();
            second.createNewFile();
            third.createNewFile();
            fourth.createNewFile();
            fifth.createNewFile();
            sixth.createNewFile();
            seventh.createNewFile();
            eighth.createNewFile();
            ninth.createNewFile();
            tenth.createNewFile();
            eleventh.createNewFile();
            twelfth.createNewFile();
            this.parent = root;
            this.file1 = first;
            this.file2 = second;
            this.file3 = third;
            this.file4 = fourth;
            this.file5 = fifth;
            this.file6 = sixth;
            this.file7 = seventh;
            this.file8 = eighth;
            this.file9 = ninth;
            this.file10 = tenth;
            this.file11 = eleventh;
            this.file12 = twelfth;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenSearchAllFilesThenSuccess() {
        String parent = this.parent.toString();
        List<String> specifiedTypes = List.of("txt", "xml", "jpeg");

        List<File> expect = List.of(file3, file1, file2, file5, file6, file4, file7, file12,
                file11, file10, file9, file8);
        List<File> result = new Search().files(parent, specifiedTypes);
        boolean res = true;
        res = expect.containsAll(result);
        assertThat(res, is(true));
    }

    @Test
    public void whenSearchXmlAndJpegFilesThenSuccess() {
        String parent = this.parent.toString();
        List<String> specifiedTypes = List.of("xml", "jpeg");
        List<File> expect = List.of(file3, file1, file5, file6, file12, file11, file9);
        List<File> result = new Search().files(parent, specifiedTypes);
        boolean res = expect.containsAll(result);
        assertThat(res, is(true));
    }

    @Test
    public void whenSearchTxtFilesThenSuccess() {
        String parent = this.parent.toString();
        List<String> specifiedTypes = List.of("txt");
        List<File> expect = List.of(file2, file4, file7, file10, file8);
        List<File> result = new Search().files(parent, specifiedTypes);
        boolean res = expect.containsAll(result);
        assertThat(res, is(true));
    }

    @Test
    public void whenSearchXmlFilesThenSuccess() {
        String parent = this.parent.toString();
        List<String> specifiedTypes = List.of("xml");
        List<File> expect = List.of(file1, file6, file11, file9);
        List<File> result = new Search().files(parent, specifiedTypes);
        boolean res = expect.containsAll(result);
        assertThat(res, is(true));
    }

    @Test
    public void whenSearchJpegFilesThenSuccess() {
        String parent = this.parent.toString();
        List<String> specifiedTypes = List.of("jpeg");
        List<File> expect = List.of(file3, file5, file12);
        List<File> result = new Search().files(parent, specifiedTypes);
        boolean res = expect.containsAll(result);
        assertThat(res, is(true));
    }

    @Test
    public void whenSearchSomeFilesThenFail() {
        String parent = this.parent.toString();
        List<String> specifiedTypes = List.of("bmp");
        List<File> expect = List.of();
        List<File> result = new Search().files(parent, specifiedTypes);
        boolean res = expect.containsAll(result);
        assertThat(res, is(true));
    }
}
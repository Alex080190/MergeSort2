//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class FileInfo {
    public FileInfo() {
    }

    public static List<String> getInputFiles(List<String> options) throws IOException, MyException {
        int index = options.indexOf("out.txt");
        if (index + 1 == options.size()) {
            throw new MyException("Необходимо передать имена входных файлов");
        } else {
            List<String> namesOfInputFiles = new ArrayList();

            for (int i = index + 1; i < options.size(); ++i) {
                namesOfInputFiles.add((String) options.get(i));
            }

            return namesOfInputFiles.stream().distinct().collect(Collectors.toList());
        }
    }

    public static List<Integer> readIntegerFile(String file) throws IOException {
        List<Integer> result = new ArrayList();
        BufferedReader reader = new BufferedReader(new FileReader(file));

        try {
            while (reader.ready()) {
                String temporal = reader.readLine();
                if (!temporal.contains(" ")) {
                    result.add(Integer.valueOf(temporal));
                }
            }
        } catch (Throwable var6) {
            try {
                reader.close();
            } catch (Throwable var5) {
                var6.addSuppressed(var5);
            }

            throw var6;
        }

        reader.close();
        return result;
    }

    public static List<String> readStringFile(String file) throws IOException {
        List<String> result = new ArrayList();
        BufferedReader reader = new BufferedReader(new FileReader(file));

        try {
            while (reader.ready()) {
                String temporal = reader.readLine();
                if (!temporal.contains(" ")) {
                    result.add(temporal);
                }
            }
        } catch (Throwable var6) {
            try {
                reader.close();
            } catch (Throwable var5) {
                var6.addSuppressed(var5);
            }

            throw var6;
        }

        reader.close();
        return result;
    }

    public static void writeFile(List<String> result) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("out.txt"));
        Iterator var2 = result.iterator();

        while (var2.hasNext()) {
            String s = (String) var2.next();
            bufferedWriter.write(s + System.lineSeparator());
        }

        bufferedWriter.close();
    }
}

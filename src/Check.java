//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Check {
    public Check() {
    }
    public static void checkArguments(List<String> options) throws MyException, IOException {
        if (options.size() == 0) {
            throw new MyException("Необходимо передать аргументы");
        } else if (options.contains("-a") && options.contains("-d")) {
            throw new MyException("Переданы два возможных вариатна сортировки, нужно не указывать вариант сортировки(тогда сортировка выполнится по возрастанию или передать 1 вариант сортировки: -a или -d");
        } else if (options.contains("-s") && options.contains("-i")) {
            throw new MyException("Указаны 2 типа данных, необходимо указать только 1, -s или -i");
        } else if (!options.contains("-s") && !options.contains("-i")) {
            throw new MyException("Не указан тип данных, необходимо указать -s или -i");
        } else if (!options.contains("out.txt")) {
            throw new MyException("Необходимо указать имя выходного файлы: out.txt");
        }
    }
    public static List<String> checkInputFiles(List<String> namesOfInputFiles, List<String> options, boolean natural) throws IOException, MyException {
        String path = System.getProperty("user.dir") + "/";
        List<String> deletedFiles = new ArrayList();

        int i;
        String file;
        for (i = 0; i < namesOfInputFiles.size(); ++i) {
            file = (String) namesOfInputFiles.get(i);
            boolean exists = (new File(path + file)).exists();
            if (!exists) {
                System.out.println("Файл " + file + " не существует, исключаем");
                deletedFiles.add(file);
            }
        }
        namesOfInputFiles.removeAll(deletedFiles);
        List strings;
        if (options.contains("-s")) {
            for (i = 0; i < namesOfInputFiles.size(); ++i) {
                file = (String) namesOfInputFiles.get(i);
                strings = FileInfo.readStringFile(file);
                if (strings.size() == 0) {
                    System.out.println("Файл " + file + " пуст, исключаем");
                    deletedFiles.add(file);
                }

                if (!natural) {
                    Collections.reverse(strings);
                    System.out.println(strings);
                }

                if (!isSortedString(strings, natural)) {
                    System.out.println("Файл " + file + " не отсортирован, исключаем");
                    deletedFiles.add(file);
                }
            }
        } else {
            for (i = 0; i < namesOfInputFiles.size(); ++i) {
                file = (String) namesOfInputFiles.get(i);
                strings = FileInfo.readIntegerFile(file);
                if (strings.size() == 0) {
                    System.out.println("Файл " + file + " пуст, исключаем");
                    deletedFiles.add(file);
                }

                if (!natural) {
                    Collections.reverse(strings);
                }

                if (!isSortedIntegers(strings, natural)) {
                    System.out.println("Файл " + file + " не отсортирован, исключаем");
                    deletedFiles.add(file);
                }
            }
        }

        namesOfInputFiles.removeAll(deletedFiles);
        System.out.println("Осталось файлов для сортировки: " + namesOfInputFiles.size());
        return namesOfInputFiles;
    }

    public static boolean isSortedIntegers(List<Integer> integers, boolean natural) {
        if (integers.size() != 0 && integers.size() != 1) {
            int i;
            if (natural) {
                for (i = 0; i < integers.size() - 1; ++i) {
                    if ((Integer) integers.get(i) > (Integer) integers.get(i + 1)) {
                        return false;
                    }
                }
            } else {
                for (i = 0; i < integers.size() - 1; ++i) {
                    if ((Integer) integers.get(i) < (Integer) integers.get(i + 1)) {
                        return false;
                    }
                }
            }

            return true;
        } else {
            return true;
        }
    }

    public static boolean isSortedString(List<String> strings, boolean natural) {
        if (strings.size() != 0 && strings.size() != 1) {
            for (int i = 0; i < strings.size() - 1; ++i) {
                char[] str1 = ((String) strings.get(i)).toCharArray();
                char[] str2 = ((String) strings.get(i + 1)).toCharArray();
                int index = Math.min(str1.length, str2.length);
                int j;
                if (natural) {
                    for (j = 0; j < index && str1[j] >= str2[j]; ++j) {
                        if (str1[j] > str2[j]) {
                            return false;
                        }
                    }
                } else {
                    for (j = 0; j < index && str1[j] <= str2[j]; ++j) {
                        if (str1[j] < str2[j]) {
                            return false;
                        }
                    }
                }
            }

            return true;
        } else {
            return true;
        }
    }
}

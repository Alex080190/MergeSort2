//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class Merge {
    public Merge() {
    }

    public static List<Integer> mergeSortInteger(List<String> namesOfInputFiles, boolean natural) throws IOException {
        ListIterator<String> iterator = namesOfInputFiles.listIterator();

        Object result;
        List current;
        for (result = new ArrayList(); iterator.hasNext(); result = mergeInteger((List) result, current, natural)) {
            String file = (String) iterator.next();
            current = FileInfo.readIntegerFile(file);
            if (!natural) {
                Collections.reverse(current);
            }
        }

        return (List) result;
    }

    public static List<Integer> mergeInteger(List<Integer> first, List<Integer> second, boolean natural) {
        List<Integer> result = new ArrayList();
        int i = 0;
        int j = 0;
        if (natural) {
            while (i < first.size() && j < second.size()) {
                if ((Integer) first.get(i) <= (Integer) second.get(j)) {
                    result.add((Integer) first.get(i++));
                } else {
                    result.add((Integer) second.get(j++));
                }
            }
        } else {
            while (i < first.size() && j < second.size()) {
                if ((Integer) first.get(i) >= (Integer) second.get(j)) {
                    result.add((Integer) first.get(i++));
                } else {
                    result.add((Integer) second.get(j++));
                }
            }
        }

        while (i < first.size()) {
            result.add((Integer) first.get(i++));
        }

        while (j < second.size()) {
            result.add((Integer) second.get(j++));
        }

        return result;
    }

    public static List<String> mergeSortString(List<String> namesOfInputFiles, boolean natural) throws IOException {
        ListIterator<String> iterator = namesOfInputFiles.listIterator();

        Object result;
        List current;
        for (result = new ArrayList(); iterator.hasNext(); result = mergeString((List) result, current, natural)) {
            String file = (String) iterator.next();
            current = FileInfo.readStringFile(file);
            if (!natural) {
                Collections.reverse(current);
            }
        }

        return (List) result;
    }

    public static List<String> mergeString(List<String> first, List<String> second, boolean natural) {
        if (first.size() == 0) {
            return second;
        } else if (second.size() == 0) {
            return first;
        } else {
            List<String> result = new ArrayList();
            int i = 0;
            int j = 0;
            char[] str1;
            char[] str2;
            int index;
            String current;
            int k;
            if (natural) {
                for (; i < first.size() && j < second.size(); result.add(current)) {
                    str1 = ((String) first.get(i)).toCharArray();
                    str2 = ((String) second.get(j)).toCharArray();
                    index = Math.min(first.size(), second.size());
                    current = (String) first.get(i);

                    for (k = 0; k < index; ++k) {
                        if (str1[k] < str2[k]) {
                            current = (String) first.get(i++);
                            break;
                        }

                        if (str2[k] < str1[k]) {
                            current = (String) second.get(j++);
                            break;
                        }
                    }
                }
            } else {
                for (; i < first.size() && j < second.size(); result.add(current)) {
                    str1 = ((String) first.get(i)).toCharArray();
                    str2 = ((String) second.get(j)).toCharArray();
                    index = Math.min(first.size(), second.size());
                    current = (String) first.get(i);

                    for (k = 0; k < index; ++k) {
                        if (str1[k] > str2[k]) {
                            current = (String) first.get(i++);
                            break;
                        }

                        if (str2[k] > str1[k]) {
                            current = (String) second.get(j++);
                            break;
                        }
                    }
                }
            }

            while (i < first.size()) {
                result.add((String) first.get(i++));
            }

            while (j < second.size()) {
                result.add((String) second.get(j++));
            }

            return result;
        }
    }
}

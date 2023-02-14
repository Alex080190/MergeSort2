//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws MyException, IOException {
        List<String> options = new ArrayList(Arrays.asList(args));
        boolean natural = !options.contains("-d");
        Check.checkArguments(options);
        List<String> inputFiles = FileInfo.getInputFiles(options);
        List<String> checkedInputFiles = Check.checkInputFiles(inputFiles, options, natural);
        List result;
        if (options.contains("-i")) {
            result = Merge.mergeSortInteger(checkedInputFiles, natural);
            List<String> stringList = (List) result.stream().map(String::valueOf).collect(Collectors.toList());
            FileInfo.writeFile(stringList);
        } else {
            result = Merge.mergeSortString(checkedInputFiles, natural);
            FileInfo.writeFile(result);
        }

    }
}

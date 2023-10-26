package au.com.nuvento.atm.handlefiles;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ReadFile {
    /**
     * Get Contents From File
     * @param filePath is to location where the file is
     * @param remove_delim is what delimiter to use
     * @return a new List
     * @throws FileNotFoundException Thrown if file not in path
     */
    public List<String[]> getContentsFromFile(String filePath, String remove_delim) throws FileNotFoundException {

        List<String[]> fileData = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                fileData.add(scanner.nextLine().split(remove_delim));
            }
        }
        return fileData;
    }
}
package au.com.nuvento.atm.utils;

import java.io.*;

public class WriteToFile {
    /**
     * Rewrite Method
     * @param firstInt is Opening Balance of selected account.
     * @param secondInt is new Balance. Opening Balance +/- Amount
     */
    public void reWrite(String firstInt, String secondInt) {
        String fileName = "data/OpeningAccountsData.txt"; // Use the actual file name

        try {
            // Open the file for reading and writing
            File file = new File(fileName);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                // Replace "is" with "was" in the current line
                line = line.replace(firstInt, secondInt);
                content.append(line).append("\n");
            }

            // Close the reader
            reader.close();

            // Open the file for writing (overwrite the original content)
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(content.toString());

            // Close the writer
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

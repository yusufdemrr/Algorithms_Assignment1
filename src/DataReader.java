import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    public int[] getFlowDurations(int size, String FILE_PATH) {
        List<Integer> flowDurations = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            // Read and skip first line (header line)
            br.readLine();

            String line;
            int count = 0;
            while ((line = br.readLine()) != null && count < size) {
                String[] parts = line.split(",");
                int flowDuration = Integer.parseInt(parts[6]); // 7th column (index 6) is Flow Duration
                flowDurations.add(flowDuration);
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Convert list to array
        int[] durationsArray = new int[flowDurations.size()];
        for (int i = 0; i < flowDurations.size(); i++) {
            durationsArray[i] = flowDurations.get(i);
        }

        return durationsArray;
    }
}


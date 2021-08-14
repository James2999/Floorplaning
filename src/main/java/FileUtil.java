import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    public static List<Block> readCsv(String fileName) {
        ArrayList<Block> blockList = new ArrayList<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            String str;
            int cnt = 0;
            while ((str = in.readLine()) != null) {
                String[] split = str.split(",");
                int width = Integer.valueOf(split[0]);
                int height = Integer.valueOf(split[1]);
                Block block = new Block(cnt, width, height);
                cnt = cnt + 1;
                blockList.add(block);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return blockList;
    }
}

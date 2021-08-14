import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.create(FileUtil.readCsv("data.csv"));
        List<TreeNode> nodeList = tree.getNodeArray();
        ArrayList<Block> blocks = new ArrayList<>();
        for (TreeNode node : nodeList) {
            blocks.add(node.getData());
        }
        DrawUtil.paintRectList(blocks,0.000005,tree.getMaxWidth(),tree.getMaxHeight(),false);
    }
}


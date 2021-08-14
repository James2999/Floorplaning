import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreeNode {
    private TreeNode parent;
    private TreeNode leftChild;
    private TreeNode rightChild;
    private Block data;

    public TreeNode(Block data) {
        this.data = data;
    }
}

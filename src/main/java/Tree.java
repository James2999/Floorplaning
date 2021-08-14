import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class Tree {
    private static Random rand;
    private List<TreeNode> nodeArray = new ArrayList<TreeNode>();
    private TreeNode head;
    private int maxWidth = 0;
    private int maxHeight = 0;
    private int Area = 0;

    /**
     * 以随机的方式创建一个新树
     * @param blockList
     */
    public void create(List<Block> blockList) {
        head = new TreeNode(blockList.get(0));
        TreeNode tempNode = head;
        nodeArray.add(tempNode);
        for (int i = 1; i < blockList.size(); i++) {
            TreeNode Child = new TreeNode(blockList.get(i));
            Child.setParent(tempNode);
            nodeArray.add(Child);
            if (Math.random() < 0.5) {
                tempNode.setLeftChild(Child);
            } else {
                tempNode.setRightChild(Child);
            }
            tempNode = Child;
        }
        updatePosition(head);
        updateMaxSize();
    }

    /**
     * 以DFS的方式根据树的结构更新每个节点内的块的位置信息
     * @param node
     */
    public void updatePosition(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode parent = node.getParent();
        if (parent != null) {
            if (parent.getLeftChild() == node) {//自身为父节点的左孩子
                node.getData().setX(parent.getData().getX() + parent.getData().getWidth());
                node.getData().setY(parent.getData().getY());
            } else {
                node.getData().setX(parent.getData().getX());
                node.getData().setY(parent.getData().getY() + parent.getData().getHeight());
            }
        }
        updatePosition(node.getLeftChild());
        updatePosition(node.getRightChild());
    }

    /**
     * 计算所需的矩形长宽与面积并更新变量
     */
    public void updateMaxSize() {
        for (TreeNode treeNode : nodeArray) {
            if (treeNode.getData().getX() + treeNode.getData().getWidth() > maxWidth) {
                maxWidth = (int) (treeNode.getData().getX() + treeNode.getData().getWidth());
            }
            if (treeNode.getData().getY() + treeNode.getData().getHeight() > maxHeight) {
                maxHeight = (int) (treeNode.getData().getY() + treeNode.getData().getHeight());
            }
        }
        Area = maxHeight * maxWidth;
    }

    /**
     * 通过块的编号返回节点
     * @param number
     * @return
     */
    public TreeNode find(int number) {
        return nodeArray.get(number);
    }

}

public class Test {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.create(FileUtil.readCsv("data.csv"));

    }
}


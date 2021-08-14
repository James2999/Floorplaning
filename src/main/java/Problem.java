public class Problem {
	private static Problem problem = null;
    private int blockNum = 30; //number of nodes
    private int bestCost = 217723;//the best known solution
    private int[][] blocks;

    public int getBlockNum() { return blockNum;}
    public int getBestCost() { return bestCost;}
    public int getWidth(int index) { return blocks[index][0]; }
    public int getHeight(int index) { return blocks[index][1]; }
    
    private Problem() {
    	blocks = new int[blockNum][2];
    	for (int i = 0; i < data.length; i++) {
   			blocks[i][0] = data[i][0];
   			blocks[i][1] = data[i][1];
    	}
    }
    
    public static Problem get() { 
    	if (problem == null) {
    		problem = new Problem();
    	}
    	return problem; 
    }
    
    public String toString() {
    	String str = "" + blockNum  + "\t" + bestCost + "\n\n";
    	
    	for (int i = 0; i < blocks.length; i++) {
    		for (int j = 0; j < blocks[i].length; j++) {
    		    str += blocks[i][j] + "\t";
    	    }
    		str += "\n";
    	}
    	return str;
    }
    
    public static void main(String[] args) {
        System.out.println(Problem.get());
    }
    
    //test data with 30 blocks
    private static int[][] data = new int[][] {
    	{117, 106},
    	{44, 45},
    	{57, 98},
    	{134, 78},
    	{79, 88},
    	{103, 37},
    	{62, 78},
    	{108, 79},
    	{127, 64},
    	{112, 108},
    	{89, 35},
    	{74, 52},
    	{84, 95},
    	{62, 64},
    	{84, 113},
    	{39, 112},
    	{69, 134},
    	{71, 132},
    	{42, 106},
    	{103, 120},
    	{134, 127},
    	{98, 45},
    	{89, 81},
    	{50, 130},
    	{49, 108},
    	{118, 35},
    	{67, 130},
    	{37, 33},
    	{71, 125},
    	{45, 50}
    };
}


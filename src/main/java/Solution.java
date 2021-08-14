import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;

public class Solution implements Comparable<Solution> {
	public static Problem prob;
	private static Random rand;
	
	public int cost;

	public int getCost() { return cost; }
	
	public static void init() {
		prob = Problem.get();
		rand = new Random();
	}
	
	public Solution() {
		//--------------added your code here
		
		//---------------------------------
	}
	
	
	/**
	 * 生成一个新的解
	 * @return
	 */
	public Solution neighbor() {
		return null;
	}
	
	public void save(String fileName) {
		//decode();
		try {
			PrintWriter printWriter = new PrintWriter(new FileWriter(fileName));
			printWriter.write(toString());
			printWriter.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
    
    public String toString() {
    	String str = cost + "\n";

    	str += "\n";
    	return str;
    }
    
    public int compareTo(Solution s) {
    	if (this.cost < s.cost) {
    		return 1;
    	} else if (this.cost == s.cost){
    		return 0;
    	} else {
    		return -1;
    	}
    }
    
    public static void main(String[] args) {
    	String name = "file";//8,9,10,20,50,70,100,410,500,1000
     	try {
    	    Problem problem = Problem.get();
    	    System.out.println(problem);
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}
    	
    	Solution.init();
    	Solution gs = new Solution();
    	int times = 25;
    	int total = 0;
     	for (int t = 0; t < times; t++) {
    		Solution s = new Solution();
    		System.out.println(t + "----" + Problem.get().getBestCost() + ", " + s.cost);
    		total += s.cost;
    		if (s.cost < gs.cost) {
    			gs = s;
    		}
    	}
    	System.out.println(Problem.get().getBestCost() + ", " + gs.cost + "," + total/times);
    	gs.save((new File("")).getAbsolutePath() + "/results/" + name + ".txt");
     }
     
}

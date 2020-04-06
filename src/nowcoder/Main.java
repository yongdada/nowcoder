package nowcoder;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class Main{
	
	public static void main(String[] args) {
		// []{}()
		Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        in.close();
        ArrayList list = new ArrayList<Character>();
        for(int i=0; i<str.length();i++) {
        	char c = str.charAt(i);
        	if(c=='[') {
        		list.add(c);
        		continue;
        	}
        	if(c==']') {
        		boolean flag =  list.remove((Character)'[');
        		if(!flag) {
        			System.out.println("false");
        			break;
        		}
        		continue;
        	}
        	if(c=='{') {
        		list.add(c);
        		continue;
        	}
        	if(c=='}') {
        		boolean flag =  list.remove((Character)'{');
        		if(!flag) {
        			System.out.println("false");
        			break;
        		}
        		continue;
        	}
        	if(c=='(') {
        		list.add(c);
        		continue;
        	}
        	if(c==')') {
        		boolean flag =  list.remove((Character)'(');
        		if(!flag) {
        			System.out.println("false");
        			break;
        		}
        		continue;
        	}
        }
        if(list.isEmpty()) {
        	System.out.println("true");
        } else {
        	System.out.println("false");
        }
        
	}
	public static void main4(String[]args)throws Exception {
	    final Object obj = new Object();
	    Thread t1 = new Thread() {
	        public void run() {
	            synchronized (obj) {
	                try {
	                    obj.wait();
	                    System.out.println("Thread 1 wake up.");
	                } catch (InterruptedException e) {
	                }
	            }
	        }
	    };
	    t1.start();
	    Thread.sleep(1000);//We assume thread 1 must start up within 1 sec.
	    Thread t2 = new Thread() {
	        public void run() {
	            synchronized (obj) {
	                obj.notifyAll();
	                System.out.println("Thread 2 sent notify.");
	            }
	        }
	    };
	    t2.start();
	}
	/**
	 * 完全数
	 * 第一个完全数是6，第二个完全数是28，第三个完全数是496，后面的完全数还有8128、33550336等等。
	 * @param args
	 */
	public static void perfectNum() {
		for (int num = 1; num <= 1000; num++) {
			int sum = 0;
			for (int x = 1; x < num; x++) {
				if (num % x == 0) {
					sum += x;
				}
			}
			if (num == sum) {
				System.out.println(num);
			}
		}
	}

	/**
	 * 五猴分桃
     * @param count  桃子被分次数
     * @param remain 最后一次可能的桃子数
     * @param total  现有桃子数
     * @return 上一次桃子数
     * 
     * sum(5, 4, 4)  n^n-(n-1) = 3121
     */
    public static int sum(int count, int remain, int total) {
        total = total / 4 * 5 + 1;
        if (count == 1) {
            return total;
        }
        if (total % 5 == 1 && total % 4 == 0) {
            count--;
        } else {
            count = 5;
            remain += 4;
            total = remain;
        }
        return sum(count, remain, total);
    }
    /**
     * devide(0, 0, 1, 5)
     * @param result
     * @param sum
     * @param i
     * @param monkey
     * @return
     */
    public int devide(int result, int sum, int i, int monkey)
    {
        result = i == 1 ? sum : result;
        return result % monkey == 1 ? (i == monkey ? sum : devide((result-1)/5 * 4, sum, i+1, monkey) ): devide(result, sum+1, 1, monkey);
    }

    /**
     * 兔子繁殖问题
     * @param n
     * @return
     */
	public static int getRabitFormMoon(int n){
        if(n<0){
            System.out.println("输入的月数不能小于0");
            return 0;
        }
        if(n==1||n==2){   //第一项和第二项都等于1，所以当是n=1和n=2都返回1
            return 1;
        }
        return getRabitFormMoon(n-1)+getRabitFormMoon(n-2);   //如果不是第一和第二项，则返回前一项+前一项的前一项的和
    }
	
	
	/**
	 * 功能：有个机器人坐在X*Y网格的左上角，只能向右、向下移动。机器人从（0,0）到（X,Y）有多少种走法。
	 * 进阶：假设有些点为“禁区”，机器人不能踏足。找出一条路径，让机器人从左上角移动到右下角。
	 */
	
	/**
	 * 正整数x和y，取值范围[1,10]
	 * 走格子 x*y的网格 
	 * @param x
	 * @param y
	 * @return
	 */
	public static int table(int x, int y) {
		if (x == 1)
			return y + 1;
		if (y == 1)
			return x + 1;
		return table(x - 1, y) + table(x, y - 1);
	}
	/**
	 * 递归
	 * @param x
	 * @param y
	 * @param path
	 * @return
	 */
	public static boolean getPath(int x,int y,ArrayList<Point> path){
		Point p=new Point(x,y);
		path.add(p);
		if(x==0&&y==0)
			return true;//找到路径
		
		boolean success=false;
		if(x>=1&&isFree(x-1,y))//向左走
			success=getPath(x-1,y, path);
		if(y>=1&&isFree(x,y-1))
			success=getPath(x,y-1,path);
		
		if(!success)
			path.add(p);//错误路径
		 
		return success;
		
	}
	/**
	 * 动态规划
	 * @param x
	 * @param y
	 * @param path
	 * @param cache
	 * @return
	 */
	public static boolean getPathDP(int x, int y, ArrayList<Point> path, HashMap<Point, Boolean> cache) {
		Point p = new Point(x, y);
		if (x == 0 & y == 0)
			return true;

		path.add(p);

		if (cache.containsKey(p))
			return cache.get(p);

		boolean success = false;
		if (x >= 1 && isFree(x - 1, y))
			success = getPathDP(x - 1, y, path, cache);
		if (y >= 1 && isFree(x, y - 1))
			success = getPathDP(x, y - 1, path, cache);

		if (!success)
			path.add(p);// 错误路径的点

		cache.put(p, success);// 缓存结果

		return success;
	}

	private static boolean isFree(int i, int y) {
		//TODO: 设置陷阱点
		if (i == 3 && y == 2)
			return false;
		return true;
	}

	static class Point {
		int x;
		int y;
		boolean isFree;

		public Point() {
		}

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	//=====================================================================
	
    public static void main2(String[] arges) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s=bf.readLine())!=null) {
             
            int n = Integer.valueOf(s);
           
            String[] arrStr = bf.readLine().split(" ");
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = Integer.valueOf(arrStr[i]);
            }
            System.out.println(mergeSort(arr));
        }
    }
    public static int ysf(int n, int m){    //此题目中，n=41, m=3
	    if(n == 1){
	        return n;
	    }
	    return (ysf(n-1,m) + m - 1)% n + 1;
	}
    public static long mergeSort(int[] arr){
        if(arr == null || arr.length <= 1){
            return 0;
        }
        return mergeSort(arr, 0, arr.length-1);
    }
    
    public static long mergeSort(int[] arr, int l, int r){
    	if (l == r) {
			return 0;
		}
    	int mid = l + ((r - l) >> 1);
        return mergeSort(arr, l, mid) + mergeSort(arr, mid+1, r) + merge(arr, l, mid, r);
    }

    public static long merge(int[] arr, int l ,int mid, int r){
        int[] help = new int[r-l+1];
        int p1 = l;
        int p2 = mid+1;
        int rst = 0;
        int i = 0;
        while(p1<=mid && p2<=r){
            rst += arr[p1] < arr[p2] ? (r-p2+1)*arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] :arr[p2++];
        }
        while(p1<=mid){
            help[i++] = arr[p1++];
        }
        while(p2<=r){
            help[i++] = arr[p2++];
        }
        for(int j=0; j<help.length; j++){
            arr[l+j] = help[j];
        }
        return rst;
    }
}
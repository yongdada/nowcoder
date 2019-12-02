package class_03;

import java.util.Stack;

public class Code_02_GetMinStack {
	public static class MyStack1 {
		private Stack<Integer> stackData;
		private Stack<Integer> stackMin;

		public MyStack1() {
			this.stackData = new Stack<Integer>();
			this.stackMin = new Stack<Integer>();
		}

		public void push(int newNum) {
			if (this.stackMin.isEmpty()) {
				this.stackMin.push(newNum);
			} else if (newNum <= this.getmin()) {
				this.stackMin.push(newNum);
			}
			this.stackData.push(newNum);
		}

		public int pop() {
			if (this.stackData.isEmpty()) {
				throw new RuntimeException("Your stack is empty.");
			}
			int value = this.stackData.pop();
			if (value == this.getmin()) {
				this.stackMin.pop();
			}
			return value;
		}

		public int getmin() {
			if (this.stackMin.isEmpty()) {
				throw new RuntimeException("Your stack is empty.");
			}
			return this.stackMin.peek();
		}
	}

	public static class MyStack2 {
		private Stack<Integer> stackData;
		private Stack<Integer> stackMin;

		public MyStack2() {
			this.stackData = new Stack<Integer>();
			this.stackMin = new Stack<Integer>();
		}

		public void push(int x) {
			if (this.stackMin.isEmpty()) {
				this.stackMin.push(x);
			} else if (x < this.getMin()) {
				this.stackMin.push(x);
			} else {
				int newMin = this.stackMin.peek();
				this.stackMin.push(newMin);
			}
			this.stackData.push(x);
		}

		public int pop() {
			if (this.stackData.isEmpty()) {
				throw new RuntimeException("Your stack is empty.");
			}
			this.stackMin.pop();
			return this.stackData.pop();
		}

		public int getMin() {
			if (this.stackMin.isEmpty()) {
				throw new RuntimeException("Your stack is empty.");
			}
			return this.stackMin.peek();
		}
	}
	
	class MinStack {

	    /** initialize your data structure here. */
	    private Stack<Integer> stackData;
	    private Stack<Integer> stackMin;
	    public MinStack() {
	        this.stackData = new Stack<Integer>();
	        this.stackMin = new Stack<Integer>();
	    }
	    
	    public void push(int x) {
	        if(stackData.isEmpty()){
	            stackData.push(x);
	            stackMin.push(x);
	        } else if(stackMin.peek() > x){
	        	stackData.push(x);
	            stackMin.push(x);
	        } else {
	        	stackMin.push(stackMin.peek());
	            stackData.push(x);
	        }
	    }
	    
	    public void pop() {
	    	if(stackData.isEmpty())
	    		throw new RuntimeException("此时栈为空，不能弹出！");
	    	stackData.pop();
            stackMin.pop();
	    }
	    
	    public int top() {
	    	return stackData.peek();
	    }
	    
	    public int getMin() {
	    	if(stackData.isEmpty())
	    		throw new RuntimeException("此时栈为空，不能弹出！");
	        return stackMin.peek();
	    }
	}

	/**
	 * Your MinStack object will be instantiated and called as such:
	 * MinStack obj = new MinStack();
	 * obj.push(x);
	 * obj.pop();
	 * int param_3 = obj.top();
	 * int param_4 = obj.getMin();
	 */

	public static void main(String[] args) {
		MyStack1 stack1 = new MyStack1();
		stack1.push(3);
		System.out.println(stack1.getmin());
		stack1.push(4);
		System.out.println(stack1.getmin());
		stack1.push(1);
		System.out.println(stack1.getmin());
		System.out.println(stack1.pop());
		System.out.println(stack1.getmin());

		System.out.println("=============");

		MyStack1 stack2 = new MyStack1();
		stack2.push(3);
		System.out.println(stack2.getmin());
		stack2.push(4);
		System.out.println(stack2.getmin());
		stack2.push(1);
		System.out.println(stack2.getmin());
		System.out.println(stack2.pop());
		System.out.println(stack2.getmin());
	}

}

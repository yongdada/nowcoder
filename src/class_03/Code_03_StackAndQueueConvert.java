package class_03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Code_03_StackAndQueueConvert {

	public static class TwoStacksQueue {
		private Stack<Integer> stackPush;
		private Stack<Integer> stackPop;

		public TwoStacksQueue() {
			stackPush = new Stack<Integer>();
			stackPop = new Stack<Integer>();
		}

		public void push(int pushInt) {
			stackPush.push(pushInt);
		}

		public int poll() {
			if (stackPop.empty() && stackPush.empty()) {
				throw new RuntimeException("Queue is empty!");
			} else if (stackPop.empty()) {
				while (!stackPush.empty()) {
					stackPop.push(stackPush.pop());
				}
			}
			return stackPop.pop();
		}

		public int peek() {
			if (stackPop.empty() && stackPush.empty()) {
				throw new RuntimeException("Queue is empty!");
			} else if (stackPop.empty()) {
				while (!stackPush.empty()) {
					stackPop.push(stackPush.pop());
				}
			}
			return stackPop.peek();
		}
	}
	
	class MyQueue {
	    /** Initialize your data structure here. */
		private Stack<Integer> stackPush;
		private Stack<Integer> stackPop;
	    public MyQueue() {
	        this.stackPush = new Stack<Integer>();
	        this.stackPop = new Stack<Integer>();
	    }
	    
	    /** Push element x to the back of queue. */
	    public void push(int x) {
	        stackPush.push(x);
	    }
	    
	    /** Removes the element from in front of queue and returns that element. */
	    public int pop() {
	    	if(stackPop.isEmpty()) {
	    		while(! stackPush.isEmpty()) {
	    			stackPop.push(stackPush.pop());
	    		}
	    	}
	    	return stackPop.pop();
	    }
	    
	    /** Get the front element. */
	    public int peek() {
	    	if(stackPop.isEmpty()) {
	    		while(! stackPush.isEmpty()) {
	    			stackPop.push(stackPush.pop());
	    		}
	    	}
	    	return stackPop.peek();
	    }
	    
	    /** Returns whether the queue is empty. */
	    public boolean empty() {
	        return stackPop.empty() && stackPush.empty();
	    }
	}

	/**
	 * Your MyQueue object will be instantiated and called as such:
	 * MyQueue obj = new MyQueue();
	 * obj.push(x);
	 * int param_2 = obj.pop();
	 * int param_3 = obj.peek();
	 * boolean param_4 = obj.empty();
	 */

	public static class TwoQueuesStack {
		private Queue<Integer> queue;
		private Queue<Integer> help;

		public TwoQueuesStack() {
			queue = new LinkedList<Integer>();
			help = new LinkedList<Integer>();
		}

		public void push(int pushInt) {
			queue.add(pushInt);
		}

		public int peek() {
			if (queue.isEmpty()) {
				throw new RuntimeException("Stack is empty!");
			}
			while (queue.size() != 1) {
				help.add(queue.poll());
			}
			int res = queue.poll();
			help.add(res);
			swap();
			return res;
		}

		public int pop() {
			if (queue.isEmpty()) {
				throw new RuntimeException("Stack is empty!");
			}
			while (queue.size() > 1) {
				help.add(queue.poll());
			}
			int res = queue.poll();
			swap();
			return res;
		}

		private void swap() {
			Queue<Integer> tmp = help;
			help = queue;
			queue = tmp;
		}

	}
	
	class MyStack {

	    /** Initialize your data structure here. */
		private Queue<Integer> queue;
		private Queue<Integer> help;		
		
	    public MyStack() {
	        this.queue = new LinkedList<Integer>();
	        this.help = new LinkedList<Integer>();
	    }
	    
	    /** Push element x onto stack. */
	    public void push(int x) {
	        queue.add(x);
	    }
	    
	    /** Removes the element on top of the stack and returns that element. */
	    public int pop() {
	        while (queue.size() > 1) {
	        	help.add(queue.poll());
	        }
	        int tmp = queue.poll();
	        swap();
	        return tmp;
	    }
	    
	    /** Get the top element. */
	    public int top() {
	    	while (queue.size() > 1) {
	        	help.add(queue.poll());
	        }
	        int tmp = queue.poll();
	        help.add(tmp);
	        swap();
	        return tmp;
	    }
	    
	    /** Returns whether the stack is empty. */
	    public boolean empty() {
	        return queue.isEmpty();
	    }
	    
	    private void swap() {
	    	Queue<Integer> tmp = queue;
	    	queue = help;
	    	help = tmp;
	    }
	}

	/**
	 * Your MyStack object will be instantiated and called as such:
	 * MyStack obj = new MyStack();
	 * obj.push(x);
	 * int param_2 = obj.pop();
	 * int param_3 = obj.top();
	 * boolean param_4 = obj.empty();
	 */

}

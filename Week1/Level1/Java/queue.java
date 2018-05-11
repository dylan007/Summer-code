import java.io.*;
import java.util.*;
class Solution {
	static Node start;//first node of the linked list
	static Node last;//last node of the linked list
	/*
		Maintaining pointers to both the first and last node of the linked list,
		allows us to do both push and pop operations on queues in constant time
		with almost negligible memory overheads.
		If we did not maintain the pointer to the last node, it would result in
		the complexity of push operation to be O(N) instead of O(1).
	*/

	static void push(int x) {
		Node newnode = new Node(x);
		if(start==null){ //if the queue is empty
			start=newnode;
			last=newnode;
		}
		else{
			last.next = newnode; //appending the node to the end
			last = newnode;
		}
	}

	static void pop() {
		if(start==null) {
			System.out.println("Queue is empty!");
			return;
		}
		System.out.println(start.value);
		start=start.next;//removing reference from the starting node thereby deleting it
	}

	public static void main(String[] args) throws IOException {
		int q = nextInt();
		while(q-->0) {
			int type = nextInt();//type of query
			if(type==1)
				pop();
			else
				push(nextInt()); //calling the push function and accepting the value that needs to be inserted
		}
	}

	//A class representing a node in a linked list
	static class Node {
		int value;
		Node next;
		Node(int x) {
			value = x;
			next = null;
		}
	}

	/*
	Helper functions for faster input.
	*/
	static int nextInt()throws IOException{
		InputStream in=System.in;
		int ans=0;
		boolean flag=true;
		byte b=0;
		boolean neg=false;
		while ((b>47 && b<58) || flag){
			if(b==45)
				neg=true;
			if(b>=48 && b<58){
				ans=ans*10+(b-48);
				flag=false;
			}
			b=(byte)in.read();
		}
		if(neg)
			return -ans;
		return ans;
	}

	static long nextLong()throws IOException{
		InputStream in=System.in;
		long ans=0;
		boolean flag=true;
		byte b=0;
		while ((b>47 && b<58) || flag){
			if(b>=48 && b<58){
				ans=ans*10+(b-48);
				flag=false;
			}
			b=(byte)in.read();
		}
		return ans;
	}
	static String next()throws Exception{
		StringBuilder sb=new StringBuilder(1<<16);
		InputStream in=System.in;
		byte b=0;
		do{
			if(!isWhiteSpace(b))
				sb.append((char)b);
			b=(byte)in.read();
		}while(!isWhiteSpace(b) || sb.length()==0);
		return sb.toString();
	}
	static boolean isWhiteSpace(byte b){
		char ch=(char)b;
		return ch=='\0' || ch==' ' || ch=='\n';
	}
}
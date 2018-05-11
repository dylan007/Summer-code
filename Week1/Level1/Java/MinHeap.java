import java.io.*;
import java.util.*;
class MinHeap {
	int arr[];
	int size;
	int capacity;

	MinHeap(int capacity) {
		this.capacity = capacity;
		size = 0;
		arr = new int[capacity];
	}

	int parent(int idx) { //gives the parent of the given index
		return (idx-1)>>1;
	}

	int lchild(int idx) { //gives the left child of the given index
		return (idx<<1)+1;
	}

	int rchild(int idx) { //gives the right chuld of the given index
		return (idx+1)<<1;
	}

	void swap(int i,int j) { //utility function that swaps the values of the given indices
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	void heapify(int idx) { //heapifies at that index assuming that both it's subtrees are heaps
		int min = idx;
		if(lchild(idx)<size && arr[lchild(idx)]<arr[min])
			min = lchild(idx);
		if(rchild(idx)<size && arr[rchild(idx)]<arr[min])
			min = rchild(idx);
		if(min!=idx){
			swap(idx,min);
			heapify(min);
		}
	}

	boolean insert (int x) {
		if(size == capacity)
			return false;
		size++;
		int i = size - 1;
		arr[i] = x;
		while(i!=0 && arr[parent(i)] > arr[i]){
			swap(i,parent(i));
			i = parent(i);
		}
		return true;
	}

	boolean deleteMin() {
		if(size==0)
			return false;
		size--;
		swap(0,size);
		heapify(0);
		return true;
	}

	int getmin() {
		if(size == 0)
			return -1; //key values lie between 1 and 1e9 so -1 signifies empty heap
		return arr[0];
	}

	public static void main(String[] args) throws IOException {
		int q = nextInt();
		MinHeap mh = new MinHeap(q);//there can be maximum of q insertions
		while(q-- > 0){
			int type = nextInt();
			switch(type) {
				case 1 : int val = nextInt();
				mh.insert(val);
				break;
				case 2 : int min = mh.getmin();
				if(min==-1)
					System.out.println("Heap is empty!");
				else
					System.out.println(min);
				break;
				case 3 : 
				if(!mh.deleteMin())
					System.out.println("Heap is empty!");
			}
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
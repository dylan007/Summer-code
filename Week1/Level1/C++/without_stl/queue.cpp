#include <bits/stdc++.h>

using namespace std;

/*
* We use linked lists to implement the queue adt in this case. 
* Create a structure based on a node in the queue.
*/
typedef struct node{
  int data;           // This property holds the value in a particular node.
  struct node *next; // This property holds the pointer to the next node in the queue.
}node;

node* push(node *tail,int data){
  node *newnode = (node *)malloc(sizeof(node)); //Create a new node and allocate space to the new node.
  newnode->data = data;                         // Set data property to required value.
  newnode->next = NULL;                         // Points to null because this is the last node in the queue.
  if(tail!=NULL)                                // if tail is null, it means the list is empty.
	tail->next = newnode;                       // So we just return newnode in that case. 
  return newnode;                               // Else we set the next pointer to the newnode.
}

node *pop(node *head){
  return head->next;                          // updates the head pointer in main with head->next;
} 

int isEmpty(node *head){
  return head==NULL;                          // head/tail pointer being null signifies empty queue.
}

int front(node *head){
  return head->data;                          // Returns the first element in the queue.
}

int main(){
  int q;
  cin >> q;
  node *head,*tail;
  head = tail = NULL;               // Initialise both to null signifying empty list.
  while(q--){
	int c;
	cin >> c;
	if(c==1){
	  if(isEmpty(head))             // check for empty list before popping.
		cout << "Queue is empty!" << endl;  
	  else{
		cout << front(head) << endl;  // print the first element and pop in next step.
		head = pop(head);             // This sets the head to head->next; 
	  }
	}
	else{
	  int x;
	  cin >> x;
	  if(isEmpty(head)){				// This shows no nodes in the list.
		tail = push(tail,x); 			// This will make tail point to the newly created node. 
		head = tail;					// Since, there is only one node in the list, head should also
	  }									// be pointing to tail.
	  else
		tail = push(tail,x);			// If the list is not empty
	}
  }
  return 0;
}

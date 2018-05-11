#include<bits/stdc++.h>
using namespace std;

/*
 * Here we are using linked lists to implement the Stack ADT. 
 * First we create a structure that represents any node in the stack. The node should contain an integer and the pointer to the next node. 
 */
typedef struct node{                    
  int data;
  struct node *next;
}node;


/*
 * The first function of the stack data structure should be the push function. This inserts an integer into the stack
 * and puts it on the top of the stack. The function takes two parameters, one being the pointer to the first node in
 * the stack or the top node. The second parameter is the number being inserted. After the push function is completed,
 * the top node now contains the number that was just inserted.
 */
node* push(node *head,int data){
  node *newnode = (node *)malloc(sizeof(node)); //Create a new variable of type node and allocate the required space.
  //Read up more on malloc. I'm serious.
  newnode->data = data;
  //Assign the data property of the structure with the passed value.
  newnode->next = head;
  //Point this node to the old root of the list.
  return newnode;
  //This is now the new node of the list.
}

node* pop(node *head){
  return head->next;
  //Ideally free this node and then return but this works too. This returns the next node in the list and makes it the new head.
}

int top(node *head){
  return head->data;
  //Since the head of the list is the top node on the stack, we just return the data stored in that node.
}

int isEmpty(node *head){
  return (head == NULL);
  // The list is empty only when the head is NULL which means that there are no nodes in the list.
  // This might not work if you don't initialise the head pointer to null initially. 
}

void display(node *head){
  node *temp = head;
  while(temp != NULL){
    cout << temp->data << " ";  // Simple display function that iterates over the list until a null 
    temp = temp->next;          // node is found.
  }
  cout << endl;
  return;
} 

int main(){
  int q;
  cin >> q;
  node *head = NULL;
  while(q--){
    int c;
    cin >> c;
    if(c==1){
      if(isEmpty(head))
        cout << "Stack is Empty!" << endl;
      else{
        cout << top(head) << endl;
        head = pop(head);
      }
    }
    else{
      int x;
      cin >> x;
      head = push(head,x);
    }
  }
  return 0;
}

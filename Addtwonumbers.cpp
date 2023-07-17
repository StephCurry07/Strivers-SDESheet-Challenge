#include <iostream>

 class Node {
public:
     int data;
     Node *next;
     Node() {
         this->data = 0;
         this->next = NULL;
     }
     Node(int data) {
         this->data = data;
         this->next = NULL;
     }
     Node (int data, Node *next) {
         this->data = data;
         this->next = next;
     }
};

Node *addTwoNumbers(Node *l1, Node *l2){
    Node* dummyHead = new Node(0);
    Node* curr = dummyHead;
    int carry = 0;

    while (l1 != nullptr || l2 != nullptr) {
        int sum = carry;

        if (l1 != nullptr) {
            sum += l1->data;
            l1 = l1->next;
        }

        if (l2 != nullptr) {
            sum += l2->data;
            l2 = l2->next;
        }

        carry = sum / 10;
        curr->next = new Node(sum % 10);
        curr = curr->next;
    }

    if (carry > 0) {
        curr->next = new Node(carry);
    }

    return dummyHead->next; 
}
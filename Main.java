package DataStructures;

class Node{
    private int data ;  /* contains the information  */
    private Node next ; /* contains the address of next node */

    /* default constructor */
    public Node(){
        this.data = 0 ;
        this.next = null ;
    }

    /* Method to set the data */
    public void setData(int data){
        this.data  =  data ;
    }

    /* Method to set the next node */
    public void setNext(Node next){
        this.next = next ;

    }

    /* Method to get the data */
    public int getData()
    {
        return this.data ;

    }

    /* Method to get the next value */
    public Node getNext()
    {
        return this.next ;
    }

}

 class LinkedList{
    private Node head ;

    /*  default constructor */
    public LinkedList(){
        head = null  ;
    }

    /* Method to check the List is empty */
     public boolean isEmpty()
     {
         if( head == null  )
             return true ;
         return false;
     }

     /* Method to traverse the list  */
     public void traverse() {
         Node temp;
         if (isEmpty()) {
             System.out.println("List is empty ");
             return;
         }
         temp = head;
         while (temp != null) {
             System.out.print(temp.getData());
             System.out.print("\t");
             temp = temp.getNext();
         }
     }


     /*  Method to insert element at left hand side of list  */
     public void insertAtBegining(int data)
    {
        Node node = new Node() ;
        node.setData(data);
        node.setNext(head);
        head = node  ;
    }

    /* Method to insert element at right hand side of list */
    public void insertAtEnd(int data){
        Node node  = new Node();
        node.setData(data);
        if( isEmpty() ){  // when list is empty
            node.setNext(head);
            head = node ;
            return ;
        }
        Node temp = head ;
        while( temp.getNext() != null )
        {
            temp = temp.getNext();
        }
        temp.setNext(node);

    }

    /* Method to search a node in List  */
    public Node search(int data)
    {
        Node temp = head ;
        while( temp != null ){
            if( temp.getData() == data )
                return temp ;
            temp = temp.getNext() ;

        }
        System.out.println("Element is not Present ");
        return null ;
    }

    public void insertAfter(int target , int data )
    {
        Node temp = search(target);
        if( temp == null)
            return ;
        Node node = new Node() ;
        node.setData(data);
        Node ptr = temp.getNext() ;
        temp.setNext(node);
        node.setNext(ptr);

    }
    public void insertBefore(int target , int data)
    {
        Node temp = search(target) ;
        if(temp == null ){
            System.out.println( target +"Not found"+"in List" );
            return ;
        }
        else if( temp == head ) { /* if target is head node  */
            insertAtBegining(data);
            return ;
        }
        Node node = new Node();
        node.setData(data);
        Node temp1 = head ;
        while( temp1.getNext() != temp  )
        {
            temp1 = temp1.getNext() ;
        }
        temp1.setNext(node);
        node.setNext(temp) ;

    }
   
     /* method to delete the item in end of list  */
    public void deleteAtEnd()
    {
    }
     /* method to delete the item in the front of list   */ 
    public void deleteAtBegin()
    {
        if( this.isEmpty() )
        {
            System.out.println("Already empty ");
            return ;
        }
        Node temp = head ;
        head = head.getNext() ;
        temp = null ;

    }
     /* method to delete specific element   */
    public void delete(int data )
    {
    }
     /* method to delete the whole list  */ 
    public void deleteList()
    {
    }


 }




public class Main{
    public static void main(String[] args) {

        LinkedList List =  new LinkedList() ;

        List.insertAtBegining(3);
        List.insertAtBegining(2);
        List.insertAtBegining(1);
        List.insertAtEnd(4);
        List.insertAtEnd(5);
        List.insertBefore(1 , -11);
        List.traverse();


    }
}

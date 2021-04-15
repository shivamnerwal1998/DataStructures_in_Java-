package DataStructures  ;

class Stack_Node
{
     private int top   ;
     private int stack[] = new int[100]  ;
     public int getTop() { return this.top ; }
     public void setTop() { this.top = -1 ; }
     public int getData() {return this.stack[this.top]  ;}

     public void setData(int data) {
         this.stack[this.top] = data ;
     }

     public void increaseTop()
     {
         if(this.top <= 100 )   this.top++ ;
         else   System.out.println("Overflow");
     }
     public void decreaseTop(){

         this.top-- ;

     } ;

}

class Stack_Operations{
    public Stack_Node create_Stack(Stack_Node s)  {
        s.setTop();
        return s ;
    }
    public boolean isEmpty(Stack_Node s)
    {
        if( s.getTop()< 0   )
            return true ;
        else
            return false ;

    }
    public boolean isFull(Stack_Node s)
    {
        if( s.getTop()> 100   )
            return true ;
        else
            return false ;

    }
    public Stack_Node push(Stack_Node s , int data)
    {
        if( this.isFull(s)) {
            System.out.println("Stack Overflow");
            return s;
        }
        s.increaseTop();
        s.setData(data);
        return s ;
    }
    public Stack_Node poop(Stack_Node s)
    {

        if( this.isEmpty(s) )
        {
            System.out.println("Stack underflow");
            return s;
        }
        else
            s.decreaseTop();
        return s;
    }
    public int peek (Stack_Node s)
    {

        if( this.isEmpty(s) )
        {
            System.out.println("Stack underflow");
            return -100 ;
        }
        else

        return s.getData();
    }


}


public class Stack_Using_Array{

    public static void main(String[] args) {
        Stack_Node s = new Stack_Node() ;
        Stack_Operations Stack = new Stack_Operations() ;
        /* creating Empty stack  */
        Stack.create_Stack(s) ;
        /* if result is true empty stack is created  */
        System.out.println(Stack.isEmpty(s));
        /* Inserting a node in stack  */
        s = Stack.push(s,1) ;
        System.out.println(Stack.peek(s));
        s = Stack.push(s,2) ;
        System.out.println(Stack.peek(s));
        s = Stack.poop(s) ;
        System.out.println(Stack.peek(s));
        s = Stack.poop(s) ;
        System.out.println(Stack.peek(s));




    }
}


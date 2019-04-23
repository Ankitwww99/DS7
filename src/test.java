import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class MyStack
{
    int size;
    int top;
    int stackarray[];
    public MyStack(int sz) {
        size =sz;
        top=-1;
         stackarray = new int[size];
    }
    public void push(int value) {
        if(! isFull())
        {
            top++;
            stackarray[top]=value;
        }
    }
    public void rmm(int a){
        for (int i = a-1; i <top-1; i++) {
            stackarray[i]=stackarray[i+1];
        }
        pop();
    }
    public void isnn(int a,int vv){
        for (int i = top; i >a ; i--) {
            stackarray[i]=stackarray[i-1];
        }
        stackarray[a-1]=vv;
    }
    public boolean isFull() {
        return (top==stackarray.length-1);
    }
    public int pop(){
        return stackarray[top--];
    }
    public boolean isEmpty()
    {
        return (top==-1);
    }
    public void printdd(){
        /*for (int i = 0; i <=top; i++) {
            System.out.print(stackarray[i] +" ");
        }*/
        System.out.println(Arrays.toString(stackarray));
    }
    public void reverse(){
        for(int i=0;i<stackarray.length/2;i++ ){
            int temp=stackarray[i];
            stackarray[i]=stackarray[stackarray.length-1-i];
            stackarray[stackarray.length-1-i]=temp;
        }
    }
    public void serch(int v){
        int c=-1;
        for(int i=0;i<stackarray.length;i++){
            if(stackarray[i]==v) {
                c = i;
                break;
            }
        }
        if(c>0)
            System.out.println("index is="+c);
        else
            System.out.println("element not found");
    }
}
class A {
    public static void main(String[] args) throws IOException {
        InputStreamReader ir=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(ir);
        System.out.println("Enter the size of list");
        int sz=Integer.parseInt(br.readLine());
        MyStack obj = new MyStack(sz);
        for (int i = 0;; i++) {

            System.out.println("\nEnter\n0-to enter the data" +
                    "\n1=display content of list" +
                    "\n2=to check list is full" +
                    "\n3=to check list is empty" +
                    "\n4=to search the element" +
                    "\n5=for reverse the list" +
                    "\n6=to remove element" +
                    "\n7=to insert at particular index"+
                    "\n8=to exit the program");
            int c=Integer.parseInt(br.readLine());
            switch (c){
                case 0:
                    System.out.println("enter data");
                    int da=Integer.parseInt(br.readLine());
                    obj.push(da);
                    break;
                case 1:
                    obj.printdd();
                    break;
                case 2:
                    boolean b=obj.isFull();
                    System.out.println("Status="+b);
                    break;
                case 3:
                    boolean bb=obj.isEmpty();
                    System.out.println("Status="+bb);
                    break;
                case 4:
                    System.out.println("enter value to be search");
                    int va=Integer.parseInt(br.readLine());
                    obj.serch(va);
                    break;
                case 5:
                    obj.reverse();
                    break;
                case 6:
                    System.out.println("enter indexd to be remove");
                    int d1=Integer.parseInt(br.readLine());
                    obj.rmm(d1);
                    break;
                case 7:
                    System.out.println("enter index and value to be insert");
                    int in=Integer.parseInt(br.readLine());
                    int val=Integer.parseInt(br.readLine());
                    obj.isnn(in,val);
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.out.println("wrong key press\ntry again");
            }
        }
    }
}

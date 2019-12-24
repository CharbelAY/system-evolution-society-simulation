import java.io.*;
import java.util.Stack;
import  java.lang.String;

class Node{
    char element;
    Node left,right;

    Node(char element){
        this.element=element;
        left=null;
        right=null;
    }
}

class ExpressionTree{

    boolean isOperator(char in){
        if(in=='+'||in=='-'||in=='*'||in=='/'||in=='^'){
            return true;
        }
        return false;
    }

    void inOrderTraversal(Node n){
        if(n!=null){
            inOrderTraversal(n.left);
            System.out.print(n.element);
            inOrderTraversal(n.right);
        }
    }


    Node constructTree(char postfix[]) {
        Stack<Node> st = new Stack();
        Node t, t1, t2;

        for (int i = 0; i < postfix.length; i++) {

            if (!isOperator(postfix[i])) {
                t = new Node(postfix[i]);
                st.push(t);
            } else
            {
                t = new Node(postfix[i]);

                t1 = st.pop();
                t2 = st.pop();

                t.right = t1;
                t.left = t2;

                st.push(t);
            }
        }

        // only element will be root of expression
        // tree
        t = st.peek();
        st.pop();

        return t;
    }

}





public class Playground {


    public static void main(String[] args) {

        ExpressionTree et = new ExpressionTree();
        String postfix = "ab+ef*g*-";
        char[] charArray = postfix.toCharArray();
        Node root = et.constructTree(charArray);
        System.out.println("infix expression is");
        et.inOrderTraversal(root);

    }

}

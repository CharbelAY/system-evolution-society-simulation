import  java.lang.String;


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

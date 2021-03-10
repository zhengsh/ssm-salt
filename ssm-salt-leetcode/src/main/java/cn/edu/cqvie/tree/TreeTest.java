package cn.edu.cqvie.tree;

public class TreeTest {

    public static void main(String[] args) {
        TreeTest test = new TreeTest();
        Node tree = test.createTree("A(B(C(D(,),),),E(,))");

        System.out.println(tree);
    }

    public Node createTree(String str) {
        if (str == null || "".equals(str) || str.length() < 4) {
            return null;
        }
        char s = str.charAt(0);
        Node node = new Node(s);

        String[] arr = splitStr(str.substring(2, str.length() - 1));
        node.left = createTree(arr[0]);
        node.right = createTree(arr[1]);
        return node;
    }

    public String[] splitStr(String str) {
        int idx = 0;
        int subIndex = 0;
        for (int i = 1; i < str.length(); i++) {
            char s = str.charAt(i);
            if (s == '(') {
                idx++;
                continue;
            }
            if (s == ')') {
                idx--;
                continue;
            }
            if (idx == 0) {
                subIndex = i;
                break;
            }
        }
        return new String[]{str.substring(0, subIndex), str.substring(subIndex + 1)};
    }
}

class Node {
    public char data;
    public Node left;
    public Node right;

    public Node(char data) {
        this.data = data;
    }
}

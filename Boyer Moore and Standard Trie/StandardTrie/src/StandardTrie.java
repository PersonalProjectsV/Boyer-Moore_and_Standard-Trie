import java.io.File;
import java.util.*;
public class StandardTrie {
    public static void main(String[] args)throws Exception {
        Tree tree=new Tree();
        File file=new File("StandardTrie/words.txt");
        Scanner words=new Scanner(file);
        while (words.hasNextLine()){
            String word=words.nextLine();
            insertRecursive(word,tree.root);
        }
        words.close();
        System.out.println("DFS Traversal of Standard Trie");
        searchRecursivee(tree.root);
    }
    public static void insertRecursive(String word,TreeNode root){
        insertRecursive(root,word,0);
    }
    public static  void insertRecursive(TreeNode cur,String word,int index){
        if(index==word.length()){
            cur.endOfWord=true;
            return;
        }
        Character ch=word.charAt(index);
        TreeNode node=cur.childred.get(ch);

        if(node==null){
            node=new TreeNode();
            cur.childred.put(ch,node);
        }
        insertRecursive(node,word,index+1);
    }
    public  static void delete(String word,TreeNode root){
        detele(root,word,0);
    }
    public static boolean detele(TreeNode cur,String word,int index){
        if(index==word.length()){
            if(!cur.endOfWord){
                return false;
            }
            cur.endOfWord=false;
            return cur.childred.size()==0;
        }
        Character ch=word.charAt(index);
        TreeNode node=cur.childred.get(ch);
        if(node==null){return false;}
        boolean deleteCurNOde=detele(node,word,index+1);
        if(deleteCurNOde){
            cur.childred.remove(ch);
            return cur.childred.size()==0;
        }
        return false;
    }
    public static void searchRecursivee(TreeNode root){
        searchRecursiveeS(root);
    }
    public static void searchRecursiveeS(TreeNode cur){
        if(cur==null){
            return;
        }
        Map c=cur.childred;
        Set<Character> keys=c.keySet();
        for (Character i:keys){
            System.out.print(i);
            TreeNode nodee=cur.childred.get(i);
            searchRecursiveeS(nodee);
        }
    }
}
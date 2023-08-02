import java.util.HashMap;
import java.util.Map;
public class TreeNode {
    Map<Character,TreeNode> childred;
    boolean endOfWord;
    public TreeNode(){
        childred=new HashMap<>();
        endOfWord=false;
    }
}
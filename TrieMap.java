//Note: All of your TrieMapInterface method implementations must function recursively
//I have left the method signatures from my own solution, which may be useful hints in how to approach the problem
//You are free to change/remove/etc. any of the methods, as long as your class still supports the TrieMapInterface
import java.util.ArrayList;
import java.util.HashMap;
public class TrieMap implements TrieMapInterface{
  public TrieMapNode root;
  
  public TrieMap(){
    root=new TrieMapNode ();
  }
  
  //Indirectly recursive method to meet definition of interface
  public void put(String key, String value){
	  if(root.getChildren().containsKey(key.charAt(0))){
		  key=key.substring(1);
		  this.put(root,key, value);  
	  }
	  else
	  {
		  this.put(root, key, value);
	  }
	  
	  }
	  
	  //Recursive method
	  public void put(TrieMapNode current, String curKey, String value){
	    if(curKey==null){
	    	current.setValue(value);
	    }
	    else
	    {
	    	curKey=curKey.substring(1);
	    	TrieMapNode a= new TrieMapNode();
	    	this.put(a,curKey,value);
	    }
			
	  }
  
  //Indirectly recursive method to meet definition of interface
  public String get(String key){
    if (this.containsKey(key)){
    	return this.get(root,key);
    }
    else 
    	return null;
  }
  
  //Recursive method
  public String get(TrieMapNode current, String curKey){
	return  current.getChildren().get(curKey).getValue()+curKey;
  }
  
  //Indirectly recursive method to meet definition of interface
  public boolean containsKey(String key){
    return false;
  }
  
  //Recursive method
  public boolean containsKey(TrieMapNode current, String curKey){
    return false;
  }
  
  //Indirectly recursive method to meet definition of interface
  public ArrayList<String> getValuesForPrefix(String prefix){
    return new ArrayList<String>();
  }
  
  //Recursive helper function to find node that matches a prefix
  public TrieMapNode findNode(TrieMapNode current, String curKey){
    return null;
  }
  
  //Recursive helper function to get all keys in a node's subtree
  public ArrayList<String> getKeys(TrieMapNode current){
    return new ArrayList<String>();
  }
  
  //Indirectly recursive method to meet definition of interface
  public void print(){
    if(root.getChildren().isEmpty()){
    	print(root);
    }
    else{
    	for(Character C : root.getChildren().keySet()){
    		print(root.getChildren().get(C));
    	}
    }
    	
  }
  
  //Recursive method to print values in tree
  public void print(TrieMapNode current){
    if(current.getChildren().isEmpty())
    	System.out.println(current.getValue());
    else{
    	for(Character C : current.getChildren().keySet()){
    		print(current.getChildren().get(C));
    	}
    		}
  }
  
  public static void main(String[] args){
    
  }
}
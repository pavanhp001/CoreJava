package Algarithms;

public class BT {
	
	int left,right = 1;
	int count = 0;
	
	private BTNode root;
	
	public BT(){
		root = null;
	}
	public boolean isEmpty(){
		return root == null;
	}
	
	public void insert(int data){
		root = insert(root,data);
	}
	public BTNode insert(BTNode root, int data) {
		
		if(root == null){
			root = new BTNode(data);
		}else{
			if(root.getRight() == null){
				root.setRight(insert(root.getRight(),data));
			}else{
				root.setLeft(insert(root.getLeft(),data));
			}
		}
		return root;
	}
	
	public void preOrder(){
		preOrder(root);
	}
	public void inOrder(){
		inOrder(root);
	}
	public void postOrder(){
		postOrder(root);
	}
	
	public void preOrder(BTNode root){
		if(root != null){
			
			System.out.print(" "+root.getData());
			preOrder(root.getLeft());
			preOrder(root.getRight());
		}
	}
	public void inOrder(BTNode root){
		if(root != null){
			inOrder(root.getLeft());
			System.out.print(" "+root.getData());
			inOrder(root.getRight());
		}
	}
	public void postOrder(BTNode root){
		if(root != null){
			postOrder(root.getLeft());
			postOrder(root.getRight());
			System.out.print(" "+root.getData());
		}
	}
	
    public int countNodes()
    {
        return countNodes(root);
    }
    /* Function to count number of nodes recursively */
    private int countNodes(BTNode r)
    {
        if (r == null)
            return 0;
        else
        {
        	int l =1;
           /* left += countNodes(r.getLeft());
            right += countNodes(r.getRight());
            System.out.println("Left Nodes count="+left+" - Right Nodes="+right);
            return left+right;*/
        	 l += countNodes(r.getLeft());
             l += countNodes(r.getRight());
             //System.out.println("Left Nodes count="+l+" - Right Nodes="+right);
             System.out.println("count="+l+"  data="+r.getData());
             System.out.println("count = "+(++count));
             return l;
        }
    }
}

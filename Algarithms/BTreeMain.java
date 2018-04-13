package Algarithms;

public class BTreeMain {
	
	public static void main(String[] args) {
		
		BT bt = new BT();
		
		int[] array = {8,2,6,3,9,7};
		
		for(int a: array){
			bt.insert(a);
		}
		System.out.println("preOrder=");
		bt.preOrder();
		System.out.println();
		System.out.println("inOrder=");
		bt.inOrder();
		System.out.println();
		System.out.println("postOrder=");
		bt.postOrder();
		System.out.println();
		System.out.println(bt.countNodes());
		int total = 0;
		for (int i : array) {
			total = total+i;
		}
		System.out.println("total="+total);
	}
}

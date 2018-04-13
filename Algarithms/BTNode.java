package Algarithms;

public class BTNode {
	
	private BTNode left, right;
	private int data;
	public BTNode(){
		
		left = null;
		right = null;
		data = 0;
	}
	public BTNode(int data){
		left = null;
		right = null;
		this.data = data;
	}
	/**
	 * @return the left
	 */
	public BTNode getLeft() {
		return left;
	}
	/**
	 * @param left the left to set
	 */
	public void setLeft(BTNode left) {
		this.left = left;
	}
	/**
	 * @return the right
	 */
	public BTNode getRight() {
		return right;
	}
	/**
	 * @param right the right to set
	 */
	public void setRight(BTNode right) {
		this.right = right;
	}
	/**
	 * @return the data
	 */
	public int getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(int data) {
		this.data = data;
	}
}

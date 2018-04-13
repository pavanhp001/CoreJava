package externalization;

public class Father {

	int parent = 1;
	
	transient String parent12 = "pavan"; 

	public Father() {
		System.out.println("Father Constructor");
		parent = 3;
	}

	{
		System.out.println("Initialization Block..");
		parent = 2;
	}
}
package pvl7;

public class start {

	public static void main(String[] args) {
		pvl7 test=new pvl7();
		test.newNode();
		test.newNode();
		test.newNode();
		test.newNode();

		System.out.println(test.setEdge(0, 1));
		System.out.println(test.setEdge(0, 2));
		System.out.println(test.setEdge(0, 3));
		System.out.println(test.setEdge(1, 3));
		System.out.println(test.setEdge(2, 3));
		//System.out.println(test.setEdge(3, 4));
		//System.out.println(test.setEdge(1, 4));
		System.out.println(test.getEdges());
		System.out.println(test.getNGons(3));
		System.out.println(test.hasFullCircle());
	}

}

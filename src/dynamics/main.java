package dynamics;

public class main {
	
	
	
	public static void main(String[] args) {
		
		SimpleLinkedList<Integer> teste = new SimpleLinkedList<Integer>();
		
		teste.add(1);
		teste.add(2);
		teste.add(3);
		teste.add(-2);
		
		System.out.println(teste.print());
		//System.out.println(teste.getIndexOf(-2));
		teste.remove(2);
		teste.remove(1);
		teste.remove(3);
		teste.remove(-2);
		System.out.println(teste.print());
		
		//System.out.println(teste.size());
		
	}
}

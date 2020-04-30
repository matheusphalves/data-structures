package dynamics;

public class LinkedListOrdinated<T> extends SimpleLinkedList<T> {

	
	@Override
	public void add(T info) {
		if(this.getFirst()==null) {
			super.add(info);//adição do primeiro elemento da lista
		}else {
			
			if(this.getFirst().compareTo(info)==1) {
				super.add(info); //menor número é adicionado sempre na frente da lista!
			}else {
				Node<T> aux = this.getFirst();
				while(aux.getNext()!=null) {
					if(aux.getNext().compareTo(info)==1) {//próximo valor será inferior! 
						Node<T> temp = new Node<T>(info);
						temp.setNext(aux.getNext());		
						aux.setNext(temp);		
						break;
					}	
					aux = aux.getNext();//adição no final da lista!
				}		
				
				if(aux.getNext()==null)
					aux.setNext(new Node<T>(info));
				
				this.setSize(this.getSize()+1);	
			}	
		}
	}
	
	//demais métodos não necessitam ser sobrescritos!
	
	public static void main(String[] args) {
		LinkedListOrdinated<Integer> temp = new LinkedListOrdinated<Integer>();
		temp.add(5);
		temp.add(-2);
		temp.add(10);
		temp.add(3);
		temp.add(4);
		temp.add(-1);
		temp.add(0);
		temp.add(1);
		temp.add(30);

		
		System.out.println(temp.print());
	}
	
}

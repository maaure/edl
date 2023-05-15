public class Main {
    public static void main(String[] args) {
        ArrayLista<Integer> lista = new ArrayLista<Integer>();
        
        System.out.println("Esta vazia? " + lista.isEmpty());
        lista.insertLast(1);
        lista.insertLast(2);
        lista.insertLast(3);
        lista.insertLast(4);
        lista.insertLast(5);
        
        System.out.println("Tamanho: " + lista.size());
        lista.printList();


        Position<Integer> p1 = lista.getPosition(2);
         
        lista.insertAfter(p1, 100);
        lista.printList();
        
        System.out.println("Valor do elemento na posição 20: " + p1.getValue());
        
        lista.insertBefore(p1, 101);
        lista.printList();
        
        System.out.println("Primeiro elemento: " + lista.first());
        System.out.println("Último elemento: " + lista.last());
        System.out.println("Esta vazia? " + lista.isEmpty());
        
        Position<Integer> p2 = lista.getPosition(4);
        System.out.println("Valor do elemento na posição 4: " + p2.getValue());
        
        lista.swapElements(p1, p2);

        lista.printList();

        lista.replaceElement(p2, 520);

        lista.printList();
        
        System.out.println(lista.before(5));
        System.out.println(lista.after(5));
        lista.printList();
        
        lista.remove(p1); 

        System.out.println("Valor de p1: " + p1.getValue() + "... Removendo p1: ");

        lista.printList();


        int s = lista.size();
        
        System.out.println("Removendo todos elementos... ");
        for(int i = 0; i < s; i++) {
            Position<Integer> k = lista.getPosition(0);
            System.out.println("Removendo... " + k.getValue());
            lista.remove(k);
        }
        
        
        System.out.println("Esta vazia? " + lista.isEmpty());
        lista.printList();
        
    }
}

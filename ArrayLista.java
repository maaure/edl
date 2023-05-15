import java.util.Arrays;


//Java, eu te JURO que eu sei o que tô fazendo com meus tipos. TE JURO. Confie em mim.
@SuppressWarnings("unchecked")
public class ArrayLista<T> implements Lista<T> {
    
    private Position<T>[] data;
    private Integer size;

    public ArrayLista() {
        this.data = new Position[0];
        size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return data.length == 0;
    }

    @Override
    public T first() {
        return data[0].getValue();
    }

    @Override
    public T last() {
        return data[size - 1].getValue();
    }

    @Override
    public T before(Integer i) {
        if(i <= 0 || i >= size)
            throw new ArrayIndexOutOfBoundsException();

        return data[i - 1].getValue();
    }

    @Override
    public T after(Integer i) {
        if(i < 0 || i >= size - 1)
            throw new ArrayIndexOutOfBoundsException();

        return data[i + 1].getValue();
    }

    @Override
    public void replaceElement(Position<T> n, T data) {
        n.setValue(data);
    }

    @Override
    public void swapElements(Position<T> n, Position<T> q) {
        T temp = q.getValue();
        q.setValue(n.getValue());
        n.setValue(temp);
    }

    @Override
    public void insertBefore(Position<T> n, T data) {
        int index = findIndex(n);
        Position<T> newPosition = new Position<T>(data);

        insertElementAt(newPosition, index);
    }

    @Override
    public void insertAfter(Position<T> n, T data) {
        int index = findIndex(n);
        Position<T> newPosition = new Position<T>(data);

        insertElementAt(newPosition, index + 1);
    }

    @Override
    public void insertFirst(T o) {
        Position<T> newPosition = new Position<T>(o);
        Position<T>[] newData = new Position[size + 1];

        newData[0] = newPosition;
        for(int i = 0; i < size; i++) {
            newData[i + 1] = data[i];
        }

        data = newData;
        size++;
    }

    @Override
    public void insertLast(T o) {
        Position<T> newPosition = new Position<T>(o);
        Position<T>[] newData = new Position[size + 1];

        newData[size] = newPosition;
        for(int i = 0; i < size; i++) {
            newData[i] = data[i];
        }

        data = newData;
        size++;
    }

    @Override
    public T remove(Position<T> n) {
        int k = findIndex(n);

        if(size == 0) {
            throw new RuntimeException("A lista ja esta vazia");
        }

        Position<T>[] newData = new Position[size - 1];
        
        for(int i = 0; i < k; i++) {
            newData[i] = data[i];
        }

        for(int i = k + 1; i < data.length; i++) {
            newData[i - 1] = data[i];
        }

        data = newData;
        size--;
    
        return n.getValue();
    }


    /**
     * Meus métodos auxiliares para os outro métodos.
     */
    
    private int findIndex(Position<T> n) {
        for(int i = 0; i < size; i++) {
            if(data[i].equals(n))
                return i;
        }
        return -1;
    }

    private void insertElementAt(Position<T> n, int index) {
        /* Metodo de preguiçoso, você poderia iterar o array uma única vez e ja realizar a inserção. Isso aqui deve ser O(só deus sabe) */
        Position<T>[] firstPart = Arrays.copyOfRange(data, 0, index);
        Position<T>[] secondPart = Arrays.copyOfRange(data, index, size);
        Position<T>[] newData = new Position[size + 1];


        int i = 0;
        for(; i < firstPart.length; i++)
            newData[i] = firstPart[i];

        newData[i++] = n;
        
        for(int k = 0; i < newData.length; i++)
            newData[i] = secondPart[k++];
        
        this.data = newData;
        size++;
    
    }

    /**
     * Métodos de visualização
     */

    public void printList() {
        for(int i = 0; i < size; i++) {
            System.out.print(data[i].getValue() + " ");
        }
        System.out.println();
    }


    /**
     * Métodos "extras"
     */

    public Position<T> getPosition(Integer n) {
        if(n < 0 || n >= size)
            throw new RuntimeException("Essa posição não existe na lista D:");
        return data[n];    
    }
}

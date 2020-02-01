package ImplementDataStructure;

public class MyArrayList<T> {

    private static final int INITIAL_CAPACITY = 5;

    private int size ;

    private Object[] data ;

    private int index ;

    public MyArrayList(){
        this.data = new Object[INITIAL_CAPACITY];
        this.size = INITIAL_CAPACITY;
    }

    //add // remove //get
    public void add(T element)
    {
        if(this.index == this.size - 1)
        {
            resizeArray();
        }
        else
        {
            this.data[index] = element;
            index++;
        }
    }

    public Object get(int index) throws Exception {
        if(index >= this.size)
        {
            throw new IndexOutOfBoundsException();
        }
        else if(index < 0)
        {
            throw new Exception("Negative indexes not allowed");
        }
        return this.data[index];
    }

    public void remove(int index) throws Exception
    {
        if(index >= this.size)
        {
            throw new IndexOutOfBoundsException();
        }
        else if(index < 0)
        {
            throw new Exception("Negative indexes not allowed");
        }
        for(int i = index ; i+1<this.size ; i++)
        {
            this.data[i] = this.data[i+1];
        }
    }

    private void resizeArray()
    {
        Object [] array = new Object[this.size + INITIAL_CAPACITY];
        if (this.size >= 0) {
            System.arraycopy(this.data, 0, array, 0, this.size);
        }
        this.data = array;
    }

}

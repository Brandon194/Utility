package misc;

import java.util.NoSuchElementException;

/**
 * Created by Brandon194 on 10/21/2014.
 */
public class List {
    /** The array itself */
    Object array[];
    /** The length of the array */
    public static int length;

    /** Constructor */
    public List(){
        array = new Object[0];
        length = 0;
    }

    /** Constructor
     *
     * @param numOfElements Number of Elements in the array
     */
    public List(Class classIn, int numOfElements){
        length = numOfElements;
        array = new Object[length];
    }

    /**
     * Add an element to the next available slot in the array
     * @param e Object to put in the array
     */
    public void add(Object e){
        Object temp[] = array;
        array = new Object[length+1];

        for (int i=0;i<length-1;i++)
            array[i] = temp[i];

        length++;
    }

    /**
     * Remove element passed to the array
     * @param e element to be removed
     * @throws NoSuchElementException
     */
    public void remove(Object e) throws NoSuchElementException{
        boolean worked = false;

        for(int i=0;i<length-1;i++){
            if (array[i] == e){
                array[i] = null;
                worked = true;
            }
        }

        if (worked) elementRemoved();
        else throw new NoSuchElementException();

    }

    /**
     * remove index specified
     * @param index index to be removed.
     * @throws ArrayIndexOutOfBoundsException
     */
    public void remove(int index) throws ArrayIndexOutOfBoundsException{
        if (index>length+1) throw new ArrayIndexOutOfBoundsException("No such index: " + index);
        array[index] = null;
        elementRemoved();
    }

    /**
     * Set a specific element as another Object
     * @param e new Object
     * @param index Index placement for that object
     * @throws ArrayIndexOutOfBoundsException
     */
    public void setElement(Object e, int index) throws  ArrayIndexOutOfBoundsException{
        if (index>length+1) throw new ArrayIndexOutOfBoundsException("No such index: " + index);
        array[index] = e;
    }

    /**
     * Set a specific element as another Object
     * @param e new Object
     * @param index Index placement for that object
     * @throws ArrayIndexOutOfBoundsException
     */
    public void set(Object e, int index) throws  ArrayIndexOutOfBoundsException{
        if (index>length+1) throw new ArrayIndexOutOfBoundsException("No such index: " + index);
        array[index] = e;
    }

    /**
     * Set the array as another array
     * @param e new Object
     * @throws ArrayIndexOutOfBoundsException
     */
    public void set(Object e[]){
        array = e;
        length = e.length;
    }

    /**
     *
     * @return the array
     */
    public Object[] get(){
        return array;
    }

    /**
     * get a specific element out ot the array
     * @param index index of the element
     * @return the element at index specified
     * @throws ArrayIndexOutOfBoundsException
     */
    public Object getElement(int index) throws ArrayIndexOutOfBoundsException{
        if (index>length+1) throw new ArrayIndexOutOfBoundsException("No such index: " + index);
        return array[index];
    }

    /**
     * get a specific element out ot the array
     * @param index index of the element
     * @return the element at index specified
     * @throws ArrayIndexOutOfBoundsException
     */
    public Object get(int index) throws ArrayIndexOutOfBoundsException{
        if (index>length+1) throw new ArrayIndexOutOfBoundsException("No such index: " + index);
        return array[index];
    }

    /**
     * shortens the array when an element has been removed so that the array is only as long as it needs to be.
     */
    private void elementRemoved(){
        int count = 0;
        for (int i=0;i<array.length;i++){
            if (array[i] == null) count++;
        }
        Object temp[] = array;
        array = new Object[length-count];
        count = 0;

        for(int i=0;i<array.length;i++){
            if (temp[i+count] == null) count++;
            else array[i] = temp[i + count];
        }
    }
}

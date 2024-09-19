package utils;
// Create a class called ArrayList (CapWords for class names)
public class ArrayList {
    // Create attributes for class
    // Every ArrayList will contain its own array of numbers
    private int [] data;
    // Every ArrayList will contain its own count of elements
    private int count;

    // Create a constructor (equivalent to __init__) to set up each new ArrayList

    /**
     * Default constructor for ArrayList.
     *
     * This will initialise the internal array to a size of 10. Subsequent increases are made by the grow() method.
     */
    public ArrayList(){
        // Set the initial array size to 10
        data = new int[10];
        // Set the number of elements in the list to 0
        count = 0;
    }

    /**
     * Add a new element to the list.
     *
     * Where there is insufficient space remaining in the internal array, the array size will be increased using the
     * grow() method.
     *
     * @param num The value to be added.
     * @return True. (There is no situation where this will not add)
     */
    public boolean add(int num){
        if(data.length == count){
            grow();
        }
        // Add the new element to the end of the list (first available space in the array)
        data[count] = num;
        // Increase the number of elements in the list
        count++;
        // Return true as the element has been added successfully
        return true;
    }

    /**
     * Get the element at the specified position.
     * @param index The position from which to retrieve the element.
     * @return The element at the specified position.
     * @throws IndexOutOfBoundsException Where the supplied position is outside the bounds of the data in the array.
     */
    public int get(int index){
        // Check if the position is valid, i.e. not AFTER the end of the list or BEFORE the start
        if(index >= count || index < 0){
            // If it's outside the bounds of the list, throw an exception
            throw new IndexOutOfBoundsException("Position supplied must be between 0 and size of list.");
        }
        // If the requested position is valid, return the data at that position
        return data[index];
    }

    /**
     * Get the number of elements currently stored in the list.
     * @return The number of elements present in the list.
     */
    public int size(){
        // Return the number of elements in the list
        return count;
    }

    /**
     * Increase the size of the internal array. This will increase the size of the internal array by 15 slots each
     * time it is called.
     */
    public void grow(){
        int [] enlargedArray = new int[data.length+15];

        for (int i = 0; i < data.length; i++) {
            enlargedArray[i] = data[i];
        }

        data = enlargedArray;
    }
}

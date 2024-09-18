package utils;
// Create a class called ArrayList (CapWords for class names)
public class ArrayList {
    // Create attributes for class
    // Every ArrayList will contain its own array of numbers
    private int [] data;
    // Every ArrayList will contain its own count of elements
    private int numElements;

    // Create a constructor (equivalent to __init__) to set up each new ArrayList
    public ArrayList(){
        // Set the initial array size to 10
        data = new int[10];
        // Set the number of elements in the list to 0
        numElements = 0;
    }

    // Create a method to add a new element to the list
    // This method takes in a number to be added and returns a boolean
    public boolean add(int num){
        // todo: Add logic for guard condition - grow array where no space is left
        // Add the new element to the end of the list (first available space in the array)
        data[numElements] = num;
        // Increase the number of elements in the list
        numElements++;
        // Return true as the element has been added successfully
        return true;
    }

    // Create a method to get an element from a specific position
    public int get(int index){
        // Check if the position is valid, i.e. not AFTER the end of the list or BEFORE the start
        if(index > numElements || index < 0){
            // If it's outside the bounds of the list, throw an exception
            throw new IndexOutOfBoundsException("Position supplied must be between 0 and size of list.");
        }
        // If the requested position is valid, return the data at that position
        return data[index];
    }

    // Create a method to get the size of the list
    public int size(){
        // Return the number of elements in the list
        return numElements;
    }

    // todo: Add method to grow the internal array by 10 spaces.
}

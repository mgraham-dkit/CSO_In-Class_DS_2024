package utils;

public class ArrayList {
    private int [] data;
    private int count;

    public ArrayList(){
        data = new int[10];
        count = 0;
    }

    public boolean add(int num){
        // todo: Add logic for guard condition - grow array where no space is left
        data[count] = num;
        count++;
        return true;
    }

    public int get(int index){
        if(index > count || index < 0){
            throw new ArrayIndexOutOfBoundsException("Position supplied must be between 0 and size of list.");
        }
        return data[index];
    }

    public int size(){
        return count;
    }

    // todo: Add method to grow the internal array by 10 spaces.
}

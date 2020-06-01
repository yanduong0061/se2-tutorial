package tut07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A class of bags whose entries are stored in a fixed-size array.
 */
public final class ArrayBag<T extends Comparable<? super T>> implements BagInterface<T> {
    //STEP 1: DETERMINES THE DATA FIELDS   
    /**
    * TO-DO: Declares the necessary attributes
    * bag: [T]
    * numberOfEntries: int
    * DEFAULT_CAPACITY: int (30)
    * MAX_CAPACITY: int (3000)
    */
    final T[] bags;
    private int numberOfElements;
    private static final int DEFAULT_CAPACITY = 30;
    private static final int MAX_CAPACITY = 3000;
    //STEP 2: IMPLEMENTS THE CONSTRUCTORS
    /**
     * TO-DO: Creates an empty bag whose initial capacity is 30.
     */
    public ArrayBag() {
    	this(DEFAULT_CAPACITY);
    } 

    /**
     * TO-DO: Creates an empty bag having a given capacity.
     *
     * @param desiredCapacity The integer capacity desired.
     */
    @SuppressWarnings("unchecked")
	public ArrayBag(int desiredCapacity) {
    	if(desiredCapacity <= MAX_CAPACITY) {  		
    		  bags = (T[]) new Comparable[desiredCapacity];
    		  numberOfElements = 0;
    	} else {
    	throw new IllegalStateException("Bags can not be created!");
    	}

    }

    //STEP 3: IMPLEMENTS THE FUNCTIONS
    /**
     * TO-DO: Adds a new entry to this bag.
     *
     * @param newEntry The object to be added as a new entry.
     * @return True if the addition is successful, or false if not.
     */
    public boolean add(T newEntry) {
		
		if(!isArrayFull()) {
		bags[numberOfElements]  = newEntry;
		numberOfElements++;
			return true;
		} else {
			return false;
		}
   
    } 

    /**
     * TO-DO: Retrieves all entries that are in this bag.
     *
     * @return A newly allocated array of all the entries in this bag.
     */
    public T[] toArray() {
		return Arrays.copyOf(bags, numberOfElements);
    } 

    /**
     * TO-DO: Sees whether this bag is empty.
     *
     * @return True if this bag is empty, or false if not.
     */
    public boolean isEmpty() {
		return numberOfElements == 0;

    } 

    /**
     * TO-DO: Gets the current number of entries in this bag.
     *
     * @return The integer number of entries currently in this bag.
     */
    public int getCurrentSize() {
		return numberOfElements;

    } 

    /**
     * TO-DO: Counts the number of times a given entry appears in this bag.
     *
     * @param anEntry The entry to be counted.
     * @return The number of times anEntry appears in this bag.
     */
    public int getFrequencyOf(T anEntry) {
    	int count = 0;
    	if(!contains(anEntry))
    		return -1;
    	else {
	for(T t : bags) {
		if(t == anEntry)
			count++;
	}
    	}
return count;
    } 

    /**
     * TO-DO: Tests whether this bag contains a given entry.
     *
     * @param anEntry The entry to locate.
     * @return True if this bag contains anEntry, or false otherwise.
     */
    public boolean contains(T anEntry) {
		for(T t: bags) {
			if(t == anEntry)
				return true;
		} 
		return false;

    } 

    /**
     * TO-DO: Removes all entries from this bag.
     */
    public void clear() {
    	if(isEmpty()) {
    		System.err.println("Array is empty!");
    	} else {
    		List<T> list = new ArrayList<>(Arrays.asList(bags));
    		list.clear();
    	}

    } 

    /**
     * TO-DO: Removes one unspecified entry from this bag, if possible.
     *
     * @return Either the removed entry, if the removal was successful, or null.
     */
    public T remove() {
		if(isEmpty()) {
			System.err.println("Collection is empty!");
			return null;
		}	
		 else {
			 return bags[--numberOfElements];
		 }	
    } 

    /**
     * TO-DO: Removes one occurrence of a given entry from this bag.
     *
     * @param anEntry The entry to be removed.
     * @return True if the removal was successful, or false if not.
     */
    public boolean remove(T anEntry) {
		if(isEmpty()) {
			System.err.println("Array is empty!");
			return false;
		} else {
			/*
			 * List<T> list = new ArrayList<>(Arrays.asList(bags)); return
			 * list.remove(anEntry);
			 */
			for(int i = 0; i < bags.length; i++) {
				if(bags[i] == anEntry) {
				for(int k = i; k < bags.length - 1; k++) {
					bags[k] = bags[k + 1];
				}
				break;
				}
			}
			return true;
		}

    } 

    // TO-DO: Returns true if the array bag is full, or false if not.
    public boolean isArrayFull() {
		return numberOfElements == bags.length - 1;

    }  

    // TO-DO: Locates a given entry within the array bag.
    // Returns the index of the entry, if located,
    // or -1 otherwise.
    // Precondition: checkInitialization has been called.
    
    public int getIndexOf(T anEntry) {
    	int founded = 0;
		if(!contains(anEntry)) {
			return -1;
		} else {
			for(int i = 0; i < bags.length; i++) {
				if(bags[i] == anEntry)
					founded = i;
			}
		}
		return founded;

    } 

    // TO-DO: Removes and returns the entry at a given index within the array.
    // If no such entry exists, returns null.
    // Precondition: 0 <= givenIndex < numberOfEntries.
    // Precondition: checkInitialization has been called.
	public T removeEntry(int givenIndex) {
		int index = 0;
		T t = null;
		if(!contains(bags[givenIndex])) {
			System.err.println("The index is not existed!");
			return null;
		} else {
			for(int i = 0; i < bags.length; i++) {
				if(bags[i] == bags[givenIndex]) {
					index = i;
					t = bags[index];
					for(int k = i; k < bags.length - 1; k++) {
						bags[k] = bags[k + 1];
						
					}
					numberOfElements--;
					break;
				}
				
			}
			return t;
		}
		/*
		 * List<T> list = new ArrayList<>(Arrays.asList(bags)); return
		 * list.remove(givenIndex);
		 */

    } 

} 



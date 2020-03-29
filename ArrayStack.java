import java.util.Arrays; 

public class ArrayStack<T> implements Stack<T>
{
	private T[] data; //Private variable called data is an array of any template
	private int top; //Private integer variable called top to keep track of the last pushed item
	private static final int CAPACITY = 10; //Private final variable for the initital capacity of the array stack

	public ArrayStack() //Constructor 1 
	{
		this(CAPACITY);
	}

	public ArrayStack(int capacity) //Constructor 2 - takes a parameter of type int which will initiliase an array of length capacity
	{
		T[] temp = (T[]) new Object[capacity];
		data = temp;  
		this.top = 0; 
	}

	//Overridden Constructor 

	public void push(T item) //Adds an item to the top of the stack 
	{
		resizeArray(); //If array is too small then increase the capacity of the array
		data[top] = item; //Adds element to the array stack
		top++; //Increase count of array
	}

	public T pop() throws Exception //Removes an item from the stack
	{
		if (empty())
		{
			throw new Exception("Cannot pop from empty stack."); 
		}

		T temp = data[top-1]; //Delete item which is the last pushed item 
		top--; //Decrease count 
		return temp; //Return the deleted item 
	}

	public T peek() throws Exception //Returns a copy of the last pushed item
	{
		if(empty())
		{
			throw new Exception("Cannot peek from empty stack."); 
		}

		return data[top - 1]; //Copy of last pushed item is returned
	}

	public boolean empty() //Checks if the stack is empty 
	{
		return top == 0; //When stack is empty, top is equal to 0 
	}

	public void resizeArray() //Resizes the array if the last pushed item is equal to the length of the array
	{
		if (top == data.length) 
		{
			T[] temp = (T[]) new Object[2 * data.length]; //Doubles the size of the array
			for(int i = 0; i < data.length; i++)
			{
				temp[i] = data[i]; 
			}

			data = temp; 
		}

		
	}
}
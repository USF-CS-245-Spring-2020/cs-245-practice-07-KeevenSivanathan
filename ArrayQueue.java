import java.util.Arrays; 

public class ArrayQueue<T> implements Queue<T>
{
	private T[] data; //Private variable called data is an array of any template
	private int front; //Private variable called front to keep track of the start of the queue
	private int rear; //Private variable called rear to keep track of the end of the queue
	private int size; //Private variable to keep track of the size of the array


	public ArrayQueue() //Constructor - initialises an array of template type with length 10
	{
		data = (T[]) new Object[10];  
	}

	public T dequeue() throws Exception //Removes an item from the front of the queue 
	{
		if(size == 0)
		{
			throw new Exception("Cannot dequeue an empty queue.");
		}

		T temp = data[front]; //Temp variable made to equal the front of the queue
		data[front] = null; //Front of queue is set to null 
		if(++front == data.length) 
		{
			front = 0; 
		}

		if(--size > 0 && size == data.length / 4) //Resize the queue to fit the current number of elements in queue
		{
			resizeArray(data.length/2); 
		}

		return temp; //Returns the deleted item
	}

	public void enqueue(T item) //Adds an item to the back of the queue
	{
		if(data.length == size) //If queue is too small
		{
			resizeArray(data.length*2); //Increase capacity by 2
		}

		data[rear++] = item; //Add item to end of queue
		if(rear == data.length) 
		{
			rear = 0; 
		}

		size++; //Increase count of size
 
	}

	public boolean empty() //Checks if the queue is empty
	{
		boolean isEmpty = false; 
		if(size == 0) //If size is 0 
		{
			isEmpty = true; //Then queue is empty 
		}

		return isEmpty;
	}

	public void resizeArray(int capacity) //Increases the capacity of the queue if there is not enough space
	{
		T[] temp = (T[]) new Object[capacity]; 

		for(int i = 0; i < size; i++)
		{
			temp[i] = data[(front + i) % data.length]; 
		}

		data = temp; 
		front = 0; 
		rear = size; 
	}
}

import java.util.ArrayList;

public class SimpleDeque<T> implements DequeInterface<T>
{
 private T [] data; 
 private int back;  // index of logical back item in deque
 private int size;

 public SimpleDeque(int initsize)
 {
  // Note how array is created and cast to T.
  data = (T []) new Object[initsize];
  // Back is initialized to -1 for special case when deqeue
  // is empty.  Be careful about this special case for both
  // adding and removing.
  back = -1;
  size = 0;
 }

 public String toString()
 {
  
  ArrayList str = new ArrayList();

  if (size > 0)
  {
   for (int i = 0; i < size; i++)
   {
    str.add(data[i]);
    
   }
   return str.toString();
  }
  else return new String("Deque is Empty");
  
  // Make and return single String from data stored
  // in Deque.  Proceed from front to back.
  
//  StringBuilder str = new StringBuilder();
//
//  if (size > 0)
//  {
//   for (int i = 0; i < size; i++)
//   {
//    str.append(data[i]);
//    
//   }
//   return str.toString();
//  }
//  else return new String("Deque is Empty");
 } 

 public void addToFront(T newEntry)
 {
  // Add to front, shifting data to make room.
  // If array is full, print out a message and do not
  // add the entry.

  if (size == data.length)
  {
   System.out.println("No room, " + newEntry + " not added");
  }

  else if (size == 0) 
  {
   data[0] = newEntry;
   size++;
   back++;
  }

  else {
   for (int i = back; i >= 0; i--)
   {
    data[i+1] = data[i];
   }
   data[0] = newEntry;
   size++;
   back++;
  }
 }

 public void addToBack(T newEntry)
 {
  // Add to back -- no shifting is required.
  // If array is full, print out a message and do not
  // add the entry.

  if (size == data.length)
  {
   System.out.println("No room, " + newEntry + " not added");
  }
  
  else
  {
   data[back + 1] = newEntry;
   size++;
   back++;
  }
 }


 public T removeBack()
 {
  // remove and return the item at the back of the deque
  // If deque is empty, return null

  if (size == 0)
   return null;
  else 
  {
   T backItem = data[back];
   data[back] = null;
   size--;
   back--;
   return backItem;
  } 
 }

 public T getBack()
 {
  // return item at the back of the deque without disturbing
  // it.  If dequeu is empty, return null
  if (size == 0)
   return null;
  else
   return data[back];
 }

 public T removeFront()
 {
  // remove and return the item at the front of the deque
  // If deque is empty, return null.  You will need to shift
  // the remaining items over in order to keep the front at
  // index 0  

  if (size == 0)
   return null;

  else {
   T frontItem = data[0];
   data[0] = null;
   for (int i = 0; i < back; i++)
   {
    data[i] = data[i+1];
   }
   size--;
   back--;
   return frontItem;
  }

 }

 public T getFront()
 {
  // return the item at the front of the deque with disturbing
  // it.  If deque is empty, return null
  if (size == 0)
   return null;
  else
   return data[0];
 }  

 public boolean isEmpty()
 {
  return size == 0;
 }

 public void clear()
 {
  // reset deque to be empty and allow old objects to be
  // garbage collected.
  data = (T[]) new Object[data.length];
  size = 0;
 }

}
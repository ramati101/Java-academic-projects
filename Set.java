/**
 *  the class Set represent a group of odd natural numbers. 
 */
public class Set
{
    private IntNode _head ;
    private int _count;
    /**
     *  set constructor - build new empty linked list.
     *  time complexity - O(1)
     *  space complexity - O(1)
     */
    public Set()
    {
        _head = null ;
    }
    // methods:
    /**
     *  the method check if the linked list empty.
     *  @return true if the linked list is empty, and false if its isnt.
     *  time complexity - O(1)
     *  space complexity - O(1)
     */
    public boolean isEmpty ()
    {
        return _head == null;
    }
    /**
     * the method check if int num is exists in the liked list.
     * @return true if the int num is exists in the linked list and false if he isnt.
     * time complexity - O(n)
     * space complexity - O(n)
     */
    public boolean isMember (int num)
    {
        IntNode current = _head;
        if(current==null)
            return false;
        else
            while(current!=null) //check if we get to the end of the linked list.
            {
                if( current.getValue()==num ) // find the int we want in the linked list.
                    return true;
                else 
                    current = current.getNext();
            }
        return false;
    }
    /**
     * the method check if two linked list are equals.
     * @param Set other - the other linked list we want to compare.
     * @return true if they equals to each other, else return false.
     * time complexity - O(n)
     * space complexity - O(n)
     */
    public boolean equals (Set other)
    {
        return this.subSet(other) && other.subSet(this);  // if two groups are subSet one to anther so they equals.
    }
    /**
     * the method return the length of the linkes list.
     * @return int that represnet the length.
     * time complexity - O(1)
     * space complexity - O(1)
     */
    public int numOfElements ()
    {
        return this._count; 
    }
    /**
     * the method check if the Set other is Sub-Set of This set.
     * @param Set other - the set we want to check if he's in this set.
     * @return true if Set other is Sub-Set of this set, else return false.
     * time complexity - O(n)
     * space complexity - O(n)
     */
    public boolean subSet (Set other)
    {
        if(other==null)
            return false;
        IntNode ptr1 = _head;
        IntNode ptr2 = other._head;
        if( other._count>this._count ) // if the other group is bigger than the first so he cant be subSet to her.
            return false;
        if( ptr1==null && ptr2==null ) // if two groups are empty they subSet one to anther.
            return true;
        while( ptr2!=null && ptr1!=null ) // run to the and of one of the groups.
        {
            if( ptr2.getValue()==ptr1.getValue() ) // if we found a int who exist in the first group we pass to the next int we want to find from the start of the first group.
            {
                ptr2 = ptr2.getNext(); 
                ptr1 = this._head;
            }
            else 
                ptr1 = ptr1.getNext();
        }
        if( ptr1==null ) // if the loop stop because it get to the end of the first group, its because it didnt find one of the object from the other group in the first group.
            return false;
        return true;
    }
    /**
     * the method add int to the Set linked list. if he is bigger than 0, odd number and not in the linked list already.
     * @param int x - the int we want to add to the Set.
     * time complexity - O(n)
     * space complexity - O(1)
     */
    public void addToSet (int x)
    {
        if( x>0 && (x%2)==1 && !(this.isMember(x)) ) // check if the number is positive and odd-number and didnt exists in the group already.
        {
            IntNode newIntNode = (this.isEmpty())?  new IntNode(x, null) : new IntNode(x, _head); // if the group is empty so it become the first and only object in it.
            _head = newIntNode;
            _count++;
        }
    }
    /**
     * the method remove a IntNode with the value x from the Set linked list.
     * @param int x - the value of the IntNode we want to remove.
     * time complexity - O(n)
     * space complexity - O(n)
     */
    public void removeFromSet (int x)
    {
        if( x>0 && (x%2)==1 && (this.isMember(x)) && !(this.isEmpty()) ) // check if the number is positive and odd-number and exist in the group and if the group not empty. 
        {
            IntNode current = _head, prev = null;
            while (current!= null) // run to the end of the group.
            {
                if (current.getValue() == x) // if you find the int in the group.
                {
                    if (prev==null)  // check if the int we want to remove is the first object.
                    {    
                        _head=current.getNext(); 
                        _count--;
                    }
                    else  // else make the previus object point on the next object.
                        prev.setNext(current.getNext()); _count--;
                    break;
                }
                prev = current;
                current =current.getNext();
            }
        }
    }
    /**
     * the method return String with all the values on the set linked list.
     * @return String - with all the values.
     * time complexity - O(n)
     * space complexity - O(n)
     */
    public String toString()
    {
        String setStr = new String("");
        IntNode current = _head;
        if( current==null )
            return "{}";
        if( current!= null )
            setStr += "{"+current.getValue(); current = current.getNext();
        while ( (current != null) ) // run to the end of the group.
        {
            setStr += ","+current.getValue();
            current = current.getNext();
        }
        setStr += "}";
        return setStr;
    }
    /**
     * the method return Set linked list that represnt the intersection between to Sets linked lists.
     * @param Set other - the other Set we want to check the intersection with.
     * @return Set that contain all the values the common between to Sets.
     * time complexity - O(n^2)
     * space complexity - O(n)
     */
    public Set intersection (Set other)
    {
        if(other==null)
            return null;
        Set interSet = new Set();
        IntNode current = _head;
        while( current!=null ) // run to the end of the group.
        {
            if( other.isMember(current.getValue()) ) // check if the object is exists in the group already.
                interSet.addToSet( current.getValue() );
            current = current.getNext();
        }
        return interSet;
    }
    /**
     * the method return Set linked list that represnt the union between to Sets linked lists.
     * @param Set other - the other Set we want to check the union with.
     * @return Set that contain all the values in two Sets.
     * time complexity - O(n^2)
     * space complexity - O(n)
     */
    public Set union (Set other)
    {
        if(other==null)
            return null;
        Set uniSet = new Set();
        IntNode ptr1 = _head;
        IntNode ptr2 = other._head;
        while( ptr1!=null ) // run to the end of the group.
        {    
            uniSet.addToSet(ptr1.getValue()); 
            ptr1=ptr1.getNext();
        }
        while( ptr2!=null ) // run to the end of the group.
        {    
            uniSet.addToSet(ptr2.getValue());
            ptr2=ptr2.getNext();
        }
        return uniSet;
    }
    /**
     * the method return Set linked list that contain all the ints that in this Set and not in the other Set.
     * @param Set other - the other Set we want to check the if the int exists in.
     * @return Set that contain the values in this Set and not in the other.
     * time complexity - O(n^2)
     * space complexity - O(n)
     */
    public Set difference (Set other)
    {
        if(other==null)
            return null;        
        Set difSet = new Set();
        IntNode current = _head;
        while( current!=null )
        {    
           if( !other.isMember(current.getValue()) ) // check if the object is exists in the group already.
               difSet.addToSet(current.getValue());
           current = current.getNext();  
        }        
        return difSet;
    }
    }
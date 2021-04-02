import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MessageStack
{
    private LinkedList<Message> elements;
    private int count;
    public MessageStack()
    {
        elements = new LinkedList<>();
        count = 0;
    }
    public void push(Message m)
    {
        if(m == null)
            throw new NullPointerException();
        elements.addFirst(m);
        count++;
    }
    public void push(LinkedList<Message> list)
    {
        if(list==null)
            throw new NullPointerException();
        for (Message message: list)
            push(message);
    }
    public Message pop()
    {
        if(elements.isEmpty())
            throw new NoSuchElementException();
        count--;
        return elements.removeFirst();
    }
    public LinkedList<Message> pop(int n)
    {
        if(isEmpty())
            throw new NoSuchElementException();
        LinkedList<Message> list = new LinkedList<>();
        for (int i = 0; i < n && !isEmpty(); i++)
            list.addFirst(pop());
        return list;
    }
    public boolean isEmpty()
    {
        return elements.isEmpty();
    }

    public int size()
    {
        return count;
    }

}

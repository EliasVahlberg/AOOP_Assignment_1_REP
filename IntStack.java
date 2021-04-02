/**
 * @author Elias Vahlberg & $ Hamed Haghjo on 2021-03-24
 */
import java.util.LinkedList;

public class IntStack
{
    private int length;
    private LinkedList<Integer> elements;

    public IntStack(LinkedList<Integer> elements)
    {
        this.elements = elements;
        length = elements.size();
    }

    public IntStack()
    {
        elements = new LinkedList<>();
        length = 0;
    }
    public void push(int element)
    {
        elements.addFirst(element);
        length++;
    }
    public void push(LinkedList<Integer> l)
    {
        if(l==null)
            throw new NullPointerException();
        for (int i = 0; i<l.size(); i++)
            push(l.get(i));
    }
    public int pop()
    {
        int element = elements.removeFirst();
        length--;
        return element;
    }
    public LinkedList<Integer> pop(int n)
    {
        LinkedList<Integer> l = new LinkedList<>();
        for (int i = 0; i < n&&!isEmpty(); i++)
            l.addFirst(pop());
        return l;
    }

    public int getLength()
    {
        return length;
    }
    public boolean isEmpty()
    {
        return elements.isEmpty();
    }
}

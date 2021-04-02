import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class IntStackTest
{
    private LinkedList<Integer> nulllist = null;
    private LinkedList<Integer> list1;
    private LinkedList<Integer> list1rev;
    private IntStack s0;
    private IntStack s1;
    private IntStack sn;
    private static int n = 100;
    @BeforeEach
    void setUp()
    {
        s0 = new IntStack();
        s1 = new IntStack();
        sn = new IntStack();
        s1.push(1);
        list1 = new LinkedList<>();
        list1rev = new LinkedList<>();
        for (int i = 0; i < n; i++)
        {
            sn.push(i);
            list1.addFirst(i);
            list1rev.addFirst(n-i-1);
        }
    }

    @AfterEach
    void tearDown()
    {
        s0 = null;
        s1 = null;
        sn = null;
    }

    @Test
    void testPush()
    {
        try{
            s0.push(list1);
            assertEquals(n,s0.getLength());
            for (int i = 0; !s0.isEmpty(); i++)
                assertEquals(i,s0.pop());
            try
            {
                s0.push(nulllist);
                fail("Exception not caught");
            }catch (NullPointerException ne)
            {

            }

        }catch (Exception e)
        {
            e.printStackTrace();
            fail("Unexpected Exception caught fail");
        }
    }

    @Test
    void tetsPop()
    {
        try
        {
            assertTrue(s0.pop(n).isEmpty());
            assertEquals(n,sn.getLength());
            LinkedList<Integer> ln = sn.pop(n);
            assertEquals(0,sn.getLength());
            assertEquals(ln.size(), n);
            while(!ln.isEmpty()&&!list1rev.isEmpty())
                assertEquals(list1rev.removeFirst(),ln.removeFirst());


            if(!ln.isEmpty()||!list1rev.isEmpty())
                fail("Not acccurate number of elements in stack");

        }catch (Exception e)
        {
            e.printStackTrace();
            fail("Unexpected Exception caught fail");
        }
    }
}
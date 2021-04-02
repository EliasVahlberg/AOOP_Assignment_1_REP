/**
 * @author Elias Vahlberg & $ Hamed Haghjo on 2021-03-25
 */
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MessageQueueTest
{
    MessageQueue q0;
    MessageQueue q1;
    MessageQueue qn;
    private int n =100;

    @BeforeEach
    void setUp()
    {
        q0 = new MessageQueue(n);
        q1 = new MessageQueue(n);
        qn = new MessageQueue(n);
        q1.add(new Message("1"));
        for (int i = 0; i < n; i++)
        {
            qn.add(new Message(Integer.toString(i)));
        }
    }

    @AfterEach
    void tearDown()
    {
        q0 = null;
        q1 = null;
        qn = null;
    }

    @Test
    void testConstructor()
    {
        try
        {
            try{
                MessageQueue mq = new MessageQueue(0);
                fail("No Exception");
            }catch (IllegalArgumentException iae)
            {

            }
        } catch (Exception e)
        {
            fail("Unexpected Exception");
        }

    }
    @Test
    void testRemove()
    {
        try
        {
            try
            {
                q0.remove();
                fail();
            } catch (NoSuchElementException nee)
            {
            }
            assertEquals("1", q1.remove().toString());
            for (int i = 0; i < n; i++)
                assertEquals(qn.remove().toString(),Integer.toString(i));


        } catch (Exception e)
        {
            e.printStackTrace();
            fail("Unexpected Exception");
        }
    }

    @Test
    void testAdd()
    {
        try
        {
            assertFalse(q0.isFull());
            assertFalse(q1.isFull());
            assertTrue(qn.isFull());
            assertEquals(n,qn.size());
            qn.add(new Message("100"));
            assertEquals(n+1,qn.size());
            for (int i = n+1; i < n*10; i++)
            {
                qn.add(new Message(Integer.toString(i)));
            }
        } catch (Exception e)
        {
            e.printStackTrace();
            fail("Unexpected Exception");
        }
    }
}
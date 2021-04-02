/**
 * @author Elias Vahlberg & $ Hamed Haghjo on 2021-03-29
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Optional;
public class Exercise406
{
    public static String maximum(ArrayList<String> a, Comparator<String> c)
    {
        Optional<String> max = a.stream().max(c);
        if(max.isEmpty())
            throw new NoSuchElementException();
        else return max.get();
    }
}

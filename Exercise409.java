/**
 * @author Elias Vahlberg & $ Hamed Haghjo on 2021-03-29
 */

public class Exercise409
{

    public static String[] filter(String[] a, Filter f)
    {
        String[] strings = new String[a.length];
        int n = 0;
        for(String s : a)
            if(f.accept(s))
            {
                strings[n] = s;
                n++;
            }
        String[] shortenedArr = new String[n];
        for (int i = 0; i < n; i++)
            shortenedArr[i] = strings[i];
        return shortenedArr;
    }
}

public class Tester
{
    public static void main(String[] args)
    {
        String s = "Hello World";
        Scanner in = new Scanner(s);
        while (in.hasNext())
            System.out.println(in.next());
    }
}
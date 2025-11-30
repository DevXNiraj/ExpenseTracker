class Construct
{
 int size;
Construct(int s)
{
size = s;
}
void area()
 {
int area= size*size;
System.out.println(area);
}
public static void main (String args[])
{
Construct c = new Construct(10);
c.area ();
}
 }
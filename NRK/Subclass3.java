class Superclass
{
Superclass(int x)
{
System.out.println("parent class construct:");
}
}
class Subclass3 extends SuperClass
{
Subclass3()
{
super(10);
System.out.println("child class construct:");
}
public static void main(String[]args)
{
Subclass3 sc=new Subclass3();
}
}

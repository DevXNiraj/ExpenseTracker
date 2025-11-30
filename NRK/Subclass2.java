class Superclass
{
int x =10;
void display()
{
System.out.println("parent class variable:"+x);
}
}
class Subclass2 extends Superclass
{
int x =20;
void display()
{
super.display();
System.out.println("child class variable:"+x);
}
public static void main(String[]args)
{
Subclass2 sc=new Subclass2();
sc.display();
}
}

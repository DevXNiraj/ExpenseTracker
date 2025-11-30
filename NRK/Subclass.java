class Superclass
{
int x =10;
}
class Subclass extends Superclass
{
int x =20;
void display()
{
System.out.println("parent class variable:"+super.x);
System.out.println("child class variable:"+x);
}
public static void main(String[]args)
{
Subclass sc=new Subclass();
sc.display();
}
}

 interface Drawing
{
    int RADIUS=5;
    void Draw();
}
class Demo implements Drawing
{
    public void Draw()
{
    System.out.println("Drawing circle");
}
public static void main (String args[])
{
    System.out.println(Drawing.RADIUS);
    Demo d=new Demo();
    d.Draw();
}
}
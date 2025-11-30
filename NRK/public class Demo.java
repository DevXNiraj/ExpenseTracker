public Class Demo   
{  
   public static void main (String args[])
{
    try
{
    int a=10/0;
}
catch(arithmatic Exception )
{
    System.out.println("ae");
    System.out.println("Exception handling catch block");
}
System.out.println("Rest of the code");
}
}
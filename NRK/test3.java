class Animal{

void eat(){
System.out.println("eating");
}
}
class Dog extends Animal{
void bark(){

System.out.println("barking");
}
}
class cat extends Animal{
    void meow(){
        System.out.println("meowing");
    }
}
class test3{
    public static void main (String args[])
    {
        
        cat d=new cat();
        d.eat();
        d.meow();
    }
}





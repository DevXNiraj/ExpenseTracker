class Animal1{
    void eat(){
        System.out.println("eating");
    }

}
class Dog extends Animal1{
    void bark(){
        System.out.println("barking");
    }
}
class BabyDog extends Dog{

    void weep(){
        System.out.println("weeping");
 
    }
}
class test1{
    BabyDog d=new BabyDog();
    d.eat();
    d.bark();
    d.weep();
}
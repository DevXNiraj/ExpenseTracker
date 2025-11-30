                                                                                                                                                                                                                                         class Student {
    int rollno = 10;
    String dept = "IT";

    void show() {
        System.out.println("IT student");
    }

    public static void main(String args[]) {
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();

        s2.rollno = 45;
        s2.dept = "IT";
        s3.rollno = 13;
        s3.dept = "ENTC";

        s1.show();
        System.out.println("Roll no: "+ s1.rollno);
        System.out.println("Dept: " + s1.dept);

        s2.show();
        System.out.println("Roll no: "+ s2.rollno);
        System.out.println("Dept: " + s2.dept);

        s3.show();
        System.out.println("Roll no: "+ s3.rollno);
        System.out.println("Dept: " + s3.dept);

        s3.rollno = s2.rollno;
        s3.dept = s2.dept;
        System.out.println("Roll no: "+ s3.rollno);
        System.out.println("Dept: " + s3.dept);
    }
}
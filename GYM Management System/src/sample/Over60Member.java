package sample;

public class Over60Member extends DefaultMember{
    private int Age;

    //Adding constructor for over60member class
    public Over60Member(String MembershipNumber, String name, int age, String Date,String ContactNum) {
        super(MembershipNumber, name,Date,ContactNum);
        this.setAge(age);
        //getDate();
    }


    public int getAge() {
        return Age;
    }

    //validating age of the member
    public void setAge(int age) {
        if (age >= 60){
            this.Age = age;
        }else{
            throw new IllegalArgumentException("Invalid age");
        }
    }



}

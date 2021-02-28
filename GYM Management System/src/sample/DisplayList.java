package sample;

import javafx.beans.property.SimpleStringProperty;

public class DisplayList {
    private SimpleStringProperty MembershipNumber = new SimpleStringProperty("");
    private SimpleStringProperty Name = new SimpleStringProperty("");
    private SimpleStringProperty Date = new SimpleStringProperty("");
    private SimpleStringProperty School = new SimpleStringProperty("");
    private SimpleStringProperty Type = new SimpleStringProperty("");
    private SimpleStringProperty Age = new SimpleStringProperty("");
    private SimpleStringProperty ContactNum = new SimpleStringProperty("");


    //Adding constructor for displayList class
    public DisplayList(String membershipNumber, String name, String Date , String Type, String School,String age,String ContactNum) {
        setMembershipNumber(membershipNumber);
        setName(name);
        setDate(Date);
        setType(Type);
        setSchool(School);
        setAge(age);
        setContactNum(ContactNum);

    }

    //all the getters and setters

    public String getMembershipNumber() {
        return MembershipNumber.get();
    }
    public void setMembershipNumber(String membershipNumber) {
        MembershipNumber.set(membershipNumber);
    }

    public String getName() {
        return Name.get();
    }

    public void setName(String name){
        Name.set(name);
    }

    public String getDate() {
        return Date.get();
    }
    public void setDate(String date){
        Date.set(date);
    }


    public String getSchool() {
        return School.get();
    }

    public void setSchool(String school){
        School.set(school);
    }

    public String getType() {
        return Type.get();
    }

    public void setType(String type) {
        Type.set(type);
    }

    public String getAge() {
        return Age.get();
    }

    public void setAge(String age){
        Age.set(age);
    }

    public String getContactNum() {
        return ContactNum.get();
    }

    public void setContactNum(String contactNum){
        ContactNum.set(contactNum);
    }


}

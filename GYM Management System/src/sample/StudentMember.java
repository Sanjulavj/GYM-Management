package sample;

public class StudentMember extends DefaultMember {
    private String SchoolName;

    //Adding constructor for schoolMember class
    public StudentMember(String MembershipNumber, String studentName, String schoolName, String Date,String ContactNum) {
        super(MembershipNumber,studentName,Date,ContactNum);
        SchoolName = schoolName;
    }

    //all the getters and setters
    public String getSchoolName() {
        return SchoolName;
    }

    public void setSchoolName(String schoolName) {
        SchoolName = schoolName;
    }



}

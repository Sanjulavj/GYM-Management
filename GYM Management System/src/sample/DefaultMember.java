package sample;


public class DefaultMember {
    private String MembershipNumber;
    private String Name;
    private Date date;
    private int ContactNum;

    //Adding constructor for defaultmember class
    public DefaultMember(String membershipNumber, String name, String date, String ContactNum) {
        Name = name;
        MembershipNumber = membershipNumber;
        String[] dateArray  = date.split("/");
        int day = Integer.parseInt(dateArray[0]);
        int month = Integer.parseInt(dateArray[1]);
        int year = Integer.parseInt(dateArray[2]);
        Date newDate = new Date(day,month,year);
        this.date = newDate;
        IDCheck(membershipNumber);

        contactNumCheck(ContactNum);
    }

    //all the getters and setters

    public String getMembershipNumber() {
        return MembershipNumber;
    }

    public void setMembershipNumber(String membershipNumber) {
        MembershipNumber = membershipNumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getContactNum() { return ContactNum;
    }

    public void setContactNum(int contactNum) { ContactNum = contactNum;
    }
    //end of the all the getters and setters

    //validating membershipID
    public void IDCheck(String MembershipNumber) {
        if (MembershipNumber.length() == 5 && ('d' == MembershipNumber.charAt(0) || MembershipNumber.charAt(0) == 's' || MembershipNumber.charAt(0) == 'a')) {
            this.MembershipNumber = MembershipNumber;
        } else {
            throw new IllegalArgumentException("Invalid Member ID");
        }
    }

    //validating Contact number
    public void contactNumCheck(String ContactNum){
        if (ContactNum.length() == 10) {
            this.ContactNum = Integer.parseInt(ContactNum);
        } else {
            throw new IllegalArgumentException("Invalid contact number");
        }
    }


}


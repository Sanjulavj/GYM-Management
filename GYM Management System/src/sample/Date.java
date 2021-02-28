package sample;

public class Date {
    private int day;
    private int month;
    private int year;

    //Adding constructor for date class
    public Date(int day,int month,int year) {
        setDay(day);
        setMonth(month);
        setYear(year);
        monthCheck(month);
        dayCheck(day, month, year);
        toString();
    }

    //validating months
    public void monthCheck (int month){
        if(month >0 && month <= 12){
            this.month = month;
        }else {
            throw new IllegalArgumentException("Invalid Month");
        }

   }

    //validating days to relavant month
   public void dayCheck(int day, int month,int year) {

       if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {      //months that have 31 days
           if (day > 0 && day <= 31) {
               this.day = day;
           } else {
               throw new IllegalArgumentException("Invalid day");
           }
       } else if (month == 4 || month == 6 || month == 9 || month == 11 ) {     //months that have 30 days only
           if (day > 0 && day <= 30) {
               this.day = day;
           } else {
               throw new IllegalArgumentException("Invalid day");
           }

       }else if(month==2){      //validating february
           if(year%4==0){       //if it is leap year
               if (day > 0 && day <= 29) {
                   this.day = day;
               }else {
                   throw new IllegalArgumentException("Invalid day");
               }
           }else if(year%4!=0){     //if it is not leap year
               if (day > 0 && day <= 28) {
                   this.day = day;
               }else {
                   throw new IllegalArgumentException("Invalid day");
               }
           }
       }

   }

   //way of inputing date to the collection
    @Override
    public String toString() {
        return  getDay() + "/" + getMonth()  + "/" + getYear();
    }

    //all the getters and setters

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

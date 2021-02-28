package sample;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyGymManagerTest {
    MyGymManager myGymManager = new MyGymManager();

    //testing about wrong date input
    @Test(expected = IllegalArgumentException.class)
    public void defaultInputsDateTest() {
        myGymManager.defaultInputs("d0001","Default","Jane","35.07.2020","0773245678");
    }

    //testing about wrong contact number input
    @Test(expected = IllegalArgumentException.class)
    public void studentInputsContactNumTest() {
        myGymManager.studentInputs("s0010","Student","Kohli","Ananda","07.07.2020","07556678989");
    }

    //testing about wrong age input
    @Test(expected = IllegalArgumentException.class)
    public void over60InputsAgeTest() {
        myGymManager.over60Inputs("a0002","Over60","Kohli",35,"07.07.2020","0773245678");
    }

    //testing a delete member(if ID is not used)
    @Test
    public void dataDeletesTest() {
        myGymManager.dataDeletes("s0100");
        assertEquals("Member doesn't exist to delete","Member doesn't exist to delete");
    }

    //testing about adding a default member
    @Test
    public void defaultInputsTest() {
        myGymManager.defaultInputs("d0006","Default","Jane","09.07.2020","0773245678");
        assertEquals("Member added Successfully","Member added Successfully");
    }


    //testing about adding a student member
    @Test
    public void studentInputsTest() {
        myGymManager.studentInputs("s0005","Student","Kohli","Ananda","08.07.2020","0755667898");
        assertEquals("Member added Successfully","Member added Successfully");
    }

    //testing about adding over 60 member
    @Test
    public void over60InputsTest() {
        myGymManager.over60Inputs("a0005","Over60","Raini",65,"07.07.2020","0773245678");
        assertEquals("Member added Successfully","Member added Successfully");
    }

    //testing about print list
    @Test
    public void printListTest() {
        myGymManager.printList();
    }

    //testing about sort list
    @Test
    public void sortRecordsTest() {
        myGymManager.sortRecords();
    }

    //testing about write to text file
    @Test
    public void write_save_test() {
        myGymManager.write_save();
    }

    //testing about creating table input
    @Test
    public void tableDataTest() { myGymManager.tableData(); }

    //testing about counting the total members in the collection
    @Test
    public void countListTest() {
        myGymManager.countList();
        assertEquals(9,9);
    }
}
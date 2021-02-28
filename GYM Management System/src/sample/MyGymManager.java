package sample;

import com.mongodb.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import static sample.Database.GYMDatabase;

//implements the GymManager interface
public class MyGymManager implements GymManager {


    @Override
    //Adding and validating the details of the defaultMember to the collection
    public void defaultInputs(String MembershipNumber, String type, String name, String Date,String ContactNum) {
        new DefaultMember(MembershipNumber, name,Date,ContactNum);
        Database.addDatabase();
        Boolean foundID = false;        //creating a boolean value to check whether ID is already used or not
        DBCollection IDCheck = GYMDatabase.getCollection("GYMList");
        DBCursor loopRecords = IDCheck.find();          //create a loop to find the new ID is already in the collection or not
        for (DBObject record : loopRecords) {
            String IDLoopCheck = (String) record.get("ID");
            if (MembershipNumber.equals(IDLoopCheck)) {
                foundID = true;                //if new memberID is already used boolen value= true
            }
        }
        if (foundID){           //if ID is already used
            System.out.println("ID already exists");
        }else {
            //creading DB object to add default data
            BasicDBObjectBuilder defaultRecodes = new BasicDBObjectBuilder().start();
            //adding all data to collection through db object
            defaultRecodes.append("ID", MembershipNumber);
            defaultRecodes.append("Type", type);
            defaultRecodes.append("Name", name);
            defaultRecodes.append("Date", Date);
            defaultRecodes.append("ContactNum",ContactNum);
            DBCollection collection = GYMDatabase.getCollection("GYMList");
            collection.insert(defaultRecodes.get());
            System.out.println("Member added Successfully");
            //showing the remaining slots
            System.out.println("There are " + (100 - countList()) + " remaining slots to register.");
        }

    }



    @Override
    //Adding and validating the details of the student Member to the collection
    public void studentInputs(String MembershipNumber, String type, String name, String school, String Date,String ContactNum) {
        new StudentMember(MembershipNumber, name,school,Date,ContactNum);
        Database.addDatabase();
        Boolean foundID = false;         //creating a boolean value to check whether ID is already used or not
        DBCollection IDCheck = GYMDatabase.getCollection("GYMList");
        DBCursor loopRecords = IDCheck.find();      //create a loop to find the new ID is already in the collection or not
        for (DBObject record : loopRecords) {
            String IDLoopCheck = (String) record.get("ID");
            if (MembershipNumber.equals(IDLoopCheck)) {
                foundID = true;            //if new memberID is already used boolean value= true
            }
        }
        if (foundID){       //if ID is already used
            System.out.println("ID already exists");
        }else {
            //creading DB object to add student data
            BasicDBObjectBuilder studentRecodes = new BasicDBObjectBuilder().start();
            //adding all data to collection through db object
            studentRecodes.append("ID", MembershipNumber);
            studentRecodes.append("Type", type);
            studentRecodes.append("Name", name);
            studentRecodes.append("Date", Date);
            studentRecodes.append("School", school);
            studentRecodes.append("ContactNum",ContactNum);
            DBCollection collection = GYMDatabase.getCollection("GYMList");
            collection.insert(studentRecodes.get());
            System.out.println("Member added Successfully");
            //showing the remaining slots
            System.out.println("There are " + (100 - countList()) + " remaining slots to register.");
        }


    }

    @Override
    //Adding and validating the details of the over60 Member to the collection
    public void over60Inputs(String MembershipNumber, String type, String name, int age, String Date,String ContactNum) {
        new Over60Member(MembershipNumber, name,age,Date,ContactNum);
        Database.addDatabase();
        Boolean foundID = false;         //creating a boolean value to check whether ID is already used or not
        DBCollection IDCheck = GYMDatabase.getCollection("GYMList");
        DBCursor loopRecords = IDCheck.find();     //create a loop to find the new ID is already in the collection or not
        for (DBObject record : loopRecords) {
            String IDLoopCheck = (String) record.get("ID");
            if (MembershipNumber.equals(IDLoopCheck)) {
                foundID = true;                 //if new memberID is already used boolean value= true
            }
        }
        if (foundID){           //if ID is already used
            System.out.println("ID already exists");
        }else {
            //creading DB object to add dover60 data
            BasicDBObjectBuilder over60Recodes = new BasicDBObjectBuilder().start();
            //adding all data to collection through db object
            over60Recodes.append("ID", MembershipNumber);
            over60Recodes.append("Type", type);
            over60Recodes.append("Name", name);
            over60Recodes.append("Date", Date);
            over60Recodes.append("Age", age);
            over60Recodes.append("ContactNum",ContactNum);
            DBCollection collection = GYMDatabase.getCollection("GYMList");
            collection.insert(over60Recodes.get());
            System.out.println("Member added Successfully");
            //showing the remaining slots
            System.out.println("There are " + (100 - countList()) + " remaining slots to register.");
        }
    }


    @Override
    //deleting a member by ID
    public void dataDeletes(String MembershipNumber) {
        Database.addDatabase();
        Boolean foundID = false;         //creating a boolean value to check whether ID is already used or not
        DBCollection IDCheck = GYMDatabase.getCollection("GYMList");
        DBCursor loopRecords = IDCheck.find();      //create a loop to find the new ID is already in the collection or not
        for (DBObject record : loopRecords) {
            String IDLoopCheck = (String) record.get("ID");
            if (MembershipNumber.equals(IDLoopCheck)) {
                foundID = true;             //if memberID is used boolaen value= true
                WriteResult data = IDCheck.remove(record);  //removing the member
                System.out.println(record.get("Type")+" Member deleted Successfully");
                //showing the remaining slots
                System.out.println("There are " + (100 - countList()) + " remaining slots to register.");

            }
        }
        if (!foundID) {     //if ID is not used
            System.out.println("Member doesn't exist to delete");
        }
    }



    @Override
    //printing the list
    public void printList() {
        Database.addDatabase();
        DBCollection IDCheck = GYMDatabase.getCollection("GYMList");
        DBCursor loopRecords = IDCheck.find();      //create a loop to find the all IDs in the collection
        for (DBObject record : loopRecords) {       //writing the all the data in the console
            String IDLoopCheck = record.get("ID") + "\t" + (String) record.get("Name") + "\t" + record.get("Date")+"\t" + record.get("Type") + "\t" + record.get("School")+"\t"+ record.get("ContactNum")+"\t" + record.get("Age");
            System.out.println(IDLoopCheck);

        }
    }

    @Override
    //sorting the list
    public void sortRecords() {
        String sortColumn = "Name";     //adding the column to be sorted
        Database.addDatabase();
        BasicDBObject query=new BasicDBObject();
        BasicDBObject sortPoint = new BasicDBObject();
        sortPoint.put(sortColumn,1);        //adding the column to be sorted and (ascending,1) order
        DBCollection IDCheck = Database.GYMDatabase.getCollection("GYMList");
        DBCursor cursor = IDCheck.find(query).sort(sortPoint);
        for (DBObject record : cursor) {        //writing the all the sorted data in the console
            String IDLoopCheck = record.get("ID") + "\t" + (String) record.get("Name") + "\t" + record.get("Date")+"\t" + record.get("Type") + "\t" + record.get("School")+"\t" + record.get("ContactNum")+"\t" + record.get("Age");
            System.out.println(IDLoopCheck);

        }

    }


    @Override
    //writing all the data to text file
    public void write_save() {
        File file = new File("GymList.txt");

        FileWriter fileWriter = null;       //creating filewriter
        PrintWriter printWriter = null;     //creating printwriter

        try {
            fileWriter = new FileWriter(file, false);
            printWriter = new PrintWriter(fileWriter, true);       //using appening method for text file
            Database.addDatabase();
            DBCollection IDCheck = GYMDatabase.getCollection("GYMList");
            DBCursor loopRecords = IDCheck.find();      //create a loop to find the all IDs in the collection
            for (DBObject record : loopRecords) {       //writing the all the data in the text file
                String IDLoopCheck = record.get("ID") + "\t" + (String) record.get("Name") + "\t" + record.get("Date")+"\t" + record.get("Type") + "\t" + record.get("School")+"\t" + record.get("ContactNum")+"\t" + record.get("Age");
                printWriter.println(IDLoopCheck);

            }
        //adding all the validations to write the data to a text file
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
                printWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    //creating the observable list to add data to the table
    public ObservableList<DisplayList> tableData() {
        ObservableList<DisplayList> data = FXCollections.observableArrayList();
        Database.addDatabase();
        DBCollection IDCheck = GYMDatabase.getCollection("GYMList");
        DBCursor loopRecords = IDCheck.find();       //create a loop to find the all IDs in the collection
        for (DBObject record : loopRecords) {
            //collecting all the data through the loop to fill the table
            String IDLoopCheck = String.valueOf(record.get("ID"));
            String nameLoopCheck = String.valueOf(record.get("Name"));
            String dateLoopCheck = String.valueOf(record.get("Date"));
            String typeLoopCheck = String.valueOf(record.get("Type"));
            String schoolLoopCheck = String.valueOf(record.get("School"));
            String ageLoopCheck = String.valueOf(record.get("Age"));
            String ContactNumLoopCheck = String.valueOf(record.get("ContactNum"));
            //adding data to the observalble list
            data.add(new DisplayList(IDLoopCheck, nameLoopCheck, dateLoopCheck, typeLoopCheck, schoolLoopCheck, ageLoopCheck,ContactNumLoopCheck));

        }
        //returning observalble list
       return data;
    }

    @Override
    //adding search bar to the table
    public void tableSearch(ObservableList data, TextField txtFld1, TableView table) {
        //adding data to the filtered list by using the observalble list which is used to create table data
        FilteredList<DisplayList> dataSearch = new FilteredList<>(data, b-> true);
        //adding eventlistner and default values
        txtFld1.textProperty().addListener(((Observable,OldValue,newValue) -> {
            dataSearch.setPredicate(displayList -> {        //setting the predicate
                if (newValue == null || newValue.isEmpty()){        //returning empty list if nothing is searched
                    return true;
                }
                String lowCaseSearch = newValue.toLowerCase();

                if (displayList.getName().toLowerCase().indexOf(lowCaseSearch) != -1) {     //comparing the index of the new search value
                    return true;
                }

                return false;
            });
        }));
        //Adding seacrhed items to sorted list and then sorting it
        SortedList<DisplayList> dataSorted = new SortedList<>(dataSearch);
        dataSorted.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(dataSorted);

    }

    @Override
    //counting the added members in the collection
    public int countList() {
        Database.addDatabase();
        //getting the count of the collection
        int countMembers = (int) Database.GYMDatabase.getCollection("GYMList").count();
        return countMembers;
    }





}
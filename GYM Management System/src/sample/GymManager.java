package sample;

import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public interface GymManager {
    //Adding and validating the details of the default Member to the collection
    public void defaultInputs(String MembershipNumber , String type, String name, String Date,String ContactNum);

    //Adding and validating the details of the student Member to the collection
    public void studentInputs(String MembershipNumber , String type, String name , String school, String Date,String ContactNum);

    //Adding and validating the details of the over60 Member to the collection
    public void over60Inputs(String MembershipNumber , String type, String name , int age, String Date,String ContactNum);

    //deleting a member by ID
    public void dataDeletes(String MembershipNumber);

    //printing the list
    public void printList();

    //sorting the list
    public void sortRecords();

    //writing all the data to text file
    public void write_save();

    //creating the observable list to add data to the table
    public ObservableList<DisplayList> tableData();

    //adding search bar to the table
    public void tableSearch(ObservableList data, TextField txtFld1, TableView table);

    //counting the added members in the collection
    public int countList();


}







package sample;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUI {
    public static void main(String[] args) {
        MyGymManager myGymManager = new MyGymManager();
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("----------------------------------------------------------");
                System.out.println("Enter 1 to add a member");
                System.out.println("Enter 2 to delete a member");
                System.out.println("Enter 3 to print the list of members");
                System.out.println("Enter 4 to sort the list");
                System.out.println("Enter 5 to write and save in a file.");
                System.out.println("Enter 6 to open the GUI");
                System.out.println("Enter 0 to open the Exit");
                System.out.print("Enter: ");
                int operation = sc.nextInt();
                System.out.println("You entered " + operation);

                if (operation == 1) {
                    if (myGymManager.countList() <= 100) {
                        Scanner scanner = new Scanner(System.in);
                        System.out.print("Enter 1 for default member 2 for Student member or 3 for over 60 member : ");
                        int op2 = scanner.nextInt();
                        System.out.println("You entered " + op2);

                        if (op2 == 1) {
                            Scanner sc2 = new Scanner(System.in);
                            System.out.print("Enter member's ID : ");
                            String MembershipNumber1 = sc2.nextLine();
                            System.out.print("Enter member's name : ");
                            String name = sc2.nextLine();
                            String type = "Default";
                            System.out.print("Enter member's admission date (day/month/year): ");
                            String date = sc2.nextLine();
                            System.out.print("Enter member's contact number : ");
                            String contactNum = sc2.nextLine();

                            myGymManager.defaultInputs(MembershipNumber1, type, name, date,contactNum);

                        } else if (op2 == 2) {
                            Scanner sc3 = new Scanner(System.in);
                            System.out.print("Enter student member's ID : ");
                            String MembershipNumber2 = sc3.nextLine();
                            System.out.print("Enter student member's name : ");
                            String studentName = sc3.nextLine();
                            System.out.print("Enter student member's school : ");
                            String studentSchool = sc3.nextLine();
                            String type = "Student";
                            System.out.print("Enter member's admission date (day/month/year): ");
                            String date = sc3.nextLine();
                            System.out.print("Enter member's contact number : ");
                            String contactNum = sc3.nextLine();

                            myGymManager.studentInputs(MembershipNumber2, type, studentName, studentSchool, date,contactNum);

                        } else if ((op2 == 3)) {
                            Scanner sc4 = new Scanner(System.in);
                            System.out.print("Enter over60 member's ID : ");
                            String MembershipNumber3 = sc4.nextLine();
                            System.out.print("Enter over60 member's name : ");
                            String over60Name = sc4.nextLine();
                            System.out.print("Enter over60 member's age : ");
                            int over60Age = sc4.nextInt();
                            String type = "Over60";
                            Scanner sc5 = new Scanner(System.in);
                            System.out.print("Enter member's admission date (day/month/year): ");
                            String date = sc5.nextLine();
                            System.out.print("Enter member's contact number : ");
                            String contactNum = sc5.nextLine();

                            myGymManager.over60Inputs(MembershipNumber3, type, over60Name, over60Age, date,contactNum);

                        } else {
                            System.out.println("Wrong input");
                            System.exit(0);
                        }
                    } else {
                        System.out.println("There are no any remaining slots to register.");
                        System.exit(0);
                    }

                } else if (operation == 2) {
                    Scanner input = new Scanner(System.in);
                    System.out.print("Enter a ID number to delete : ");
                    String MembershipNumber4 = input.nextLine();
                    myGymManager.dataDeletes(MembershipNumber4);

                } else if (operation == 3) {
                    myGymManager.printList();

                } else if (operation == 4) {
                    myGymManager.sortRecords();

                } else if (operation == 5) {
                    myGymManager.write_save();

                } else if (operation == 6) {
                    GUI.main(args);

                } else if (operation == 0) {
                    System.exit(0);

                } else {
                    System.out.println("Wrong input");
                    System.exit(0);
                }
            } catch (InputMismatchException e) {
                System.out.println("Wrong data type");
            }
        }
    }
}

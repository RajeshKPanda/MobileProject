package academy.learnProgramming;

import sun.java2d.pipe.SpanIterator;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("0039 330 1111");

    public static void main(String[] args) {
        boolean quit = false;
        startPhone();
        printActions();
        while(!quit){

            System.out.println("\n Enter action  - 6 to show available actions");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action){
                case 0:
                    System.out.println("\n shutting down ");
                    quit = true;
                    break;
                case 1:
                    printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
            }
            
        }

    }

    private static void addNewContact(){
        System.out.println("Enter new Contact Name ");
        String name = scanner.nextLine();
        System.out.println("Enter Phone Number ");
        String number = scanner.nextLine();
        Contact newContact = Contact.createContact(name,number);
        if(mobilePhone.addNewContact(newContact)){
            System.out.println("New Contact Added : name " + name + " , phone = " + number );
        } else {
            System.out.println("Cannot add , " + name + " already on File ... ");
        }
    }

    private static void updateContact() {
        System.out.println("Enter existing contact Name ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println(" Contact cannot be found ");
        }

        System.out.println("Enter new Contact Name");
        String newName = scanner.nextLine();
        System.out.println("Enter new Contact Number : ");
        String newNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName, newNumber);
        if (mobilePhone.updateContact(existingContactRecord, newContact)) {
            ;
            System.out.println("Contact updated successfully");
        } else {
            System.out.println("Error updating the record ");
        }
    }

    private static void removeContact() {

        System.out.println("Enter existing contact Name ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println(" Contact cannot be found ");
            return;
        }

        if(mobilePhone.removeContact(existingContactRecord)){
            System.out.println("Contact successfully deleted ");
        } else {
            System.out.println("Error delting contact");
        }

        if(mobilePhone.removeContact(existingContactRecord)){
            System.out.println("Successfully delete Contact ");
        }
    }


    private static void queryContact() {

        System.out.println("Enter existing contact Name ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println(" Contact cannot be found ");
            return;
        }
        System.out.println("Name " + existingContactRecord.getContactName() + " Phone Number " + existingContactRecord.getPhoneNumber());
    }



    private static void printContacts(){
        mobilePhone.printContacts();
    }

    private static void startPhone(){
        System.out.println("Starting Phone ... ");
    }

    private static void printActions(){
        System.out.println("\nAvailable Actions : \n Press");
        System.out.println("0 - to Shut down \n " +
                "1 - Print New Contact \n" +
                "2 - To Add New Contact \n" +
                "3 - To Update New Contact \n" +
                "4 - To Remove an existing Contact \n" +
                "5 - Query if an Existing Contact exists \n" +
                "6 - To Print a list of available actions.");
        System.out.println("Choose your actions : ");
    }

}

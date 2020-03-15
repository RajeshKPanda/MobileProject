package academy.learnProgramming;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContact;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContact = new ArrayList<Contact>();
    }

    public boolean addNewContact(Contact contact){
        if(findContact(contact.getContactName()) >= 0){
            System.out.println("Contact is already in the File ");
            return false;
        }
        myContact.add(contact);
        return true;
    }

    private int findContact(Contact contact){
        return this.myContact.indexOf(contact);
    }

    private int findContact(String contactName){
        for(int i = 0; i < myContact.size(); i++){
            Contact contact = this.myContact.get(i);
            if(contact.getContactName().equals(contactName)){
                return i;
            }
        }
        return -1;
    }

    public boolean updateContact(Contact oldContact,Contact newContact){
        int foundPosition = findContact(oldContact);
        if(foundPosition <= 0){
            System.out.println(oldContact.getContactName() + " not found" );
            return true;
        }

        this.myContact.set(foundPosition,newContact);
        return false;
    }

    public String queryContact(Contact contact){
        if(findContact(contact) >= 0){
            return contact.getContactName();
        }
        return null;
    }

    public boolean removeContact(Contact contact){
        int foundPosition = findContact(contact);
        if(foundPosition < 0){
            System.out.println(contact.getContactName() +  " is not found ");
            return false;
        }

        this.myContact.remove(foundPosition);
        System.out.println("Contact Name " + contact.getContactName() + " Is deleted");
        return true;

    }

    public void printContacts(){

        System.out.println("Contact List ");
        for(int i = 0; i < this.myContact.size(); i++){
            System.out.println((i + 1) + "." + this.myContact.get(i).getContactName() + " --> " + this.myContact.get(i).getPhoneNumber());
        }
    }

    public Contact queryContact(String name){
        int position = findContact(name);
        if(position >= 0){
             return this.myContact.get(position);
        }
        return null;
    }


}


package com.bridgelabz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBook {
    ArrayList<Contact> Book = new ArrayList<Contact>();
    static Scanner scanner = new Scanner(System.in);

    static HashMap<String, ArrayList<Contact>> hashmap = new HashMap<>();
    static AddressBook Details = new AddressBook();

    // add details
    public void addDetails() {

        Scanner scanner = new Scanner(System.in);
        Contact details = new Contact();
        System.out.println("Enter the First Name ");
        details.setFirstName(scanner.nextLine());
        System.out.println("Enter the Last Name ");
        details.setLastName(scanner.nextLine());
        System.out.println("Enter the Address ");
        details.setAddress(scanner.nextLine());
        System.out.println("Enter the City ");
        details.setCity(scanner.nextLine());
        System.out.println("Enter the State ");
        details.setState(scanner.nextLine());
        System.out.println("Enter the Email of person");
        details.setEmail(scanner.nextLine());
        System.out.println("Enter the Zip code of person");
        details.setZipCode(scanner.nextInt());
        System.out.println("Enter the mobile number");
        details.setPhoneNumber(scanner.nextInt());

        Book.add(details);

        System.out.println(Book);
    }

    // edit the details

    public void editDetails() {

        System.out.println("Confirm your first name to edit details: ");
        String name = scanner.next();

        for (int i = 0; i < Book.size(); i++) {
            if (Book.get(i).getFirstName().equals(name)) {
                System.out.println("Select form below to change: ");
                System.out.println(
                        "\n1.First Name\n2.Last Name\n3.Address\n4.city\n5.State\n6.Email\n7.Zip\n8.Phone number");
                int check = scanner.nextInt();

                switch (check) {
                    case 1:
                        System.out.println("Enter first name");
                        Book.get(i).setFirstName(scanner.next());
                        break;
                    case 2:
                        System.out.println("Enter Last name");
                        Book.get(i).setLastName(scanner.next());
                        break;
                    case 3:
                        System.out.println("Enter address");
                        Book.get(i).setAddress(scanner.next());
                        break;
                    case 4:
                        System.out.println("Enter city");
                        Book.get(i).setCity(scanner.next());
                        break;
                    case 5:
                        System.out.println("Enter state");
                        Book.get(i).setState(scanner.next());
                        break;
                    case 6:
                        System.out.println("Enter email");
                        Book.get(i).setEmail(scanner.next());
                        break;
                    case 7:
                        System.out.println("Enter Zip");
                        Book.get(i).setZipCode(scanner.nextInt());
                        break;
                    case 8:
                        System.out.println("Enter phone number");
                        Book.get(i).setPhoneNumber(scanner.nextInt());
                        break;
                }

                System.out.println(Book);

            } else
                System.out.println("Enter valid First name");
        }

    }

    // display the details

    public void output() {

        System.out.println(Book);
    }


    // delete the details

    public void deleteDetails() {

        System.out.println("Confirm your first name to edit details: ");
        String name = scanner.next();

        for (int i = 0; i < Book.size(); i++) {
            if (Book.get(i).getFirstName().equals(name)) {
                System.out.println("Select form below to change: ");
                Book.remove(i);
//                Book.get(i).setFirstName("");
//                Book.get(i).setLastName("");
            }
        }
        System.out.println(Book);
    }

    public void createAddressBook() {

        while (true) {
            System.out.println("Choose what you want to do: ");
            System.out.println(
                    "1.Create new address book.\n2.Edit existing address book.\n3.Display all address books.\n4.exit");
            int choose = scanner.nextInt();

            if (choose == 4) {
                System.out.println("Exited");
                break;
            }

            switch (choose) {
                case 1:
                    System.out.println("Enter the name of address book: ");
                    String addressName = scanner.next();

                    // condition to check for uniqueness of address book.
                    if (hashmap.containsKey(addressName)) {
                        System.out.println("Address book name exits, enter different name");
                        break;
                    }

                    ArrayList<Contact> newaddressbook = new ArrayList<>();
                    Book = newaddressbook;
                    while (true) {
                        int choose1;
                        System.out.println("Choose what you want to do: ");
                        System.out.println("1.Add details.\n2.Edit details.\n3.Delete contact.\n4.Exit");
                        choose1 = scanner.nextInt();
                        if (choose1 == 4) {
                            System.out.println("Exited");
                            break;
                        }
                        switch (choose1) {
                            case 1:
                                Details.addDetails();
                                break;
                            case 2:
                                Details.editDetails();
                                break;
                            case 3:
                                Details.deleteDetails();
                                break;
                            default:
                                System.out.println("Choose valid option");
                                break;
                        }
                        hashmap.put(addressName, Book);
                        System.out.println(hashmap);
                    }
                    break;

                case 2:
                    System.out.println("Enter the name of address book: ");
                    String oldAddressBook = scanner.next();

                    // condition to check whether address book exists or no.
                    if (hashmap.containsKey(oldAddressBook)) {

                        ArrayList<Contact> oldaddressbook = new ArrayList<>();
                        Book = oldaddressbook;
                        Book = hashmap.get(oldAddressBook);
                        while (true) {
                            System.out.println("Choose what you want to do: ");
                            System.out.println("1.Add details.\n2.Edit details.\n3.Delete contact.\n4.Exit");
                            int choose2 = scanner.nextInt();
                            if (choose2 == 4) {
                                System.out.println("Exited");
                                break;
                            }
                            switch (choose2) {
                                case 1:
                                    Details.addDetails();addDetails();
                                    break;
                                case 2:
                                    Details.editDetails();
                                    break;
                                case 3:
                                    Details.deleteDetails();
                                    break;
                                default:
                                    System.out.println("Choose valid option");
                                    break;
                            }
                            hashmap.put(oldAddressBook, Book);
                            System.out.println(hashmap);
                            System.out.println( );
                        }
                    } else {
                        System.out.println("Enter valid address book name");
                    }
                    break;

                case 3:
                    System.out.println(hashmap);
                    break;

                default:
                    System.out.println("Enter valid option");

            }
        }
    }

    public static void main(String[] args) {
        Details.createAddressBook();
    }
}
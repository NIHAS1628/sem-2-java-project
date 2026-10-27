import java.util.*;

class Main {

    // Contact class
    static class Contact {
        String name, phone, email;

        Contact(String name, String phone, String email) {
            this.name = name;
            this.phone = phone;
            this.email = email;
        }

        void display() {
            System.out.println("Name: " + name);
            System.out.println("Phone: " + phone);
            System.out.println("Email: " + email);
            System.out.println("-------------------");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Contact> list = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n1.Add 2.View 3.Search 4.Update 5.Delete 6.Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // IMPORTANT

            switch(choice) {

                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    list.add(new Contact(name, phone, email));
                    System.out.println("Contact Added Successfully!");
                    break;

                case 2:
                    if(list.isEmpty()) {
                        System.out.println("No contacts available");
                    } else {
                        for(Contact c : list) {
                            c.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter name to search: ");
                    String s = sc.nextLine();
                    boolean found = false;

                    for(Contact c : list) {
                        if(c.name.equalsIgnoreCase(s)) {
                            c.display();
                            found = true;
                        }
                    }

                    if(!found)
                        System.out.println("Contact not found");
                    break;

                case 4:
                    System.out.print("Enter name to update: ");
                    String u = sc.nextLine();
                    boolean updated = false;

                    for(Contact c : list) {
                        if(c.name.equalsIgnoreCase(u)) {
                            System.out.print("Enter new phone: ");
                            c.phone = sc.nextLine();
                            System.out.print("Enter new email: ");
                            c.email = sc.nextLine();
                            System.out.println("Contact Updated Successfully!");
                            updated = true;
                        }
                    }

                    if(!updated)
                        System.out.println("Contact not found");
                    break;

                case 5:
                    System.out.print("Enter name to delete: ");
                    String d = sc.nextLine();
                    boolean removed = list.removeIf(c -> c.name.equalsIgnoreCase(d));

                    if(removed)
                        System.out.println("Contact Deleted Successfully!");
                    else
                        System.out.println("Contact not found");
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while(choice != 6);

        sc.close();
    }
}

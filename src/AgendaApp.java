
import java.util.InputMismatchException;
import java.util.Scanner;



public class AgendaApp {
    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario

        Agenda agendaTelefonica = new Agenda(3);
        String nombre;
        int telefono;

        Contact c;

        while (!salir) {

            System.out.println("1. add a contact");
            System.out.println("2. show all contacts");
            System.out.println("3. search contact by name");
            System.out.println("4. Does the contact exist?");
            System.out.println("5. delete contact");
            System.out.println("6. Contacts availables");
            System.out.println("7. Agenda full");
            System.out.println("8. exit");
            try {
                System.out.println("enter one of the options");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:

                        //Pido valores
                        System.out.println("write a name");
                        nombre = sn.next();

                        System.out.println("enter a phone number");
                        telefono = sn.nextInt();

                        //Creo el contacto
                        c = new Contact(nombre, telefono);

                        agendaTelefonica.add(c);

                        break;
                    case 2:

                        agendaTelefonica.show();

                        break;
                    case 3:

                        //pido el nombre
                        System.out.println("enter a name");
                        nombre = sn.next();

                        agendaTelefonica.searchByName(nombre);

                        break;
                    case 4:

                        //pido el nombre
                        System.out.println("enter a name");
                        nombre = sn.next();

                        //Creo el contacto auxiliar
                        c = new Contact(nombre, 0);

                        if (agendaTelefonica.existContact(c)) {
                            System.out.println("contact exists");
                        } else {
                            System.out.println("contact does not exist");
                        }

                        break;
                    case 5:

                        //pido el nombre
                        System.out.println("enter a name");
                        nombre = sn.next();

                        //Creo el contacto auxiliar
                        c = new Contact(nombre, 0);

                        agendaTelefonica.deleteContact(c);

                        break;
                    case 6:

                        System.out.println("Hay " + agendaTelefonica.roomAvailable() + " contacts available");

                        break;
                    case 7:

                        //como devuelve un booleano, lo meto en un if
                        if (agendaTelefonica.isFull()) {
                            System.out.println("the agenda book is full");
                        } else {
                            System.out.println("you can still enter more contacts");
                        }

                        break;
                    case 8:
                        salir = true;
                        break;
                    default:
                        System.out.println("numbers between 1 and 8 only");
                }

            } catch (InputMismatchException e) {
                System.out.println("you should enter a number");
                sn.next();
            }

        }

    }





    }


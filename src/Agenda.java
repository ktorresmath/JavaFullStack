public class Agenda {
    private Contact contacts [];

    public Agenda(){
        this.contacts =  new Contact[10];
    }

    public Agenda(int size){
        this.contacts = new Contact[size];
    }

    public void add(Contact c){
        if (existContact(c)){
            System.out.println("contact already exists");
        }else if(isFull()){
            System.out.println("agent is full");
        }
        else{
            boolean inserted = false;
            for(int i=0;i<contacts.length && !inserted;i++){
                if(contacts[i] == null){    // in case the index is taken
                    contacts[i] = c;    //insert the contact in the array
                    inserted = true;    // so only one contact is inserted at a time
                }
            }
        }
    }

    public boolean isFull(){
        for (int i=0; i<contacts.length;i++){
            if(contacts[i]==null){
                return false;
            }
        }
        return true;
    }

    public boolean existContact(Contact c){
        for(int i=0;i<contacts.length;i++){
            if(contacts[i] != null && c.equals(contacts[i])) { // fix this// contacts[i].equals(c)
                return true;
            }

        }
        return false;
    }

    public void show(){
        for(int i=0;i<contacts.length;i++){
            if(contacts[i] != null){
                System.out.println(contacts[i]+" ");
            }

        }
    }

    public void searchByName(String n){

            boolean found = false;
            for(int i=0;i< contacts.length && !found;i++){
                if(contacts[i] != null &&  contacts[i].getName().trim().equalsIgnoreCase(n.trim())){
                    System.out.println(contacts[i].getPhoneNumber());
                    found = true;
                }
            }
            if(!found){
                System.out.println("no number found with this name "+ n);
            }



    }

    public void deleteContact(Contact c){

        boolean deleted = false;
        for(int i =0;i<contacts.length && !deleted;i++){
            if(contacts[i] !=null && contacts[i].equals(c) ){
                    contacts[i] = null;
                    deleted = true;
                    System.out.println("contact "+ c+" was deleted");

            }

        }
        if(!deleted){
            System.out.println("no contact were deleted");
        }
    }

    public int roomAvailable(){
        int aux = 0;

        for(int i=0;i<contacts.length;i++){
            if(contacts[i] == null){
                aux++;
            }
        }

        return aux;
    }


}

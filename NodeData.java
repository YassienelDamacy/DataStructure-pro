public class NodeData {
    public String name;
    public String address;
    public String email;
    public String phoneNmb;
    public NodeData(String name,String address,String email,String phoneNmb) // constructor
    {
        this.address=address;
        this.name=name;
        this.email=email;
        this.phoneNmb=phoneNmb;
    }
    public void addContact(int index,String []contact,String cont){
    }
    public void displayItem() // display item, format "27,"
    {
        System.out.print(name+" , ");
    }

}

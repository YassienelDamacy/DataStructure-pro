public class phoneBook implements Comparable<phoneBook>{
    private  String name;
    private  String phoneNumb;
    private  String email;
    private  String address;
    public phoneBook(String name,String phoneNumb,String email,String address){
        this.address=address;
        this.name=name;
        this.email=email;
        this.phoneNumb=phoneNumb;
    }
    public phoneBook(String name) {
        this.name = name;
    }

    public void setData(String name,String phoneNumb,String email,String address)
    {
        this.address=address;
        this.name=name;
        this.email=email;
        this.phoneNumb=phoneNumb;
    }

    public void setAddress(String address) {
        this.address = address;
    }
   public void setEmail(String email) {
        this.email = email;
    }
      public void setName(String name) {
        this.name = name;
      }
    public void setNumber(String number) {
        this.phoneNumb = phoneNumb;
    }
    public String getEmail() {
        return email;
    }
    public String getAddress() {
        return address;
    }
    public String getPhoneNumb() {
        return phoneNumb;
    }
      public String getName() {
       return name;
      }


    @Override
    public String toString() {
        return "{ " +
                "name='" + name + '\'' +
                ", phoneNumb='" + phoneNumb + '\'' +
               ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}'+"\n";

    }

    @Override
    public int compareTo(phoneBook obj){
        return this.name.compareTo(obj.name);
    }
}

public class Customers {
    private String name;
    private String address;
    private final String NIP;
    private final java.sql.Date date;
    public Customers(String name,String NIP,java.sql.Date date,String address){
        this.address = address;
        this.name = name;
        this.date = date;
        this.NIP = NIP;
    }
    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public String getNIP(){
        return NIP;
    }
    public java.sql.Date getDate(){
        return date;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAddress(String address){
        this.address = address;
    }
}

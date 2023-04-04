public class Customers {
    private String name;
    private String address;
    private final String VATid;
    private final java.sql.Date date;
    public Customers(String name, String VATid, java.sql.Date date, String address){
        this.address = address;
        this.name = name;
        this.date = date;
        this.VATid = VATid;
    }
    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public String getVATid(){
        return VATid;
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

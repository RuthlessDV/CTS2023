import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // write your code here
        OShop o = new OShop("Emag", "logo.jpg", new ArrayList<Product>());

        Product p1 = new Product("Laptop", 3200.5, 1,1, 1123, "");
        Product p2 = new Product("Frigider", 207.95, 1,2, 1245, "");

        Product p3 = new Product(p1);

        p3.setQty(5);
        p3.setName("Paine");

        o.modifyProductsList(1,p1);
        o.modifyProductsList(1,p2);

        o.modifyProductsList(2, p1);
        System.out.println(p1.isEqual(p2));
    }
}

class OShop {
    private String onlineShopName;
    private String i;
    private ArrayList<Product> products;

    OShop(String name, String img, ArrayList<Product> products)
    {
        this.products = new ArrayList<Product>();
        this.i = img;
        this.onlineShopName = name;
    }

    public void modifyProductsList(int what, Product p)
    {
        if(what == 1)
        {
            this.products.add(p);
        }
        else
            this.products.remove(p);
    }

    public String getOnlineShopName() {
        return onlineShopName;
    }

    public void setOnlineShopName(String onlineShopName) {
        this.onlineShopName = onlineShopName;
    }

    public String getI() {
        return i;
    }

    public void setImg(String img) {
        this.i = img;
    }
}

class Product
{
    private int Id;
    private String Name;
    private double Price;
    private int Type;
    private int Category;
    private int qty;
    private String expiryDate; //expiry date - only for goods
    private String details; // ex.: processor, memory, power, volume (for refrigerators etc)

    public Product(String name, double price, int type, int category, int id, String expiryDate)
    {
        this.Name = name;
        this.Price = price;
        this.Type = type;
        this.Category = category;
        this.Id = id;
        this.expiryDate = expiryDate;
    }

    public Product(Product p)
    {
        this.Name = p.Name;
        this.Price = p.Price;
        this.Type = p.Type;
        this.Category = p.Category;
        this.Id = p.Id;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        this.Price = price;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public int getType() {
        return Type;
    }

    public void setType(int type) {
        this.Type = type;
    }

    public boolean isEqual(Product p)
    {
        if(p.Id != this.Id)
            return false;
        if(!p.Name.equals(this.Name))
            return false;
        if(p.Price != this.Price)
            return false;
        if(p.Type != p.Type)
            return false;
        if(p.Category != this.Category)
            return false;

        return true;
    }

    public void modifyPrice(boolean flag, double val)
    {
        if(flag)
            this.Price +=this.Price *val;
        if(!flag)
            this.Price -=this.Price *val/100;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}

class User
{
    private String usn;
    private String userId;
    private ArrayList<Order> o;
    private ArrayList<Order> c;

    public User(String usn, String userId)
    {
        this.usn = usn;
        this.userId = userId;
        o=new ArrayList<Order>();
        c=new ArrayList<Order>();
    }

    public void addO1(Order o)
    {
        this.o.add(o);
    }

    public void addO2(Order o)
    {
        this.c.add(o);
    }
}

class Order
{
    private ArrayList<Product> l;
    private String addr;

    public Order()
    {
        l = new ArrayList<Product>();
    }
    public void add(Product p)
    {
        if(l.size() > 99)
            return;

        l.add(p);
    }

    public void remove(Product p)
    {
        l.remove(p);
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}

class InventoryP
{
    private Product p;
    private int q;

    public InventoryP(Product p, int q)
    {
        this.p = new Product(p);
        this.q = q;
    }
    public Product getP() {
        return p;
    }

    public void setP(Product p) {
        this.p = p;
    }

    public int getQ() {
        return q;
    }

    public void setQ(int q) {
        this.q = q;
    }
}


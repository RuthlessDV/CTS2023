import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        // write your code here
        OnlineShop o = new OnlineShop("Emag", "logo.jpg", new ArrayList<Product>());

        Product p1 = new Product("Laptop", 3200.5, 1,1, 1123, null);
        Product p2 = new Product("Frigider", 207.95, 1,2, 1245, null);

        Product p3 = new Product(p1);

        p3.setQty(5);
        p3.setName("Paine");

        //o.modifyProductsList(1,p1);
        o.addProduct(p1);
        //o.modifyProductsList(1,p2);
        o.addProduct(p2);

        //o.modifyProductsList(2, p1);
        o.removeProduct(p2);
        System.out.println(p1.isEqual(p2));
    }
}

class OnlineShop {
    private String Name;
    private String image;
    private ArrayList<Product> products;

    OnlineShop(String name, String img, ArrayList<Product> products)
    {
        this.products = new ArrayList<Product>();
        this.image = img;
        this.Name = name;
    }

//    public void modifyProductsList(int what, Product p)
//    {
//        if(what == 1)
//        {
//            this.products.add(p);
//        }
//        else
//            this.products.remove(p);
//    }

    public void addProduct(Product product){
        this.products.add(product);
    }

    public void removeProduct(Product product){
        this.products.remove(product);
    }



    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImg(String img) {
        this.image = img;
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
    private Date expiryDate; //expiry date - only for goods
    private String details; // ex.: processor, memory, power, volume (for refrigerators etc)

    public Product(String name, double price, int type, int category, int id, Date expiryDate)
    {
        this.Name = name;
        this.Price = price;
        this.Type = type;
        this.Category = category;
        this.Id = id;
        this.expiryDate = expiryDate;
    }

    public Product(Product originalProduct)
    {
        this.Name = originalProduct.Name;
        this.Price = originalProduct.Price;
        this.Type = originalProduct.Type;
        this.Category = originalProduct.Category;
        this.Id = originalProduct.Id;
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

//    public void modifyPrice(boolean flag, double val)
//    {
//        if(flag)
//            this.Price +=this.Price *val;
//        if(!flag)
//            this.Price -=this.Price *val/100;
//    }

    public void increasePrice(double val){
        this.Price += this.Price * val;
    }

    public void decreasePrice(double val){
        this.Price -= this.Price *val/100;
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
    private String Username;
    private String Id;
    private ArrayList<Order> orderList;

    //private ArrayList<Order> c; redundant?

    public User(String usn, String userId)
    {
        this.Username = usn;
        this.Id = userId;
        orderList =new ArrayList<Order>();
        //c=new ArrayList<Order>();
    }

    public void addOrder(Order o)
    {
        this.orderList.add(o);
    }

//    public void addO2(Order o)
//    {
//        this.c.add(o);
//    } --lista neutilizata/metoda redundanta?
}

class Order
{
    private ArrayList<Product> productList;
    private String address;

    public Order()
    {
        productList = new ArrayList<Product>();
    }
    public void add(Product p)
    {
        if(productList.size() > 99)
            return;

        productList.add(p);
    }

    public void remove(Product p)
    {
        productList.remove(p);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

class Inventory
{
    private Product p;
    private int qty;

    public Inventory(Product p, int qty)
    {
        this.p = new Product(p);
        this.qty = qty;
    }
    public Product getP() {
        return p;
    }

    public void setP(Product p) {
        this.p = p;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}


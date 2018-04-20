package com.wenbin.datastructure;

public class Product {
    private String pid;
    private String pname;
    private String pcat;
    private double pprice;

    public Product() {
    }

    public Product(String pid, String pname, String pcat, double pprice) {

        this.pid = pid;
        this.pname = pname;
        this.pcat = pcat;
        this.pprice = pprice;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPcat() {
        return pcat;
    }

    public void setPcat(String pcat) {
        this.pcat = pcat;
    }

    public double getPprice() {
        return pprice;
    }

    public void setPprice(double pprice) {
        this.pprice = pprice;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Product) {
            Product _obj = ((Product) obj);
            return _obj.pid.equals(this.pid) && _obj.pcat.equals(this.pcat) && _obj.pname.equals(this.pname) && _obj.pprice == this.pprice;
        }
        return false;
    }

    @Override
    public String toString() {
        return "[id: " + this.pid + " name: " + this.pname + " cat: " + this.pcat + " price: " + this.pprice + "]";
    }

}

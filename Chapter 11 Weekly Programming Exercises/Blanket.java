public class Blanket {
    public String size;
    public String color;
    public String material;
    public double price;
    
    public Blanket() {
        size = "Twin";
        color = "white";
        material = "cotton";
        price = 30.00;
    }
    
    public void setSize(String size) {
        if (size.equalsIgnoreCase("double")) {
            this.size = "Double";
            price += 10.00;
        } else if (size.equalsIgnoreCase("queen")) {
            this.size = "Queen";
            price += 25.00;
        } else if (size.equalsIgnoreCase("king")) {
            this.size = "King";
            price += 40.00;
        } else {
            this.size = "Twin";
            price = 30.00;
        }
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public void setMaterial(String material) {
        if (material.equalsIgnoreCase("wool")) {
            this.material = "wool";
            price += 20.00;
        } else if (material.equalsIgnoreCase("cashmere")) {
            this.material = "cashmere";
            price += 45.00;
        } else {
            this.material = "cotton";
        }
    }
    
    public String toString() {
        return "Size: " + size + "\nColor: " + color + "\nMaterial: " + material + "\nPrice: $" + price;
    }

    public double getPrice(double price){
        return price;
    }
}

public abstract class Book {
    public String title;
    public double price;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public abstract void setPrice(double price);

    public void display() {
        System.out.println("Title: " + title);
        System.out.println("Price: $" + price);
    }
}

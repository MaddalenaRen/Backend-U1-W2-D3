import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Product p1=new Product(1L, "La compagnia dell'anello. Il Signore degli anelli", "Books", 25.50);
        Product p2=new Product(2L, "Le due torri. Il Signore degli anelli", "Books", 37.50);
        Product p3=new Product(3L, "Il ritorno del re. Il Signore degli anelli", "Books", 41.50);
        Product p4=new Product(4L, "Trilogia Signore degli anelli & Lo Hobbit", "Books", 120.0);
        Product p5=new Product(5L, "T-Short", "Baby", 15.0);
        Product p6=new Product(6L, "Harry Potter e la pietra Filosofale", "Movie", 21.70);
        Product p7=new Product(7L, "Harry Potter e la camera dei Segreti", "Movie" , 18.50);
        Product p8=new Product(8L, "Felpa-Vans","Boys", 80.0);

        List<Product> products = List.of(p1, p2,p3,p4,p5,p6,p7,p8);



        Customer c1= new Customer(123L, "Pippo", 1);
        Customer c2= new Customer(456L, "Albano", 2);
        Customer c3= new Customer(789L, "TopoGigio", 3);


        Order o1= new Order(321L,"ordine effettuato", LocalDate.of(2025,4,6), LocalDate.of(2025,4,7), null, null);
        Order o2= new Order(654L,"ordine effettuato", LocalDate.of(2025,5,9), LocalDate.of(2025,5,11), null, null);
        Order o3= new Order(987L,"ordine effettuato", LocalDate.of(2025,4,12), LocalDate.of(2025,4,14), null, null);

        o1.setCustomer(c1);
        o1.setProducts(List.of(p1,p2,p3));

        o2.setCustomer(c2);
        o2.setProducts(List.of(p4,p5));

        o3.setCustomer(c3);
        o3.setProducts(List.of(p6,p7,p8));

        List<Order> ordersList= List.of(o1,o2,o3);








        List<Product> booksList= products.stream().filter(product -> product.getCategory().equalsIgnoreCase("Books")&& product.getPrice()>100).toList();


        //Stampa dell'esercizio 1
        System.out.println("-----------Esercizio 1 ------------");
        for (Product p : booksList) {
            System.out.println(p.getName() + " - " + p.getPrice());
        }

       List<Order> orderedList= ordersList.stream().filter(order -> order.getProducts().stream().anyMatch(product -> product.getCategory().equalsIgnoreCase("Baby"))).toList();

        System.out.println("-----------Esercizio 2: Ordini con prodotti categoria 'Baby' ------------");
        for (Order order : orderedList) {
            System.out.println(order);
        }

        List<Product> productsboys = products.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase("Boys"))
                .map(product -> {
                    product.setPrice(product.getPrice() * 0.9);
                    return product;
                })
                .toList();

        System.out.println("------------- Esercizio 3: Ordini con prodotti categoria 'Boys'------------");
        System.out.println(productsboys);


    }
}

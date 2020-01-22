

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Main {

    public static void main(String[] args) {
        try {
            // Here we create a document object and use JSoup to fetch the website
            Document doc = Jsoup.connect("https://www.walmart.com.mx/productos?Ntt=television").get();

            // With the document fetched, we use JSoup's title() method to fetch the title
            System.out.printf("Title: %s\n", doc.title());

            // Get the list of repositories
            Elements products = doc.getElementsByClass("_1tqY_egGtfSaq6uxUqq4g4");

            /**
             * For each product extract
             *
             */
            for (Element product : products) {
                // Extract the alt text, contains product name
                String productName = product.getElementsByClass("repo-item-alt").text();

                //Extract image path
                String imagePath = product.getElementsByClass("repo-item-src").text();


                // Format and print the information to the console
                System.out.println(productName);
                System.out.println("\t" + imagePath);
                System.out.println("\n");
            }

            // In case of any IO errors, we want the messages written to the console
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
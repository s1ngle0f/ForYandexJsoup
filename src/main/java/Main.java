import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    //Симуляция координат(потом буду брать с GPS)
    private static String x = "55.638083";
    private static String y = "37.327853";

    //Вытягивание странички по координатам, если ввести напрямую в браузер, то выдает нужную область
    private static Document getPage(String x, String y) throws IOException {
        String url = "https://yandex.ru/maps/213/moscow/search/остановка/?ll="+ y +"%2C"+ x +"&sll="+ y +"%2C"+ x +"&sspn=0.001392%2C0.000460&z=21";
        //String url = "https://ru.ebay.com/b/Chaises/38208/bn_1519952";
        Document page = Jsoup.connect(url)
                //.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.77 YaBrowser/20.11.0.817 Yowser/2.5 Safari/537.36")
                .userAgent("Mozilla")
                .cookie("beget", "begetok")
                .get();
        System.out.println( url );
        return page;
    }
//href="https://yandex.ru/maps/?ll=37.33459450415905%2C55.63493493737053&z=16&mode=stop&masstransit%5BstopId%5D=3215543377&utm_source=api-maps&from=api-maps"
// https://yandex.ru/maps/213/moscow/stops/3215543377/?from=api-maps&ll=37.334595%2C55.634935&utm_source=api-maps&z=16
    //
    //1. https://yandex.ru/maps/213/moscow/search/остановка/?ll=37.328004%2C55.638033&sctx=ZAAAAAgBEAAaKAoSCacz4mT2qUJAEaE5C5us0UtAEhIJAAAYFblnYT8RAABUzT8HRz8oCkC7%2FwZIAVXNzMw%2BWABqAnJ1cACdAc3MTD2gAQCoAQC9AVthKHzCAZQBqL%2FE6MgGqKr%2Fi5MC7uX7io0Fxv2WnpAD1czLjPMBxYWQvM8Fit6Z9bwCk4%2Fj4%2FcDxsb6%2FcECisrk2o8FjZzatq0FgvrW3Y4C0Pm0ubgG4pmdmlKGrd2E6AOq7dONkQaU4vemjAbqo7OMwwaz4bC83QOlvpn5ygLxmPz5owaK%2FvO%2FMJyH1%2BLKA6fLncaEBYmcgK7DAQ%3D%3D&sll=37.328004%2C55.638033&sspn=0.001915%2C0.000633&z=20.54
    //2. https://yandex.ru/maps/213/moscow/search/остановка/?ll=37.327989%2C55.638073&sll=37.327989%2C55.638073&z=21
    // разброс sspn=0.001392%2C0.000460
    //ctx позволяет видеть САМЫЕ ближние остновки
//   ближайшие остановки *сделать парсер*
    //
    public static void main(String[] args) throws IOException {
        Document page = getPage(x, y);
//        Element el = page.select("div.sidebar-container").first();
//        Element el1 = el.select( "div[class=search-business-snippet-view__content]" ).first();
        System.out.println( page );
        System.out.println( "------------------------------------------------------------------------" );
    }
}

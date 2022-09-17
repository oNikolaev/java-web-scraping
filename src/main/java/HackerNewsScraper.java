import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.w3c.dom.html.HTMLElement;

import java.util.List;

public class HackerNewsScraper {
    public static void main(String[] args) {
        String baseURL = "https://news.ycombinator.com/";
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);

        HtmlPage page = null;
        try {
            page = client.getPage(baseURL);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<HtmlElement> itemList = page.getByXPath("//tr[@class='athing']");
        if (itemList.isEmpty()) {
            System.out.printf("No item found");
        } else {
            for (HtmlElement htmlItem : itemList) {
                int position = Integer.parseInt(
                        ((HtmlElement) htmlItem.getFirstByXPath("./td/span"))
                                .asText()
                                .replace(".", ""));
            }
        }

    }
}

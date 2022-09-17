import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class SimpleGETRequest {
    public static void main(String[] args) {
        String baseURL = "https://news.ycombinator.com/";
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);

        try {
            HtmlPage page = client.getPage(baseURL);
            System.out.printf(page.asXml());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

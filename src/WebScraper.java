import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
    public static void main(String[] args) {
        System.out.println(urlToString("http://erdani.com/tdpl/hamlet.txt"));
        System.out.println(wordCount("http://erdani.com/tdpl/hamlet.txt"));
        System.out.println(wordFoundCount("http://erdani.com/tdpl/hamlet.txt", "four"));
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    /**
     * Returns the number of words in the page.
     *
     * @param url
     * @return int value of number of words on the page with the param url
     */
    public static int wordCount(final String url) {
        Scanner wordCounter = new Scanner(urlToString(url));
        int words = 0;
        while (wordCounter.hasNext()) {
            wordCounter.next();
            words++;
        }
        return words;
    }

    /**
     *
     */
    public static int wordFoundCount(final String url, final String wordToFind) {
        Scanner wordFinder = new Scanner(urlToString(url));
        int wordFoundTimes = 0;

        while (wordFinder.hasNext()) {
            wordFinder.next();
            if (wordFinder.equals(wordToFind)) {
                wordFoundTimes++;
            }
        }
        return wordFoundTimes;
    }
}

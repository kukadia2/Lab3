import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 * A class that prints a URL's contents and computes its word count.
 * @author kukad
 *
 */
public class Lab3 {

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
     * Counts the total number of words in the URL.
     * @param urlContents
     * urlContents the urlContents
     * @return wordCount
     */
    public static int wordCount(final String urlContents) {
        int wordCount = 0;
        for (int i = 0; i < urlContents.length(); i++) {
            if (urlContents.charAt(i) == ' ' && urlContents.charAt(i + 1) != ' ') {
                wordCount++;
            }
        }
        return wordCount;
    }
    /**
     * Counts the occurrences of a specific word.
     * @param urlContents
     * urlContents the urlContents
     * @param wordToBeFound
     * wordToBeFound the wordToBeFound
     * @return wordCountOfWordToBeFound
     */
     public static int oneWordCount(final String urlContents, final String wordToBeFound) {
        int wordCountOfWordToBeFound = 0;
        String parsedString = urlContents;
        int index = parsedString.toLowerCase().indexOf(wordToBeFound);
        while (index != -1) {
            wordCountOfWordToBeFound++;
            parsedString = parsedString.substring(index + 1);
            index = parsedString.toLowerCase().indexOf(wordToBeFound);
        }
        return wordCountOfWordToBeFound;
    }

    /**
     * Solicits a URL from the user.
     * @param args
     * args the args
     */
    public static void main(final String[] args) {
        String urlContents = urlToString("http://erdani.com/tdpl/hamlet.txt");
        System.out.println(urlContents);
        System.out.println("The word count is " + wordCount(urlContents) + ".");
        System.out.println("The word prince appears " + oneWordCount(urlContents, "prince")
            + " times in the URL contents.");
    }
}

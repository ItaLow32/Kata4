package kata4;

/**
 *
 * @author ItaLow32
 */
import kata4.load.EmailLoader;
import kata4.load.Loader;
import kata4.load.FileLoader;
import java.io.File;
import java.util.List;

public class Kata4 {

    public static void main(String[] args) {
        Loader loader = new EmailLoader(new FileLoader(new File("email.txt")));
        List<String> emails = loader.load();
        Histogram<String> histogram = new Histogram<>();
        
        for (String email : emails) {
            histogram.increment(email.substring(email.indexOf("@")+1));
        }
        
        HistogramDisplay histogramDisplay = new HistogramDisplay("Histogram Display...", histogram);
        histogramDisplay.execute();
    }
    
}

package kata4.load;

/**
 *
 * @author ItaLow32
 */
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class EmailLoader implements Loader{

    Loader loader;

    public EmailLoader(Loader loader) {
        this.loader = loader;
    }
    
    @Override
    public List<String> load() {
        List<String> data = loader.load();
        List<String> emails = new ArrayList<>();
        
        for (String line : data)
            if(isEmail(line)) emails.add(line);
        
        return emails;
    }

    private static final Pattern emailPattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    private boolean isEmail(String line) {
        return emailPattern.matcher(line).matches();
    }
    
    
    
}

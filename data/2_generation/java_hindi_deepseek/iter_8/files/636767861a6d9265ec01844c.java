import java.util.ArrayList;
import java.util.List;

public class AppenderManager {
    private List<String> appenders;

    public AppenderManager() {
        this.appenders = new ArrayList<>();
    }

    /**
     * पैरामीटर के रूप में दिए गए नाम के साथ एपेंडर को एपेंडर्स की सूची से हटा दें।
     * @param name एपेंडर का नाम जिसे हटाना है
     */
    public void removeAppender(String name) {
        if (name != null) {
            appenders.remove(name);
        }
    }

    // Optional: Method to add appenders for testing
    public void addAppender(String name) {
        if (name != null) {
            appenders.add(name);
        }
    }

    // Optional: Method to get appenders for testing
    public List<String> getAppenders() {
        return new ArrayList<>(appenders);
    }
}
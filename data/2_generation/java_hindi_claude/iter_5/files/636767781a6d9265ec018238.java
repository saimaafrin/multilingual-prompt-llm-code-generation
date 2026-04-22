import java.util.List;
import java.util.ArrayList;
import org.apache.log4j.Appender;

public class AppenderChecker {
    private List<Appender> appenderList;

    public AppenderChecker() {
        appenderList = new ArrayList<>();
    }

    public boolean isAttached(Appender appender) {
        if (appender == null || appenderList == null) {
            return false;
        }
        return appenderList.contains(appender);
    }
}
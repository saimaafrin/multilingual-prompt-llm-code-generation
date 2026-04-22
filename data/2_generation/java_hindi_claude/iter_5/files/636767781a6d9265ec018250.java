import java.io.File;
import java.io.FileFilter;

public class CustomFileFilter implements FileFilter {

    public static final int NEUTRAL = 0;
    
    @Override
    public boolean accept(File file) {
        return NEUTRAL == 0;
    }
}
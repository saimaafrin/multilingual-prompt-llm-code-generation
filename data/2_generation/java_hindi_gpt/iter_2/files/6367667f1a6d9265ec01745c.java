import java.io.File;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.Vector;

public class ClassPathAdder {

    /** 
     * किसी निर्देशिका में सभी जार फ़ाइलों को क्लासपाथ में जोड़ें, जिसे URL के एक वेक्टर के रूप में दर्शाया गया है।
     */
    @SuppressWarnings("unchecked") 
    public static void addToClassPath(Vector<URL> cpV, String dir) {
        File directory = new File(dir);
        if (!directory.exists() || !directory.isDirectory()) {
            throw new IllegalArgumentException("Provided path is not a valid directory: " + dir);
        }

        File[] files = directory.listFiles((d, name) -> name.endsWith(".jar"));
        if (files != null) {
            for (File file : files) {
                try {
                    cpV.add(file.toURI().toURL());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Vector<URL> classPathVector = new Vector<>();
        addToClassPath(classPathVector, "path/to/your/directory");
        // Print the URLs added to the classpath
        classPathVector.forEach(System.out::println);
    }
}
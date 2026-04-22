import java.io.InputStream;
import java.io.IOException;
import java.util.Stack;

private void addReverse(final InputStream[] files) {
    Stack<InputStream> stack = new Stack<>();
    
    // Push all InputStreams onto the stack
    for (InputStream file : files) {
        stack.push(file);
    }
    
    // Pop from the stack to process in reverse order
    while (!stack.isEmpty()) {
        InputStream file = stack.pop();
        try {
            // Process the file (this is a placeholder for actual file processing logic)
            processFile(file);
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception as needed
        }
    }
}

private void processFile(InputStream file) throws IOException {
    // Placeholder for file processing logic
    // For example, read from the InputStream and perform necessary operations
}
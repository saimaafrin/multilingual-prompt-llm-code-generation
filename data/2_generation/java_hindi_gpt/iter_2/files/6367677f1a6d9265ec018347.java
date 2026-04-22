public class TelnetClient {

    /**
     * प्रत्येक क्लाइंट को टेलनेट-फ्रेंडली आउटपुट में एक संदेश भेजता है। 
     */
    public synchronized void send(final String message) {
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("Message cannot be null or empty");
        }
        // Assuming we have a method to get the output stream for the client
        try {
            // Simulating sending a message to a telnet client
            System.out.println("Sending to client: " + message);
            // Here you would write the message to the client's output stream
            // outputStream.write(message.getBytes());
            // outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TelnetClient client = new TelnetClient();
        client.send("Hello, this is a telnet-friendly message!");
    }
}
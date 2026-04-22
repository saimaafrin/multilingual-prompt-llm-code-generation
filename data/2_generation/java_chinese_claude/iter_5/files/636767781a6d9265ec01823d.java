import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Layout;
import org.apache.log4j.spi.LoggingEvent;
import java.io.IOException;
import java.io.Writer;

public class CustomAppender extends AppenderSkeleton {
    
    private Writer writer;
    
    public CustomAppender(Writer writer) {
        this.writer = writer;
    }

    /**
     * 此方法执行实际的写入操作
     */
    @Override
    protected void subAppend(LoggingEvent event) {
        if(layout == null) {
            errorHandler.error("No layout set for the appender named [" + name + "].");
            return;
        }

        if(writer == null) {
            errorHandler.error("No writer set for the appender named [" + name + "].");
            return;
        }

        try {
            String formattedMessage = layout.format(event);
            writer.write(formattedMessage);
            
            if(layout.ignoresThrowable()) {
                String[] throwableStrRep = event.getThrowableStrRep();
                if(throwableStrRep != null) {
                    for(String line : throwableStrRep) {
                        writer.write(line);
                        writer.write(Layout.LINE_SEP);
                    }
                }
            }
            
            writer.flush();
        } catch(IOException e) {
            errorHandler.error("Failed to write to writer", e, 
                    org.apache.log4j.spi.ErrorCode.WRITE_FAILURE);
        }
    }

    @Override
    public void close() {
        if(writer != null) {
            try {
                writer.close();
            } catch(IOException e) {
                errorHandler.error("Failed to close writer", e, 
                        org.apache.log4j.spi.ErrorCode.CLOSE_FAILURE);
            }
            writer = null;
        }
    }

    @Override
    public boolean requiresLayout() {
        return true;
    }
}
package Logger;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger extends Thread {
    private File file ;
    private String message;

    public Logger(String message){
        this.message = message;
    }

    private void init() {
        file = new File("log.txt") ;
    }

    public void log() {
        synchronized (Color.BLACK) {
            try {
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(message);
                fileWriter.write('\n');
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        init();
        log();
    }
}

package ru.gb.alekseev.access.files.server;

import java.nio.file.Path;

public class TelnetChannelHandle {

    public TelnetChannelHandle (){
        folder =  Path.of("C:\\");
    }

    private Path folder;
    public Path getFolder() {
        return folder;
    }
    public void setFolder(Path folder){
        this.folder = folder;
    }


    public String ProcessMessage(String message){
        String result;
        try {
            CommandProcessor processor = CommandProcessor.parse(message, this);
            result =processor.Process();
        }
        catch (Exception exc){
            result = exc.getMessage();
        }
        return result + CommandProcessor.NEW_LINE + folder + ">";
    }

}


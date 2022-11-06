package ru.gb.alekseev.access.files.server;

import java.io.IOException;
import java.util.Locale;
import java.util.function.Function;

public abstract class CommandProcessor {

    public final static String NEW_LINE = "\r\n";

    public abstract String Process() throws IOException;

    protected TelnetChannelHandle channelHandle;

    protected CommandProcessor (TelnetChannelHandle channelHandle){
        this.channelHandle = channelHandle;
    }

    public static CommandProcessor parse(String message, TelnetChannelHandle channelHandle) {
        //removing "new line" characters at the end
        while (message.endsWith("\r") || message.endsWith("\n")){
            if (message.length() < 2){
                return new EmptyProcessor() ;
            }
            message = message.substring(0, message.length()-2);
        }

        if (message.toLowerCase(Locale.ROOT).equals(Commands.LS)){
            return new LsCommandProcessor(channelHandle);
        }

        if (message.toLowerCase(Locale.ROOT).startsWith(Commands.CD)){
            return new CdCommandProcessor(channelHandle, FormatArgument(message, Commands.CD));
        }

        if (message.toLowerCase(Locale.ROOT).startsWith(Commands.TOUCH)){
            return new TouchCommandProcessor(channelHandle, FormatArgument(message, Commands.TOUCH));
        }
        if (message.toLowerCase(Locale.ROOT).startsWith(Commands.CAT)){
            return new CatCommandProcessor(channelHandle, FormatArgument(message, Commands.CAT));
        }

        throw new RuntimeException("Unknown command");
    }

    static String FormatArgument(String message, String command) {
         message = message.substring(command.length());
         while (message.startsWith(" ")){
             message = new StringBuilder(message).deleteCharAt(0).toString();
         }
         return message;
    }
}

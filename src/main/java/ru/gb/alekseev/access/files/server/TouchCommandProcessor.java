package ru.gb.alekseev.access.files.server;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TouchCommandProcessor extends CommandProcessor {

    private String fileName;
    protected TouchCommandProcessor(TelnetChannelHandle channelHandle, String fileName) {
        super(channelHandle);
        this.fileName = fileName;
    }

    @Override
    public String Process() throws IOException {
        Files.createFile(Paths.get(channelHandle.getFolder().toString(), fileName));
        return "";
    }
}


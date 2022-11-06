package ru.gb.alekseev.access.files.server;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CatCommandProcessor extends CommandProcessor {
    private String fileName;
    public CatCommandProcessor(TelnetChannelHandle channelHandle, String fileName) {
        super(channelHandle);
        this.fileName = fileName;
    }

    @Override
    public String Process() throws IOException {
        Path path = Paths.get(channelHandle.getFolder().toString(), fileName);
        return Files.readString(path);
    }
}

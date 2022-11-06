package ru.gb.alekseev.access.files.server;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MkDirCommandProcessor extends CommandProcessor{

    private String folderNameToCreate;
    protected MkDirCommandProcessor(TelnetChannelHandle channelHandle, String folderNameToCreate) {
        super(channelHandle);
        this.folderNameToCreate = folderNameToCreate;
    }

    @Override
    public String Process() throws IOException {
        Path folder = Paths.get(channelHandle.getFolder().toString(), folderNameToCreate);
        Files.createDirectory(folder);
        channelHandle.setFolder(folder);
        return folderNameToCreate;
    }
}

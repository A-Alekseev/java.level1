package ru.gb.alekseev.access.files.server;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CdCommandProcessor extends CommandProcessor {

    final static String DIR_UP="..";
    private final String folderName;

    protected CdCommandProcessor(TelnetChannelHandle channelHandle, String folderName) {
        super(channelHandle);
        this.folderName = folderName;
    }

    @Override
    public String Process() throws IOException {
        if (folderName.equals(DIR_UP)){
            channelHandle.setFolder(channelHandle.getFolder().getParent());
            return "";
        }

        //trying to set absolute path
        Path futureFolder = Path.of(folderName) ;
        if (Files.exists(futureFolder) && Files.isDirectory(futureFolder)) {
            channelHandle.setFolder(futureFolder.toAbsolutePath());
            return "";
        }

        //trying relative path
        futureFolder = Paths.get(channelHandle.getFolder().toString(), folderName);
        if (Files.exists(futureFolder) && Files.isDirectory(futureFolder)) {
            channelHandle.setFolder(futureFolder.toAbsolutePath());
            return "";
        }

        throw new FileNotFoundException("Directory " + folderName + " not found");
    }
}

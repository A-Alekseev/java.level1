package ru.gb.alekseev.access.files.server;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class LsCommandProcessor extends CommandProcessor {

    final static String DIRECTORY_PREFIX = "[DIR] ";

    protected LsCommandProcessor(TelnetChannelHandle channelHandle) {
        super(channelHandle);
    }


    @Override
    public String Process() throws IOException {
        StringBuilder filesList = new StringBuilder();
        return Files.list(channelHandle.getFolder())
                .map(path -> FormatFileName(path))
                .sorted()
                .collect(Collectors.joining(NEW_LINE));
    }

    private static String FormatFileName(Path path) {
        String fileName = path.getFileName().toString();
        if (Files.isDirectory(path)){
            fileName = DIRECTORY_PREFIX + " " + fileName;
        }
        return fileName;
    }
}

package ru.gb.alekseev.access.files.server;

import java.io.IOException;

public class EmptyProcessor extends CommandProcessor {
    protected EmptyProcessor() {
        super(null);
    }

    @Override
    public String Process() throws IOException {
        return "";
    }
}

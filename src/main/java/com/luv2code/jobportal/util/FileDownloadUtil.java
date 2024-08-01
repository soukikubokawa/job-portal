package com.luv2code.jobportal.util;

import jakarta.annotation.Resource;
import org.springframework.core.io.UrlResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDownloadUtil {

    private Path foundfile;

    public org.springframework.core.io.Resource getFileAsResource(String downloadDir, String fileName) throws IOException {

        Path path = Paths.get(downloadDir);
        Files.list(path).forEach(file -> {
            if (file.getFileName().toString().startsWith(fileName)) {
                foundfile = file;
            }
        });

        if (foundfile != null) {
            return new UrlResource(foundfile.toUri());
        }
        return null;
    }
}

package com.sidgupta.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

@Slf4j
public class ResourceLoader {

    public static InputStream getResource(String path) throws IOException {

        log.info("reading from : {}", path);
        InputStream stream = ResourceLoader.class.getClassLoader().getResourceAsStream(path);

        if (Objects.nonNull(stream))
            return stream;
        return Files.newInputStream(Path.of(path));

    }

}

package com.example.stockproducer.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ConsoleReader implements AutoCloseable {

    private final BufferedReader bufferedReader;

    public ConsoleReader() {
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String readObject() {

        try {
            log.info("Read object from console");
            String object = bufferedReader.readLine();

            return object;

        } catch (IOException e) {
            log.error("IOException occurred");
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<String> readMultipleObjects() {

        try {
            List<String> objects = new ArrayList<>();
            log.info("Read multiple objects from console");

            String line = null;

            while(!line.equals("")) {

                line = bufferedReader.readLine();
                objects.add(line);
            }

            return objects;

        } catch (IOException e) {
            log.error("IOException occurred");
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void close() throws Exception {
        bufferedReader.close();
    }
}

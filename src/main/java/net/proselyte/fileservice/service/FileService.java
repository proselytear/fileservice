package net.proselyte.fileservice.service;

import net.proselyte.fileservice.dto.PostDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class FileService {

    @Value("${storage.location}")
    private String FILE_PATH;

    public void writeToFile(PostDto postDto) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write("Title: " + postDto.title() + "\n");
            writer.write("Content: " + postDto.title() + "\n");
            writer.write("==================================\n");
            System.out.println("Form data written to file successfully.");
        } catch (IOException e) {
            System.err.println("Error writing form data to file: " + e.getMessage());
        }
    }

    public String readFromFile() {
        try {
            String text = Files.readString(Paths.get(FILE_PATH));
            System.out.println("Data obtained successfully.");
            return text;
        } catch (IOException e) {
            System.err.println("Error while reading file");
            return "";
        }
    }
}

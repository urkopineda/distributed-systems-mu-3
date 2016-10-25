package com.urkopineda.file;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by urko on 24/02/16.
 */
public class Browser {

    private String root;

    public Browser(String root) {
        this.root = root;
    }

    public void dirList() throws IOException {
        try {
            Files.walk(Paths.get(root)).forEach(filePath -> {
                if (Files.isRegularFile(filePath)) {
                    System.out.println(filePath);
                }
            });
        } catch (Exception e) {
            System.out.println("You have no power here!");
        }

    }

    public static void main(String [] args) {
        Browser b = new Browser("/");
        try {
            b.dirList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

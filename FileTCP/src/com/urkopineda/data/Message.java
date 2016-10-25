package com.urkopineda.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by urko on 23/02/16.
 */
public class Message {

    private final int MAX_READ = 1024;
    private ArrayList<byte []> data;

    public Message() {
        data = new ArrayList<>();
    }

    public ArrayList<byte []> insertFile(FileInputStream file) throws IOException {
        int i = 0;
        byte [] array;
        while (file.read(array = new byte[MAX_READ], (MAX_READ * i), MAX_READ) != MAX_READ) {
            data.add(array);
            i++;
        } return data;
    }

}

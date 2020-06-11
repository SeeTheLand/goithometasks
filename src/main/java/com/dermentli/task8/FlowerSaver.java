package com.dermentli.task8;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public abstract class FlowerSaver {

    public static void save(String path, Flower[] buket) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(buket);
        objectOutputStream.close();
    }


}

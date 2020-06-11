package com.dermentli.task8;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public abstract class FlowersLoader {

    public static Flower[] load(String path) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(path);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Flower[] buket = (Flower[]) objectInputStream.readObject();
        return buket;
    }
}

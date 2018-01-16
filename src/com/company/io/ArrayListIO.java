package com.company.io;

import java.io.*;
import java.util.ArrayList;

public class ArrayListIO {
    public static void write(ArrayList arrayList, String filePath) throws IOException {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos= new FileOutputStream(filePath);
            oos= new ObjectOutputStream(fos);
            oos.writeObject(arrayList);
        }
        finally {
            if (oos != null) {
                oos.close();
            }

            if (fos != null) {
                fos.close();
            }
        }
    }

    public static ArrayList read(String filePath) throws IOException, ClassNotFoundException {
        ArrayList arrayList;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(filePath);
            ois = new ObjectInputStream(fis);
            arrayList = (ArrayList) ois.readObject();

            return arrayList;
        }
        finally {
            if (ois != null) {
                ois.close();
            }

            if (fis != null) {
                fis.close();
            }
        }
    }
}

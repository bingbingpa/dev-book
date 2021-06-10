package me.bingbingpa.ch02.item9.trywithresources;

import java.io.*;

public class Copy {
    private static final int BUFFER_SIZE = 8 * 1024;

    static void copy(String src, String dst) throws IOException {
        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dst)) {
            byte[] buf = new byte[BUFFER_SIZE];
            int n;
            while ((n = in.read(buf)) >= 0)
                out.write(buf, 0, n);
        }
    }
}

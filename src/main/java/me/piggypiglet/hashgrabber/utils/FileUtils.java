package me.piggypiglet.hashgrabber.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

// ------------------------------
// Copyright (c) PiggyPiglet 2019
// https://www.piggypiglet.me
// ------------------------------
public final class FileUtils {
    public static String md5Checksum(File file) {
        try {
            InputStream fis = new FileInputStream(file);
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] buffer = new byte[1024];
            int read;

            do {
                read = fis.read(buffer);

                if (read > 0 ) {
                    digest.update(buffer, 0, read);
                }
            } while (read != -1);

            fis.close();

            byte[] checksumBytes = digest.digest();
            StringBuilder checksum = new StringBuilder();

            for (byte b : checksumBytes) {
                checksum.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }

            return checksum.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }
}
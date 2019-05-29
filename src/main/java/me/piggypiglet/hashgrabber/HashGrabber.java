package me.piggypiglet.hashgrabber;

import me.piggypiglet.hashgrabber.utils.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;

// ------------------------------
// Copyright (c) PiggyPiglet 2019
// https://www.piggypiglet.me
// ------------------------------
public final class HashGrabber {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length > 0) {
            new HashGrabber(args);
        } else {
            System.out.println("You need to supply a list of files.");
        }
    }

    private HashGrabber(String[] args) throws FileNotFoundException {
        for (String filePath : args) {
            File file = new File(filePath.replace("/", File.separator).replace("\\", File.separator));

            if (!file.exists()) {
                throw new FileNotFoundException(filePath + " doesn't exist.");
            }

            System.out.println(file.getName() + ": " + FileUtils.md5Checksum(file));
        }
    }
}
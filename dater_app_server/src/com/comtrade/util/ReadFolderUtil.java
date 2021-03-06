package com.comtrade.util;

import com.comtrade.domain.Pictures;

import java.io.File;

public class ReadFolderUtil {

    public static void main(String[] args) {
        ReadFolderUtil ReadFolderUtil = new ReadFolderUtil();
        final String directoryLinuxMac = "/Users/loiane/test";
        //Windows directory example
        final String directoryWindows = "C://test";
        ReadFolderUtil.listFiles(directoryLinuxMac);
    }

    /**
     * List all the files and folders from a directory
     *
     * @param directoryName to be listed
     */
    public void listFilesAndFolders(String directoryName, String username) {
        File directory = new File(directoryName);
        byte[] fileContent = new byte[0];

        Pictures p = new Pictures();
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList) {

        }
    }

    /**
     * List all the files under a directory
     *
     * @param directoryName to be listed
     */
    public void listFiles(String directoryName) {
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }
    }

    /**
     * List all the folder under a directory
     *
     * @param directoryName to be listed
     */
    public void listFolders(String directoryName) {
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isDirectory()) {
                System.out.println(file.getName());
            }
        }
    }

    /**
     * List all files from a directory and its subdirectories
     *
     * @param directoryName to be listed
     */
    public void listFilesAndFilesSubDirectories(String directoryName) {
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isFile()) {
                System.out.println(file.getAbsolutePath());
            } else if (file.isDirectory()) {
                listFilesAndFilesSubDirectories(file.getAbsolutePath());
            }
        }
    }
}

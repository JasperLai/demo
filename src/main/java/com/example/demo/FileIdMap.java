package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class FileIdMap {
    private Map<String, String> fileIdMap;

    public FileIdMap() {
        fileIdMap = new HashMap<>();
    }

    // Add a new entry to the map (file name, file id)
    public void addEntry(String fileName, String fileId) {
        fileIdMap.put(fileName, fileId);
    }

    // Search for entries with file names containing the search item
    public Map<String, String> findEntriesContaining(String searchItem) {
        Map<String, String> result = new HashMap<>();
        for (String fileName : fileIdMap.keySet()) {
            if (fileName.contains(searchItem)) {
                result.put(fileName, fileIdMap.get(fileName));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FileIdMap fileIdMap = new FileIdMap();
        fileIdMap.addEntry("aaa.txt", "1");
        fileIdMap.addEntry("bbb.txt", "2");
        fileIdMap.addEntry("ccc.txt", "3");

        // Search for entries by a search item
        String searchItem = "aa";
        Map<String, String> searchResult = fileIdMap.findEntriesContaining(searchItem);

        if (!searchResult.isEmpty()) {
            System.out.println("Search Results:");
            for (Map.Entry<String, String> entry : searchResult.entrySet()) {
                System.out.println("File Name: " + entry.getKey() + ", File ID: " + entry.getValue());
            }
        } else {
            System.out.println("No files found containing the search item: " + searchItem);
        }
    }
}


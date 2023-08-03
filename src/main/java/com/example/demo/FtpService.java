package com.example.demo;

import org.apache.commons.net.ftp.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FtpService {
    private static final String FTP_SERVER = "ftp.example.com";
    private static final int FTP_PORT = 21;
    private static final String FTP_USERNAME = "your-ftp-username";
    private static final String FTP_PASSWORD = "your-ftp-password";

    private static final String REMOTE_DIRECTORY = "/batch_handle/EBOND/PUBLIC/BONDFILE/";
    private static final String LOCAL_DIRECTORY = "local_directory/";

    public static void main(String[] args) {
        FtpService ftpService = new FtpService();
        ftpService.downloadAndMoveFiles();
    }

    public void downloadAndMoveFiles() {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(FTP_SERVER, FTP_PORT);
            ftpClient.login(FTP_USERNAME, FTP_PASSWORD);

            // Change to the desired directory on the FTP server
            ftpClient.changeWorkingDirectory(REMOTE_DIRECTORY);

            // Get the list of files in the directory
            FTPFile[] files = ftpClient.listFiles();

            // Create a directory to store downloaded files locally
            // If the directory doesn't exist, create it
            String localHandledDirectory = LOCAL_DIRECTORY + getFormattedDate("yyyyMMdd");
            new File(localHandledDirectory).mkdirs();

            for (FTPFile file : files) {
                if (file.isFile()) {
                    // Download the file
                    String remoteFilePath = REMOTE_DIRECTORY + file.getName();
                    String localFilePath = localHandledDirectory + "/" + file.getName();
                    downloadFile(ftpClient, remoteFilePath, localFilePath);
                }
            }

            ftpClient.logout();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // After downloading all files, move them to the "handled" subdirectory
        moveFilesToHandledSubdirectory();
    }

    private void downloadFile(FTPClient ftpClient, String remoteFilePath, String localFilePath) throws IOException {
        try (FileOutputStream outputStream = new FileOutputStream(localFilePath)) {
            ftpClient.retrieveFile(remoteFilePath, outputStream);
        }
    }

    private void moveFilesToHandledSubdirectory() {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(FTP_SERVER, FTP_PORT);
            ftpClient.login(FTP_USERNAME, FTP_PASSWORD);

            // Change to the current date directory on the FTP server
            String handledDirectory = REMOTE_DIRECTORY + getFormattedDate("yyyyMMdd") + "/handled/";
            ftpClient.changeWorkingDirectory(handledDirectory);

            // Get the list of files in the "handled" directory
            FTPFile[] files = ftpClient.listFiles();

            // Move each file to the "handled" subdirectory inside the ${yyyymmdd} directory
            for (FTPFile file : files) {
                if (file.isFile()) {
                    String originalFilePath = handledDirectory + file.getName();
                    String newFilePath = REMOTE_DIRECTORY + getFormattedDate("yyyyMMdd") + "/" + file.getName();
                    ftpClient.rename(originalFilePath, newFilePath);
                }
            }

            ftpClient.logout();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getFormattedDate(String pattern) {
        LocalDate currentDate = LocalDate.now();
        // Create a DateTimeFormatter with the desired pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        // Format the date using the formatter
        return currentDate.format(formatter);
    }
}

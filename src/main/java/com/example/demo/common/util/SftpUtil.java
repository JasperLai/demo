package com.example.demo.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Vector;

import com.jcraft.jsch.*;


public class SftpUtil {

    private String host;
    private int port;
    private String username;
    private String password;

    public static final String ROOT_PATH = "/Users/mubinlai/";

    public SftpUtil(String host, int port, String username, String password) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    public void uploadDirectory(String localPath, String remotePath) throws JSchException, SftpException {
        JSch jsch = new JSch();
        Session session = jsch.getSession(username, host, port);
        session.setPassword(password);
        session.setConfig("StrictHostKeyChecking", "no");
        session.connect();

        ChannelSftp channelSftp = (ChannelSftp) session.openChannel("sftp");
        channelSftp.connect();

        uploadDirectory(channelSftp, localPath, remotePath);

        channelSftp.disconnect();
        session.disconnect();
    }

    private void uploadDirectory(ChannelSftp channelSftp, String localPath, String remotePath) throws JSchException,SftpException {
        File localDir = new File(localPath);
        if (!localDir.isDirectory()) {
            throw new IllegalArgumentException("Local path is not a directory: " + localPath);
        }

        String[] folders = remotePath.split("/");
        StringBuilder path = new StringBuilder(ROOT_PATH);

        for (String folder : folders) {
            if (folder.length() > 0) {
                path.append(folder).append("/");
                try {
                    channelSftp.cd(path.toString()); // 尝试进入目录
                } catch (SftpException e) {
                    // 如果进入目录失败，假设目录不存在，尝试创建
                    try {
                        channelSftp.mkdir(path.toString());
                        channelSftp.cd(path.toString());
                    } catch (SftpException ex) {
                        throw new SftpException(ex.id, "Failed to create directory: " + path.toString(), ex);
                    }
                }
            }
        }

        File[] files = localDir.listFiles();
        if (files != null) {
            for (File file : files) {
                String finalPath = path.toString();

                if (file.isFile()) {
                    try {
                        channelSftp.put(new FileInputStream(file), finalPath + file.getName());
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (SftpException e) {
                        e.printStackTrace();
                    }
                } 
            }
        }
    }

    public void downloadDirectory(String remotePath, String localPath) throws JSchException, SftpException {
        JSch jsch = new JSch();
        Session session = jsch.getSession(username, host, port);
        session.setPassword(password);
        session.setConfig("StrictHostKeyChecking", "no");
        session.connect();

        ChannelSftp channelSftp = (ChannelSftp) session.openChannel("sftp");
        channelSftp.connect();

        downloadDirectory(channelSftp, remotePath, localPath);

        channelSftp.disconnect();
        session.disconnect();
    }

    private void downloadDirectory(ChannelSftp channelSftp, String remotePath, String localPath) throws SftpException {
        File localDir = new File(localPath);
        if (!localDir.exists()) {
            localDir.mkdirs();
        }

        @SuppressWarnings("unchecked")
        Vector<ChannelSftp.LsEntry> list = channelSftp.ls(remotePath);
        for (ChannelSftp.LsEntry entry : list) {
            if (!entry.getAttrs().isDir()) {
                channelSftp.get(remotePath + "/" + entry.getFilename(), localPath + "/" + entry.getFilename());
            } 
        }
    }

    public static void main(String[] args) {
        SftpUtil sftpUtil = new SftpUtil("localhost", 22, "Mubin Lai", "laimubin1");
        try {
            // sftpUtil.uploadDirectory("/Users/mubinlai/code/demo/testupload","download/asdfsdf/dsf");

            sftpUtil.downloadDirectory("download/asdfsdf/dsf", "/Users/mubinlai/code/demo/testuploadDest");
        } catch (JSchException | SftpException e) {
            e.printStackTrace();
        }
    }
}


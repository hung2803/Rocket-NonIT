package com.vti.template.utils.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * This class is Manager IO File
 * 
 * @author NNDuy
 * @version 1.0
 * @Date Oct 29, 2017
 */
public class FileIOManager {
	private static final String FILE_NOT_EXIST = "Error! File not Exist.";
	private static final String WRITE_FILE_SUCCESS = "Write file success!";
	private static final String FOLDER_NOT_EXIST_OR_NOT_FOLDER = "Error! Folder not Exist or not folder.";
	private static final String COPY_FILE_SUCCESS = "Copy file success!";
	private static final String DOWNLOAD_FILE_SUCCESS = "Download file success!";

	/**
	 * Read content file by FileInputStream
	 * 
	 * @param filePath
	 * @throws IOException
	 *             if an I/O error occurs.
	 */
	public void readFileByInputStream(String filePath) throws IOException {
		// if file not Exist
		if (!new File(filePath).exists()) {
			// show message error
			System.out.println(FILE_NOT_EXIST);
		}
		// if file exist
		// read 1024 element
		byte[] b = new byte[1024];
		// create flow input stream
		FileInputStream in = new FileInputStream(filePath);
		// get length of file. If not read then length = -1
		int length = in.read(b);
		// read content
		while (length > -1) {
			// read byte from position 0 -> length
			String content = new String(b, 0, length);
			System.out.println(content + "\n " + length);
			// continue read file from position read(b)
			length = in.read(b);
		}
		// close input stream
		in.close();
	}

	/**
	 * Read content file by BufferedReader
	 * 
	 * @param filePath
	 * @throws IOException
	 *             if an I/O error occurs.
	 */
	public void readFileBufferedReader(String filePath) throws IOException {
		// if file not Exist
		if (!new File(filePath).exists()) {
			// show message error
			System.out.println(FILE_NOT_EXIST);
		}
		// if file exist
		// Open file
		BufferedReader input = new BufferedReader(new FileReader(filePath));
		String line;
		// Repeat access until end of input
		while ((line = input.readLine()) == null) {
			System.out.println(line);
		}
		// close Buffered
		input.close();
	}

	/**
	 * Read content file by RandomAccessFile
	 * 
	 * @param filePath
	 * @throws IOException
	 *             if an I/O error occurs.
	 */
	public void readFileByRandomAccessFile(String filePath) throws IOException {
		// if file not Exist
		if (!new File(filePath).exists()) {
			// show message error
			System.out.println(FILE_NOT_EXIST);
		}
		// if file exist
		// RandomAccessFile default cann't read UTF-8
		// would like UTF-8 ==> search RandomAccessFile read utf-8
		// w is write
		// r is read
		try {
			RandomAccessFile random = new RandomAccessFile(filePath, "rw");
			// randomAccessFile.seek(); // lay con tro tra ve vi tri nao
			// tra ve vi tri con tro
			// randomAccessFile.getFilePointer();
			while (random.getFilePointer() < random.length()) {
				// readLine() is read 1 line in file
				System.out.println(random.readLine());
			}
			// close random
			random.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Write File By Output Stream
	 * 
	 * @param filePath
	 *            - path file to write
	 * @param content
	 *            - content write to file
	 * @throws IOException
	 *             if an I/O error occurs.
	 */
	public void writeFileByOutputStream(String filePath, String content) throws IOException {
		File file = new File(filePath);
		// if file not Exist
		if (!file.exists()) {
			// show message error
			System.out.println(FILE_NOT_EXIST);
		}
		// if file exist
		// create output stream
		// false(default) is write from head
		// true is continue write to file
		try {
			FileOutputStream output = new FileOutputStream(file, true);
			// write file by byte
			output.write(content.getBytes());
			output.close();
			// show message success
			System.out.println(WRITE_FILE_SUCCESS);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Write File By BufferedWriter
	 * 
	 * @param filePath
	 *            - path file to write
	 * @param content
	 *            - content write to file
	 * @throws IOException
	 *             if an I/O error occurs.
	 */
	public void writeFileByBufferedWriter(String filePath, String content) throws IOException {
		// if file not Exist
		if (!new File(filePath).exists()) {
			// show message error
			System.out.println(FILE_NOT_EXIST);
		}
		// if file exist
		// create output
		BufferedWriter output = new BufferedWriter(new FileWriter(filePath));
		// write file by byte
		output.write(content);
		output.newLine();
		output.close();
		// show message success
		System.out.println(WRITE_FILE_SUCCESS);
	}

	/**
	 * Copy file to folder
	 * 
	 * @param pathFileFrom
	 *            - path of file
	 * @param pathFolderTo
	 *            - path of folder
	 * @return true if copy file success, false if file is not exist or folder
	 *         is not exist or not folder
	 * 
	 * @throws IOException
	 *             if an I/O error occurs.
	 */
	public boolean copyFile(String pathFileFrom, String pathFolderTo) throws IOException {
		// if file not Exist
		if (!new File(pathFileFrom).exists()) {
			// show message error
			System.out.println(FILE_NOT_EXIST);
			return false;
		}

		// if folder not Exist or not folder
		File folder = new File(pathFolderTo);
		if (!folder.exists() || !folder.isDirectory()) {
			// show message error
			System.out.println(FOLDER_NOT_EXIST_OR_NOT_FOLDER);
			return false;
		}

		// if file exist and folder
		// get name file
		String s[] = pathFileFrom.split("/");
		String name = s[s.length - 1];
		// create pathFolderTo = pathFolderTo/name
		pathFolderTo += "/" + name;
		try {
			// create flow input and output stream
			FileInputStream input = new FileInputStream(pathFileFrom);
			FileOutputStream output = new FileOutputStream(pathFolderTo);
			byte[] b = new byte[1024];
			// get length of file. If not read then length = -1
			int length = input.read(b);
			while (length != -1) {
				// write content of file from position 0 -> length to output
				output.write(b, 0, length);
				// continue read file from position read(b)
				length = input.read(b);
			}
			// close input and output
			input.close();
			output.close();
			// show message
			System.out.println(COPY_FILE_SUCCESS);
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Download file from Internet
	 * 
	 * @param link
	 *            - link ends with jpg
	 * @param folderSave
	 *            - forder save
	 * 
	 * @return true if download file success, false if folder not exist is not
	 *         exist or not folder
	 * 
	 * @throws MalformedURLException
	 *             enter link invalid format
	 */
	public boolean downloadFile(String link, String folderSave) throws MalformedURLException, IOException {
		// if folder not Exist or not folder
		File folder = new File(folderSave);
		if (!folder.exists() || !folder.isDirectory()) {
			// show message error
			System.out.println(FOLDER_NOT_EXIST_OR_NOT_FOLDER);
			return false;
		}
		// if folder exist
		// get name file
		String s[] = link.split("/");
		String name = s[s.length - 1];
		folderSave = folderSave + "/" + name;
		// create connection to URL
		URL url = new URL(link);
		// open connection
		URLConnection connection = url.openConnection();
		// get size of file
		int size = connection.getContentLength();
		// read file from Internet use InputStream
		InputStream in = connection.getInputStream();
		// save file use FileOutputStream
		FileOutputStream output = new FileOutputStream(folderSave);
		int byteDownloaded = 0;
		byte[] b = new byte[1024];
		// get length of file. If not read then length = -1
		int length = in.read(b);
		while (length != -1) {
			byteDownloaded += length;
			// print % byte downloaded
			System.out.println(byteDownloaded * 100f / size + "%");
			// write content downloaded from position 0 -> length to output
			output.write(b, 0, length);
			length = in.read(b);
		}
		// close
		output.close();
		in.close();
		// show message
		System.out.println(DOWNLOAD_FILE_SUCCESS);
		return true;
	}

}

package com.vti.template.utils.file;

import java.io.File;
import java.io.IOException;

/**
 * This class is manager file
 *
 * @author NNDuy
 * @version 1.0
 * @Date Oct 29, 2017
 */
public class FileManager {

	private static final String FILE_NOT_EXIST = "Error! File not Exist.";
	private static final String FILE_EXIST = "Error! File Exist.";
	private static final String CREATE_FILE_SUCCESS = "Create file success!";
	private static final String RENAME_FILE_SUCCESS = "Rename file success!";
	private static final String NOT_FOLDER = "Error! Not folder.";
	private static final String DELETE_FILE_SUCCESS = "Delete file success!";
	private static final String FILE_SOURCE_NOT_EXIST = "Error! File source not Exist.";
	private static final String FILE_DESTINATION_NOT_EXIST = "Error! File destination not Exist.";

	private File file;

	/**
	 * Constructor for class FileManager
	 * 
	 * @param filePath
	 */
	public FileManager(String filePath) {
		// create file and points to the filePath
		file = new File(filePath);
	}

	/**
	 * Check File Exist
	 * 
	 * @return true if file Exist, false if file not Exist
	 *
	 */
	public boolean checkFileExist() {
		return (file.exists());
	}

	/**
	 * Create new file
	 * 
	 * @return true if create success, false if file exist
	 * @throws IOException
	 *             If an I/O error occurred
	 *
	 */
	public boolean createNewFile() throws IOException {
		// if file Exist
		if (checkFileExist()) {
			// Show message error
			System.out.println(FILE_EXIST);
			return false;
		}
		// if file not Exist
		// Create new File
		file.createNewFile();
		// Show message
		System.out.println(CREATE_FILE_SUCCESS);
		return true;

	}

	/**
	 * Delete file
	 * 
	 * @return true if delete file success, false if file not exist
	 *
	 */
	public boolean deleteFile() {
		// if file not exist
		if (!checkFileExist()) {
			// Show message
			System.out.println(FILE_NOT_EXIST);
			return false;
		}
		// if file Exist
		// Delete file
		file.delete();
		// Show message
		System.out.println(DELETE_FILE_SUCCESS);
		return true;
	}

	/**
	 * Check filePath is folder
	 * 
	 * @return true if filePath is folder, false if filePath is not exist or
	 *         file
	 *
	 */
	public boolean checkIsFolder() {
		return file.isDirectory();
	}

	/**
	 * Rename file or Move file
	 * 
	 * @param filePathNew
	 *            - file path new
	 * @return true if rename file success, false if file not exist or file
	 *         destination exist
	 */
	public boolean renameFile(String filePathNew) {
		// if file source not exist
		if (!checkFileExist()) {
			// Show message error
			System.out.println(FILE_SOURCE_NOT_EXIST);
			return false;
		}
		// if file source Exist
		// create new file destination with path = filePath
		File dest = new File(filePathNew);
		// if file destination exist
		if (dest.exists()) {
			// Show message error
			System.out.println(FILE_DESTINATION_NOT_EXIST);
			return false;
		}
		// if file destination not exist
		// copy data from file to destination and delete file
		file.renameTo(dest);
		// Show message
		System.out.println(RENAME_FILE_SUCCESS);
		return true;
	}

	/**
	 * Print list file and folder in folder
	 * 
	 */
	public void printListFileInFolder() {
		// if it is not folder
		if (!checkIsFolder()) {
			// show message error
			System.out.println(NOT_FOLDER);
		}
		// if it is folder
		// get list file in folder
		String[] listName = file.list();
		for (int i = 0; i < listName.length; i++) {
			System.out.println(listName[i]);
		}
	}

	/**
	 * Print list all file and folder in folder
	 * 
	 * @param file
	 *            - enter file root
	 */
	public void printListAllFileInFolder(File file) {
		// if file is folder
		if (file.isDirectory()) {
			// Get list file in folder
			File[] arrayfile = file.listFiles();
			for (int i = 0; i < arrayfile.length; i++) {
				System.out.println(arrayfile[i].getName());
				// file.getPath() : get path file
				printListAllFileInFolder(arrayfile[i]);
			}
		}
	}
}

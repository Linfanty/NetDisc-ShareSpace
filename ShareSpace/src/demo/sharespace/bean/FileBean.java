package demo.sharespace.bean;

import java.io.Serializable;

public class FileBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4567470827709851261L;

	private String fileId;  // 文件ID
	private String fileName; // 文件名
	private String filePath; // 文件路径

	public String getFileId() { // 取文件ID
		return fileId;
	}

	public void setFileId(String fileId) {  // 设置文件ID
		this.fileId = fileId;
	}

	public String getFileName() { // 取文件名
		return fileName;
	}

	public void setFileName(String fileName) { // 设置文件名
		this.fileName = fileName;
	}

	public String getFilePath() { // 取文件路径
		return filePath;
	}

	public void setFilePath(String filePath) { // 设置文件路径
		this.filePath = filePath;
	}
	
}

package demo.sharespace.bean;

import java.io.Serializable;
import java.util.Date;

public class FileBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4567470827709851261L;

	private String fileId;  // 文件ID
	private String fileName; // 文件名
	private String filePath; // 文件路径
	private Date fileDate;
	private String filedesc;
	private String filestate;

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
	
	public Date getFileDate() {
		return fileDate;
	}
	public void setFileDate(Date FileDate) { 
		this.fileDate =  FileDate;
	}
	
	public String getFileDesc() { // 取文件desc
		return filedesc;
	}

	public void setFileDesc(String filedesc) { // 设置文件desc
		this.filedesc = filedesc;
	}
	
	public String getFileState() { // 取文件desc
		return filestate;
	}

	public void setFileState(String filestate) { // 设置文件desc
		this.filestate = filestate;
	}
}

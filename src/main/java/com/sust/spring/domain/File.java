package com.sust.spring.domain;

/**
 * 图片信息类
 */
public class File {

	private Long id;
	private String fileName;

	public File() {
		super();
	}

	public File(Long id, String fileName) {
		super();
		this.id = id;
		this.fileName = fileName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "File [id=" + id + ", fileName=" + fileName + "]";
	}

}

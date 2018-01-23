package com.nanda.rest.qube;

public class SharedFile {
	private String fileId;

	private String createdOn;

	private String bytesCompleted;

	private String fileHash;

	private String status;

	private String name;

	private String size;

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getBytesCompleted() {
		return bytesCompleted;
	}

	public void setBytesCompleted(String bytesCompleted) {
		this.bytesCompleted = bytesCompleted;
	}

	public String getFileHash() {
		return fileHash;
	}

	public void setFileHash(String fileHash) {
		this.fileHash = fileHash;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Shared File ==> [fileId = " + fileId + ", createdOn = " + createdOn + ", bytesCompleted = " + bytesCompleted
				+ ", fileHash = " + fileHash + ", status = " + status + ", name = " + name + ", size = " + size + "]";
	}
}

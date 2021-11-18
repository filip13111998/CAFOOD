package com.ftn.CAFOOD.model;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "Image")
public class Image implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long id;

    @Lob
    @Column(name = "image_content")
    private byte[] content;

    @Column(name = "image_name" ,unique = true)
    private String name;
    
    @Column(name = "image_deleted")
    private boolean delete;

    public Image() {
		
	}
    
	public Image(byte[] content, String name, boolean delete) {
		super();
		this.content = content;
		this.name = name;
		this.delete = delete;
	}

	
	
	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Image [id=" + id + ", content=" + Arrays.toString(content) + ", name=" + name + ", delete=" + delete
				+ "]";
	}
    
    
	
}

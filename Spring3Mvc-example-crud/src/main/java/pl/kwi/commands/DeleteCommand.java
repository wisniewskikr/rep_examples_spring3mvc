package pl.kwi.commands;

import java.io.Serializable;

public class DeleteCommand implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String submit;
	private Long id;
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}	
	
}

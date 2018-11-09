package com.classpost.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "post")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Post {
	
	@Id
    @Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "like")
	private Long like = (long) 0;
	
	@Column(name = "dislike")
	private Long dislike = (long) 0;
	
	@Column(name = "note")
	@ElementCollection(targetClass=Double.class)
	private List<Double> notes;
	
	@ManyToOne
    @NotNull(message = "Parent can not be null")
	@JoinColumn(name = "parent_id", referencedColumnName = "email")
    private User parent;
	
	@Column(name = "text")
    private String text;
	
	@Column(name = "location")
	private String location;

	@Lob
	@Column(name = "image")
	@NotNull(message = "image can not be null")
	@NotEmpty(message = "image can not be empty")
	private byte[] image;
	
	@Column(name = "createDate")
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalDateTime createDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getLike() {
		return like;
	}

	public void setLike(Long like) {
		this.like = like;
	}

	public Long getDislike() {
		return dislike;
	}

	public void setDislike(Long dislike) {
		this.dislike = dislike;
	}

	public List<Double> getNotes() {
		return notes;
	}

	public void setNotes(List<Double> notes) {
		this.notes = notes;
	}

	public User getParent() {
		return parent;
	}

	public void setParent(User parent) {
		this.parent = parent;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
	
	
	
}

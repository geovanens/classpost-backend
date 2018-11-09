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
	
	@ManyToOne
    @NotNull(message = "Parent can not be null")
	@JoinColumn(name = "parent_id", referencedColumnName = "email")
    private User parent;
	
	@Column(name = "positive")
	private Long positive = new Long(0);
	
	@Column(name = "negative")
	private Long negative = new Long(0);
	
	@Column(name = "note")
	@ElementCollection(targetClass=Double.class)
	private List<Double> notes;
	
	@Column(name = "text")
    private String text;
	
	@Column(name = "location")
	private String location;

	@Column(name = "image", columnDefinition="TEXT")
	@NotNull(message = "image can not be null")
	@NotEmpty(message = "image can not be empty")
	private String image;
	
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

	public User getParent() {
		return parent;
	}

	public void setParent(User parent) {
		this.parent = parent;
	}

	public Long getPositive() {
		return positive;
	}

	public void setPositive(Long positive) {
		this.positive = positive;
	}

	public Long getNegative() {
		return negative;
	}

	public void setNegative(Long negative) {
		this.negative = negative;
	}

	public List<Double> getNotes() {
		return notes;
	}

	public void setNotes(List<Double> notes) {
		this.notes = notes;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

}

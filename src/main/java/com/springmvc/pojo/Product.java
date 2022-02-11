package com.springmvc.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "products2")

public class Product implements Serializable {

	public Set<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Set<Nsx> getNsxS() {
		return nsxS;
	}

	public void setNsxS(Set<Nsx> nsxS) {
		this.nsxS = nsxS;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

//	public List<Nsx> getNsxS() {
//		return nsxS;
//	}
//
//	public void setNsxS(List<Nsx> nsxS) {
//		this.nsxS = nsxS;
//	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Size(min = 5, max = 100, message = "{product.name.sizeErr}")
	private String name;
	private String description;
	@Min(value = 10000, message = "{product.price.minErr}")
	@Max(value = 10000000, message = "{product.price.maxErr}")
	private BigDecimal price;
	private String image;

	@Column(name = "created_date")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date createDate;
	private int active;

	// many to one thi phai la eager

	@ManyToOne
	@JoinColumn(name = "category_id")
	@NotNull(message = "{product.category1.nullErr}")
	@JsonIgnore
	private Category category;

	@JsonIgnore
	@ManyToMany

	@JoinTable(name = "product_nsx", joinColumns = { @JoinColumn(name = "product_id") }, inverseJoinColumns = {
			@JoinColumn(name = "nsx_id") })

//	private List<Nsx> nsxS; ha thap phien ban jackson databind
	private Set<Nsx> nsxS;
	
	@JsonIgnore
	@OneToMany(mappedBy="product" ,fetch=FetchType.EAGER)
	private Set<Comment> comments;
	
	@JsonIgnore
	@OneToMany(mappedBy="product" )
	private Set<OrderDetail> orderDetails;

	@Transient
	private MultipartFile file;

	public Product() {

	}

}

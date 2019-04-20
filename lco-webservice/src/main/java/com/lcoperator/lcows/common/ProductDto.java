package com.lcoperator.lcows.common;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ProductDto {
	private Long catentryId;
	private String chnumber;
	private String chname;
	private String url;
	private double price;

	public Long getCatentryId() {
		return catentryId;
	}

	public void setCatentryId(Long catentryId) {
		this.catentryId = catentryId;
	}

	public String getChnumber() {
		return chnumber;
	}

	public void setChnumber(String chnumber) {
		this.chnumber = chnumber;
	}

	public String getChname() {
		return chname;
	}

	public void setChname(String chname) {
		this.chname = chname;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("catentryId", catentryId).append("chnumber", chnumber)
				.append("chname", chname).append("url", url).append("price", price).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(chname).append(catentryId).append(chnumber).append(url).append(price)
				.toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof ProductDto) == false) {
			return false;
		}
		ProductDto rhs = ((ProductDto) other);
		return new EqualsBuilder().append(chname, rhs.chname).append(catentryId, rhs.catentryId)
				.append(chnumber, rhs.chnumber).append(url, rhs.url).append(price, rhs.price).isEquals();
	}
}

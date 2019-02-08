package ru.mpryanikov.advertisement.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name="ad")
public class Ad {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ad_id")
    private Long ad_id;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    @Column(name="category_id")
    private Long category_id;

    public Long getAd_id() {
        return ad_id;
    }

    public void setAd_id(Long ad_id) {
        this.ad_id = ad_id;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public String getAd_name() {
        return ad_name;
    }

    public void setAd_name(String ad_name) {
        this.ad_name = ad_name;
    }

    public String getAd_content() {
        return ad_content;
    }

    public void setAd_content(String ad_content) {
        this.ad_content = ad_content;
    }

    public String getAd_phone() {
        return ad_phone;
    }

    public void setAd_phone(String ad_phone) {
        this.ad_phone = ad_phone;
    }

    @Column(name="ad_name")
    private String ad_name;

    @Column(name="ad_content")
    private String ad_content;

    @Column(name="ad_phone")
    private String ad_phone;

}

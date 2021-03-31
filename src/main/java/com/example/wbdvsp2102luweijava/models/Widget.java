package com.example.wbdvsp2102luweijava.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="widgets")
public class Widget {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id; // Unique identifier for this widget
  private String topicId; // Topic this lesson belongs to
  private String type; // Type of the widget, e.g., Heading, List, Paragraph, Image, YouTube, HTML, Link
  private Integer size; // Useful to represent size of widget, e.g., heading size
  private String text; // Plain text useful for heading text, paragraph text, link text, etc
  private String name; // Optional name of the widget
  private Boolean ordered; // widget list isOrdered
  private String src; // Absolute or relative URL referring to online resource
  private String url;
  private String href;
  private Integer width; // Widget's horizontal
  private Integer height; // vertical size
  private String cssClass; // CSS class implementing some CSS rule and transformations configured in some CSS rule
  private String style; // CSS transformations applied to the widget
  private String value; // Some arbitrary initial value interpreted by the widget

  public Widget() {
  }

  public Widget(Long id) {
    this.id = id;
  }

  public Widget(String topicId, String type, Integer size, String text, String name, Boolean ordered,
      String src, String url, String href, Integer width, Integer height, String cssClass, String style,
      String value) {
    this.topicId = topicId;
    this.type = type;
    this.size = size;
    this.text = text;
    this.name = name;
    this.ordered = ordered;
    this.src = src;
    this.url = url;
    this.href = href;
    this.width = width;
    this.height = height;
    this.cssClass = cssClass;
    this.style = style;
    this.value = value;
  }

  public Widget(Long id, String topicId, String type, Integer size, String text, String name, Boolean ordered,
      String src, String url, String href, Integer width, Integer height, String cssClass, String style,
      String value) {
    this.id = id;
    this.topicId = topicId;
    this.type = type;
    this.size = size;
    this.text = text;
    this.name = name;
    this.ordered = ordered;
    this.src = src;
    this.url = url;
    this.href = href;
    this.width = width;
    this.height = height;
    this.cssClass = cssClass;
    this.style = style;
    this.value = value;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTopicId() {
    return topicId;
  }

  public void setTopicId(String topicId) {
    this.topicId = topicId;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Boolean getOrdered() {
    return ordered;
  }

  public void setOrdered(Boolean ordered) {
    this.ordered = ordered;
  }

  public String getSrc() {
    return src;
  }

  public void setSrc(String src) {
    this.src = src;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public Integer getWidth() {
    return width;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }

  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public String getCssClass() {
    return cssClass;
  }

  public void setCssClass(String cssClass) {
    this.cssClass = cssClass;
  }

  public String getStyle() {
    return style;
  }

  public void setStyle(String style) {
    this.style = style;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}

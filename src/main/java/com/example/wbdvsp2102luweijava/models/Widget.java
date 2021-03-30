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
  private Long id;
  private String topicId;
  private String type;
  private Integer size;
  private String text;
  private String name;
  private Integer widgetOrder;
  private String resourceUrl;
  private Integer width;
  private Integer height;
  private String cssClass;
  private String style;
  private String value;

  public Widget() {
  }

  public Widget(Long id) {
    this.id = id;
  }

  public Widget(String topicId, String type, Integer size, String text, String name, Integer widgetOrder,
      String resourceUrl, Integer width, Integer height, String cssClass, String style, String value) {
    this.topicId = topicId;
    this.type = type;
    this.size = size;
    this.text = text;
    this.name = name;
    this.widgetOrder = widgetOrder;
    this.resourceUrl = resourceUrl;
    this.width = width;
    this.height = height;
    this.cssClass = cssClass;
    this.style = style;
    this.value = value;
  }

  public Widget(Long id, String topicId, String type, Integer size, String text, String name,
      Integer widgetOrder, String resourceUrl, Integer width, Integer height, String cssClass, String style,
      String value) {
    this.id = id;
    this.topicId = topicId;
    this.type = type;
    this.size = size;
    this.text = text;
    this.name = name;
    this.widgetOrder = widgetOrder;
    this.resourceUrl = resourceUrl;
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

  public Integer getWidgetOrder() {
    return widgetOrder;
  }

  public void setWidgetOrder(Integer widgetOrder) {
    this.widgetOrder = widgetOrder;
  }

  public String getResourceUrl() {
    return resourceUrl;
  }

  public void setResourceUrl(String resourceUrl) {
    this.resourceUrl = resourceUrl;
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

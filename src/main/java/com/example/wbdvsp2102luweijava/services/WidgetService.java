package com.example.wbdvsp2102luweijava.services;

import com.example.wbdvsp2102luweijava.models.Widget;
import com.example.wbdvsp2102luweijava.repositories.WidgetRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WidgetService {

  @Autowired
  WidgetRepository repository;

//  private List<Widget> widgets = new ArrayList<>();

  public List<Widget> findAllWidgets() {
    return (List<Widget>) repository.findAll();
  }

  public List<Widget> findWidgetsForTopic(String topicId) {
    return repository.findWidgetsForTopic(topicId);
//      List<Widget> ws = new ArrayList<>();
//      for (Widget w : widgets) {
//        if (w.getTopicId().equals(topicId)) {
//          ws.add(w);
//        }
//      }
//      return ws;
  }

  public Widget createWidgetForTopic(String topicId, Widget widget) {
    widget.setTopicId(topicId);
    return repository.save(widget);
//    widget.setId((new Date()).getTime());
//    widgets.add(widget);
//    return widget;
  }

  public Integer deleteWidget(Long id) {
    repository.deleteById(id);
//      int index = -1;
//      for (int i = 0; i < widgets.size(); i++) {
//        if (widgets.get(i).getId().equals(id)) {
//          index = i;
//          widgets.remove(index);
//          return 1;
//        }
//      }
      return 1;
  }

  public Integer updateWidget(Long id, Widget widget) {
    Widget originalWidget = repository.findById(id).get();

    String topicId = widget.getTopicId();
    if (topicId != null) originalWidget.setTopicId(topicId);
    String type = widget.getType();
    if (type != null) originalWidget.setType(type);
    Integer size = widget.getSize();
    if (size != null) originalWidget.setSize(size);
    String text = widget.getText();
    if (text != null) originalWidget.setText(text);
    String name = widget.getName();
    if (name != null) originalWidget.setName(name);
    Integer widgetOrder = widget.getWidgetOrder();
    if (widgetOrder != null) originalWidget.setWidgetOrder(widgetOrder);
    String resourceUrl = widget.getResourceUrl();
    if (resourceUrl != null) originalWidget.setResourceUrl(resourceUrl);
    Integer width = widget.getWidth();
    if (width != null) originalWidget.setWidth(width);
    Integer height = widget.getHeight();
    if (height != null) originalWidget.setHeight(height);
    String cssClass = widget.getCssClass();
    if (cssClass != null) originalWidget.setCssClass(cssClass);
    String style = widget.getStyle();
    if (style != null) originalWidget.setStyle(style);
    String value = widget.getValue();
    if (value != null) originalWidget.setValue(value);

    repository.save(originalWidget);
    return 1;
//      for (int i = 0; i < widgets.size(); i++) {
//        if (widgets.get(i).getId().equals(id)) {
//          widgets.set(i, widget);
//          return 1;
//        }
//      }
//      return -1;
  }

}


// service responsibility is to maintain the data, to manipulate the data, to work with the data
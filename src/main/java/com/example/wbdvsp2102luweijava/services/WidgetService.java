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
    Widget originalWidget = findWidgetById(id);
    widget.setId(originalWidget.getId());
    repository.save(widget);
    return 1;
//      for (int i = 0; i < widgets.size(); i++) {
//        if (widgets.get(i).getId().equals(id)) {
//          widgets.set(i, widget);
//          return 1;
//        }
//      }
//      return -1;
  }

  public Widget findWidgetById(Long wid) {
    return repository.findWidgetById(wid);
  }

}


// service responsibility is to maintain the data, to manipulate the data, to work with the data
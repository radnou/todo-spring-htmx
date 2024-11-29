package com.rmoss.demohtmx.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Todos {
  private static final AtomicInteger id = new AtomicInteger(0);

  public static Todo todo(String title) {
    return new Todo(id.incrementAndGet(), title, false, "");
  }

 public static Todo todo(String title, Boolean status, String category) {
    return new Todo(id.incrementAndGet(), title, status, category);
  }
}

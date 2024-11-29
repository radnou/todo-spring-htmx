package com.rmoss.demohtmx.model;

import java.util.concurrent.atomic.AtomicInteger;

public record Todo(Integer id, String title, Boolean completed, String category) {}


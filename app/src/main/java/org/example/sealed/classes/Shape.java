package org.example.sealed.classes;

public sealed class Shape permits Circle, Square, Rectangle, WeirdShape { public void greet(){ System.out.println("Hello World Shape!"); } }

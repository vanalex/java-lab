package org.example.sealed.classes;

public sealed class Rectangle  extends Shape permits TranspRectangle, FilledRectangle { public void greet(){ System.out.println("Hello World Rectangle!"); } }

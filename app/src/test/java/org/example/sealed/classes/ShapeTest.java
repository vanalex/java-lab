package org.example.sealed.classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShapeTest {

    @Test
    void testCircleInstaceOfShape(){
        Shape circle = new Circle();
        assertInstanceOf(Circle.class, circle);
    }

    @Test
    void testSquareInstaceOfShape(){
        Shape square = new Square();
        assertInstanceOf(Square.class, square);
    }

    @Test
    void testRectangleInstaceOfShape(){
        Shape rectangle = new Rectangle();
        assertInstanceOf(Rectangle.class, rectangle);
    }

    @Test
    void testFilledRectangleInstaceOfShape(){
        Shape filledRectangle = new Rectangle();
        assertInstanceOf(Rectangle.class, filledRectangle);
        assertInstanceOf(Shape.class, filledRectangle);
    }
}
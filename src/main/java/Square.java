import bagel.*;
import bagel.util.Rectangle;

public class Square {

    private final Image image;
    private double x;
    private double y;
    private Rectangle rect;

    /** Square(double x, doubly)
     *
     *  creates a Square object at the specified x, y location
     *
     * @param x
     * @param y
     */

    public Square(double x, double y) {
        image = new Image("res/square.png");
        this.x = x;
        this.y = y;
        //this.rect = new Rectangle(x, y, image.getWidth(), image.getHeight());
    }

    /** getY()
     *
     * @return returns the square's y value, which is the center point of the square
     */

    public double getY() {
        return this.y;
    }

    /** render()
     * draws the image of the square into the game view at its current location
     */

    public void render() {
        image.draw(this.x, this.y);
    }

    /** move(double dx, double dy)
     * moves the current location of the square
     * @param dx
     * @param dy
     */

    public void move(double dx, double dy) {
        x += dx;
        y += dy;

    }

    /** getHeight()
     *
     * @returns the height of the square
     */

    public double getHeight() {
        return image.getHeight();
    }

    /** getBoundingBox()
     *
     * @return creates and returns the bounding box for the square
     */

    public Rectangle getBoundingBox() {
        return new Rectangle(x, y, image.getWidth(), image.getHeight());
    }

    public boolean checkCollision(Square movingSquare) {
        rect = new Rectangle(x, y, image.getWidth(), image.getHeight());
        return (rect.intersects(movingSquare.getBoundingBox()));
    }
}



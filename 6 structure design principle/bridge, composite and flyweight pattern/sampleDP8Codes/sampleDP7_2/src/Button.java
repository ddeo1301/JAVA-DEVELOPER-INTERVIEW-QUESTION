public class Button implements UIComponent{

    @Override
    public void draw() {
        System.out.println("drawing button");
    }

    @Override
    public void add(UIComponent component) {
        System.out.println("adding button");
    }

    @Override
    public void remove(UIComponent component) {
        System.out.println("removing button");
    }
}

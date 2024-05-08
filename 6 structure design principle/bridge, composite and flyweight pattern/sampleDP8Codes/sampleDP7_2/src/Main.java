public class Main {
    public static void main(String[] args) {
        UIComponent uiComponent = new Menu();

        uiComponent.add(new Button());
        uiComponent.add(new Button());
        Button btn = new Button(); // reference share liye
        
        uiComponent.add(btn);

        uiComponent.draw();

        uiComponent.remove(btn);


        uiComponent.draw();
    }
}
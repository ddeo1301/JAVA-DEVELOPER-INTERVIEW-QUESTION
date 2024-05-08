import java.util.ArrayList;
import java.util.List;

public class Menu implements UIComponent{
    ///Menu k andar bhot ssaaare parts ho skte hai
    //iske andar k saare parts ko main -> Children kehra hu

    List<UIComponent> children = new ArrayList<>();

    @Override
    public void draw() {
        for(UIComponent cmp: children) {
            cmp.draw();
        }
    }

    @Override
    public void add(UIComponent component) {
       children.add(component);
    }

    @Override
    public void remove(UIComponent component) {
        children.remove(component);
    }
}

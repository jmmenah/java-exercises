
import java.io.Serializable;

public class Foo implements Serializable {

    static final long serialVersionUID = 42L;

    int attr;
    String message;
    Bar[] bars;

    public Foo() {
        attr = 99;
        message = "foo";
        bars = new Bar[10];
        for (int i = 0; i < 10; i++) {
            bars[i] = new Bar(i);
        }
    }
}

class Bar implements Serializable {

    int attr;

    public Bar(int attr) {
        this.attr = attr;
    }

}

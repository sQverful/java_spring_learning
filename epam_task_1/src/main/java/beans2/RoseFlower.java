package beans2;

import org.springframework.stereotype.Component;

@Component
public class RoseFlower {
    private String name;

    public RoseFlower() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

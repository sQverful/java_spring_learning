package beans2;

import org.springframework.stereotype.Component;

@Component
public class CatAnimal {
    private String name;

    public CatAnimal() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package beans2;

import org.springframework.stereotype.Component;

@Component
public class NarcissusFlower {
    private String name;

    public NarcissusFlower() {

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package otherBeans;

public interface OtherBean {
    String name = "Just OtherBean";
    int order = -1;

    default void sayName() {
        System.out.println(name);
    }

    default void sayOrder() {
        System.out.println("My order = " + order);
    }



}

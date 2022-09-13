package core.version10;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Timer;

public class EnumTest {

    public static void main(String[] args) {
        for (Size value : Size.values()) {
            System.out.println(value.toString());
        }
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a size:");
        String input = scan.next().toUpperCase();
        // 转换成Enum类型
        Size size = Enum.valueOf(Size.class, input);
        System.out.println("Size: " + size);
        System.out.println("abbreviation: " + size.getAbbreviation());
        System.out.println("ordinal: " + size.ordinal());
        System.out.println("name: " + size.name());
    }

}


enum Size {
    // 测试ENUM
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");

    private String abbreviation;

    private Size(String abbreviation){
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

}

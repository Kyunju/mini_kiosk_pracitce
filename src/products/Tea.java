package products;

import java.util.Scanner;

public class Tea extends Product{
    private boolean isRemoveTeabag;

    public Tea(int id, String name, int price, boolean isRemoveTeabag) {
        super(id, name, price);
        this.isRemoveTeabag = isRemoveTeabag;
    }

    @Override
    public void applyOption() {
        System.out.println("티백을 제거하시겠습니까? (1)_예 (2)_아니오");
        Scanner scanner = new Scanner(System.in);
        int selectOption = Integer.parseInt(scanner.nextLine());
        if (selectOption == 1) isRemoveTeabag = true;
    }

    @Override
    public String getOptionToString() {
        return isRemoveTeabag ? "(티백제거)" : "";
    }
}

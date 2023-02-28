package products;

import java.util.Scanner;

public class Coffee extends Product{
    private boolean isAdditionalShot;

    public Coffee(int id, String name, int price, boolean isAdditionalShot) {
        super(id, name, price);
        this.isAdditionalShot = isAdditionalShot;
    }

    // 옵션 적용해주기
    // - 상품에 따라 옵션을 물어봐주고 입력 받기
    // - 입력한 옵션을 적용해주기
    // - 옵션 선택 내용을 문자열로 만들어주기


    @Override
    public void applyOption() {
        System.out.println("샷을 추가하시겠습니까? (1)_예 (2)_아니오");
        Scanner scanner = new Scanner(System.in);
        int selectOption = Integer.parseInt(scanner.nextLine());
        if (selectOption == 1) isAdditionalShot = true;
    }

    @Override
    public String getOptionToString() {
        return isAdditionalShot ? "(샷추가)" : "";
    }
}

import java.util.InputMismatchException;
import java.util.Scanner;

public class Supermarket {
    public static void main(String[] args) {
        System.out.println("재민마켓 온 것을 환영합니다!!!");
        Scanner scanner = new Scanner(System.in);
        Goods[] goodsArr = new Goods[5];
        int index = 0;
        boolean onoff = true;
        int menu = 0;

        for(int n = 0; n< goodsArr.length; n++){
            goodsArr[n] = new Goods();
        }



        while(onoff){
            try {
                menu = 0;
                System.out.println("\n1. 상품 등록 / 2. 상품 조회 / 3. 결제 / 4. 사용조회");
                System.out.print("메뉴를 선택하세요. >> ");

                menu = scanner.nextInt();

            }
            catch (InputMismatchException e){
                System.out.println("숫자만 입력해주세요");
                scanner.next();
            }
            switch (menu){
                case 1:
                    if(index >=5){
                        System.out.println("등록 칸이 다 찼습니다.");
                        continue;
                    }
                    else {
                        System.out.print("상품을 등록해주세요>> ");
                        String name = scanner.next();
                        System.out.print("생산일자 입력>> ");
                        String pDate = scanner.next();
                        System.out.print("원가격을 입력해 주세요>>");
                        int price = scanner.nextInt();

                        if(pDate.equals("0")){
                            goodsArr[index] = new Goods(index, name, price);
                        }
                        else {
                            System.out.print("할인율 입력>> ");
                            float discount = scanner.nextFloat();
                            goodsArr[index] = new Goods(index, pDate, name, price, discount);
                        }
                        index++;
                    }
                    break;
                case 2:
                    for(int i=0; i<goodsArr.length; i++){
                        goodsArr[i].inform();
                    }
                    break;
                case 3:
                    System.out.print("상품ID를 입력해주세요>>");
                    int i = scanner.nextInt();
                    System.out.println(goodsArr[i].name+"의 가격은 "+goodsArr[i].discountedPrice() + "원입니다");
                   /* if(select  >= index){
                        System.out.println("해당하신 물품은 존재하지 않습니다.");
                        break;
                    }
                    else{
                        System.out.print("할인율을 입력해주세요>>");
                        float discount = scanner.nextFloat();
                        int dprice = (int)(price[select] * (100 - discount)/100);
                        System.out.println(goods[select] + "의 가격은 " + dprice + "원 입니다");
                    }*/

                case 4:
                    onoff = false;
                    break;

            }

        }


       /* System.out.print("상품을 등록해주세요>> ");
        String goods = scanner.next();

        System.out.print(goods + "가격을 입력해 주세요>>");
        int price = scanner.nextInt();

       // System.out.print(goods + "할인율을 입력해주세요>>");
       // float discount = scanner.nextFloat();
       // price = (int)(price-price*(discount/100));

        System.out.println(goods + "의 가격은 " + price + "원입니다.");*/
        scanner.close();
        System.out.println("이용해주셔서 감사합니다");


    }
}

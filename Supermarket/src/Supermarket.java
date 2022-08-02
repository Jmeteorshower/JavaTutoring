import java.util.InputMismatchException;
import java.util.Scanner;

public class Supermarket {
   /* public static void inform (Goods goods){
        goods.inform();
    }
    */

    public static void main(String[] args) {

        System.out.println("재민마켓 온 것을 환영합니다!!!");
        Scanner scanner = new Scanner(System.in);
        Goods[] goodsArr = new Goods[5];

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
                    if(Goods.index >=5){
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
                            goodsArr[Goods.index%5] = new Goods(Goods.index, name, price);
                        }
                        else {
                            System.out.print("할인율 입력>> ");
                            float discount = scanner.nextFloat();
                            System.out.print("유통깋나을 입력해주세요.>>");
                            String eDate = scanner.next();
                            if(eDate.equals("0")){
                                goodsArr[Goods.index%5] = new Goods(Goods.index, pDate, name, price, discount);
                            }
                            else{//업캐스팅
                                goodsArr[Goods.index%5] = new FreshFood(Goods.index,pDate,name, price, discount,eDate);
                            }
                        }

                        Goods.index++;
                        System.gc(); //객체 소멸
                    }
                    break;
                case 2:
                    for(int i=0; i<goodsArr.length; i++) {
                        goodsArr[i].inform();
                        //inform(goodsArr[n]);
                    }
                    break;
                case 3:
                    System.out.print("상품ID를 입력해주세요>>");
                    int i = scanner.nextInt();
                    System.out.println(goodsArr[i%5].getName()+"의 가격은 "+goodsArr[i%5].discountedPrice() + "원입니다");

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

 /*
       test a = new test();
        test b=  new test();

        a.n =0;
        b.n =10;
        int sum = Calculate.increase(a,b);
        System.out.println(a.n+", " + sum);
        */
    }
}

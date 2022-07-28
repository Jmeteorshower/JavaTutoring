public class Goods {
    public static int index=0;
    int id;
    String pDate;
    private String name;
    int price;
    float discount;

    //Goods i = new Goods();
    Goods() {
        this(0,"0000/00/00","비어 있음" , 0, 99);
    }

    Goods(int id, String name, int price) {
        this(id, "0000/00/00", name,price, 0);
    }
    Goods(int id, String pDate, String name, int price, float discount){
        this.id= id;
        this.pDate = pDate;
        this.name = name;
        this.price = price;
        this.discount = discount;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    void inform() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("상품번호: " + id + " | 상품명: "+ name + " | 가격: " + price);
        System.out.println("생산일자: " + pDate + " | 할인율: "+discount);
    }
    int discountedPrice(){
        return (int)(price - price * (discount / 100));
    }
}

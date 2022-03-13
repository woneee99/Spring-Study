package hello.core.order;

public class Order {

    private Long memberId;
    private String itemName;
    private int itemprice;
    private int discountPrice;

    public Order(Long memberId, String itemName, int itemprice, int discountPrice) {
        this.memberId = memberId;
        this.itemName = itemName;
        this.itemprice = itemprice;
        this.discountPrice = discountPrice;
    }

    public int calculatePrice(){
        return itemprice-discountPrice;
    }

    public Long getMemberId() {
        return memberId;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemprice() {
        return itemprice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "memberId=" + memberId +
                ", itemName='" + itemName + '\'' +
                ", itemprice=" + itemprice +
                ", discountPrice=" + discountPrice + '}';
    }
}
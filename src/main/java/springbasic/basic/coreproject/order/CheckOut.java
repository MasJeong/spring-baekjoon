package springbasic.basic.coreproject.order;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.domain.Persistable;
import springbasic.basic.auditing.domain.BaseDomain;

import java.io.Serializable;

@Entity
@IdClass(CheckOutPK.class)
@Getter
@Setter
@AllArgsConstructor
@ToString
public class CheckOut extends BaseDomain implements Serializable, Persistable<CheckOutPK> {

    @Id
    @GeneratedValue(generator = "sequential")
    @GenericGenerator(name = "sequential", strategy = "springbasic.basic.util.UUIDUtil")
    @Column(name = "ID")
    private String memberId;

    @Id
    @Column(name = "ITEM_NAME")
    private String itemName;

    @Column(name = "ITEM_PRICE")
    private int itemPrice;

    @Column(name = "DISCOUNT_PRICE")
    private int discountPrice;

    public int calculatePrice() {
        return itemPrice - discountPrice;
    }

    @Override
    public CheckOutPK getId() {
        return CheckOutPK.builder()
                .memberId(this.memberId)
                .itemName(this.itemName)
                .build();
    }

    @Override
    public boolean isNew() {
        return this.getFrstRegDt() == null;
    }
}

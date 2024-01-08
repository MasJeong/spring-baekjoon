package springbasic.basic.coreproject.order;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class CheckOutPK implements Serializable {

    private String memberId;

    private String itemName;
}

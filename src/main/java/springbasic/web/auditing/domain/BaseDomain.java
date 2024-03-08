package springbasic.web.auditing.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
@Setter
public abstract class BaseDomain extends BaseTimeDomain {
	@CreatedBy
    @Column(name = "FRST_RGTR_UUID", length = 20,  updatable = false)
    private String frstRgtrId;


    @LastModifiedBy
    @Column(name = "LAST_MDFR_UUID", length = 20)
    private String lastMdfcnId;
}

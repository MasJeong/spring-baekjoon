package springbasic.web.auditing.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
@Setter
public abstract class BaseTimeDomain {
	@CreatedDate
    @Column(name = "FRST_REG_DT", updatable = false)
    private LocalDateTime frstRegDt;

    @LastModifiedDate
    @Column(name = "LAST_MDFCN_DT")
    private LocalDateTime lastMdfcnDt;

}

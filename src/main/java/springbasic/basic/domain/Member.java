package springbasic.basic.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.domain.Persistable;
import springbasic.basic.auditing.domain.BaseDomain;
import springbasic.basic.enums.Grade;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member extends BaseDomain implements Serializable, Persistable<String> {

    @Id
//    auto_increment -> custom uuid generate
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(generator = "sequential")
    @GenericGenerator(name = "sequential", strategy = "springbasic.basic.util.UUIDUtil")
    @Column(name = "ID")
    private String memberId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "GRADE")
    private Grade grade;

    @Override
    public String getId() {
        return this.getMemberId();
    }

    @Override
    public boolean isNew() {
        return this.getFrstRegDt() == null;
    }
}

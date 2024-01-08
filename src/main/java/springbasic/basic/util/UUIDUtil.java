package springbasic.basic.util;

import com.fasterxml.uuid.Generators;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.util.UUID;

/**
 * UUID Util
 */
public class UUIDUtil implements IdentifierGenerator {

    @Override
    public Object generate(SharedSessionContractImplementor session, Object object) {
        //sequential uuid 생성
        UUID uuid = Generators.timeBasedGenerator().generate();
        String[] arrUuid = uuid.toString().split("-");
        String strUuid = arrUuid[2] + arrUuid[1] + arrUuid[0] + arrUuid[3] + arrUuid[4];

        StringBuffer sb = new StringBuffer(strUuid);
        sb.insert(8, "-");
        sb.insert(13, "-");
        sb.insert(18, "-");
        sb.insert(23, "-");
        uuid = UUID.fromString(sb.toString());

        return uuid.toString().toLowerCase();
    }
}

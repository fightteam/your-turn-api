package org.fightteam.yourturn.api.core.domain;

import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 实体抽象结构
 * <p>
 * 注重写了hashcode方法，使用hash表注意
 *
 * @author faith
 * @since 0.0.1
 */
@Getter
@Setter
@MappedSuperclass
public abstract class AbstractEntity<T> {
    @Id
    @GeneratedValue
    private T id;
    private DateTime createTime;
    private DateTime updateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractEntity)) return false;

        AbstractEntity abstractEntity = (AbstractEntity) o;

        if (id != null ? !id.equals(abstractEntity.id) : abstractEntity.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}

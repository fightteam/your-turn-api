package org.fightteam.yourturn.api.core.domain;

import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

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
public abstract class Entity<T> {
    private T id;
    private DateTime createTime;
    private DateTime updateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entity)) return false;

        Entity entity = (Entity) o;

        if (id != null ? !id.equals(entity.id) : entity.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}

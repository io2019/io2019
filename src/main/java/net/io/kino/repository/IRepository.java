package net.io.kino.repository;
import net.io.kino.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@org.springframework.stereotype.Repository


public interface IRepository<T> {
    public boolean add(T object);
    public boolean remove(T object);
    public Collection<T> getAll();
    public boolean update(T tObject, Object object);


}

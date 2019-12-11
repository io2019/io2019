package net.io.kino.repository;

import com.sun.xml.bind.v2.TODO;
import net.io.kino.model.Order;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OrdersRepository implements JpaRepository<Order, Long>{
    private List<Order> orders;

    public Order getOrderById (Long id)
    {
        for (Order o:orders)
        {
            if(o.getId()==id) return o;
        }
        return null;
    }
    @Override
    public List<Order> findAll() {
        return orders;
    }

    @Override
    public List<Order> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Order> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Order> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return orders.size();
    }

    @Override
    public void deleteById(Long aLong) {
        orders.remove(getOrderById(aLong));
    }

    @Override
    public void delete(Order entity) {
        orders.remove(entity);
    }

    @Override
    public void deleteAll(Iterable<? extends Order> entities) {
        List<Order> temp= new ArrayList<>(orders);
        orders.removeAll(temp);
    }

    @Override
    public void deleteAll() {
        List<Order> temp= new ArrayList<>(orders);
        orders.removeAll(temp);
    }

    @Override
    public <S extends Order> S save(S entity) {
        orders.add(entity);
        return entity;
    }

    @Override
    public <S extends Order> List<S> saveAll(Iterable<S> entities) {
        for (Order o:entities)
        {
            orders.add(o);
        }
        return null;
    }

    @Override
    public Optional<Order> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Order> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Order> entities) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Order getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Order> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Order> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Order> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Order> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Order> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Order> boolean exists(Example<S> example) {
        return false;
    }

}

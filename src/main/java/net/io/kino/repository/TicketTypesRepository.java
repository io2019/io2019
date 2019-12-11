package net.io.kino.repository;


import net.io.kino.model.TicketType;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class TicketTypesRepository implements JpaRepository<TicketType, Long>,Iterable<TicketType> {
    private List<TicketType> ticketTypes;

    public boolean add(TicketType ticketType)
    {
        return false;
    }
    
    @Override
    public List<TicketType> findAll() {
        return ticketTypes;
    }

    @Override
    public List<TicketType> findAll(Sort sort) {
        return null;
    }

    @Override
    public List<TicketType> findAllById(Iterable<Long> longs) {
     return null;
    }

    @Override
    public <S extends TicketType> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends TicketType> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<TicketType> entities) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public TicketType getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends TicketType> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends TicketType> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public Page<TicketType> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends TicketType> S save(S entity) {
        return null;
    }

    @Override
    public Optional<TicketType> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public long count() {
        long counter = 0;
        for (TicketType ticketType: ticketTypes
             )
        {
            counter++; }
        return counter;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(TicketType entity) {
        ticketTypes.remove(entity);

    }

    @Override
    public void deleteAll(Iterable<? extends TicketType> entities) {
        ticketTypes.removeAll(ticketTypes);
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends TicketType> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends TicketType> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends TicketType> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends TicketType> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public Iterator<TicketType> iterator() {
        return ticketTypes.iterator();
    }
}

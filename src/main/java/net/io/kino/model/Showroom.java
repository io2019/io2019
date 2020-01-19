package net.io.kino.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@Table(name = "showrooms")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Showroom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private Integer noOfColumns;
    private Integer noOfRows;

    public Showroom(String name, int numberOfRows, int numberOfColumns) {
        this.name = name;
        this.noOfColumns = numberOfColumns;
        this.noOfRows = numberOfRows;
    }

    public Showroom() {}

    public long getId() { return id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfSeats(){
        return this.noOfRows*this.noOfColumns;
    }

    public void setNoOfRows (Integer nr) {
        this.noOfRows = nr;
    }

    public void setNoOfColumns(Integer nr) {
        this.noOfColumns = nr;
    }
}
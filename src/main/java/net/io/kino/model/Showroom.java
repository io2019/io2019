package net.io.kino.model;

import javax.persistence.*;

@Entity
@Table(name = "showrooms")
public class Showroom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Integer noOfColumns;
    private Integer noOfRows;

    public Showroom(String name, int numberOfRows, int numberOfColumns) {
        this.name = name;
        this.noOfColumns = numberOfColumns;
        this.noOfRows = numberOfRows;
    }

    public Showroom() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNoOfRows (Integer nr) {
        this.noOfRows = nr;
    }

    public Integer getNoOfRows() {
        return noOfRows;
    }

    public void setNoOfColumns(Integer nr) {
        this.noOfColumns = nr;
    }

    public Integer getNoOfColumns() {
        return noOfColumns;
    }

}

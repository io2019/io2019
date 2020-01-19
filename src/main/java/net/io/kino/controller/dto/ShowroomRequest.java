package net.io.kino.controller.dto;

import net.io.kino.model.Showroom;

public class ShowroomRequest extends Showroom {
    private String showRoomName;
    private Integer noOfColumns;
    private Integer noOfRows;

    public String getShowRoomName() { return showRoomName; }

    public void setShowRoomName(String showRoomName) { this.showRoomName = showRoomName; }

    public Integer getNoOfColumns() { return noOfColumns; }

    public void setNoOfColumns(Integer noOfColumns) { this.noOfColumns = noOfColumns; }

    public Integer getNoOfRows() { return noOfRows; }

    public void setNoOfRows(Integer noOfRows) { this.noOfRows = noOfRows; }
}

package com.shu.db.tool;

/**
 * Created by PoleToWin on 2019/4/22 21:41
 */
public class CourseTableRow {
    private int  RowIndex;
    private char[] tablerow;

    public CourseTableRow(char[] tablerow,int rowIndex) {
        RowIndex = rowIndex;
        this.tablerow = tablerow;
    }

    public int getRowIndex() {
        return RowIndex;
    }

    public void setRowIndex(int rowIndex) {
        RowIndex = rowIndex;
    }

    public char[] getTablerow() {
        return tablerow;
    }

    public void setTablerow(char[] tablerow) {
        this.tablerow = tablerow;
    }
}

package com.shu.db.tool;

import com.shu.db.entity.Elective;

/**
 * Created by PoleToWin on 2019/4/22 21:39
 */
public class MapElective {
    private char mapper;
    private Elective elective;

    public MapElective(char mapper, Elective elective) {
        this.mapper = mapper;
        this.elective = elective;
    }

    public char getMapper() {
        return mapper;
    }

    public void setMapper(char mapper) {
        this.mapper = mapper;
    }

    public Elective getElective() {
        return elective;
    }

    public void setElective(Elective elective) {
        this.elective = elective;
    }
}

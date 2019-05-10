package com.shu.db.dao;

import com.shu.db.entity.Department;
import java.util.List;

/**
 * Created by PoleToWin on 2019/5/1 17:53
 */
public interface DepartmentDao {
    List<Department> getDepartmentList();
    Department getDepartmentByYxh(String yxh);
}

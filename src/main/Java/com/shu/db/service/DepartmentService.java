package com.shu.db.service;

import com.shu.db.entity.Department;
import java.util.List;

/**
 * Created by PoleToWin on 2019/5/1 18:04
 */
public interface DepartmentService {
    List<Department> getDepartmentList();
    Department getDepartmentByYxh(String yxh);
}

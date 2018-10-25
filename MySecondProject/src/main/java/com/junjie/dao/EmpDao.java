package com.junjie.dao;

import com.junjie.model.Emp;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 刘俊杰 on 2018/10/25.
 */
public interface EmpDao {
    void addEmp(Emp emp);
    void deleteEmp(Emp emp);
    void updateEmp(Emp emp);
    Emp getEmpByEmpId(Emp emp);
    Emp getEmpByEmpAccountAndPass(Emp emp);
    Emp getEmpByEmpAccount(Emp emp);
    List<Emp> getEmpByJobId(Emp emp);
    List<Emp> getEmpByJobIdAndLimit(HashMap<String,Object> hashMap);
    List<Emp> getAllEmps();
    List<Emp> getAllEmpsByLimit(HashMap<String,Object> hashMap);

}

package com.junjie.service;

import com.junjie.model.Emp;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 刘俊杰 on 2018/10/25.
 */
public interface EmpService {
    boolean addEmp(Emp emp);
    boolean deleteEmp(Emp emp);
    boolean updateEmp(Emp emp);
    Emp getEmpByEmpId(int emp_id);
    Emp getEmpByEmpAccountAndPass(String emp_account,String emp_pass);
    Emp getEmpByEmpAccount(String emp_account);
    List<Emp> getEmpByJobId(int emp_job_id);
    List<Emp> getEmpByJobIdAndLimit(int job_id,int beginIndex,int pageSize);
    List<Emp> getAllEmps();
    List<Emp> getAllEmpsByLimit(int beginIndex,int pageSize);
}

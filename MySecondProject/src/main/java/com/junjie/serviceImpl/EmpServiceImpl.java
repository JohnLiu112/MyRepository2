package com.junjie.serviceImpl;

import com.junjie.dao.EmpDao;
import com.junjie.model.Emp;
import com.junjie.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 刘俊杰 on 2018/10/25.
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDao empDao;

    public boolean addEmp(Emp emp) {
        if (emp==null){
            return false;
        }
        empDao.addEmp(emp);
        return true;
    }

    public boolean deleteEmp(Emp emp) {
        if (emp==null){
            return false;
        }
        empDao.deleteEmp(emp);
        return true;
    }

    public boolean updateEmp(Emp emp) {
        if (emp==null){
            return false;
        }
        empDao.updateEmp(emp);
        return true;
    }

    public Emp getEmpByEmpId(int emp_id) {
        if (emp_id<1){
            return null;
        }
        Emp emp=new Emp();
        emp.setEmp_id(emp_id);
        return empDao.getEmpByEmpId(emp);
    }

    public Emp getEmpByEmpAccountAndPass(String emp_account,String emp_pass) {
        if (emp_account==null||emp_pass==null){
            return null;
        }
        Emp emp=new Emp();
        emp.setEmp_account(emp_account);
        emp.setEmp_pass(emp_pass);
        return empDao.getEmpByEmpAccountAndPass(emp);
    }

    public Emp getEmpByEmpAccount(String emp_account) {
        if (emp_account==null){
            return null;
        }
        Emp emp=new Emp();
        emp.setEmp_account(emp_account);
        return empDao.getEmpByEmpAccount(emp);
    }

    public List<Emp> getEmpByJobId(int emp_job_id) {
        if (emp_job_id<1){
            return null;
        }
        Emp emp=new Emp();
        emp.setEmp_job_id(emp_job_id);
        return empDao.getEmpByJobId(emp);
    }

    public List<Emp> getEmpByJobIdAndLimit(int job_id, int beginIndex, int pageSize) {
        if (job_id<1||beginIndex<1||pageSize<1){
            return null;
        }
        HashMap<String,Object> hashMap=new HashMap<String, Object>();
        hashMap.put("job_id",job_id);
        hashMap.put("beginIndex",beginIndex);
        hashMap.put("pageSize",pageSize);
        return empDao.getEmpByJobIdAndLimit(hashMap);
    }

    public List<Emp> getAllEmps() {
        return empDao.getAllEmps();
    }

    public List<Emp> getAllEmpsByLimit(int beginIndex, int pageSize) {
        if (beginIndex<1||pageSize<1){
            return null;
        }
        HashMap<String,Object> hashMap=new HashMap<String, Object>();
        hashMap.put("beginIndex",beginIndex);
        hashMap.put("pageSize",pageSize);
        return empDao.getEmpByJobIdAndLimit(hashMap);
    }
}

package com.mballem.tutorial;

import com.mballem.tutorial.dao.EmployeeDAO;
import com.mballem.tutorial.util.HibernateUtil;

public class EmployeeManager {
    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAO();
        //dao.get1();
        //dao.get2();
        //dao.get3();
        //dao.get4();
        //dao.get5();
        dao.get6();

        HibernateUtil.close();
    }
}
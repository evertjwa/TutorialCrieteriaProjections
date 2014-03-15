package com.mballem.tutorial.dao;

import com.mballem.tutorial.entity.Employee;
import com.mballem.tutorial.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Marcio Ballem
 * Date: 10/03/14
 * Time: 19:23
 * http://www.mballem.com
 */
public class EmployeeDAO {

    private Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }

    public void get1() {
        Criteria max = getSession().createCriteria(Employee.class)
                .setProjection(Projections.max("salary"));
        System.out.println("The highest salary : " + max.uniqueResult());

        Criteria min = getSession().createCriteria(Employee.class)
                .setProjection(Projections.min("salary"));
        System.out.println("The lowest salary: " + min.uniqueResult());

        Criteria sum = getSession().createCriteria(Employee.class)
                .setProjection(Projections.sum("salary"));
        System.out.println("Sum of salaries: " + sum.uniqueResult());

        Criteria avg = getSession().createCriteria(Employee.class)
                .setProjection(Projections.avg("salary"));
        System.out.println("Average of salaries: " + avg.uniqueResult());

        Criteria rows = getSession().createCriteria(Employee.class)
                .setProjection(Projections.rowCount());
        System.out.println("Total of rows: " + rows.uniqueResult());
    }

    /**
     * Group by state
     */
    public void get2() {
        List results = getSession().createCriteria(Employee.class)
                .setProjection(Projections.projectionList()
                        .add(Projections.rowCount())
                        .add(Projections.max("salary"))
                        .add(Projections.min("salary"))
                        .add(Projections.sum("salary"))
                        .add(Projections.avg("salary"))
                        .add(Projections.groupProperty("state"))
                )
                .list();

        for (Object objects : results) {
            Object[] o = (Object[]) objects;
            System.out.println("------------ "+ o[5] +" -------------");
            System.out.println("Number of Employees: " + o[0]);
            System.out.println("The highest salary: " + o[1]);
            System.out.println("The lowest salary: " + o[2]);
            System.out.println("Sum of salaries: " + o[3]);
            System.out.println("Average of salaries: " + o[4]);
        }
    }

    /**
     * Group by salary and Order by desc (9-0) salary.
     */
    public void get3() {
        List results = getSession().createCriteria(Employee.class)
                .setProjection(Projections.projectionList()
                        .add(Projections.rowCount())
                        .add(Projections.max("salary"))
                        .add(Projections.min("salary"))
                        .add(Projections.sum("salary"))
                        .add(Projections.avg("salary"))
                        .add(Projections.groupProperty("state").as("byOrder"))
                )
                .addOrder(Order.desc("byOrder"))
                .list();

        for (Object objects : results) {
            Object[] o = (Object[]) objects;
            System.out.println("------------ "+ o[5] +" -------------");
            System.out.println("Number of Employees: " + o[0]);
            System.out.println("The highest salary: " + o[1]);
            System.out.println("The lowest salary: " + o[2]);
            System.out.println("Sum of salaries: " + o[3]);
            System.out.println("Average of salaries: " + o[4]);
        }
    }

    /**
     * Group by state and show the employee with the highest salary to each state.
     */
    public void get4() {
        List results = getSession().createCriteria(Employee.class)
                .setProjection(Projections.projectionList()
                        .add(Projections.property("firstName"))
                        .add(Projections.property("surname"))
                        .add(Projections.property("city"))
                        .add(Projections.property("state"))
                        .add(Projections.max("salary"))
                        .add(Projections.groupProperty("state"))
                )
                .list();

        for (Object objects : results) {
            Object[] o = (Object[]) objects;
            System.out.println("-------------------------------------");
            System.out.println("Name: " + o[0] + " " + o[1]);
            System.out.println("City: " + o[2] + ", " + o[3]);
            System.out.println("The highest salary: " + o[4]);
        }
    }

    /**
     * Group by salary, counting the quantity of salaries to each value.
     */
    public void get5() {
        List results = getSession().createCriteria(Employee.class)
                .setProjection(Projections.projectionList()
                        .add(Projections.count("salary"))
                        .add(Projections.groupProperty("salary"))
                )
                .list();

        for (Object objects : results) {
            Object[] o = (Object[]) objects;
            System.out.println("-------------------------------------");
            System.out.println("Salary equal to " + o[1] + ": " + o[0]);
        }
    }

    /**
     * Show all salaries by state without repeating the same values to the same state.
     */
    public void get6() {
        List results = getSession().createCriteria(Employee.class)
                .setProjection(Projections.projectionList()
                        .add(Projections.distinct(Projections.property("salary")))
                        .add(Projections.property("state"))
                )
                .addOrder(Order.asc("state"))
                .list();

        for (Object objects : results) {
            Object[] o = (Object[]) objects;
            System.out.println("-------------------------------------");
            System.out.println("Salaries in " + o[1] + " state: " + o[0]);
        }
    }
}

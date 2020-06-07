package orm;

import java.sql.Date;

/**
 * @ProjectName: JDBCTest
 * @Package: orm
 * @ClassName: Emp
 * @Author: HAND_WEILI
 * @Description: ${description}
 * @Date: 2020/6/6 20:36
 * @Version: 1.0
 */
public class Emp {
    private int id;
    private String username;
    private Double salary;
    private Date birthday;
    private Integer age;
    public  Emp(){}

    public Emp(int id, String username, Double salary, Date birthday, Integer age) {
        this.id = id;
        this.username = username;
        this.salary = salary;
        this.birthday = birthday;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

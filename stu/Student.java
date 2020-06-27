package cn.codeaper.stu;

import java.io.Serializable;

/**
 * @description: 学生类
 * @author: qzl
 * @created: 2020/06/22 19:35
 */

public class Student implements Serializable {
    private static int NEXT_ID;   //下一位学号
    private int student_ID;   //学号
    private String name;    //姓名
    private String sex;    //性别
    private String major;   //专业
    private String faculty; //学院
    private int age;    //年龄
    private Subject subject;    //各科成绩

    static {
        NEXT_ID = 202001000;
    }

    public Student(){

        ++NEXT_ID;
        student_ID = NEXT_ID;
        name = "张三";
        sex = "男";
        major = "网络工程";
        faculty = "软件学院";
        age = 18;
        subject = new Subject();
    }


    public Student(int student_ID, String name, String sex, String major, String faculty, int age, Subject subject) {
        this.student_ID = student_ID;
        this.name = name;
        this.sex = sex;
        this.major = major;
        this.faculty = faculty;
        this.age = age;
        this.subject = subject;
    }

    public int getStudent_ID() {
        return student_ID;
    }

    public void setStudent_ID(int student_ID) {
        this.student_ID = student_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "" +
                student_ID +"   " +
                name +"   " +
                sex +"     " +
                age +"    " +
                faculty +"      " +
                major+"   " +
                subject +" " +
                "  ";
    }
}

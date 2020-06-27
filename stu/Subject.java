package cn.codeaper.stu;

import java.io.Serializable;

/**
 * @description: 学科
 * @author: qzl
 * @created: 2020/06/22 19:50
 */

public class Subject implements Serializable {
    private double math;   //数学
    private double English;    //英语
    private double cpp;    //C++
    private double net;    //网络
    private double Java;   //Java
    private double allScore; // 总成绩

    public Subject() {
        this.math = 0;
        English = 0;
        this.cpp = 0;
        this.net = 0;
        Java = 0;
        setAllScore();
    }

    public Subject(double math, double english, double cpp, double net, double java) {
            this.math = math;
            English = english;
            this.cpp = cpp;
            this.net = net;
            Java = java;
            setAllScore();
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
        setAllScore();
    }

    public double getEnglish() {
        return English;
    }

    public void setEnglish(double english) {
        English = english;
        setAllScore();
    }

    public double getCpp() {
        return cpp;
    }

    public void setCpp(double cpp) {
        this.cpp = cpp;
        setAllScore();
    }

    public double getNet() {
        return net;
    }

    public void setNet(double net) {
        this.net = net;
        setAllScore();
    }

    public double getJava() {
        return Java;
    }

    public void setJava(double java) {
        Java = java;
        setAllScore();
    }

    public double getAllScore() {
        return allScore;
    }

    private void setAllScore() {
        allScore = math + English + cpp + net + Java;
        //setAllScore();
    }

    @Override
    public String toString() {
        return "| "
                + math +" | "+
                 English +" |  "+
                + cpp +" | "+
                 + net +" | "+
                 + Java + " | "+
                allScore;
    }
}

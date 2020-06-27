package cn.codeaper.stu;

import java.util.Scanner;

/**
 * @description: 测试
 * @author: qzl
 * @created: 2020/06/22 19:36
 */

public class Main {
    public static void main(String[] args)  {
        DoStudent doStudent = new DoStudent();
        while(true){
            menu(doStudent);
        }
    }
    public static void display(){
        System.out.println("------------------------------欢迎使用学生信息管理系统------------------------------");
        System.out.println();
        System.out.println("                              1.添加信息                                          ");
        System.out.println("                              2.删除信息                                          ");
        System.out.println("                              3.修改信息                                          ");
        System.out.println("                              4.查询信息                                          ");
        System.out.println("                              5.打印信息                                          ");
        System.out.println();
        System.out.println("请输入要选择的操作[1-5]：");
    }

    public static void menu(DoStudent doStudent) {
        Scanner in = new Scanner(System.in);
        display();
        int choose = in.nextInt();
        switch (choose){
            case 1:
                doStudent.add();
                break;
            case 2:
                doStudent.delete();
                break;
            case 3:
                doStudent.change();
                break;
            case 4:
                doStudent.find();
                break;
            case 5:
                doStudent.show();
                break;
            default:
                break;
        }
    }
}

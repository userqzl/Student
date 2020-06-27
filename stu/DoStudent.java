package cn.codeaper.stu;

import java.io.*;
import java.util.*;

/**
 * @description: 操作学生信息
 * @author: qzl
 * @created: 2020/06/22 19:36
 */

public class DoStudent {


    //把容器写入文件
    private void writeFile(LinkedList<Student> list)  {

        try(PrintWriter out = new PrintWriter(
                new FileWriter("E:\\Code\\Java\\学生信息管理系统\\Student\\src\\cn\\codeaper\\stu\\stu.txt"))) {
            //PrintWriter out = new PrintWriter("E:\\Code\\Java\\学生信息管理系统\\Student\\src\\cn\\codeaper\\stu\\stu.txt","UTF-8");

            for (Student s : list) {
                out.println(s.getStudent_ID() + "|" + s.getName() + "|" + s.getSex() + "|" + s.getAge() + "|" + s.getFaculty() + "|" + s.getMajor() + "" + s.getSubject());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //读文件到容器中
    private LinkedList readFile() {

        LinkedList<Student> students = new LinkedList<>();

        Scanner in = null;
        try {
            in = new Scanner(new FileInputStream("E:\\Code\\Java\\学生信息管理系统\\Student\\src\\cn\\codeaper\\stu\\stu.txt"),"UTF-8");
        } catch (FileNotFoundException e) {
            System.out.println("文件未找到！");
            e.printStackTrace();
        }

        //处理每一行
        String line = "";
        while(in.hasNextLine()){

            line = in.nextLine();
            if(line == null || line.equals(""))  continue;   //遇到空行则跳过
            String [] tokens = line.split("\\|");
            Student student = new Student(
                    Integer.valueOf(tokens[0]),
                    tokens[1],
                    tokens[2],
                    tokens[5],
                    tokens[4],
                    Integer.valueOf(tokens[3]),
                    new Subject(
                            Double.valueOf(tokens[6].toString()),
                            Double.valueOf(tokens[7].toString()),
                            Double.valueOf(tokens[8].toString()),
                            Double.valueOf(tokens[9].toString()),
                            Double.valueOf(tokens[10].toString()))
            );

            students.add(student);
        }
        return students;
    }

    //添加信息
    public void add() {
        //创建容器。存放学生
        LinkedList<Student> students = new LinkedList<>();
        students = readFile();
        int count = 0;
        //LinkedList<Student> list = new LinkedList<>();

        Scanner in = new Scanner(System.in);
        while(true){
            Student student = new Student();
            //依次输入学生信息
            System.out.println("请输入学生信息");
            System.out.print("请输入学号: ");
            student.setStudent_ID(Integer.valueOf(in.next()));
            System.out.print("请输入姓名: ");
            student.setName(in.next());
            System.out.print("请输入性别：");
            student.setSex(in.next());
            System.out.print("请输入专业：");
            student.setMajor(in.next());
            System.out.print("请输入学院：");
            student.setFaculty(in.next());
            System.out.print("请输入年龄：");
            student.setAge(in.nextInt());
            System.out.println("--请输入各科成绩--");
            System.out.println("请依次输入数学、英语、C++、网络、Java 成绩：");
            Subject subject = new Subject();
            subject.setMath(Double.valueOf(in.next()));
            subject.setEnglish(Double.valueOf(in.next()));
            subject.setCpp(Double.valueOf(in.next()));
            subject.setNet(Double.valueOf(in.next()));
            subject.setJava(Double.valueOf(in.next()));
            student.setSubject(subject);

//            list = readFile();
//
//            if(list.contains(student)){
//                System.out.println("学生"+student.getStudent_ID()+"已存在！");
//
//            }
//            else {
            students.add(student);
            ++count;
            int choose = 2;
            System.out.println("是否继续录入？ 1.是  2.否");
            choose = in.nextInt();
            if(choose == 1) continue;
            if(choose == 2) break;
        }
        writeFile(students);
        System.out.println("添加成功！，共添加"+count+"条信息。");
    }

    //删除信息
    public void delete(){
        LinkedList<Student> students = new LinkedList<>();   //存放从文件读取的信息
        Student student = new Student();        //存放被删除的文件
        boolean isdelete = false;

        System.out.println("请输入你要删除的学生学号：");

        Scanner in = new Scanner(System.in);
        int delete_Id = in.nextInt();

        //读取信息
        students = readFile();
        ListIterator<Student> iterator = students.listIterator();
        //遍历链表
        while(iterator.hasNext()){
            student = iterator.next();
            //如果找到对应学生，删chu
            if(student.getStudent_ID() == delete_Id) {
                iterator.remove();
                System.out.println("学号：" + student.getStudent_ID() + " 姓名：" + student.getName() + " 性别：" + student.getSex() + "的学生已删除！");
                isdelete = true;
                break;
            }
        }
        if(!isdelete)
            System.out.println("学号："+delete_Id+ " 的学生不存在！");

        //写回文件
        writeFile(students);
    }

    //修改信息
    public void change(){
        LinkedList<Student> students = new LinkedList<>();   //存放从文件中读取的信息
        Student student = new Student();     //临时信息

        Scanner in = new Scanner(System.in);

        //读取信息
        students = readFile();
        System.out.println("请输入你要修改的学生学号：");
        int ID = in.nextInt();

        boolean has_stu = false;   //学生是否存在

        //找到该学生
        ListIterator<Student> iterator = students.listIterator();
        while(iterator.hasNext()){
            student = iterator.next();

            if(student.getStudent_ID() == ID){
                has_stu = true;
                break;
            }
        }

        if(has_stu){
            System.out.println("请选择要修改的信息：[ 1.姓名 2.性别 3.年龄 4.专业 5.学院 6.学号 ]");
            int choose = in.nextInt();
            switch (choose){
                case 1:
                    System.out.println("请输入修改后的姓名：");
                    String name = in.next();
                    student.setName(name);
                    System.out.println("修改成功！");
                    break;
                case 2:
                    System.out.println("请输入修改后的性别：");
                    String sex = in.next();
                    student.setSex(sex);
                    System.out.println("修改成功！");
                    break;
                case 3:
                    System.out.println("请输入修改后的年龄：");
                    int age = in.nextInt();
                    student.setAge(age);
                    System.out.println("修改成功！");
                    break;
                case 4:
                    System.out.println("请输入修改后的专业：");
                    String major = in.next();
                    student.setMajor(major);
                    System.out.println("修改成功！");
                    break;
                case 5:
                    System.out.println("请输入修改后的学院：");
                    String faculty = in.next();
                    student.setFaculty(faculty);
                    System.out.println("修改成功！");
                    break;
                case 6:
                    System.out.println("请输入修改后的学号：");
                    int id = in.nextInt();
                    student.setStudent_ID(id);
                    System.out.println("修改成功！");
                    break;
                default:
                    System.out.println("输入无效！");
                    break;
            }
            //将修改后的1信息写入文件
            writeFile(students);
        }


    }

    //查询信息
    public void find(){
        LinkedList<Student> students = new LinkedList<>();   //存放从文件中读取的信息
        Student student = new Student();     //临时信息
        boolean has_stu = false;
        int count = 0;
        Scanner in = new Scanner(System.in);

        System.out.println("请选择查询方式：1.按学号查找 2.按姓名查找  3.按年龄查找[闭区间]  4.按总分查找[闭区间]");
        int choose = in.nextInt();

        //读取文件
        students = readFile();

        switch (choose){
            case 1:
                System.out.println("请输入要查询的学号：");
                int id = in.nextInt();
                ListIterator<Student> iterator = students.listIterator();
                while(iterator.hasNext()){
                    student = iterator.next();

                    if(student.getStudent_ID() == id){
                        has_stu = true;
                        ++count;
                        if(count == 1){
                            System.out.println("查找成功！");
                            System.out.println("学    号 | 姓 名 | 性别 | 年龄 | 学      院 | 专      业 | 数学 | 英语 | C++ | 网络 | Java | 总分");
                            System.out.println("---------------------------------------------------------------------------------------------");
                        }
                        System.out.println(student);
                    }
                }
                System.out.println("---------------------------------------------------------------------------------------------");
                System.out.println("共找到"+count+"条信息！");
                if(!has_stu){
                    System.out.println("["+id+"]该学生不存在");
                }
                break;
            case 2:
                System.out.println("请输入要查询的姓名：");
                String name = in.next();
                ListIterator<Student> iterator1 = students.listIterator();
                while(iterator1.hasNext()){
                    student = iterator1.next();

                    if(student.getName().equals(name)){
                        has_stu = true;
                        ++count;
                        if(count == 1){
                            System.out.println("查找成功！");
                            System.out.println("学    号 | 姓 名 | 性别 | 年龄 | 学      院 | 专      业 | 数学 | 英语 | C++ | 网络 | Java | 总分");
                        }
                        System.out.println(student);
                    }
                }
                System.out.println("共找到"+count+"条信息！");
                if(!has_stu){
                    System.out.println("["+name+"]该学生不存在");
                }
                break;
            case 3:
                System.out.println("请输入要查询的年龄区间：");
                int minAge = in.nextInt();
                int maxAge = in.nextInt();
                ListIterator<Student> iterator2 = students.listIterator();
                while(iterator2.hasNext()){
                    student = iterator2.next();

                    if(student.getAge() >= minAge && student.getAge() <= maxAge ){
                        has_stu = true;
                        ++count;
                        if(count == 1){
                            System.out.println("查找成功！");
                            System.out.println("学    号 | 姓 名 | 性别 | 年龄 | 学      院 | 专      业 | 数学 | 英语 | C++ | 网络 | Java | 总分");
                        }
                        System.out.println(student);
                    }
                }
                System.out.println("共找到"+count+"条信息！");
                if(!has_stu){
                    System.out.println("["+minAge+"-"+maxAge+"]该学生不存在");
                }
                break;
            case 4:
                System.out.println("请输入要查询的分数区间：");
                int minScore = in.nextInt();
                int maxScore = in.nextInt();
                ListIterator<Student> iterator3= students.listIterator();
                while(iterator3.hasNext()){
                    student = iterator3.next();

                    if(student.getSubject().getAllScore() >= minScore && student.getSubject().getAllScore() <= maxScore ){
                        has_stu = true;
                        ++count;
                        if(count == 1){
                            System.out.println("查找成功！");
                            System.out.println("学    号 | 姓 名 | 性别 | 年龄 | 学      院 | 专      业 | 数学 | 英语 | C++ | 网络 | Java | 总分");
                        }
                        System.out.println(student);
                    }
                }
                System.out.println("共找到"+count+"条信息！");
                if(!has_stu){
                    System.out.println("["+minScore+"-"+maxScore+"]该学生不存在");
                }
                break;
            default:
                System.out.println("输入无效！");
                break;
        }

    }

    //打印信息
    public void show()  {
        LinkedList<Student> students = readFile();
        System.out.println("学    号 | 姓 名 | 性别 | 年龄 | 学      院 | 专      业 | 数学 | 英语 | C++ | 网络 | Java | 总分");
        System.out.println("--------------------------------------------------------------------------------------");
        for(Student s : students){
            System.out.println(s);
        }
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println();
    }
}

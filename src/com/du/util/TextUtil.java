package com.du.util;

/*
 * 文本信息的工具类
 * 以后修改文本信息，直接去修改这里就可以了
 * */
public class TextUtil {
    //welcome的界面
    //static修饰方法 1.可以直接被类名.方法（）调用 2.在内存中只有1份，其他修改，他会跟着修改
    //还有，关于static静态代码块 他一般适用于 界面场景的提前加载
    //static{
    //   这就叫做 静态代码块
    // }

    public static void welcome(){
        System.out.println("**********");
        System.out.println("先生/女士");
        System.out.println("欢迎使用ATM取款机");
        System.out.println("**********");

    }
    //客户的1级选择
    public static void oneLeveOption(){
        System.out.println("******************************");
        System.out.println("*****请输入你想要操作的类型****");
        System.out.println("******1.余额查询  2.取款******");
        System.out.println("******3.转账       4.存款*****");
        System.out.println("******5.退卡       ***********");
        System.out.println("******************************");
    }
    // static  方法名带有static 关键字的静态方法，可以直接 类名.方 法（） 调用
    public static void   doSaveMoney(){
        System.out.println("******************************");
        System.out.println("********想要取款的金额*******");
        System.out.println("********1.100      2.200********");
        System.out.println("********3.300      4.500********");
        System.out.println("********5.800      6.1000*******");
        System.out.println("********7.2000     8.其他*******");
        System.out.println("******************************");
    }


    public static void upMoneyUI(){
        System.out.println("******************************");
        System.out.println("********想要存款的金额*******");
        System.out.println("********1.100      2.200********");
        System.out.println("********3.300      4.500********");
        System.out.println("********5.800      6.1000*******");
        System.out.println("********7.2000     8.其他*******");
        System.out.println("*****注：存的钱必须为整数*******");
        System.out.println("******************************");
    }
}


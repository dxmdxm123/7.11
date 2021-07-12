package com.du.service;


import com.du.bean.Customer;
import com.du.bean.CustomerData;
import com.du.util.TextUtil;

import java.util.List;
import java.util.Scanner;

//此类是完成客户的所有业务（增删改查）
public class CustomerService {
    private List<Customer> customerList;
    private Customer currentCustomer;
    //CustomerData customerData  = CustomerData.getInstance();
    //List<Customer> customerList = customerData.getCustomerList();
    //1.查，登录 判断账号密码是否正确
    public void checkPwd(String cardid, String cardPwd) {
        CustomerData customerData = CustomerData.getInstance();
        //List-<Customer> customerList = customerData.getCustomerList();
        //1.拿到cardid中的账户名和cardPwd对list中的数据做对比
        customerList = customerData.getCustomerList();
        System.out.println("cardid = " + cardid);
        System.out.println("cardPwd = " + cardPwd);

        for (Customer customer : customerList) {
            if (customer.getAccount().equals(cardid) && customer.getPassword().equals(cardPwd)) {
                currentCustomer = customer;
                System.out.println("欢迎" + customer.getCname() + "顾客登录！请注意旁边安全");
                TextUtil.oneLeveOption(); //界面
                Scanner scanner = new Scanner(System.in);
                String option = scanner.nextLine();
                oneOption(option);
                //如何保证按了 1 3 5.. 让他再此回到此界面呢？
            }
        }
    }
    private void oneOption(String option){
        switch (option){
            case "1":
                System.out.println("余额查询");
                //当按下1之后 回退到1及选项
                doSelectMoney();

                goOneHome();
                break;
            case "2":
                System.out.println("取款");
                goOneHome();
                break;
            case "3":
                System.out.println("转账");
                goOneHome();
                break;
            case "4":
                System.out.println("存款");
                goOneHome();
                break;
            case "5":
                System.out.println("退卡");
                goOneHome();
                break;
        }
    }
    //查询余额
    private void doSelectMoney(){
        double money = currentCustomer.getMoney();
        System.out.println("余额是"+money);
    }
    private void goOneHome(){
        TextUtil.oneLeveOption();
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        System.out.println("option1 = " + option);
        oneOption(option);//递归算法a

    }
}

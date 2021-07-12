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
                //查询余额外
                doSelectMoney();
                //按下1之后 回退到1及选项
                goOneHome();
                break;
            case "2":
                goGetMoneyHome();
                goOneHome();
                break;
            case "3":
                doTruanMoney();
                goOneHome();
                break;
            case "4":
                doSaveMoney();
                goOneHome();
                break;
            case "5":
                doQuitCard();
                goOneHome();
                break;
        }
    }
    //退卡
    private void doQuitCard(){
        System.out.println("您是否继续操作yes/no[Y/N]");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (s.equalsIgnoreCase("y")) {
            TextUtil.welcome();
        }
        if (s.equalsIgnoreCase("n")) {

        }
    }

    //存款
    private  void doSaveMoney(){
        TextUtil.upMoneyUI();
        //1. 有个提示界面
        System.out.println("请输入想存金额");

        //2. scanner 收钱 余额
        Scanner scanner = new Scanner(System.in);
        String moneyIn = scanner.nextLine();
        Double moneyInInt = Double.valueOf( moneyIn);
        double newMoney = currentCustomer.getMoney()+moneyInInt;
        if (moneyIn.equals("1")){
            //取款100 应该让顾客的多100
            double money = currentCustomer.getMoney();
            money = money+100;
            System.out.println("您的余额："+money);
            currentCustomer.setMoney(money);
        }else if (moneyIn.equals("2")) {
            double money = currentCustomer.getMoney();
            money = money+200;
            System.out.println("您的余额："+money);
            currentCustomer.setMoney(money);
        }else if (moneyIn.equals("3")) {
            double money = currentCustomer.getMoney();
            money = money+300;
            System.out.println("您的余额："+money);
            currentCustomer.setMoney(money);
        }else if (moneyIn.equals("4")) {
            double money = currentCustomer.getMoney();
            money = money+500;
            System.out.println("您的余额："+money);
            currentCustomer.setMoney(money);
        }else if (moneyIn.equals("5")) {
            double money = currentCustomer.getMoney();
            money = money+800;
            System.out.println("您的余额："+money);
            currentCustomer.setMoney(money);
        }else if (moneyIn.equals("6")) {
            double money = currentCustomer.getMoney();
            money = money+1000;
            System.out.println("您的余额："+money);
            currentCustomer.setMoney(money);
        }else if (moneyIn.equals("7")) {
            double money = currentCustomer.getMoney();
            money = money+200;
            System.out.println("您的余额："+money);
            currentCustomer.setMoney(money);
        }else if(moneyIn.equals("8")){
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入您的存取钱金额：");
            int money = sc.nextInt();
            if (money>0&&money<=currentCustomer.getMoney()){
                currentCustomer.setMoney(currentCustomer.getMoney()+money);
                System.out.println("存款成功");
                System.out.println("你的当前余额为："+currentCustomer.getMoney());
            }else {
                System.out.println("输入错误");
            }
        }
        // 3.更新 当前用户余额
        currentCustomer.setMoney(newMoney);


    }


    //转账
    private  void  doTruanMoney(){
        System.out.println("请输入对方的号码：");
        Scanner scanner = new Scanner(System.in);
        String otherAccount = scanner.nextLine();
        System.out.println("请输入转账的金额");
        String otherMoney = scanner.nextLine();
        //做计算 自己的钱 -otherMoney ，别人的钱 .otherMoney
        //自己减钱
        Double otherMoneyInt = Double.parseDouble(otherMoney);
        double currenntMoney = currentCustomer.getMoney()-otherMoneyInt;//自己被减去转账后的钱
        //别人 加钱  根据otherAccount 本人的账户查询出 别人的余额，查出别人的余额后修余额
        // 因为 所有人都在 customerList 都在这个集合中 那么遍历这个集合
        Customer other = null;
        for (Customer customer : customerList) {
            //如果 customer.getAccount等于otherAccount， 那么这个人就被选出来了
            if (customer.getAccount().equals(otherAccount)) {
                other=customer;
            }
        }
        double otherOneMoney= other.getMoney() +otherMoneyInt;//别人的余额
       //自己和别人都更新以下钱数
        currentCustomer.setMoney(currenntMoney);
        other.setMoney(otherOneMoney);// 注意：  问题？ 不能成功创建对象
        for (Customer customer : customerList) {
            System.out.println("customer = " + customer);
        }


    }
    //查询余额
    private void doSelectMoney(){
        double money = currentCustomer.getMoney();
        System.out.println("余额是"+money);
    }

    //返回页目录
    private void goOneHome(){
        TextUtil.oneLeveOption();
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        System.out.println("option1 = " + option);
        oneOption(option);//递归算法

    }

    //取款
    private  void  goGetMoneyHome(){
        TextUtil.upMoneyUI();
        //让顾客输入
        Scanner scanner = new  Scanner(System.in);
        String numIn = scanner.nextLine();
        if (numIn.equals("1")){
            //取款100 应该让顾客的前少100
            double money = currentCustomer.getMoney();
            money = money-100;
            System.out.println("您的余额："+money);
            //取完款之后  更新原有的存款
            currentCustomer.setMoney(money);
        }else if (numIn.equals("2")) {
            double money = currentCustomer.getMoney();
            money = money-200;
            System.out.println("您的余额："+money);
            currentCustomer.setMoney(money);
        }else if (numIn.equals("3")) {
            double money = currentCustomer.getMoney();
            money = money-300;
            System.out.println("您的余额："+money);
            currentCustomer.setMoney(money);
        }else if (numIn.equals("4")) {
            double money = currentCustomer.getMoney();
            money = money-500;
            System.out.println("您的余额："+money);
            currentCustomer.setMoney(money);
        }else if (numIn.equals("5")) {
            double money = currentCustomer.getMoney();
            money = money-800;
            System.out.println("您的余额："+money);
            currentCustomer.setMoney(money);
        }else if (numIn.equals("6")) {
            double money = currentCustomer.getMoney();
            money = money-1000;
            System.out.println("您的余额："+money);
            currentCustomer.setMoney(money);
        }else if (numIn.equals("7")) {
            double money = currentCustomer.getMoney();
            money = money-2000;
            System.out.println("您的余额："+money);
            currentCustomer.setMoney(money);
        }else if(numIn.equals("8")) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入您的取款金额：");
            int money = sc.nextInt();
            if (money > 0 && money <= currentCustomer.getMoney()) {
                currentCustomer.setMoney(currentCustomer.getMoney() + money);
                System.out.println("存款成功");
                System.out.println("你的当前余额为：" + currentCustomer.getMoney());
            } else {
                System.out.println("输入错误");
            }

        }
    }
}

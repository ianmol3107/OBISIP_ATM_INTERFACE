package atm_interface;
import java.util.*;

public class Anmol_Atm_Interface {
    public static class atm {
        private double balance;
        private double depositAmount;
        private double withdrawAmount;
        public atm() {
        }
        public double getBalance() {
            return balance;
        }
        public void setBalance(double balance) {
            this.balance = balance;
        }
        public double getDepositAmount() {
            return depositAmount;
        }
        public void setDepositAmount(double depositAmount) {
            this.depositAmount = depositAmount;
        }
        public double getWithdrawAmount() {
            return withdrawAmount;
        }
        public void setWithdrawAmount(double withdrawAmount) {
            this.withdrawAmount = withdrawAmount;
        }

    }

    public interface AtmOperationInterface {

        public void viewBalance();
        public void withdrawAmount(double withdrawAmount);
        public void depositAmount(double depositAmount);
        public void moneyTransfer(double moneyTransfer);
        public void viewTransactionHistory();

    }

    public static class AtmOperationImpl implements AtmOperationInterface {
        String name;
        String userName;
        String password;
        int accountNo;
        float balance = 50000f;
        int transactions = 0;
        String transactionHistory = "";
        atm atm = new atm();

        @Override
        public void viewBalance() {
            System.out.println("Available Balance is :" +balance);
        }

        @Override
        public void withdrawAmount(double withdrawAmount) {

            System.out.println("Enter your amount to withdraw:- ");
            Scanner input = new Scanner(System.in);
            float amount = input.nextFloat();
            try{
                if(balance >= amount){
                    transactions++;
                    balance -= amount;
                    System.out.println("Withdraw of Amount is Successful!!!");
                    String s = "Withdrawed amount is : "+amount;
                    transactionHistory = transactionHistory.concat(s);
                }
                else{
                    System.out.println("Insufficient Balance in your account...");
                }
            }
            catch(Exception e){
            }
            viewBalance();
        }

        @Override
        public void depositAmount(double depositAmount) {
            System.out.println("Enter amount to deposit:- ");
            Scanner input = new Scanner(System.in);
            float amount = input.nextFloat();
            try{
                if(amount <= 25000f){
                    transactions++;
                    balance += amount;
                    System.out.println("Amount Successfully deposited!!!");
                    String s = "Deposited amount is : "+amount;
                    transactionHistory = transactionHistory.concat(s);
                }
                else{
                    System.out.println("Amount Limit is exceeded. Limit is Rs.25000.00 only...");
                }
            }
            catch(Exception e){
            }
            viewBalance();
        }

        @Override
        public void moneyTransfer(double moneyTransfer) {


            Scanner input = new Scanner(System.in);
            System.out.println("Enter Receipent's Name:- ");
            String receipent = input.nextLine();
            System.out.println("Enter amount to transfer:- ");
            float amount = input.nextFloat();
            try{
                if(balance >= amount){
                    if(amount <= 35000f){
                        transactions++;
                        balance -= amount;
                        System.out.println("Amount:- Rs."+amount +" is tranferred successfully to "+receipent+" !!!");
                        String s = "Amount:- Rs."+amount +" is to "+receipent+" !!!";
                        transactionHistory = transactionHistory.concat(s);
                    }
                    else{
                        System.out.println("Amount Limit is exceeded. Limit is Rs.35000.00 only...");
                    }
                }
                else{
                    System.out.println("Insufficient Balance in your account...");
                }
            }
            catch(Exception e){
            }
            viewBalance();
        }

        @Override
        public void viewTransactionHistory() {
            if(transactions == 0){
                System.out.println("No transactions done!!!");
            }
            else{
                System.out.println("Your transaction history is:- \n"+transactionHistory);
            }
            System.out.println("\n");


        }

    }


    public static void main(String[] args){

        AtmOperationInterface op= new AtmOperationImpl();
        Scanner in = new Scanner(System.in);


        System.out.println("**********Welcome To ANMOL Atm Machine********** \n");

        int atmnumber=99999;
        int atmpin=12345;
        System.out.println(" Enter Atm Number :");
        int atmNumber=in.nextInt();
        System.out.println(" Enter Atm Pin :");
        int pin=in.nextInt();
        System.out.println(" \n");

        if((atmnumber==atmNumber && atmpin==pin)) {
            System.out.println(" Validation Done...Login Successfull");
            while(true) {


                System.out.println("1. Widhdraw Amount \n2. Deposit Amount \n3. Transaction History \n4. Transfer \n5. Quit \n ");
                System.out.println("Enter Choice : ");
                int ba=in.nextInt();
                if(ba==1) {
                    System.out.println("Enter Amount to be Withdrawn ");
                    double withdrawAmount = in.nextDouble();
                    op.withdrawAmount(withdrawAmount);
                }
                if(ba==2) {
                    System.out.println(" Enter Amount to Deposit :");
                    double depositAmount = in.nextDouble();
                    op.depositAmount(depositAmount);

                }
                if(ba==3) {
                    op.viewTransactionHistory();

                }
                if(ba==4) {
                    System.out.println(" Enter Account Number :");
                    double moneyTransfer = in.nextDouble();
                    op.moneyTransfer( moneyTransfer );
                }

                if(ba==5) {
                    System.out.println("Collect Your Atm Card !!...\nThank you for using ANMOL Atm Machine!!.. ");
                    System.exit(0);
                }
            }

        }
        else {
            System.out.println(" Incorrect Atm Number or pin");
            System.exit(0);

        }
    }
}

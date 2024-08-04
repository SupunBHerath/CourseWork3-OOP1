
/*
220100093 - Supun B Herath
*/
import java.util.Scanner;

class DataBase {
    private String orderId;
    private String phoneNumber;
    private String size;
    private int qty;
    private double amount;
    private String status;
    public static final String[] defaultStatusArray = { "PROCESSING", "DELIVERING", "DELIVERED" };

    public DataBase(String orderId, String phoneNumber, String size, int qty, double amount) {
        this.orderId = orderId;
        this.phoneNumber = phoneNumber;
        this.size = size;
        this.qty = qty;
        this.amount = amount;
        this.status = defaultStatusArray[0];
    }

    // set Data method
    public void setStatus(String status) {
        this.status = status;
    }

    // get Data method
    public String getOrderId() {
        return orderId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSize() {
        return size;
    }

    public int getQty() {
        return qty;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

}

public class FashionShop {
    static int id = 0;
    public static Scanner sc = new Scanner(System.in);
    public static DataBase[] data = new DataBase[0];

    public static void arrayExtend() {
        DataBase[] temp = new DataBase[data.length + 1];
        // save to old data
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        // change the address
        data = temp;
    }

    // -----------------Clear Consoler-----------------
    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
            // Handle any exceptions.
        }
    }

    // -----------------Clear line-----------------
    public static void clearLine(int x) {
        // Move the cursor up five lines
        System.out.print("\033[" + x + "A");
        // Clear the lines
        System.out.print("\033[0J");
    }

    // -----------------placeOrder-----------------

    public static void placeOrder() {
        clearConsole();
        id++;
        System.out.println("""
                \t  _____  _                   ____          _
                \t |  __ \\| |                 / __ \\        | |
                \t | |__) | | __ _  ___ ___  | |  | |_ __ __| | ___ _ __
                \t |  ___/| |/ _` |/ __/ _ \\ | |  | | '__/ _` |/ _ \\ '__|
                \t | |    | | (_| | (_|  __/ | |__| | | | (_| |  __/ |
                \t |_|    |_|\\__,_|\\___\\___|  \\____/|_|  \\__,_|\\___|_|
                 __________________________________________________________  \n""");
        System.out.printf("\t%-40s%2s%4s%05d\n\n", "Enter Order ID", ": ", "ODR#", id);
        String OderId = String.format("%4s%05d", "ODR#", id);
        P: while (true) {
            System.out.printf("\t%-40s%2s", "Enter Customer Phone Number", ": ");
            String phoneNumberIn = sc.next();
            if (phoneNumberIn.charAt(0) != '0' || phoneNumberIn.length() != 10) {
                System.out.println("\n\t\tInvalide Phone number .. Try again \n\n");
                T: while (true) {
                    System.out.printf("\t%-40s%2s", "Do you want to enter phone number again?(y/n)  ", ": ");
                    char answer = sc.next().toLowerCase().charAt(0);
                    switch (answer) {
                        case 'y':
                            clearLine(6);
                            continue P;
                        case 'n':
                            --id;
                            Home();
                            break;

                        default:
                            clearLine(1);
                            continue T;

                    }
                }
            }
            s: while (true) {
                System.out.printf("\n\t%-40s%2s", "Enter T-Shirt Size (XS/S/M/L/XL/XXL)", ": ");
                String sizeIn = sc.next().toUpperCase();
                if (!sizeIn.equals("XS") && !sizeIn.equals("S") && !sizeIn.equals("M") && !sizeIn.equals("L")
                        && !sizeIn.equals("XL") && !sizeIn.equals("XXL")) {
                    System.out.println("\n\t\tInvalide size .. Try again \n\n");
                    T: while (true) {
                        System.out.printf("\t%-40s%2s", "Do you want to enter size again?(y/n)  ", ": ");
                        char answer = sc.next().toLowerCase().charAt(0);
                        switch (answer) {
                            case 'y':
                                clearLine(7);
                                continue s;
                            case 'n':
                                --id;
                                Home();
                                break;
                            default:
                                clearLine(1);
                                continue T;
                        }
                    }
                }
                // sc.nextLine();
                q: while (true) {
                    System.out.printf("\n\t%-40s%2s", "Enter QTY", ": ");
                    int quantity = sc.nextInt();
                    if (quantity < 0) {
                        System.out.println("\n\t\tInvalide QTY .. Try again \n\n");
                        T: while (true) {
                            System.out.printf("\t%-40s%2s", "Do you want to enter QTY again?(y/n)  ", ": ");
                            char answer = sc.next().toLowerCase().charAt(0);
                            switch (answer) {
                                case 'y':
                                    clearLine(7);
                                    continue q;
                                case 'n':
                                    --id;
                                    Home();
                                    break;
                                default:
                                    clearLine(1);
                                    continue T;
                            }
                        }
                    }
                    double amountIn = 0;
                    switch (sizeIn) {
                        case "XS":
                            amountIn = 600 * quantity;
                            break;
                        case "S":
                            amountIn = 800 * quantity;
                            break;
                        case "M":
                            amountIn = 900 * quantity;
                        case "L":
                            amountIn = 1000 * quantity;
                            break;
                        case "XL":
                            amountIn = 1100 * quantity;
                            break;
                        default:
                            amountIn = 1200 * quantity;
                            break;
                    }
                    System.out.printf("\n\t%-40s%2s%.2f\n", "Amount", ": ", amountIn);
                    T: while (true) {
                        System.out.printf("\n\t%-40s%2s", "Do you want to place this order? (y/n)", ": ");
                        char answer1 = sc.next().toLowerCase().charAt(0);
                        switch (answer1) {
                            case 'y':
                                System.out.printf("\n\n\t\t%-40s", "Oder Placed ...");
                                arrayExtend();
                                DataBase newData = new DataBase(OderId, phoneNumberIn, sizeIn, quantity, amountIn);
                                data[data.length - 1] = newData;

                                T1: while (true) {
                                    System.out.printf("\n\n\t%-40s%2s", "Do you want to place another order? (y/n)",
                                            ": ");
                                    char answer2 = sc.next().toLowerCase().charAt(0);
                                    switch (answer2) {
                                        case 'y':
                                            placeOrder();
                                        case 'n':
                                            Home();
                                            break;
                                        default:
                                            clearLine(1);
                                            continue T1;
                                    }
                                }
                            case 'n':
                                --id;
                                T1: while (true) {
                                    System.out.printf("\n\n\t%-40s%2s", "Do you want to place another order? (y/n)",
                                            ": ");
                                    char answer2 = sc.next().toLowerCase().charAt(0);
                                    switch (answer2) {
                                        case 'y':
                                            placeOrder();
                                        case 'n':
                                            Home();
                                            break;
                                        default:
                                            clearLine(2);
                                            continue T1;
                                    }
                                }
                            default:
                                clearLine(2);
                                continue T;
                        }
                    }
                }
            }
        }
    }

    // -----------------searchCustomer-----------------
    //

    public static void searchCustomer() {
        clearConsole();
        System.out.println("""
                \t   _____                     _        _____          _
                \t  / ____|                   | |      / ____|        | |
                \t | (___   ___  __ _ _ __ ___| |__   | |    _   _ ___| |_ ___  _ __ ___   ___ _ __
                \t  \\___ \\ / _ \\/ _` | '__/ __| '_ \\  | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__|
                \t  ____) |  __/ (_| | | | (__| | | | | |___| |_| \\__ \\ || (_) | | | | | |  __/ |
                \t |_____/ \\___|\\__,_|_|  \\___|_| |_|  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|
                       ___________________________________________________________________________________\n\n""");

        P: while (true) {
            System.out.printf("\t%-40s%2s", "Enter Customer Phone Number", ": ");
            String phoneNumberIn = sc.next();
            boolean isCustomer = true;
            int[] index = new int[data.length];
            int count = 0;
            if (phoneNumberIn.length() == 10 || phoneNumberIn.charAt(0) == '0') {
                for (int i = 0; i < data.length; i++) {
                    if (data[i].getPhoneNumber().equalsIgnoreCase(phoneNumberIn)) {
                        isCustomer = false;
                        index[count] = i;
                        count++;
                        continue;
                    }
                }

            }
            if (isCustomer) {
                System.out.println("\n\t\tInvalid input..  \n\n");
                T: while (true) {
                    System.out.printf("\t%-40s%2s", "Do you want to search another custmer report?(y/n)  ", ": ");
                    char answer = sc.next().toLowerCase().charAt(0);
                    switch (answer) {
                        case 'y':
                            clearLine(6);
                            continue P;
                        case 'n':
                            Home();
                            break;

                        default:
                            clearLine(1);
                            continue T;
                    }
                }
            }
            String[] temSize = { "XS", "S", "M", "L", "XL", "XXL" };
            int xsCount = 0;
            int sCount = 0;
            int mCount = 0;
            int lCount = 0;
            int xlCount = 0;
            int xxlCount = 0;
            for (int i = 0; i < count; i++) {
                switch (data[index[i]].getSize()) {
                    case "XS":
                        xsCount += data[index[i]].getQty();
                        break;
                    case "S":
                        sCount += data[index[i]].getQty();
                        break;
                    case "M":
                        mCount += data[index[i]].getQty();
                        break;
                    case "L":
                        lCount += data[index[i]].getQty();
                    case "XL":
                        xlCount += data[index[i]].getQty();
                        break;
                    default:
                        xxlCount += data[index[i]].getQty();
                        break;
                }
            }

            int[] temQty = { xsCount, sCount, mCount, lCount, xlCount, xxlCount };
            double[] temAmount = { xsCount * 600, sCount * 800, mCount * 900, lCount * 1000, xlCount * 1100,
                    xxlCount * 1200 };
            // sorted by amount
            for (int j = 0; j < temSize.length; j++) {
                for (int i = 0; i < temQty.length - 1; i++) {
                    if (temAmount[i] < temAmount[i + 1]) {
                        double tempAmount = temAmount[i];
                        temAmount[i] = temAmount[i + 1];
                        temAmount[i + 1] = tempAmount;

                        int tempQTY = temQty[i];
                        temQty[i] = temQty[i + 1];
                        temQty[i + 1] = tempQTY;

                        String tempSize = temSize[i];
                        temSize[i] = temSize[i + 1];
                        temSize[i + 1] = tempSize;
                    }
                }

            }
            System.out.println("\n\n\t\t\t+--------+--------+-------------+");
            System.out.println("\t\t\t|  Size  |   QTY  |    Amount   |");
            System.out.println("\t\t\t+--------+--------+-------------+");
            double total = 0;
            for (int i = 0; i < temSize.length; i++) {
                total += temAmount[i];
                System.out.println("\t\t\t|        |        |             |");
                System.out.printf("\t\t\t|  %-5s |  %4d  | %11.2f |\n", temSize[i], temQty[i], temAmount[i]);

            }
            System.out.println("\t\t\t|        |        |             |");
            System.out.println("\t\t\t+-----------------+-------------+");
            System.out.printf("\t\t\t| %-15s | %11.2f |", " Total Amount ", total);
            System.out.println("\n\t\t\t+-----------------+-------------+");
            L1: while (true) {
                System.out.printf("\n\n\t%-40s%2s", "Do you want to search another customer report (Y/N) ?", ": ");
                char op = sc.next().charAt(0);
                if (op == 'y' || op == 'Y') {
                    searchCustomer();
                } else if (op == 'n' || op == 'N') {
                    Home();
                } else {
                    clearLine(3);
                    continue L1;
                }
            }
        }

    }

    // --------------------- searchById ---------------------
    public static int searchById(String inputId) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].getOrderId().equals(inputId)) {
                return i;
            }
        }
        return -1;
    }
    // -----------------searchOrder-----------------

    public static void searchOrder() {
        clearConsole();
        System.out.println("""
                \t   _____                     _        ____          _
                \t  / ____|                   | |      / __ \\        | |
                \t | (___   ___  __ _ _ __ ___| |__   | |  | |_ __ __| | ___ _ __
                \t  \\___ \\ / _ \\/ _` | '__/ __| '_ \\  | |  | | '__/ _` |/ _ \\ '__|
                \t  ____) |  __/ (_| | | | (__| | | | | |__| | | | (_| |  __/ |
                \t |_____/ \\___|\\__,_|_|  \\___|_| |_|  \\____/|_|  \\__,_|\\___|_|
                        ________________________________________________________________   """);

        O: while (true) {
            System.out.printf("\n\n\t%-20s%2s", "Enter Order ID", ": ");
            String inputId = sc.next();
            int x = searchById(inputId);
            ;
            if (x >= 0) {
                System.out.printf("\n\t%-20s%2s%10s", "Phone Number", ": ", data[x].getPhoneNumber());
                System.out.printf("\n\t%-20s%2s%-10s", "Size", ": ", data[x].getSize());
                System.out.printf("\n\t%-20s%2s%-10d", "QTY", ": ", data[x].getQty());
                System.out.printf("\n\t%-20s%2s%-10.2f", "Amount", ": ", data[x].getAmount());
                System.out.printf("\n\t%-20s%2s%-10s", "Status", ": ", data[x].getStatus());
                System.out.println("\n\n");
                T: while (true) {
                    System.out.printf("\t%-30s%2s", "Do you want to search another order (Y/N) ?", ": ");
                    char answer = sc.next().toLowerCase().charAt(0);
                    switch (answer) {
                        case 'y':
                            clearLine(6);
                            continue O;
                        case 'n':
                            Home();
                            break;

                        default:
                            clearLine(1);
                            continue T;
                    }
                }
            }

            if (x < 0) {
                System.out.println("\n\n\t\tInvalid ID..\n\n");
                T: while (true) {
                    System.out.printf("\t%-30s%2s", "Do you want to search another order (Y/N) ?", ": ");
                    char answer = sc.next().toLowerCase().charAt(0);
                    switch (answer) {
                        case 'y':
                            clearLine(6);
                            continue O;
                        case 'n':
                            Home();
                            break;

                        default:
                            clearLine(1);
                            continue T;
                    }
                }

            }
        }

    }
    // -----------------viewReports-----------------

    public static void viewReports() {
        clearConsole();
        System.out.println("""
                \t  _____                       _
                \t |  __ \\                     | |      \t
                \t | |__) |___ _ __   ___  _ __| |_ ___
                \t |  _  // _ \\ '_ \\ / _ \\| '__| __/ __|
                \t | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\
                \t |_|  \\_\\___| .__/ \\___/|_|   \\__|___/
                \t            | |
                \t            |_|
                        ________________________________________""");

        System.out.println("\n\t\t[1] Best in Customers");
        System.out.println("\n\t\t[2] All Orders \n");
        L1: while (true) {
            System.out.print("\tEnter option : ");
            int op = sc.nextInt();
            switch (op) {
                case 1:
                    BestInCustomers();
                    break;
                case 2:
                    AllOrders();
                    break;
                default:
                    System.out.println("\n");

                    System.out.println("\t\tInvaild Input...!\n");
                    L5: while (true) {
                        System.out.print("\tDO you want to enter option again (Y/N) :");
                        op = sc.next().charAt(0);
                        if (op == 'y' || op == 'Y') {
                            clearLine(6);
                            continue L1;
                        } else if (op == 'n' || op == 'N') {
                            viewReports();
                        } else {
                            clearLine(1);
                            continue L5;
                        }

                    }
            }
        }
    }

    public static String[] withOutDuplicatePhoneNum() {

        String[] temPhoneArr = new String[data.length];
        int newLength = 0;

        for (int i = 0; i < data.length; i++) {
            boolean isDuplicate = false;

            for (int j = 0; j < newLength; j++) {
                if (data[i].getPhoneNumber().equals(temPhoneArr[j])) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                temPhoneArr[newLength] = data[i].getPhoneNumber();
                newLength++;
            }
        }

        String[] newPhoneArr = new String[newLength];
        for (int i = 0; i < newLength; i++) {
            newPhoneArr[i] = temPhoneArr[i];
        }

        return newPhoneArr;
    }

    public static int[] duplicatePhoneIndex(String phoneNumberIn) {

        String number = phoneNumberIn;
        int j = 0;
        int[] tem = new int[data.length];

        for (int i = 0; i < data.length; i++) {
            // thawa kalikawa array ekata save kirima
            if (data[i].getPhoneNumber().equalsIgnoreCase(number)) {
                j++;
                tem[j - 1] = i;
            }

        }
        int[] tem2 = new int[j];
        for (int i = 0; i < j; i++) {
            tem2[i] = tem[i];
        }
        return tem2;
    }

    public static void BestInCustomers() {
        clearConsole();
        System.out.println("""
                \t  ____            _     _____          _____          _
                \t |  _ \\          | |   |_   _|        / ____|        | |
                \t | |_) | ___  ___| |_    | |  _ __   | |    _   _ ___| |_ ___  _ __ ___   ___ _ __ ___
                \t |  _ < / _ \\/ __| __|   | | | '_ \\  | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__/ __|
                \t | |_) |  __/\\__ \\ |_   _| |_| | | | | |___| |_| \\__ \\ || (_) | | | | | |  __/ |  \\__ \\
                \t |____/ \\___||___/\\__| |_____|_| |_|  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|  |___/

                       _________________________________________________________________________________________ """);

        System.out.println("\n\n\t\t\t+----------------+----------+----------------+");
        System.out.println("\t\t\t|  Customer ID   | All QTY  |  Total Amount  |");
        System.out.println("\t\t\t+----------------+----------+----------------+");

        String[] uniquePhones = new String[withOutDuplicatePhoneNum().length];
        int[] totalQty = new int[withOutDuplicatePhoneNum().length];
        double[] totalAmount = new double[withOutDuplicatePhoneNum().length];

        for (int j = 0; j < withOutDuplicatePhoneNum().length; j++) {

            int[] tem = duplicatePhoneIndex(withOutDuplicatePhoneNum()[j]);

            int xsCount = 0;
            int sCount = 0;
            int mCount = 0;
            int lCount = 0;
            int xlCount = 0;
            int xxlCount = 0;

            for (int i : tem) {
                switch (data[i].getSize()) {
                    case "XS":
                        xsCount += data[i].getQty();
                        break;
                    case "S":
                        sCount += data[i].getQty();
                        break;
                    case "M":
                        mCount += data[i].getQty();
                        break;
                    case "L":
                        lCount += data[i].getQty();
                        break;
                    case "XL":
                        xlCount += data[i].getQty();
                        break;
                    case "XXL":
                        xxlCount += data[i].getQty();
                        break;

                }
            }

            double Amount = 0;
            int TotalQty = 0;
            int[] qtyTable = { xsCount, sCount, mCount, lCount, xlCount, xxlCount };
            for (int qty : qtyTable) {
                TotalQty += qty;
            }
            double[] amountTable = { xsCount * 600, sCount * 800, mCount * 900, lCount * 1000, xlCount * 1100,
                    xxlCount * 1200 };
            for (double amount : amountTable) {
                Amount += amount;
            }
            uniquePhones[j] = withOutDuplicatePhoneNum()[j];
            totalQty[j] = TotalQty;
            totalAmount[j] = Amount;

        }

        for (int i = 0; i < withOutDuplicatePhoneNum().length; i++) {
            for (int j = 0; j < totalAmount.length - 1; j++) {
                if (totalQty[j] < totalQty[j + 1]) {
                    double temamount = totalAmount[j + 1];
                    totalAmount[j + 1] = totalAmount[j];
                    totalAmount[j] = temamount;

                    int temqty = totalQty[j + 1];
                    totalQty[j + 1] = totalQty[j];
                    totalQty[j] = temqty;

                    String temphone = uniquePhones[j + 1];
                    uniquePhones[j + 1] = uniquePhones[j];
                    uniquePhones[j] = temphone;
                }
            }
        }

        for (int i = 0; i < withOutDuplicatePhoneNum().length; i++) {
            System.out.println("\t\t\t|                |          |                |");
            System.out.printf("\t\t\t|  %10s    |%6d    |%14.2f  |%n", uniquePhones[i], totalQty[i], totalAmount[i]);

        }
        System.out.println("\t\t\t|                |          |                |");
        System.out.println("\t\t\t+----------------+----------+----------------+\n\n");
        L1: while (true) {
            System.out.print("\tTo access the Main Menu , please enter 0 : ");
            char op = sc.next().charAt(0);
            switch (op) {
                case '0':
                    Home();
                    break;
                default:
                    clearLine(1); // done
                    continue L1;
            }
        }
    }

    public static void AllOrders() {
        clearConsole();
        System.out.println("""
                \t\t __      ___                  ____          _
                \t\t \\ \\    / (_)                / __ \\        | |
                \t\t  \\ \\  / / _  _____      __ | |  | |_ __ __| | ___ _ __ ___
                \t\t   \\ \\/ / | |/ _ \\ \\ /\\ / / | |  | | '__/ _` |/ _ \\ '__/ __|
                \t\t    \\  /  | |  __/\\ V  V /  | |__| | | | (_| |  __/ |  \\__ \\
                \t\t     \\/   |_|\\___| \\_/\\_/    \\____/|_|  \\__,_|\\___|_|  |___/
                        \t_____________________________________________________________   \n\n""");

        System.out.println("\t+------------+-------------+------+-------+------------+--------------+");
        System.out.println("\t|  Order ID  | Customer ID | Size |  QTy  |   Amount   |    Status    |");
        System.out.println("\t+------------+-------------+------+-------+------------+--------------+");

        for (int i = data.length - 1; i >= 0; i--) {
            System.out.println("\t|            |             |      |       |            |              |");
            System.out.printf("\t| %-7s  | %-10s  |  %-4s|   %-4d| %9.2f  |  %-12s|%n", data[i].getOrderId(),
                    data[i].getPhoneNumber(), data[i].getSize(), data[i].getQty(), data[i].getAmount(),
                    data[i].getStatus());

        }
        System.out.println("\t|            |             |      |       |            |              |");
        System.out.println("\t+------------+-------------+------+-------+------------+--------------+\n\n");
        L1: while (true) {
            System.out.print("\tTo access the Main Menu , please enter 0 : ");
            char op = sc.next().charAt(0);
            switch (op) {
                case '0':
                    Home();
                    break;
                default:
                    clearLine(1);
                    continue L1;
            }
        }
    }
    // -----------------changeOrderStatus-----------------

    public static void changeOrderStatus() {
        clearConsole();

        System.out.println("""
                \t   ____          _              _____ _        _
                \t  / __ \\        | |            / ____| |      | |
                \t | |  | |_ __ __| | ___ _ __  | (___ | |_ __ _| |_ _   _ ___
                \t | |  | | '__/ _` |/ _ \\ '__|  \\___ \\| __/ _` | __| | | / __|
                \t | |__| | | | (_| |  __/ |     ____) | || (_| | |_| |_| \\__ \\
                \t  \\____/|_|  \\__,_|\\___|_|    |_____/ \\__\\__,_|\\__|\\__,_|___/
                       ________________________________________________________________
                                                                             """);

        System.out.printf("\n\t%-20s%2s", "Enter Order ID", ": ");
        String inputId = sc.next();
        int x = searchById(inputId);

        if (x >= 0) {
            System.out.printf("\n\t%-20s%2s%10s", "Phone Number", ": ", data[x].getPhoneNumber());
            System.out.printf("\n\t%-20s%2s%-10s", "Size", ": ", data[x].getSize());
            System.out.printf("\n\t%-20s%2s%-10d", "QTY", ": ", data[x].getQty());
            System.out.printf("\n\t%-20s%2s%-10.2f", "Amount", ": ", data[x].getAmount());
            System.out.printf("\n\t%-20s%2s%-10s", "Status", ": ", data[x].getStatus());
            System.out.println("\n");

            if (data[x].getStatus().equalsIgnoreCase(DataBase.defaultStatusArray[2])) {

                System.out.println("\n\t\tCan't change this order status , Order already delivered..!\n\n");

                L3: while (true) {
                    System.out.print("\tDo you want to chage another order satatus (Y/N) : ");
                    char op3 = sc.next().charAt(0);
                    if (op3 == 'y' || op3 == 'Y') {
                        changeOrderStatus();
                    } else if (op3 == 'n' || op3 == 'N') {
                        Home();
                    } else {
                        clearLine(1);
                        continue L3;
                    }
                }
            } else {
                L1: while (true) {
                    System.out.print("\tDo you want to change this order satus (Y/N ) ? :");
                    char op = sc.next().charAt(0);

                    if (op == 'y' || op == 'Y') {
                        ordeStatusChange(x);
                    } else if (op == 'n' || op == 'N') {
                        Home();
                    } else {
                        clearLine(1);
                        continue L1;
                    }
                }
            }
        }
        if (x < 0) {
            System.out.println("\n\t\t  Invalid ID..\n");
            L5: while (true) {
                System.out.printf("\t%-30s%2s", "Do you want to search another order (Y/N) ?", ": ");
                char op = sc.next().charAt(0);
                if (op == 'y' || op == 'Y') {
                    changeOrderStatus();
                } else if (op == 'n' || op == 'N') {
                    Home();
                } else {
                    clearLine(1);
                    continue L5;
                }

            }

        }
    }

    public static void ordeStatusChange(int x) {

        if (data[x].getStatus().equalsIgnoreCase(DataBase.defaultStatusArray[0])) {
            System.out.println("\n\t\t[1] Order Delivering");
            System.out.println("\n\t\t[2] Odrer Delivered\n");

            L1: while (true) {
                System.out.print("\tEnter option : ");
                int op1 = sc.nextInt();
                switch (op1) {
                    case 1:
                        data[x].setStatus(DataBase.defaultStatusArray[1]);
                        System.out.println("\n\t\tStatus Updated..!\n");
                        L5: while (true) {
                            System.out.print("\tDo you want to change anther status (Y/N) : ");
                            char op = sc.next().charAt(0);
                            if (op == 'y' || op == 'Y') {
                                changeOrderStatus();
                                continue L1;
                            } else if (op == 'n' || op == 'N') {
                                Home();
                            } else {
                                clearLine(1);
                                continue L5;
                            }
                        }

                    case 2:
                        data[x].setStatus(DataBase.defaultStatusArray[2]);

                        System.out.println("\n\t\tStatus Updated..!\n");
                        L5: while (true) {
                            System.out.print("\tDo you want to change anther status (Y/N) : ");
                            char op = sc.next().charAt(0);
                            if (op == 'y' || op == 'Y') {
                                changeOrderStatus();
                                continue L1;
                            } else if (op == 'n' || op == 'N') {
                                Home();
                            } else {
                                clearLine(1);
                                continue L5;
                            }
                        }

                    default:
                        System.out.println("\n");
                        System.out.println("\t\tInvaild Input...!\n");
                        L5: while (true) {
                            System.out.print("\tDO you want to enter option again (Y/N) :");
                            char op = sc.next().charAt(0);
                            if (op == 'y' || op == 'Y') {
                                clearLine(6);
                                continue L1;
                            } else if (op == 'n' || op == 'N') {
                                Home();
                            } else {
                                clearLine(1);
                                continue L5;
                            }

                        }
                }
            }
        } else if (data[x].getStatus().equalsIgnoreCase(DataBase.defaultStatusArray[1])) {

            System.out.println("\n\t\t[1] Odrer Delivered\n");

            L2: while (true) {
                System.out.print("\tEnter option : ");
                int op2 = sc.nextInt();
                switch (op2) {
                    case 1:
                        System.out.println("\n\t\tStatus Updated..!\n");
                        data[x].setStatus(DataBase.defaultStatusArray[2]);
                        L6: while (true) {
                            System.out.print("\tDo you want to change anther status (Y/N) : ");

                            char op = sc.next().charAt(0);
                            if (op == 'y' || op == 'Y') {
                                changeOrderStatus();
                                continue L2;
                            } else if (op == 'n' || op == 'N') {
                                Home();
                            } else {
                                clearLine(1);
                                continue L6;
                            }

                        }

                    default:
                        System.out.println("\n");
                        System.out.println("\t\tInvaild Input...!\n");
                        L5: while (true) {
                            System.out.print("\tDO you want to enter option again (Y/N) :");
                            char op = sc.next().charAt(0);
                            if (op == 'y' || op == 'Y') {
                                clearLine(6);
                                continue L2;
                            } else if (op == 'n' || op == 'N') {
                                changeOrderStatus();
                            } else {
                                clearLine(1);
                                continue L5;
                            }

                        }
                }
            }
        }
    }

    public static void removeData(int index) {
        DataBase[] tem = new DataBase[data.length - 1];
        // save data
        for (int i = index; i < data.length - 1; i++) {
            tem[i] = data[i];
        }
        // change the address
        data = tem;
    }
    // --- --------------deleteOrer-----------------

    public static void deleteOrder() {
        clearConsole();
        System.out.println("""
                \t  _____       _      _          ____          _
                \t |  __ \\     | |    | |        / __ \\        | |
                \t | |  | | ___| | ___| |_ ___  | |  | |_ __ __| | ___ _ __
                \t | |  | |/ _ \\ |/ _ \\ __/ _ \\ | |  | | '__/ _` |/ _ \\ '__|
                \t | |__| |  __/ |  __/ ||  __/ | |__| | | | (_| |  __/ |
                \t |_____/ \\___|_|\\___|\\__\\___|  \\____/|_|  \\__,_|\\___|_|
                       ____________________________________________________________    """);

        System.out.printf("\n\n\t%-20s%2s", "Enter Order ID", ": ");
        String inputId = sc.next();
        int x = searchById(inputId);

        if (x >= 0) {
            System.out.printf("\n\t%-20s%2s%10s", "Phone Number", ": ", data[x].getPhoneNumber());
            System.out.printf("\n\t%-20s%2s%-10s", "Size", ": ", data[x].getSize());
            System.out.printf("\n\t%-20s%2s%-10d", "QTY", ": ", data[x].getQty());
            System.out.printf("\n\t%-20s%2s%-10.2f", "Amount", ": ", data[x].getAmount());
            System.out.printf("\n\t%-20s%2s%-10s", "Status", ": ", data[x].getStatus());
            if (data[x].getStatus().equalsIgnoreCase(DataBase.defaultStatusArray[0])) {

                if (data[x].getStatus().equalsIgnoreCase(DataBase.defaultStatusArray[0])
                        || data[x].getStatus().equalsIgnoreCase(DataBase.defaultStatusArray[1])) {
                    System.out.println("\n\n");
                    L0: while (true) {
                        System.out.printf("\t%-30s%2s", "Do you want to delete this order (Y/N) ?", ": ");
                        char op = sc.next().charAt(0);
                        if (op == 'y' || op == 'Y') {
                            System.out.println("\n\t\tOrder Deleted..!");
                            removeData(x);
                            System.out.println("\n");
                            L2: while (true) {
                                System.out.printf("\t%-30s%2s", "Do you want to delete another order (Y/N) ?", ": ");
                                op = sc.next().charAt(0);
                                if (op == 'y' || op == 'Y') {
                                    deleteOrder();
                                } else if (op == 'n' || op == 'N') {
                                    Home();
                                } else {
                                    clearLine(1);
                                    continue L2;
                                }
                            }
                        } else if (op == 'n' || op == 'N') {
                            Home();
                        } else {
                            clearLine(3);
                            continue L0;
                        }
                    }
                } else {
                    System.out.println("\n\n\t\tCan't delete this order , Order already deliverd..! \n\n");
                    L3: while (true) {
                        System.out.printf("\t%-30s%2s", "Do you want to delete another order (Y/N) ?", ": ");
                        char op = sc.next().charAt(0);
                        if (op == 'y' || op == 'Y') {
                            deleteOrder();
                        } else if (op == 'n' || op == 'N') {
                            Home();
                        } else {
                            clearLine(1);
                            continue L3;
                        }

                    }

                }
            }
            if (x < 0) {
                System.out.println("\n\t\tInvalid ID..\n\n");
                L2: while (true) {
                    System.out.printf("\t%-30s%2s", "Do you want to delete another order (Y/N) ?", ": ");
                    char op = sc.next().charAt(0);
                    if (op == 'y' || op == 'Y') {
                        deleteOrder();
                    } else if (op == 'n' || op == 'N') {
                        Home();
                    } else {
                        clearLine(1);
                        continue L2;
                    }

                }

            }
        }
    }

    public static void Home() {
        clearConsole();
        System.out.println(
                """
                        \t /$$$$$$$$                 /$$       /$$                            /$$$$$$  /$$
                        \t| $$_____/                | $$      |__/                           /$$__  $$| $$
                         \t| $$    /$$$$$$   /$$$$$$$| $$$$$$$  /$$  /$$$$$$  /$$$$$$$       | $$  \\__/| $$$$$$$   /$$$$$$   /$$$$$$
                        \t| $$$$$|____  $$ /$$_____/| $$__  $$| $$ /$$__  $$| $$__  $$      |  $$$$$$ | $$__  $$ /$$__  $$ /$$__  $$
                        \t| $$__/ /$$$$$$$|  $$$$$$ | $$  \\ $$| $$| $$  \\ $$| $$  \\ $$       \\____  $$| $$  \\ $$| $$  \\ $$| $$  \\ $$
                        \t| $$   /$$__  $$ \\____  $$| $$  | $$| $$| $$  | $$| $$  | $$       /$$  \\ $$| $$  | $$| $$  | $$| $$  | $$
                        \t| $$  |  $$$$$$$ /$$$$$$$/| $$  | $$| $$|  $$$$$$/| $$  | $$      |  $$$$$$/| $$  | $$|  $$$$$$/| $$$$$$$/
                        \t|__/   \\_______/|_______/ |__/  |__/|__/ \\______/ |__/  |__/       \\______/ |__/  |__/ \\______/ | $$____/
                        \t                                                                                                | $$
                        \t                                                                                                | $$
                        \t                                                                                                |__/      """);

        System.out.println(
                "    -----------------------------------------------------------------------------------------------------------------\n");
        System.out.print("\t\t[1] Place Order");
        System.out.print("\t\t\t\t\t\t[2] Search Customer\n\n");
        System.out.print("\t\t[3] Search Order");
        System.out.print("\t\t\t\t\t[4] View Reports\n\n");
        System.out.print("\t\t[5] Change Order Status ");
        System.out.print("\t\t\t\t[6] Delete Order\n\n\n   ");
        System.out.print("Input Option : ");
        char num = sc.next().charAt(0);
        switch (num) {
            case '1':
                placeOrder();
                break;
            case '2':
                searchCustomer();
                break;
            case '3':
                searchOrder();
                break;
            case '4':
                viewReports();
                break;
            case '5':
                changeOrderStatus();
                break;
            case '6':
                deleteOrder();
                break;
            default:
                Home();
                break;

        }
    }

    public static void main(String[] args) {
        Home();
    }

}

//output : -->

// __      ___                  ____          _
// \ \    / (_)                / __ \        | |
//  \ \  / / _  _____      __ | |  | |_ __ __| | ___ _ __ ___
//   \ \/ / | |/ _ \ \ /\ / / | |  | | '__/ _` |/ _ \ '__/ __|
//    \  /  | |  __/\ V  V /  | |__| | | | (_| |  __/ |  \__ \
//     \/   |_|\___| \_/\_/    \____/|_|  \__,_|\___|_|  |___/
// _____________________________________________________________


// +------------+-------------+------+-------+------------+--------------+
// |  Order ID  | Customer ID | Size |  QTy  |   Amount   |    Status    |
// +------------+-------------+------+-------+------------+--------------+
// |            |             |      |       |            |              |
// | ODR#00004  | 0782503387  |  M   |   10  |  10000.00  |  PROCESSING  |
// |            |             |      |       |            |              |
// | ODR#00003  | 0782503387  |  S   |   10  |   8000.00  |  PROCESSING  |
// |            |             |      |       |            |              |
// | ODR#00002  | 0782503389  |  XL  |   10  |  11000.00  |  PROCESSING  |
// |            |             |      |       |            |              |
// | ODR#00001  | 0782503387  |  S   |   3   |   2400.00  |  DELIVERING  |
// |            |             |      |       |            |              |
// +------------+-------------+------+-------+------------+--------------+


// To access the Main Menu , please enter 0 : 
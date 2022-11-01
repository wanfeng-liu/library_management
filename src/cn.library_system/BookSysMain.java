public class BookSysMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("**************************Welcome library**************************");
        System.out.println("Please select your roles");
        System.out.println("1. Reader");
        System.out.println("2. Manager");
        System.out.print("Please enter in:");
        String usertype = scanner.nextline();
        System.out.println(usertype);
    }
}
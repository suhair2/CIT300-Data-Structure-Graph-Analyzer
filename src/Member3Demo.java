import java.util.Scanner;

public class Member3Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedListManager list = new LinkedListManager(scanner);
        list.menu();
        scanner.close();
    }
}

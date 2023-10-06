import entities.Transaction;
import mocks.MockAccountingRecord;

public class Main {
    public static void main(String[] args) {

        var trans = MockAccountingRecord.accountRecordList();

        for (Transaction transaction : trans) {
            System.out.println(transaction);
        }
        System.out.println("---------------------------------------------------------------------------");

    }
}
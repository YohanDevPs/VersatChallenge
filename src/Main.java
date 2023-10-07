import entities.AccountRecord;
import mocks.MockAccountingRecord;
import service.TotalBalanceService;

public class Main {
    public static void main(String[] args) {

        var trans = MockAccountingRecord.accountRecordList();

        for (AccountRecord accountRecord : trans) {
            System.out.println(accountRecord);
        }
        System.out.println("---------------------------------------------------------------------------");

        var ty = new TotalBalanceService(trans);
        ty.getTotalBalance().showTotalBalance();
    }
}
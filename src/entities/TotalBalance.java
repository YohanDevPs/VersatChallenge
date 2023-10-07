package entities;

import enums.ConceptType;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class TotalBalance {

    private Set<AccountRecord> activeCurrent = new HashSet<>();
    private Set<AccountRecord> fixedActive = new HashSet<>();
    private Set<AccountRecord> passiveCurrent = new HashSet<>();
    private Set<AccountRecord> passiveLongTerm = new HashSet<>();
    private BigDecimal totalActives = BigDecimal.ZERO;
    private BigDecimal totalPassives = BigDecimal.ZERO;
    private StatementIncome statementIncome;

    public TotalBalance() {
        this.statementIncome = new StatementIncome();
    }

    public void showTotalBalance() {
        showActives();
        showPassives();
        this.statementIncome.setTotalIncome(this.totalActives);
        this.statementIncome.setTotalExpenses(this.totalPassives);
        this.statementIncome.setNetProfit(this.totalActives.subtract(this.totalPassives));
        System.out.println(this.statementIncome.toString());
    }

    public void showActives() {
        showActiveCurrent();
        showFixedActive();
        System.out.printf("TOTAL: $ %.2f%n%n", this.totalActives);
    }

    public void showPassives() {
        showPassiveCurrent();
        showPassiveLongTerm();
        System.out.printf("TOTAL: $ %.2f%n%n", this.totalPassives);
    }

    private void showPassiveLongTerm() {
        BigDecimal bonusesAmount = sumAmountByConceptType(getFixedActive(), ConceptType.BONUSES);
        BigDecimal finceLeasesAmount = sumAmountByConceptType(getFixedActive(), ConceptType.FINANCE_LEASES);
        BigDecimal longTermLoanAmount = sumAmountByConceptType(getFixedActive(), ConceptType.LONG_TERM_LOAN);

        System.out.println("PASSIVOS A LARGO PLAZO");
        printAmount("Bonificaciones $", bonusesAmount);
        printAmount("Arrendamientos financeiros $", finceLeasesAmount);
        printAmount("Prestamo a largo plazo $", longTermLoanAmount);

        BigDecimal totalPassiveLongTerm = bonusesAmount.add(finceLeasesAmount).add(longTermLoanAmount);
        printTotal("Total passivos a largo plazo $", totalPassiveLongTerm);
        sumAmountPassive(totalPassiveLongTerm);
    }

    private void showPassiveCurrent() {
        BigDecimal taxAmount = sumAmountByConceptType(getPassiveCurrent(), ConceptType.TAX);
        BigDecimal billToPayAmount = sumAmountByConceptType(getPassiveCurrent(), ConceptType.BILL_TO_PAY);
        BigDecimal reserveProvisionAmount = sumAmountByConceptType(getPassiveCurrent(), ConceptType.RESERVE_PROVISION);

        System.out.println("PASSIVOS CURRIENTES");
        printAmount("Impuesto $", taxAmount);
        printAmount("Factura para pagar $", billToPayAmount);
        printAmount("Disposicion de reserva $", reserveProvisionAmount);

        BigDecimal totalPassiveCurrent = taxAmount.add(billToPayAmount).add(reserveProvisionAmount);
        printTotal("Total passivos currientes $", totalPassiveCurrent);
        sumAmountPassive(totalPassiveCurrent);
    }

    private void showFixedActive() {
        BigDecimal propertyAmount = sumAmountByConceptType(getFixedActive(), ConceptType.PROPERTY);
        BigDecimal teamAmount = sumAmountByConceptType(getFixedActive(), ConceptType.TEAM);
        BigDecimal deferredAssetAmount = sumAmountByConceptType(getFixedActive(), ConceptType.DEFERRED_ASSETS);

        System.out.println("ACTIVOS FIJOS");
        printAmount("Propiedad $", propertyAmount);
        printAmount("Equipo $", teamAmount);
        printAmount("Activos diferidos $", deferredAssetAmount);

        BigDecimal totalFixedAssets = propertyAmount.add(teamAmount).add(deferredAssetAmount);
        printTotal("Total activos fijos $", totalFixedAssets);
        sumAmountActive(totalFixedAssets);
    }

    private void showActiveCurrent() {
        BigDecimal currentMoney = sumAmountByConceptType(getActiveCurrent(), ConceptType.CURRENT_MONEY);
        BigDecimal billToReceive = sumAmountByConceptType(getActiveCurrent(), ConceptType.BILL_TO_RECEIVE);
        BigDecimal stock = sumAmountByConceptType(getActiveCurrent(), ConceptType.EFECTIVO);

        System.out.println("ACTIVOS CURRIENTES");
        printAmount("Dinero $", currentMoney);
        printAmount("Factura $", billToReceive);
        printAmount("Efectivo $", stock);

        BigDecimal totalActiveCurrent = currentMoney.add(billToReceive).add(stock);
        printTotal("Total activos currientes $", totalActiveCurrent);
        sumAmountActive(totalActiveCurrent);
    }

    private BigDecimal sumAmountByConceptType(Set<AccountRecord> records, ConceptType conceptType) {
        BigDecimal sum = BigDecimal.ZERO;
        for (AccountRecord record : records) {
            if (record.getConceptType().equals(conceptType)) {
                sum = sum.add(record.getAmount());
            }
        }
        return sum;
    }

    private void printAmount(String label, BigDecimal amount) {
        if (!amount.equals(BigDecimal.ZERO)) {
            System.out.printf("%s: %.2f%n", label, amount);
        }
    }

    private void printTotal(String label, BigDecimal total) {
        System.out.printf("%s: %.2f%n", label, total);
    }

    public Set<AccountRecord> getActiveCurrent() {
        return activeCurrent;
    }

    public void setActiveCurrent(Set<AccountRecord> activeCurrent) {
        this.activeCurrent = activeCurrent;
    }

    public Set<AccountRecord> getFixedActive() {
        return fixedActive;
    }

    public void setFixedActive(Set<AccountRecord> fixedActive) {
        this.fixedActive = fixedActive;
    }

    public Set<AccountRecord> getPassiveCurrent() {
        return passiveCurrent;
    }

    public void setPassiveCurrent(Set<AccountRecord> passiveCurrent) {
        this.passiveCurrent = passiveCurrent;
    }

    public Set<AccountRecord> getPassiveLongTerm() {
        return passiveLongTerm;
    }

    public void setPassiveLongTerm(Set<AccountRecord> passiveLongTerm) {
        this.passiveLongTerm = passiveLongTerm;
    }

    public void sumAmountActive(BigDecimal amount) {
        this.totalActives = this.totalActives.add(amount);
    }
    public void sumAmountPassive(BigDecimal amount) {
        this.totalPassives = this.totalPassives.add(amount);
    }

    public BigDecimal getTotalActives() {
        return totalActives;
    }

    public void setTotalActives(BigDecimal totalActives) {
        this.totalActives = totalActives;
    }

    public BigDecimal getTotalPassives() {
        return totalPassives;
    }

    public void setTotalPassives(BigDecimal totalPassives) {
        this.totalPassives = totalPassives;
    }
}

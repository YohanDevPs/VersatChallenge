package entities;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class TotalBalance {

    private Set<AccountRecord> activeCurrent = new HashSet<>();
    private Set<AccountRecord> fixedActive = new HashSet<>();
    private Set<AccountRecord> passiveCurrent = new HashSet<>();
    private Set<AccountRecord> passiveLongTerm = new HashSet<>();
    private BigDecimal totalActivos;
    private BigDecimal totalPassivos;

    public TotalBalance() {
    }

    public void showTotalBalance() {
        showActiveCurrent();
        showFixedActive();
        showPassiveCurrent();
        showPassiveLongTerm();
    }

    private void showPassiveLongTerm() {
        BigDecimal bonusesAmount = BigDecimal.ZERO;
        BigDecimal finceLeasesAmount = BigDecimal.ZERO;
        BigDecimal longTermLoanAmount = BigDecimal.ZERO;

        var activesCurrent = getFixedActive();

        for (AccountRecord activeRecord : activesCurrent) {
            switch (activeRecord.getConceptType()){
                case BONUSES -> bonusesAmount = bonusesAmount.add(activeRecord.getAmount());
                case FINANCE_LEASES -> finceLeasesAmount = finceLeasesAmount.add(activeRecord.getAmount());
                case LONG_TERM_LOAN -> longTermLoanAmount = longTermLoanAmount.add(activeRecord.getAmount());
            }
        }

        System.out.println("Passivos a largo plazo");
        if (!bonusesAmount.equals(BigDecimal.ZERO) ) {
            System.out.printf("Bonificaciones $: %.2f%n", bonusesAmount);
        }
        if (!finceLeasesAmount.equals(BigDecimal.ZERO) ) {
            System.out.printf("Arrendamientos financeiros $: %.2f%n", finceLeasesAmount);
        }
        if (!longTermLoanAmount.equals(BigDecimal.ZERO) ) {
            System.out.printf("Prestamo a largo plazo $: %.2f%n", longTermLoanAmount);
        }

        BigDecimal totalPassiveCurrent = bonusesAmount.add(finceLeasesAmount.add(longTermLoanAmount));

        System.out.printf("Total passivos a largo plazo $: %.2f%n", totalPassiveCurrent);
    }

    private void showPassiveCurrent() {
        BigDecimal taxAmount = BigDecimal.ZERO;
        BigDecimal billToPayAmount = BigDecimal.ZERO;
        BigDecimal reserveProvisionAmount = BigDecimal.ZERO;

        var activesCurrent = getFixedActive();

        for (AccountRecord activeRecord : activesCurrent) {
            switch (activeRecord.getConceptType()){
                case TAX -> taxAmount = taxAmount.add(activeRecord.getAmount());
                case BILL_TO_PAY -> billToPayAmount = billToPayAmount.add(activeRecord.getAmount());
                case RESERVE_PROVISION -> reserveProvisionAmount = reserveProvisionAmount.add(activeRecord.getAmount());
            }
        }

        System.out.println("Passivos Currientes");
        if (!taxAmount.equals(BigDecimal.ZERO) ) {
            System.out.printf("Impuesto $: %.2f%n", taxAmount);
        }
        if (!billToPayAmount.equals(BigDecimal.ZERO) ) {
            System.out.printf("Factura para pagar $: %.2f%n", billToPayAmount);
        }
        if (!reserveProvisionAmount.equals(BigDecimal.ZERO) ) {
            System.out.printf("Disposicion de reserva $: %.2f%n", reserveProvisionAmount);
        }

        BigDecimal totalPassiveCurrent = taxAmount.add(billToPayAmount.add(reserveProvisionAmount));

        System.out.printf("Total passivos currientes $: %.2f%n", totalPassiveCurrent);
    }


    private void showFixedActive() {
        BigDecimal propertyAmount = BigDecimal.ZERO;
        BigDecimal teamAmount = BigDecimal.ZERO;
        BigDecimal deferredAssetAmount = BigDecimal.ZERO;

        var activesCurrent = getFixedActive();

        for (AccountRecord activeRecord : activesCurrent) {
            switch (activeRecord.getConceptType()){
                case PROPERTY -> propertyAmount = propertyAmount.add(activeRecord.getAmount());
                case TEAM -> teamAmount = teamAmount.add(activeRecord.getAmount());
                case DEFERRED_ASSETS -> deferredAssetAmount = deferredAssetAmount.add(activeRecord.getAmount());
            }
        }


        System.out.println("Activos Fijos");
        if (!propertyAmount.equals(BigDecimal.ZERO) ) {
            System.out.printf("Propiedad $: %.2f%n", propertyAmount);
        }
        if (!teamAmount.equals(BigDecimal.ZERO) ) {
            System.out.printf("Equipo $: %.2f%n", teamAmount);
        }
        if (!deferredAssetAmount.equals(BigDecimal.ZERO) ) {
            System.out.printf("Activos diferidos $: %.2f%n", deferredAssetAmount);
        }

        BigDecimal totalActivosFijos = propertyAmount.add(teamAmount.add(deferredAssetAmount));

        System.out.printf("Total activos fijos $: %.2f%n", totalActivosFijos);
    }

    private void showActiveCurrent() {
        BigDecimal currentMoney = BigDecimal.ZERO;
        BigDecimal billToReceive = BigDecimal.ZERO;
        BigDecimal stock = BigDecimal.ZERO;

        var activesCurrent = getActiveCurrent();
        
        for (AccountRecord activeRecord : activesCurrent) {
            switch (activeRecord.getConceptType()){
                case CURRENT_MONEY -> currentMoney = currentMoney.add(activeRecord.getAmount());
                case BILL_TO_RECEIVE -> billToReceive = billToReceive.add(activeRecord.getAmount());
                case EFECTIVO -> stock = stock.add(activeRecord.getAmount());
            }
        }

        System.out.println("Activos Currientes");
        if (!currentMoney.equals(BigDecimal.ZERO) ) {
            System.out.printf("Dinero $: %.2f%n", currentMoney);
        }
        if (!billToReceive.equals(BigDecimal.ZERO) ) {
            System.out.printf("Factura $: %.2f%n", billToReceive);
        }
        if (!stock.equals(BigDecimal.ZERO) ) {
            System.out.printf("Efectivo $: %.2f%n", stock);
        }

        BigDecimal totalActiveCurrent = currentMoney.add(billToReceive.add(stock));

        System.out.printf("Total activos currientes $: %.2f%n", totalActiveCurrent);
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

    public BigDecimal getTotalActivos() {
        return totalActivos;
    }

    public void setTotalActivos(BigDecimal totalActivos) {
        this.totalActivos = totalActivos;
    }

    public BigDecimal getTotalPassivos() {
        return totalPassivos;
    }

    public void setTotalPassivos(BigDecimal totalPassivos) {
        this.totalPassivos = totalPassivos;
    }
}

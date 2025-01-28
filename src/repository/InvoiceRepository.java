package repository;

import entity.Invoice;

import java.util.ArrayList;
import java.util.List;

public class InvoiceRepository {

    private List<Invoice> invoices = new ArrayList<>();

    // Fatura eklemek istersek:
    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
        System.out.println("Fatura başarıyla oluşturuldu! " + invoice.getId());
    }

    // ID ile Fatura bulmak istersek:
    public Invoice getInvoiceById(int id) {
        for(Invoice invoice : invoices) {
            if(invoice.getId() == id) {
                return invoice;
            }
        }
        return null; //Eğer fatura bulunamazsa null döner.
    }

    // Tüm faturaları listelemek istersek:
    public List<Invoice> getAllInvoices(){
        return invoices;
    }

    // Fatura bilgilerini güncellemek istersek:
    public void updateInvoice(Invoice updatedInvoice){
        for(int i = 0; i < invoices.size(); i++) {
            if(invoices.get(i).getId() == updatedInvoice.getId()) {
                invoices.set(i, updatedInvoice);
                System.out.println("Fatura bilgisi başarıyla güncellendi! " + updatedInvoice.getId());
                return;
            }
        }
                System.out.println("Güncellenecek fatura bulunamadı!" + updatedInvoice.getId());
                System.out.println("Mevcut fatura listesi: " + getAllInvoices());
    }

    // ID ile Fatura silmek istersek:
    public void deleteInvoice(int id){
        invoices.removeIf(invoice -> invoice.getId() == id);
        System.out.println("Fatura bilgisi başarıyla silindi! " + id);
    }


}

package service;

import entity.Invoice;
import repository.InvoiceRepository;

public class InvoiceService {
    private InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public void addInvoice(Invoice invoice) {
        invoiceRepository.addInvoice(invoice);
    }

    public Invoice getInvoiceById(int id) {
        return invoiceRepository.getInvoiceById(id);
    }

    public void updateInvoice(Invoice updatedInvoice) {
        invoiceRepository.updateInvoice(updatedInvoice);
    }

    public void deleteInvoice(int id) {
        invoiceRepository.deleteInvoice(id);
    }
}
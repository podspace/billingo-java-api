package hu.billingo;

import com.fasterxml.jackson.core.type.TypeReference;
import hu.billingo.exceptions.BillingoException;
import hu.billingo.models.*;

import java.util.List;

public class Billingo {

    public RequestBuilder requester;

    public Billingo(String publicKey, String privateKey, String requesterUrl) {
        this.requester = new RequestBuilder(publicKey, privateKey, requesterUrl, 0L);
    }

    public Billingo(String publicKey, String privateKey, String requesterUrl, Long correctionMilis) {
        this.requester = new RequestBuilder(publicKey, privateKey, requesterUrl, correctionMilis);
    }

    public List<ResponseData<BankAccount>> getBankAccounts() throws BillingoException {
        return requester.get("/bank_accounts", new TypeReference<APIResponseList<ResponseData<BankAccount>>>() {
        }).data;
    }

    public ResponseData<BankAccount> getBankAccountById(Long id) throws BillingoException {
        APIResponseSingle<ResponseData<BankAccount>> jsonString = requester.get("/bank_accounts/" + id, new TypeReference<APIResponseSingle<ResponseData<BankAccount>>>() {
        });
        return jsonString.data;
    }

    public ResponseData<BankAccount> createBankAccount(BankAccount account) throws BillingoException {
        return requester.post("/bank_accounts", Json.toJson(account).toString(), new TypeReference<APIResponseSingle<ResponseData<BankAccount>>>() {
        }).data;
    }

    public ResponseData<BankAccount> updateBankAccount(Long id, BankAccount account) throws BillingoException {
        return requester.put("/bank_accounts/" + id, Json.toJson(account).toString(), new TypeReference<APIResponseSingle<ResponseData<BankAccount>>>() {
        }).data;
    }

    public List<ResponseData<Client>> getClients() throws BillingoException {
        return requester.get("/clients", new TypeReference<APIResponseList<ResponseData<Client>>>() {
        }).data;
    }

    public ResponseData<Client> getClientById(Long id) throws BillingoException {
        return requester.get("/clients/" + id, new TypeReference<APIResponseSingle<ResponseData<Client>>>() {
        }).data;
    }

    public ResponseData<Client> createClient(Client client) throws BillingoException {
        return requester.post("/clients", Json.toJson(client).toString(), new TypeReference<APIResponseSingle<ResponseData<Client>>>() {
        }).data;
    }

    public ResponseData<Client> updateClient(Long id, Client client) throws BillingoException {
        return requester.put("/clients/" + id, Json.toJson(client).toString(), new TypeReference<APIResponseSingle<ResponseData<Client>>>() {
        }).data;
    }

    public void deleteClient(Long id) throws BillingoException {
        requester.delete("/clients/" + id);
    }

    public Double convertCurrency(String from, String to, Double value) throws BillingoException {
        return requester.get("/currency/from=" + from + "&to=" + to + "&value=" + value, new TypeReference<APIResponseSingle<ResponseData<Currency>>>() {
        }).data.attributes.value;
    }

    public List<ResponseData<Expense>> getExpenses() throws BillingoException {
        return requester.get("/expenses", new TypeReference<APIResponseList<ResponseData<Expense>>>() {
        }).data;
    }
    /* not in the public api document, but its logical
    public ResponseData<Expense> getExpenseById(Long id) {
        String jsonString = requester.get("/expenses/" + id);
        return Json.fromJson(jsonString, new TypeReference<APIResponseSingle<ResponseData<Expense>>>() {
        }).data;
    }
    */

    public ResponseData<Expense> createExpense(Expense expense) throws BillingoException {
        return requester.post("/expenses", Json.toJson(expense).toString(), new TypeReference<APIResponseSingle<ResponseData<Expense>>>() {
        }).data;
    }

    public ResponseData<Expense> updateExpense(Long id, Expense expense) throws BillingoException {
        return requester.put("/expenses/" + id, Json.toJson(expense).toString(), new TypeReference<APIResponseSingle<ResponseData<Expense>>>() {
        }).data;
    }

    public List<ResponseData<ExpenseCategory>> getExpenseCategories(String langcode) throws BillingoException {
        return requester.get("/expenses/categories/" + langcode, new TypeReference<APIResponseList<ResponseData<ExpenseCategory>>>() {
        }).data;
    }

    public List<ResponseData<Invoice>> getInvoices() throws BillingoException {
        return requester.get("/invoices", new TypeReference<APIResponseList<ResponseData<Invoice>>>() {
        }).data;
    }
    public ResponseData<Invoice> getInvoiceById(Long id) throws BillingoException {
        return requester.get("/invoices/" + id, new TypeReference<APIResponseSingle<ResponseData<Invoice>>>() {
        }).data;
    }

    public ResponseData<Invoice> createInvoice(Invoice invoice) throws BillingoException {
        return requester.post("/invoices", Json.toJson(invoice).toString(), new TypeReference<APIResponseSingle<ResponseData<Invoice>>>() {
        }).data;
    }

    public String getInvoiceUrl(Long id) throws BillingoException {
        String code = requester.get("/invoices/" + id + "/code", new TypeReference<APIResponseSingle<InvoiceCode>>() {
        }).data.code;
        return "https://www.billingo.hu/access/c:" +
            code;
    }

    /* TODO invoice cancel */
    public void cancelInvoice(Long id) {
    }

    public void sendInvoiceEmail(Long id) throws BillingoException {
        requester.get("/invoices/" + id + "/send", new TypeReference<APIResponseStatusOnly>() {
        });
    }

    public void payInvoice(Long id, InvoicePayment payment) throws BillingoException {
        requester.post("/invoices/" + id + "/pay", Json.toJson(payment).toString(), new TypeReference<APIResponseStatusOnly>() {
        });
    }

    /* TODO invoice blocks */
    public void getInvoiceBlocks(Long id) {
    }

    public List<ResponseData<PaymentMethod>> getPaymentMethods(String langcode) throws BillingoException {
        return requester.get("/payment_methods/" + langcode, new TypeReference<APIResponseList<ResponseData<PaymentMethod>>>() {
        }).data;
    }

    public List<ResponseData<Vat>> getVats() throws BillingoException {
        return getVats(null, null);
    }

    public List<ResponseData<Vat>> getVats(Double value) throws BillingoException {
        return getVats(value, null);
    }

    public List<ResponseData<Vat>> getVats(String description) throws BillingoException {
        return getVats(null, description);
    }

    public List<ResponseData<Vat>> getVats(Double value, String description) throws BillingoException {
        String queryString = "";
        if(value != null || description != null) {
            queryString += "/";
        }
        if(value != null) {
            queryString += "v=" + value;
            if(description != null) {
                queryString += "&";
            }
        }
        if(description != null) {
            queryString += "d=" + description;
        }

        return requester.get("/vat" + queryString, new TypeReference<APIResponseList<ResponseData<Vat>>>() {
        }).data;
    }

    /* TODO EU VAT */
    public void getEUVat(Long id) {
    }
}

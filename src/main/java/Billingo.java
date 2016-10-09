import com.fasterxml.jackson.core.type.TypeReference;
import exceptions.BillingoException;
import models.*;

import java.util.List;

public class Billingo {

    public RequestBuilder requester;

    public Billingo(String publicKey, String privateKey, String requesterUrl) {
        this.requester = new RequestBuilder(publicKey, privateKey, requesterUrl);
    }

    public List<ResponseData<BankAccount>> getBankAccounts() throws BillingoException {
        String jsonString = requester.get("/bank_accounts");
        return Json.fromJson(jsonString, new TypeReference<APIResponseList<ResponseData<BankAccount>>>() {
        }).data;
    }

    public ResponseData<BankAccount> getBankAccountById(Long id) throws BillingoException {
        String jsonString = requester.get("/bank_accounts/" + id);
        return Json.fromJson(jsonString, new TypeReference<APIResponseSingle<ResponseData<BankAccount>>>() {
        }).data;
    }

    public ResponseData<BankAccount> createBankAccount(BankAccount account) throws BillingoException {
        String jsonString = requester.post("/bank_accounts", Json.toJson(account).toString());
        return Json.fromJson(jsonString, new TypeReference<APIResponseSingle<ResponseData<BankAccount>>>() {
        }).data;
    }

    public ResponseData<BankAccount> updateBankAccount(Long id, BankAccount account) throws BillingoException {
        String jsonString = requester.put("/bank_accounts/" + id, Json.toJson(account).toString());
        return Json.fromJson(jsonString, new TypeReference<APIResponseSingle<ResponseData<BankAccount>>>() {
        }).data;
    }

    public List<ResponseData<Client>> getClients() throws BillingoException {
        String jsonString = requester.get("/clients");
        return Json.fromJson(jsonString, new TypeReference<APIResponseList<ResponseData<Client>>>() {
        }).data;
    }

    public ResponseData<Client> getClientById(Long id) throws BillingoException {
        String jsonString = requester.get("/clients/" + id);
        return Json.fromJson(jsonString, new TypeReference<APIResponseSingle<ResponseData<Client>>>() {
        }).data;
    }

    public ResponseData<Client> createClient(Client client) throws BillingoException {
        String jsonString = requester.post("/clients", Json.toJson(client).toString());
        return Json.fromJson(jsonString, new TypeReference<APIResponseSingle<ResponseData<Client>>>() {
        }).data;
    }

    public ResponseData<Client> updateClient(Long id, Client client) throws BillingoException {
        String jsonString = requester.put("/clients/" + id, Json.toJson(client).toString());
        return Json.fromJson(jsonString, new TypeReference<APIResponseSingle<ResponseData<Client>>>() {
        }).data;
    }

    public void deleteClient(Long id) throws BillingoException {
        String jsonString = requester.delete("/clients/" + id);
    }

    public Double convertCurrency(String from, String to, Double value) throws BillingoException {
        String jsonString = requester.get("/currency/from=" + from + "&to=" + to + "&value=" + value);
        return Json.fromJson(jsonString, new TypeReference<APIResponseSingle<ResponseData<Currency>>>() {
        }).data.attributes.value;
    }

    public List<ResponseData<Expense>> getExpenses() throws BillingoException {
        String jsonString = requester.get("/expenses");
        return Json.fromJson(jsonString, new TypeReference<APIResponseList<ResponseData<Expense>>>() {
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
        String jsonString = requester.post("/expenses", Json.toJson(expense).toString());
        return Json.fromJson(jsonString, new TypeReference<APIResponseSingle<ResponseData<Expense>>>() {
        }).data;
    }

    public ResponseData<Expense> updateExpense(Long id, Expense expense) throws BillingoException {
        String jsonString = requester.put("/expenses/" + id, Json.toJson(expense).toString());
        return Json.fromJson(jsonString, new TypeReference<APIResponseSingle<ResponseData<Expense>>>() {
        }).data;
    }

    public List<ResponseData<ExpenseCategory>> getExpenseCategories(String langcode) throws BillingoException {
        String jsonString = requester.get("/expenses/categories/" + langcode);
        return Json.fromJson(jsonString, new TypeReference<APIResponseList<ResponseData<ExpenseCategory>>>() {
        }).data;
    }

    /*
    public List<ResponseData<Invoice>> getInvoicess() {
        String jsonString = requester.get("/invoices");
        return Json.fromJson(jsonString, new TypeReference<APIResponseList<ResponseData<Invoice>>>() {
        }).data;
    }
    */
    public ResponseData<Invoice> getInvoiceById(Long id) throws BillingoException {
        String jsonString = requester.get("/invoices/" + id);
        return Json.fromJson(jsonString, new TypeReference<APIResponseSingle<ResponseData<Invoice>>>() {
        }).data;
    }

    public ResponseData<Invoice> createInvoice(Invoice invoice) throws BillingoException {
        String jsonString = requester.post("/invoices", Json.toJson(invoice).toString());
        return Json.fromJson(jsonString, new TypeReference<APIResponseSingle<ResponseData<Invoice>>>() {
        }).data;
    }

    public String getInvoiceUrl(Long id) throws BillingoException {
        String jsonString = requester.get("/invoices/" + id + "/code");
        return "https://www.billingo.hu/access/c:" +
            Json.fromJson(jsonString, new TypeReference<APIResponseSingle<InvoiceCode>>() {
            }).data.code;
    }

    /* TODO invoice cancel */
    public void cancelInvoice(Long id) {
    }

    public void sendInvoiceEmail(Long id) throws BillingoException {
        String jsonString = requester.get("/invoices/" + id + "/send");
    }

    public void payInvoice(Long id, InvoicePayment payment) throws BillingoException {
        String jsonString = requester.post("/invoices/" + id + "/pay", Json.toJson(payment).toString());
    }

    /* TODO invoice blocks */
    public void getInvoiceBlocks(Long id) {
    }

    public List<ResponseData<PaymentMethods>> getPaymentMethods(String langcode) throws BillingoException {
        String jsonString = requester.get("/payment_methods/" + langcode);
        return Json.fromJson(jsonString, new TypeReference<APIResponseList<ResponseData<PaymentMethods>>>() {
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

        String jsonString = requester.get("/vat" + queryString);
        return Json.fromJson(jsonString, new TypeReference<APIResponseList<ResponseData<Vat>>>() {
        }).data;
    }

    /* TODO EU VAT */
    public void getEUVat(Long id) {
    }
}

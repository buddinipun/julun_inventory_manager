package com.aptota.app.dao;

import com.aptota.app.model.Quotation;
import com.aptota.app.model.requests.GetQuotation;
import org.json.JSONArray;

import com.aptota.app.model.response.Response;

public interface QuotationDao {

    public Response saveQuotationMainDetails(Quotation quotation);
    public Response saveQuotationItemDetails(JSONArray itemString, int quotationId);
    public Response getQuotationAllQuotations(GetQuotation getQuotation);
    public Response getQuotationItemDetails(int quotationId);
    public Response getQuotationById(int quotationId);
    public Response updateQuotationItemDetails(JSONArray itemString, int quotationId);

}
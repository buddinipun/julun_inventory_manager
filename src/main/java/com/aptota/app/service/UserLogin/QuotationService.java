package com.aptota.app.service.UserLogin;

import com.aptota.app.model.Quotation;
import com.aptota.app.model.Search.SearchQuotation;
import com.aptota.app.model.requests.GetQuotation;
import org.json.JSONArray;

import com.aptota.app.model.response.Response;

public interface QuotationService {
	
	public Response createQuotationMaindet(Quotation quotation);
	public Response saveQuotationItemDetails(JSONArray itemString, int quotationId);
	public Response getQuotationList(GetQuotation getQuotation);
	public Response getQuatationItemList(int quotationId);
	public Response getQuotationById(int quatationId);
	public Response updateQuotationItemDetails(JSONArray itemString, int quotationId);


}

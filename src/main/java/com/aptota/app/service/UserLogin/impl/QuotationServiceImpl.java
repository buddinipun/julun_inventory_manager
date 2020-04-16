package com.aptota.app.service.UserLogin.impl;

import com.aptota.app.dao.QuotationDao;
import com.aptota.app.model.Quotation;
import com.aptota.app.model.Search.SearchQuotation;
import com.aptota.app.model.requests.GetQuotation;
import com.aptota.app.model.response.Response;
import com.aptota.app.service.UserLogin.QuotationService;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuotationServiceImpl implements QuotationService {

    @Autowired
    QuotationDao quotationDao;
    public Response createQuotationMaindet(Quotation quotation) {

        Response response = quotationDao.saveQuotationMainDetails(quotation);
        return response;
    }
	@Override
	public Response saveQuotationItemDetails(JSONArray itemString, int quotationId) {
		// TODO Auto-generated method stub
		
		Response response = quotationDao.saveQuotationItemDetails(itemString, quotationId);
		return response;
	}

    @Override
    public Response getQuotationList(GetQuotation getQuotation) {
        Response response = quotationDao.getQuotationAllQuotations(getQuotation);
        return response;
    }

    @Override
    public Response getQuatationItemList(int quotationId) {

        Response response = quotationDao.getQuotationItemDetails(quotationId);
        return response;
    }

    @Override
    public Response updateQuotationItemDetails(JSONArray itemString, int quotationId) {

        Response response  = quotationDao.updateQuotationItemDetails(itemString, quotationId);
        return response;
    }
	@Override
	public Response getQuotationById(int quatationId) {
		// TODO Auto-generated method stub
		Response response = quotationDao.getQuotationById(quatationId);
		return response;
	}


}

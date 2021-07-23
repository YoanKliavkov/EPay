package com.sgfs.data;

 
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sgfs.Model.Bill;
import com.sgfs.Model.Merchant;
import com.sgfs.requests.CheckBillBlockedRequest;
import com.sgfs.requests.CheckBillRequest;
import com.sgfs.requests.PayBillRequest;
import com.sgfs.requests.ReverseBillRequest;
import com.sgfs.responses.CheckBillBlockedResponse;
import com.sgfs.responses.CheckBillResponse;
import com.sgfs.responses.PayBillResponse;
import com.sgfs.responses.ResponseStatus;
import com.sgfs.responses.ReverseBillResponse;
import com.sgfs.utils.FeeCalculator;

import lombok.extern.slf4j.Slf4j;
 
@Slf4j
@Repository
public class DatabaseConnection {
	
	 private ArrayList<Merchant> merchantsList = new ArrayList<Merchant>();
	 private ArrayList<Bill> billsList = new ArrayList<Bill>();
	 
	 {
		 log.info("Populating database...");
		 
		 Merchant m1 = new Merchant("1", "1", null, null, null, null, 0, null, 0, null, null, null, null, null, null);
		 Merchant m2 = new Merchant("2", "2", null, null, null, null, 0, null, 0, null, null, null, null, null, null);
		 Merchant m3 = new Merchant("3", "3", null, null, null, null, 0, null, 0, null, null, null, null, null, null);
		 Merchant m4 = new Merchant("4", "4", null, null, null, null, 0, null, 0, null, null, null, null, null, null);
		 Merchant m5 = new Merchant("5", "5", null, null, null, null, 0, null, 0, null, null, null, null, null, null);

		 
		 //first param is merchantID, second is subscrNumber
		 Bill b1 = new Bill("1", "34", null, null, 10, null, null, null);		 
		 Bill b2 = new Bill("1", "12", null, null, 30, null, null, null);		 
		 Bill b3 = new Bill("2", "53", null, null, 23, null, null, null);		 
		 Bill b4 = new Bill("5", "43", null, null, 20, null, null, null);		 
		 Bill b5 = new Bill("3", "4", null, null, 40, null, null, null);		 
		 
		 merchantsList.add(m1);
		 merchantsList.add(m2);
		 merchantsList.add(m3);
		 merchantsList.add(m4);
		 merchantsList.add(m5);

		 
		 billsList.add(b1);
		 billsList.add(b2);
		 billsList.add(b3);
		 billsList.add(b4);
		 billsList.add(b5);

	 }
	 
	 
	 @Autowired
	 private FeeCalculator feeCalc;
	 
	 
	 public ArrayList<Merchant> getMerchantsData() {
		 return merchantsList;
	 }
	 
 	 public CheckBillResponse checkBill(CheckBillRequest cbr) 
 	 {
 		for(Bill b : billsList)
		 {
			if(b.getMerchantId().equals(cbr.getMerchantId()) && b.getSubscrNumber().equals(cbr.getSubscrNumber()))
					{
						return new CheckBillResponse(ResponseStatus.OK.getStatus(), b.getValidto(), b.getAmount(), b.getShortdesc(), b.getLongdesc(), b.getSecondid());
					}
		 }
 		  		 
 		 return null;
	 }
	 
	 public CheckBillBlockedResponse checkBillBlocked(CheckBillBlockedRequest cbbr) 
	 {
		 
		 for(Bill b : billsList)
		 {
			if(b.getMerchantId().equals(cbbr.getMerchantId()) && b.getSubscrNumber().equals(cbbr.getSubscrNumber()))
			{	
				int fee = feeCalc.calculateFee(b.getAmount());
				return new CheckBillBlockedResponse(ResponseStatus.OK.getStatus(), b.getAmount(), fee, b.getAmount() + fee, b.getShortdesc(), b.getLongdesc());
			}
		 }
		 
		 return null;
	 }
	 
	 public PayBillResponse payBill(PayBillRequest pbr){
		 
		 for(Bill b : billsList)
		 {
			 
			 if(b.getMerchantId().equals(pbr.getMerchantId())
			&&  b.getSubscrNumber().equals(pbr.getSubscrNumber())
			&&  pbr.getAmount() == b.getAmount() && b.getStatus().equals("Pending"))
			 {
				 b.setStatus("Paid");
				 return new PayBillResponse(ResponseStatus.OK.getStatus());
			 }
			 
		 }
		 
		 return null;
	 }
	 
	 public ReverseBillResponse reverseBill(ReverseBillRequest rbr) {
		 return new ReverseBillResponse(ResponseStatus.OK.getStatus());
	 }
	 	 
	
	
	
	
}

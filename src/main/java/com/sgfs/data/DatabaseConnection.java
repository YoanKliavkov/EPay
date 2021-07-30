package com.sgfs.data;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sgfs.Model.Merchant;
import com.sgfs.random.RandomObjectFactory;
import com.sgfs.rest.ERequest;
import com.sgfs.rest.EResponse;

@Repository
public class DatabaseConnection {

	private ArrayList<Merchant> merchantsList = new ArrayList<Merchant>();

	@Autowired
	private RandomObjectFactory randomObjectFactory;

	private void initMerchantList() {
		for (int x = 0; x < 20; x++) {
			merchantsList.add(randomObjectFactory.getRandomMerchant());
		}

	}

	public ArrayList<Merchant> getMerchantsData() {

		if (merchantsList == null || merchantsList.isEmpty()) {
			initMerchantList();
		}

		return merchantsList;
	}

	public EResponse checkBill(ERequest cbr) {
		return randomObjectFactory.getRandomCheckBillResponse();
	}

	public EResponse checkBillBlocked(ERequest cbbr) {

		return randomObjectFactory.getRandomCheckBillBlockedResponse();
	}

	public EResponse payBill(ERequest pbr) {
		EResponse er = new EResponse();
		er.setStatus(randomObjectFactory.getRandomResponseStatus().getStatusCode());
		return er;
	}

	public EResponse reverseBill(ERequest rbr) {
		EResponse er = new EResponse();
		er.setStatus(randomObjectFactory.getRandomResponseStatus().getStatusCode());
		return er;
	}

}

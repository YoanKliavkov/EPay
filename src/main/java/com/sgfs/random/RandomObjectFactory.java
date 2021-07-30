package com.sgfs.random;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.stereotype.Service;
import com.sgfs.Model.Merchant;
import com.sgfs.rest.EResponse;
import com.sgfs.rest.ResponseStatus;

@Service
public class RandomObjectFactory {
	private String[] names = { "Georg", "Maria", "Ivan", "Peter", "Yanko", "Maya", "Alex" };

	public Merchant getRandomMerchant() {
		String name = getRandomName();
		return new Merchant(getRandomInt(0, 100_000), name, name, name, "subscr_number_type", getRandomBoolean(),
				getRandomInt(0, 3), "category_name", getRandomInt(0, 3), getRandomBoolean(), getRandomBoolean(),
				"NoDesc", "NoDesc", "RegexSubNum", "SubNumHelpInfo");
	}

	public EResponse getRandomCheckBillResponse() {
		EResponse er = new EResponse();

		ResponseStatus rs = getRandomResponseStatus();
		er.setStatus(rs.getStatusCode());

		if(rs.equals(ResponseStatus.OK))
		{
			er.setValidto(getRandomDate(new Date(System.currentTimeMillis()), getRandomDate(60)));
			er.setAmount(getRandomInt(100, 100_000_000));
			er.setShortdesc("shortDesc");
			er.setLongdesc("longDesc");
			er.setSecondid("secondid");
		}
		 
		return er;
	}

	public EResponse getRandomCheckBillBlockedResponse() {
		EResponse er =  new EResponse();
		
		ResponseStatus rs = getRandomResponseStatus();
		er.setStatus(rs.getStatusCode());
		
		if(rs.equals(ResponseStatus.OK))
		{
			int amount = getRandomInt(100, 1_000_000_000);
			int fee = amount / 100;
			int total = amount + fee;
			
			er.setAmount(amount);
			er.setFee(fee);
			er.setTotal(total);
			er.setShortdesc("shortDesc");
			er.setLongdesc("longDesc");
		}
		
		return er;
	}

	public ResponseStatus getRandomResponseStatus() {

		if (getRandomInt(1, 10) <= 7) {
			return ResponseStatus.OK;
		}

		return ResponseStatus.values()[getRandomInt(1, ResponseStatus.values().length - 1)];

	}

	/**
	 * @param days 
	 * @return random date in range(today, today + days)
	 */
	private Date getRandomDate(int days)
	{
		long currentMs = System.currentTimeMillis();
		long daysInMs = (long)24*60*60*1000*days;
		return new Date(ThreadLocalRandom.current().nextLong(currentMs, currentMs + daysInMs + 1));
	}
	
	private Date getRandomDate(Date lowerBound, Date upperBound) {
		return new Date(ThreadLocalRandom.current().nextLong(lowerBound.getTime(), upperBound.getTime() + 1));
	}

	private String getRandomName() {
		return names[getRandomInt(0, names.length - 1)];
	}

	private Boolean getRandomBoolean() {
		return getRandomInt(0, 1) == 1;
	}

	public int getRandomInt(int lowerBound, int upperBound) {
		return ThreadLocalRandom.current().nextInt(lowerBound, upperBound + 1);
	}

}

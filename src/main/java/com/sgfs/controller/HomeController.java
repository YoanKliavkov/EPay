package com.sgfs.controller;

import java.util.ArrayList;
 
import com.sgfs.Model.Merchant;
import com.sgfs.data.DatabaseConnection;
import com.sgfs.requests.CheckBillBlockedRequest;
import com.sgfs.requests.CheckBillRequest;
import com.sgfs.requests.PayBillRequest;
import com.sgfs.requests.ReverseBillRequest;
import com.sgfs.responses.CheckBillBlockedResponse;
import com.sgfs.responses.CheckBillResponse;
import com.sgfs.responses.PayBillResponse;
import com.sgfs.responses.ReverseBillResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bankApi")
public class HomeController {

	 @Autowired
	 private DatabaseConnection epayService;
	
	 @GetMapping(path = "/") 
	 public String home() {
		 return "home"; 
	 }
 	 
	 @GetMapping(path = "/getMerchantsData")
	 public ArrayList<Merchant> getMerchantsData() {
		 return epayService.getMerchantsData();
	 }
	 
	 @PostMapping(value = "/checkBill")
 	 public CheckBillResponse checkBill(@RequestBody CheckBillRequest cbr) {
		 return epayService.checkBill(cbr);
	 }
	 
	 @PostMapping(path = "/checkBillBlocked")
	 public CheckBillBlockedResponse checkBillBlocked(@RequestBody CheckBillBlockedRequest cbbr) {
		 return epayService.checkBillBlocked(cbbr);
	 }
	 
	 @PostMapping(path = "/payBill") 
	 public PayBillResponse payBill(@RequestBody PayBillRequest pbr){
		 return epayService.payBill(pbr);
 	 }
	 
	 @PostMapping(path = "/reverseBill")
	 public ReverseBillResponse reverseBill(@RequestBody ReverseBillRequest rbr) {
		 return epayService.reverseBill(rbr);
	 }
	 	 
}

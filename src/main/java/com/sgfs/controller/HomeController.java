package com.sgfs.controller;

import java.util.ArrayList;

import com.sgfs.Model.Merchant;
import com.sgfs.data.DatabaseConnection;
import com.sgfs.rest.ERequest;
import com.sgfs.rest.EResponse;

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
	public EResponse checkBill(@RequestBody ERequest cbr) {

		return epayService.checkBill(cbr);
	}

	@PostMapping(path = "/checkBillBlocked")
	public EResponse checkBillBlocked(@RequestBody ERequest cbbr) {
		return epayService.checkBillBlocked(cbbr);
	}

	@PostMapping(path = "/payBill")
	public EResponse payBill(@RequestBody ERequest pbr) {
		return epayService.payBill(pbr);
	}

	@PostMapping(path = "/reverseBill")
	public EResponse reverseBill(@RequestBody ERequest rbr) {
		return epayService.reverseBill(rbr);
	}

}

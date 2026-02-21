package blackrock.challenge.investment.controller;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import blackrock.challenge.investment.dto.Expenses;
import blackrock.challenge.investment.dto.PerformanceResponse;
import blackrock.challenge.investment.dto.ReturnRequest;
import blackrock.challenge.investment.dto.ReturnResponse;
import blackrock.challenge.investment.dto.TemporalConstraint;
import blackrock.challenge.investment.dto.Transactions;
import blackrock.challenge.investment.dto.ValidInvalidTransaction;
import blackrock.challenge.investment.dto.WageTransaction;
import blackrock.challenge.investment.service.TransactionService;


@RestController
@RequestMapping("/blackrock/challenge/v1")
public class transactionBuilderController {

	@Autowired
    TransactionService transactionService;
	
	@PostMapping("/transactions:parse")
	public List<Transactions> getTransactionList(@RequestBody List<Expenses> expenseList){
		 return transactionService.parseTransactions(expenseList);
		
	}
	
	
	@PostMapping("/transactions:validator")
	public ValidInvalidTransaction validateTransactions(@RequestBody WageTransaction wagetransaction){
		ValidInvalidTransaction validInvalidTransaction = new ValidInvalidTransaction();
		
		List<Transactions> validTrans = new ArrayList<>();
		List<Transactions> invalidTrans = new ArrayList<>();
		
		for(Transactions trans : wagetransaction.getTransactions()) {
			
			if(trans.getAmount() > 0) {
				validTrans.add(trans);
				
			}
			else {
				trans.setMessage("Negative amounts are not allowed");
				invalidTrans.add(trans);
				
			}
		}
		validInvalidTransaction.getValidTransaction().setTransaction(validTrans);
		validInvalidTransaction.getInvalidTransaction().setTransactions(invalidTrans);
		
		return  validInvalidTransaction;
		
	}
	
	
	@GetMapping("/transactions:filter")
	public ValidInvalidTransaction gettemporalconstraint(@RequestBody TemporalConstraint temporalConstraint) {
		
		ValidInvalidTransaction validInvalidTransaction = new ValidInvalidTransaction();
		
		List<Transactions> validTrans = new ArrayList<>();
		List<Transactions> invalidTrans = new ArrayList<>();
		
		for(Transactions trans : temporalConstraint.getTransactions()) {
			
			if(trans.getAmount()>0 ) {
				Transactions transaction = new Transactions();
				transaction.setDate(trans.getDate());
				transaction.setAmount(trans.getAmount());
				transaction.setCeiling(transactionService.calculateCeiling(trans.getAmount()));
				if(transaction.getDate().isAfter(temporalConstraint.getP().get(0).getStart()) && transaction.getDate().isBefore(temporalConstraint.getP().get(0).getEnd())) {
					transaction.setRemanent((transactionService.calculateRemantant(transaction.getCeiling(), transaction.getAmount())) + temporalConstraint.getP().get(0).getExtra());
				}
				else if(transaction.getDate().isAfter(temporalConstraint.getQ().get(0).getStart()) && transaction.getDate().isBefore(temporalConstraint.getQ().get(0).getEnd())) {
					transaction.setRemanent((transactionService.calculateRemantant(transaction.getCeiling(), transaction.getAmount())) + temporalConstraint.getQ().get(0).getFixed());
				}
				else {
					transaction.setRemanent(transactionService.calculateRemantant(transaction.getCeiling(), transaction.getAmount()));
				}
				
				validTrans.add(transaction);
			}
			else{
				Transactions transaction = new Transactions();
				transaction.setDate(trans.getDate());
				transaction.setAmount(trans.getAmount());
				transaction.setMessage("Negative amounts are not allowed");
				
				invalidTrans.add(transaction);
			}
			
		}
		
		validInvalidTransaction.getValidTransaction().setTransaction(validTrans);
		validInvalidTransaction.getInvalidTransaction().setTransactions(invalidTrans);
		return validInvalidTransaction;
	}
	
	
	 @PostMapping("/returns:nps")
	 public ReturnResponse calculateNPS(@RequestBody ReturnRequest request) {
	        return transactionService.calculateNPS(request);
	 }
	 
	 @PostMapping("/returns:index")
	 public ReturnResponse calculateIndex(@RequestBody ReturnRequest request) {
	        return transactionService.calculateIndex(request);
	  }
	 
	 
	 @GetMapping("/performance")
	 public PerformanceResponse performance() {

	     Runtime runtime = Runtime.getRuntime();

	     long memory = (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024);
	     int threads = Thread.activeCount();

	     return new PerformanceResponse(
	             Duration.ofMillis(System.currentTimeMillis()).toString(),
	             memory + " MB",
	             threads
	     );
	 }
	
	
	
}

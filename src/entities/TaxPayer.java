package entities;

public class TaxPayer {

	private Double salaryIncome;
	private Double servicesIncome;
	private Double capitalIncome;
	private Double helthSpending;
	private Double educationSpending;

	public TaxPayer() {
	}

	public TaxPayer(Double salaryIncome, Double servicesIncome, Double capitalIncome, Double helthSpending,
			Double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.helthSpending = helthSpending;
		this.educationSpending = educationSpending;
	}

	public Double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(Double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public Double getServicesIncome() {
		return servicesIncome;
	}

	public void setServicesIncome(Double servicesIncome) {
		this.servicesIncome = servicesIncome;
	}

	public Double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(Double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public Double getHelthSpending() {
		return helthSpending;
	}

	public void setHelthSpending(Double helthSpending) {
		this.helthSpending = helthSpending;
	}

	public Double getEducationSpending() {
		return educationSpending;
	}

	public void setEducationSpending(Double educationSpending) {
		this.educationSpending = educationSpending;
	}

	public Double salaryTax() {
		if (salaryIncome / 12 < 3000.00) {
			return 0.00;
		} else if (salaryIncome / 12 < 5000.0) {
			return salaryIncome * 0.10;
		} else {
			return salaryIncome * 0.20;
		}
	}

	public Double servicesTax() {
		if (servicesIncome > 0.00) {
			return servicesIncome * 0.15;
		} else {
			return 0.00;
		}
	}

	public Double capitalTax() {
		if (capitalIncome > 0.00) {
			return capitalIncome * 0.20;
		} else {
			return 0.00;
		}
	}

	public Double grossTax() {
		return salaryTax() + servicesTax() + capitalTax();
	}

	public Double taxRebate() {
		double grossTax = grossTax();
		double limit = grossTax * 0.30;
		double totalExpenses = helthSpending + educationSpending;

		if (totalExpenses > limit) {
			return limit;
		} else {
			return totalExpenses;
		}
	}

	public Double netTax() {
		return grossTax() - taxRebate();
	}
}

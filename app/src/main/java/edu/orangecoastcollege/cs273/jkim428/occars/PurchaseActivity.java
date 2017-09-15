package edu.orangecoastcollege.cs273.jkim428.occars;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class PurchaseActivity extends AppCompatActivity {

    // Connections to VIEW
    private EditText mPriceEditText;
    private EditText mDownPaymentEditText;
    private RadioButton mThreeYearRadioButton;
    private RadioButton mFourYearRadioButton;
    private RadioButton mFiveYearRadioButton;

    // Connection to the MODEL
    private CarLoan mCarLoan = new CarLoan();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Make a comment
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        // Use findViewById to connect controller to each view
        mPriceEditText = (EditText) findViewById(R.id.carPriceEditText);
        mDownPaymentEditText = (EditText) findViewById(R.id.downPaymentEditText);
        mThreeYearRadioButton = (RadioButton) findViewById(R.id.threeYearRadioButton);
        mFourYearRadioButton = (RadioButton) findViewById(R.id.fourYearRadioButton);
        mFiveYearRadioButton = (RadioButton) findViewById(R.id.fiveYearRadioButton);
    }

    private void collectCarLoanData()
    {
        mCarLoan.setPrice(Double.parseDouble(mPriceEditText.getText().toString()));
        mCarLoan.setDownPayment(Double.parseDouble(mDownPaymentEditText.getText().toString()));

        if (mThreeYearRadioButton.isChecked())
            mCarLoan.setTerm(3);
        else if (mFourYearRadioButton.isChecked())
            mCarLoan.setTerm(4);
        else
            mCarLoan.setTerm(5);
    }

    protected void reportSummary(View v)
    {
        collectCarLoanData();
        String report = "Monthly Payment: $" + mCarLoan.monthlyPayment() +"\n\n"
                        + "Car Sticker price: $" + mCarLoan.getPrice() +"\n"
                        + "You will put down: $" + mCarLoan.getDownPayment() +"\n"
                        + "Taxed Amt: $" + mCarLoan.taxAmount() +"\n"
                        + "Your Cost: $" + mCarLoan.totalAmount() +"\n"
                        + "Borrowed Amount: $" + mCarLoan.borrowedAmount() +"\n"
                        + "Interest Amount: $" + mCarLoan.interestAmount() +"\n\n"
                        + "Loan Term is " + mCarLoan.getTerm() + " years.\n\n"
                        + "Note:\n\n1. Loan information is made available by OC Cars.\n"
                        + "2. A sales tax rate of 8% is required in Costa Mesa.";

        // Intents start new activities and can share data with them
        Intent launchLoanSummary = new Intent(this, LoanSummaryActivity.class);
        // Put data into the Intent for Loan Summary to receive
        launchLoanSummary.putExtra("loanReport", report);
        // Start the second activity
        startActivity(launchLoanSummary);
    }
}

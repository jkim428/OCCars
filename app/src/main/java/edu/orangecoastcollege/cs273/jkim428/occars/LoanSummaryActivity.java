package edu.orangecoastcollege.cs273.jkim428.occars;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class LoanSummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_summary);

        // Receive the Intent (from PurchaseActivity)
        // Populate the text view with data

        Intent intentFromPurchase = getIntent();
        String report = intentFromPurchase.getStringExtra("loanReport");

        // Fill your TextView with data from the report
              // create view
              // findviewbyid (R.id....) - setText

    }
}

package edu.orangecoastcollege.cs273.jkim428.occars;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.view.View;

public class LoanSummaryActivity extends AppCompatActivity {

    private TextView mReportTextView;

    public TextView getReportTextView() {
        return mReportTextView;
    }

    public void setReportTextView(TextView reportTextView) {
        mReportTextView = reportTextView;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_summary);

        // Receive the Intent (from PurchaseActivity)
        // Populate the text view with data

        Intent intentFromPurchase = getIntent();
        String report = intentFromPurchase.getStringExtra("loanReport");

        // Fill your TextView with data from the report
        mReportTextView = (TextView) findViewById(R.id.reportTextView);
        mReportTextView.setText(report);
    }

    protected void returnToDataEntry(View v)
    {
        Intent returnToPurchaseActivity = new Intent(this, PurchaseActivity.class);
        startActivity(returnToPurchaseActivity);
    }
}

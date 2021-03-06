package com.whatscrap;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

/**
 * Created by Abhijith on 12-02-2017.
 */

public class LongDeleteOperation extends AsyncTask<Boolean, Integer, String> {

    Utilities utilities;
    ProgressDialog mProgressDialog;
    Context mContext;

    public LongDeleteOperation(Context context){
        mContext = context;
        utilities = new Utilities(mContext);
        mProgressDialog = new ProgressDialog(mContext);
        mProgressDialog.setMessage("Deleting...");
        mProgressDialog.setIndeterminate(false);
        mProgressDialog.setMax(100);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mProgressDialog.show();
    }

    @Override
    protected String doInBackground(Boolean... all) {
        utilities.delete(all[0]);
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        mProgressDialog.dismiss();
        Toast.makeText(mContext, "Deleted", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        mProgressDialog.setProgress(values[0]);
    }
}
